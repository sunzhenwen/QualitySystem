package com.tj.jst.inner.qualificationProductivity.queryCorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class QueryCorpDaoImpl extends BaseDao implements IQueryCorpDao{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		//基础数据库
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					CorpInfo corp = new CorpInfo();
					corp.setCorpId(rs.getString("corpId"));					//企业Id
					corp.setCorpName(rs.getString("corpName"));				//企业名称
					corp.setCorpCode(rs.getString("corpCode"));				//企业组织机构代码证
					corp.setLicenseNum(rs.getString("licenseNum"));			//工商营业执照注册号
					corp.setOfficePhone(rs.getString("officePhone"));		//办公电话
					corp.setCityNum(rs.getString("cityNum"));
				    page.getData().add(corp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * 所有资质信息
	 */
	@Override
	public List<CertifiedService> queryCertifiedService(String[] certIds) {
		// TODO Auto-generated method stub
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try{
			//先从基础数据库中获取资质的信息
			String sql1 = "select * from V_SERVICECERTDETAIL where certId = ?";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql1);
			for(int i=0;i<certIds.length;i++)
			{
				pstmt.setString(1,certIds[i]);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					//查询成功，则输出相应信息。
					CertifiedService certifiedService = new CertifiedService();
					certifiedService.setCertId(rs.getString("certId"));		//服务事项主键
					certifiedService.setCertName(rs.getString("certName"));	//服务事项名称
					certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					list.add(certifiedService);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 根据服务事项ID 选择出公司信息
	 */
	@Override
	public List<Corp> submitCertifiedService(List<CertifiedService> list) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCORPCERTDETAILINFO where tradeboundnum = ? and titlelevelnum = ? and (QUALIFTYPE = 5 or QUALIFTYPE = 9)";
		List<Corp> corplist = new ArrayList<Corp>();
		for(int i=0;i<list.size();i++)
		{
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list.get(i).getSpecialtyType());
				pstmt.setInt(2, list.get(i).getCretLevel());
				rs = pstmt.executeQuery();
				while(rs.next()){
					Corp corp = new Corp();
					corp.setCorpId(rs.getString("corpID"));
					corp.setCorpName(rs.getString("corpName"));
					corplist.add(corp);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
	                conn.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return corplist;
	}

	/**
	 * 查询所有资质信息
	 */
	@Override
	public List<CertifiedService> queryAllCertifiedService() {
		// TODO Auto-generated method stub
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try{
			//先从基础数据库中获取资质的信息
			String sql1 = "select * from V_SERVICECERTDETAIL ";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql1);				
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				//查询成功，则输出相应信息。
				CertifiedService certifiedService = new CertifiedService();
				certifiedService.setCertId(rs.getString("certId"));		//服务事项主键
				certifiedService.setCertName(rs.getString("certName"));	//服务事项名称
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				list.add(certifiedService); 
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 资质名称字典类 
	 */
	@Override
	public List<DictionaryClass> certName(String[] certIds) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTIFIEDSERVICE where certId = ?";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if(certIds!=null){
			for(int i = 0 ; i < certIds.length ; i++)
			{
				try{
					conn = ConnectionFactory.getQualityConnection();
					pstmt = conn.prepareStatement(sql);	
					pstmt.setString(1, certIds[i]);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						DictionaryClass dictionaryClass = new DictionaryClass();
						dictionaryClass.setName(rs.getString("certName"));
						list.add(dictionaryClass);
					}
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					ConnectionFactory.closeConn(conn, pstmt, rs);
				}
			}
			return list;
		}else {
			return null;
		}
		
	}

	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<CertifiedService> queryGradeCertifiedService(String check) {
		List<CertifiedService> list = new ArrayList<CertifiedService>();

		try {
			// 先从基础数据库中获取公司的信息
			String sql1 = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type='0' order by certname ";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, check); // 资质级别 1：国家 2：省 3：地市
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 查询成功，则输出相应信息。
				CertifiedService certifiedService = new CertifiedService();
				certifiedService.setCertId(rs.getString("certId")); // 服务事项主键
				certifiedService.setCertName(rs.getString("certName")); // 服务事项名称
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				list.add(certifiedService);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	
	

}
