package com.tj.jst.inner.system.qualificationRevocation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class RevocationHistoryDaoImpl extends BaseDao implements IRevocationHistoryDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 资质打回历史
	 */
	@Override
	public Page pagedQueryHistory(RevocationHistoryCondition historyCondition) {
		
		Page page = super.qualityPagedQuery(historyCondition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					QualificationRevocation qualificationRevocation = new QualificationRevocation();
					
					qualificationRevocation.setAddress(rs.getString("address"));
					qualificationRevocation.setAddtypenum(rs.getString("addtypenum"));
					qualificationRevocation.setApprovaldeptname(rs.getString("approvaldeptname"));
					qualificationRevocation.setAssets(rs.getDouble("assets"));
					qualificationRevocation.setCertName(rs.getString("certName"));
					//qualificationRevocation.setCerttradestatusnum(rs.getString("certtradestatusnum"));
					//qualificationRevocation.setCheckforeign(rs.getString("checkforeign"));
					qualificationRevocation.setCityNum(rs.getString("cityNum"));
					qualificationRevocation.setCityName(rs.getString("cityName"));
					qualificationRevocation.setAdminareaName(rs.getString("adminareaName"));
					qualificationRevocation.setCorpBirthDate(rs.getDate("corpBirthDate"));
					qualificationRevocation.setCorpCode(rs.getString("corpCode"));
					qualificationRevocation.setCorpId(rs.getString("corpId"));
					qualificationRevocation.setCorpName(rs.getString("corpName"));
					qualificationRevocation.setCountyNum(rs.getString("countyNum"));
					qualificationRevocation.setCreatDate(rs.getDate("creatDate"));
					//qualificationRevocation.setDatasource(rs.getString("datasource"));
					qualificationRevocation.setDescription(rs.getString("description"));
					qualificationRevocation.setEconomicNum(rs.getInt("economicNum"));
					qualificationRevocation.setEconomicPropertyName(rs.getString("economicPropertyName"));
					qualificationRevocation.setEmail(rs.getString("email"));
					qualificationRevocation.setFactRegPrin(rs.getDouble("factRegPrin"));
					qualificationRevocation.setFax(rs.getString("fax"));
					//qualificationRevocation.setGradeName(rs.getString("gradeName"));
					qualificationRevocation.setIdcardtypeNum(rs.getString("idcardtypeNum"));
					qualificationRevocation.setLegalMan(rs.getString("legalMan"));
					qualificationRevocation.setLegalmanDuty(rs.getString("legalmanDuty"));
					qualificationRevocation.setLegalmanidCard(rs.getString("legalmanidCard"));
					qualificationRevocation.setLegamanProtitle(rs.getString("legamanProtitle"));
					qualificationRevocation.setLicenseNum(rs.getString("licenseNum"));
					qualificationRevocation.setLinkMan(rs.getString("linkMan"));
					qualificationRevocation.setLinkPhone(rs.getString("linkPhone"));
					qualificationRevocation.setLinkTel(rs.getString("linkTel"));
					qualificationRevocation.setPrincipalUnitName(rs.getString("principalUnitName"));
					qualificationRevocation.setProvinceNum(rs.getString("provinceNum"));
					//qualificationRevocation.setPrincipalUnitNum(rs.getString("principalUnitNum"));
					qualificationRevocation.setProvinceName(rs.getString("provinceName"));
					qualificationRevocation.setRegPrin(rs.getDouble("regPrin"));
					qualificationRevocation.setSpare1(rs.getString("spare1"));
					qualificationRevocation.setTitlelevelnum(rs.getInt("titlelevelnum"));
					qualificationRevocation.setTradeboundnum(rs.getInt("tradeboundnum"));
					qualificationRevocation.setTradetypeName(rs.getString("tradetypeName"));
					qualificationRevocation.setUltimatedate(rs.getDate("ultimatedate"));
					qualificationRevocation.setUltimateresults(rs.getString("ultimateresults"));
					//qualificationRevocation.setRelationid(rs.getString("relationid"));
					qualificationRevocation.setRevocationDate(rs.getDate("revocationDate"));
					qualificationRevocation.setRevocationReason(rs.getString("revocationReason"));
					qualificationRevocation.setRevocationId(rs.getString("revocationId"));
					
					page.getData().add(qualificationRevocation);
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
	 * 资质打回历史详细
	 */
	@Override
	public QualificationRevocation revocationHistoryPage(String revocationId) {
		// TODO Auto-generated method stub
		QualificationRevocation qualificationRevocation = new QualificationRevocation();
		String sql = "select * from TBQUALIFICATIONREVOCATION_LOG where revocationId = ? " ;
		
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revocationId);
			rs = pstmt.executeQuery();
			if ( rs.next() ) {
				qualificationRevocation.setAddress(rs.getString("address"));
				qualificationRevocation.setAddtypenum(rs.getString("addtypenum"));
				qualificationRevocation.setApprovaldeptname(rs.getString("approvaldeptname"));
				qualificationRevocation.setAssets(rs.getDouble("assets"));
				qualificationRevocation.setCertName(rs.getString("certName"));
				//qualificationRevocation.setCerttradestatusnum(rs.getString("certtradestatusnum"));
				//qualificationRevocation.setCheckforeign(rs.getString("checkforeign"));
				qualificationRevocation.setCityNum(rs.getString("cityNum"));
				qualificationRevocation.setCityName(rs.getString("cityName"));
				qualificationRevocation.setAdminareaName(rs.getString("adminareaName"));
				qualificationRevocation.setCorpBirthDate(rs.getDate("corpBirthDate"));
				qualificationRevocation.setCorpCode(rs.getString("corpCode"));
				qualificationRevocation.setCorpId(rs.getString("corpId"));
				qualificationRevocation.setCorpName(rs.getString("corpName"));
				qualificationRevocation.setCountyNum(rs.getString("countyNum"));
				qualificationRevocation.setCreatDate(rs.getDate("creatDate"));
				//qualificationRevocation.setDatasource(rs.getString("datasource"));
				qualificationRevocation.setDescription(rs.getString("description"));
				qualificationRevocation.setEconomicNum(rs.getInt("economicNum"));
				qualificationRevocation.setEconomicPropertyName(rs.getString("economicPropertyName"));
				qualificationRevocation.setEmail(rs.getString("email"));
				qualificationRevocation.setFactRegPrin(rs.getDouble("factRegPrin"));
				qualificationRevocation.setFax(rs.getString("fax"));
				//qualificationRevocation.setGradeName(rs.getString("gradeName"));
				qualificationRevocation.setIdcardtypeNum(rs.getString("idcardtypeNum"));
				qualificationRevocation.setLegalMan(rs.getString("legalMan"));
				qualificationRevocation.setLegalmanDuty(rs.getString("legalmanDuty"));
				qualificationRevocation.setLegalmanidCard(rs.getString("legalmanidCard"));
				qualificationRevocation.setLegamanProtitle(rs.getString("legamanProtitle"));
				qualificationRevocation.setLicenseNum(rs.getString("licenseNum"));
				qualificationRevocation.setLinkMan(rs.getString("linkMan"));
				qualificationRevocation.setLinkPhone(rs.getString("linkPhone"));
				qualificationRevocation.setLinkTel(rs.getString("linkTel"));
				qualificationRevocation.setPrincipalUnitName(rs.getString("principalUnitName"));
				qualificationRevocation.setProvinceNum(rs.getString("provinceNum"));
				//qualificationRevocation.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				qualificationRevocation.setProvinceName(rs.getString("provinceName"));
				qualificationRevocation.setRegPrin(rs.getDouble("regPrin"));
				qualificationRevocation.setSpare1(rs.getString("spare1"));
				qualificationRevocation.setTitlelevelnum(rs.getInt("titlelevelnum"));
				qualificationRevocation.setTradeboundnum(rs.getInt("tradeboundnum"));
				qualificationRevocation.setTradetypeName(rs.getString("tradetypeName"));
				qualificationRevocation.setUltimatedate(rs.getDate("ultimatedate"));
				qualificationRevocation.setUltimateresults(rs.getString("ultimateresults"));
				//qualificationRevocation.setRelationid(rs.getString("relationid"));
				qualificationRevocation.setRevocationDate(rs.getDate("revocationDate"));
				qualificationRevocation.setRevocationReason(rs.getString("revocationReason"));
				qualificationRevocation.setRevocationId(rs.getString("revocationId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return qualificationRevocation;
	}


	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEDIC where code like '104%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("codeName").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if(!cretSequenceId.equals(""))
		{
			String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"+cretSequenceId+"%'";
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setName(rs.getString("SPECIALTYTYPE").trim());
					dictionaryClass.setCode(rs.getString("code").trim());
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		// TODO Auto-generated method stub
		String sql = "select * from TBCRETGRADEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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
	
	public List<Department> getDepartment()
	{
		Connection connection = null;
		ResultSet rs = null;
		String sql = "select id,name from systembasic_department  where show =1 and property = 0 ";
		List<Department> list = new ArrayList<Department>();
		//String[][] dw =new String[100][2];
		try{			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				list.add(dept);
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
//				if(connection != null && !connection.isClosed())
//				{
//					connection.close();
//				}
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		return list;
	}

}
