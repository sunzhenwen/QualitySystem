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
public class QualificationRevocationDaoImpl extends BaseDao implements IQualificationRevocationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
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
					qualificationRevocation.setCerttradestatusnum(rs.getString("certtradestatusnum"));
					qualificationRevocation.setCheckforeign(rs.getString("checkforeign"));
					qualificationRevocation.setCityNum(rs.getString("cityNum"));
					qualificationRevocation.setCityName(rs.getString("cityName"));
					qualificationRevocation.setAdminareaName(rs.getString("adminareaName"));
					qualificationRevocation.setCorpBirthDate(rs.getDate("corpBirthDate"));
					qualificationRevocation.setCorpCode(rs.getString("corpCode"));
					qualificationRevocation.setCorpId(rs.getString("corpId"));
					qualificationRevocation.setCorpName(rs.getString("corpName"));
					qualificationRevocation.setCountyNum(rs.getString("countyNum"));
					qualificationRevocation.setCreatDate(rs.getDate("creatDate"));
					qualificationRevocation.setDatasource(rs.getString("datasource"));
					qualificationRevocation.setDescription(rs.getString("description"));
					qualificationRevocation.setEconomicNum(rs.getInt("economicNum"));
					qualificationRevocation.setEconomicPropertyName(rs.getString("economicPropertyName"));
					qualificationRevocation.setEmail(rs.getString("email"));
					qualificationRevocation.setFactRegPrin(rs.getDouble("factRegPrin"));
					qualificationRevocation.setFax(rs.getString("fax"));
					qualificationRevocation.setGradeName(rs.getString("gradeName"));
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
					qualificationRevocation.setPrincipalUnitNum(rs.getString("principalUnitNum"));
					qualificationRevocation.setProvinceName(rs.getString("provinceName"));
					qualificationRevocation.setRegPrin(rs.getDouble("regPrin"));
					qualificationRevocation.setSpare1(rs.getString("spare1"));
					qualificationRevocation.setTitlelevelnum(rs.getInt("titlelevelnum"));
					qualificationRevocation.setTradeboundnum(rs.getInt("tradeboundnum"));
					qualificationRevocation.setTradetypeName(rs.getString("tradetypeName"));
					qualificationRevocation.setUltimatedate(rs.getDate("ultimatedate"));
					qualificationRevocation.setUltimateresults(rs.getString("ultimateresults"));
					qualificationRevocation.setRelationid(rs.getString("relationid"));
					
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
	 * 跳转打回页面
	 */
	@Override
	public QualificationRevocation revocationPage(String relationId) {
		// TODO Auto-generated method stub
		QualificationRevocation qualificationRevocation = new QualificationRevocation();
		String sql = "select * from V_QUALICATIONREVOCATION where relationId = ?" ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, relationId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qualificationRevocation.setAddress(rs.getString("address"));
				qualificationRevocation.setAddtypenum(rs.getString("addtypenum"));
				qualificationRevocation.setApprovaldeptname(rs.getString("approvaldeptname"));
				qualificationRevocation.setApprovaldept(rs.getString("approvaldept"));
				qualificationRevocation.setAssets(rs.getDouble("assets"));
				qualificationRevocation.setCertName(rs.getString("certName"));
				qualificationRevocation.setCerttradestatusnum(rs.getString("certtradestatusnum"));
				qualificationRevocation.setCheckforeign(rs.getString("checkforeign"));
				qualificationRevocation.setCityNum(rs.getString("cityNum"));
				qualificationRevocation.setCityName(rs.getString("cityName"));
				qualificationRevocation.setAdminareaName(rs.getString("adminareaName"));
				qualificationRevocation.setCorpBirthDate(rs.getDate("corpBirthDate"));
				qualificationRevocation.setCorpCode(rs.getString("corpCode"));
				qualificationRevocation.setCorpId(rs.getString("corpId"));
				qualificationRevocation.setCorpName(rs.getString("corpName"));
				qualificationRevocation.setCountyNum(rs.getString("countyNum"));
				qualificationRevocation.setCreatDate(rs.getDate("creatDate"));
				qualificationRevocation.setDatasource(rs.getString("datasource"));
				qualificationRevocation.setDescription(rs.getString("description"));
				qualificationRevocation.setEconomicNum(rs.getInt("economicNum"));
				qualificationRevocation.setEconomicPropertyName(rs.getString("economicPropertyName"));
				qualificationRevocation.setEmail(rs.getString("email"));
				qualificationRevocation.setFactRegPrin(rs.getDouble("factRegPrin"));
				qualificationRevocation.setFax(rs.getString("fax"));
				qualificationRevocation.setGradeName(rs.getString("gradeName"));
				qualificationRevocation.setIdcardtypeNum(rs.getString("idcardtypeNum"));
				qualificationRevocation.setPapertypeName(rs.getString("papertypeName"));
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
				qualificationRevocation.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				qualificationRevocation.setProvinceName(rs.getString("provinceName"));
				qualificationRevocation.setRegPrin(rs.getDouble("regPrin"));
				qualificationRevocation.setSpare1(rs.getString("spare1"));
				qualificationRevocation.setTitlelevelnum(rs.getInt("titlelevelnum"));
				qualificationRevocation.setTradeboundnum(rs.getInt("tradeboundnum"));
				qualificationRevocation.setTradetypeName(rs.getString("tradetypeName"));
				qualificationRevocation.setUltimatedate(rs.getDate("ultimatedate"));
				qualificationRevocation.setUltimateresults(rs.getString("ultimateresults"));
				qualificationRevocation.setAddtypeName(rs.getString("addtypeName"));
				qualificationRevocation.setUltimateopinion(rs.getString("ultimateopinion"));
				qualificationRevocation.setOfficePhone(rs.getString("officePhone"));
				qualificationRevocation.setPostalcode(rs.getString("postalcode"));
				qualificationRevocation.setRelationid(rs.getString("relationid"));
				qualificationRevocation.setCretGrade(rs.getString("cretGrade"));
				qualificationRevocation.setCertId(rs.getString("certId"));
				qualificationRevocation.setQualifType(rs.getString("qualifType"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qualificationRevocation;
	}
	
	/**
	 * 资质打回操作
	 * @return
	 */
	@Override
	public String revocation(QualificationRevocation qualificationRevocation) {
		// TODO Auto-generated method stub
		String message = "" ;
		int check = 0 ;
		
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement("delete from TBCORPCERTDETAILINFO where relationid = ?");
			pstmt.setString(1, qualificationRevocation.getRelationid());
			check = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCORPCERTINFO where relationid = ?");
			pstmt.setString(1, qualificationRevocation.getRelationid());
			check = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualiftype = ?,ultimateopinion = ?," +
					" approvalstaff = ?,approvalstaffid = ?,ultimatedate= ? ,ultimateresults = ? " +
					" where corpId = ? and specialtytype = ? and cretlevel = ? ");
			pstmt.setString(1, "1");
			pstmt.setString(2, "");
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setDate(5, null);
			pstmt.setString(6, "");
			pstmt.setString(7, qualificationRevocation.getCorpId());
			pstmt.setInt(8, qualificationRevocation.getTradeboundnum());
			pstmt.setInt(9, qualificationRevocation.getTitlelevelnum());
			pstmt.executeUpdate();
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("delete from TBCORPCERTDETAILINFO where relationid = ?");
			pstmt.setString(1, qualificationRevocation.getRelationid());
			check = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCORPCERTINFO where relationid = ?");
			pstmt.setString(1, qualificationRevocation.getRelationid());
			check = pstmt.executeUpdate();
			
			if(1 == check) {
				message = "打回成功，请到资质打回历史中查询" ;
				
				//将该资质低级资质恢复为有效
				this.recoverQualification(qualificationRevocation.getCorpId(),
						qualificationRevocation.getTradeboundnum(),qualificationRevocation.getTitlelevelnum()-1);
					
				this.logRevocation(qualificationRevocation);
			} else {
				//将打回操作存入log中
				message = "打回失败，请联系管理员" ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return message;
	}
	
	/**
	 * 将打回操作记录到log中
	 * @param qualificationRevocation
	 */
	private void logRevocation(QualificationRevocation qualificationRevocation) {
		// TODO Auto-generated method stub
		String sql = "insert into TBQUALIFICATIONREVOCATION_LOG (REVOCATIONID,CORPID," +
				"CORPNAME,CORPCODE,PROVINCENUM,PROVINCENAME,CITYNUM,CITYNAME,COUNTYNUM," +
				"ADMINAREANAME,QUALIFTYPE,CERTID,CERTNAME,TITLELEVELNUM,TRADEBOUNDNUM,CRETGRADE," +
				"APPROVALDEPTNAME,ADDTYPENUM,SPARE1,ULTIMATEOPINION,ULTIMATEDATE," +
				"ULTIMATERESULTS,ECONOMICNUM,LICENSENUM,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD," +
				"LEGALMANDUTY,LEGAMANPROTITLE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION," +
				"FACTREGPRIN,OFFICEPHONE,PAPERTYPENAME,ECONOMICPROPERTYNAME,PRINCIPALUNITNAME," +
				"TRADETYPENAME,ADDTYPENAME,REVOCATIONREASON,REVOCATIONDATE,ADDRESS,REGPRIN,ASSETS,CORPBIRTHDATE,APPROVALDEPT) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int check = 0 ;
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, qualificationRevocation.getCorpId());
			pstmt.setString(3, qualificationRevocation.getCorpName());
			pstmt.setString(4, qualificationRevocation.getCorpCode());
			pstmt.setString(5, qualificationRevocation.getProvinceNum());
			pstmt.setString(6, qualificationRevocation.getProvinceName());
			pstmt.setString(7, qualificationRevocation.getCityNum());
			pstmt.setString(8, qualificationRevocation.getCityName());
			pstmt.setString(9, qualificationRevocation.getCountyNum());
			pstmt.setString(10, qualificationRevocation.getAdminareaName());
			pstmt.setString(11, qualificationRevocation.getQualifType());
			pstmt.setString(12, qualificationRevocation.getCertId());
			pstmt.setString(13, qualificationRevocation.getCertName());
			pstmt.setInt(14, qualificationRevocation.getTitlelevelnum());
			pstmt.setInt(15, qualificationRevocation.getTradeboundnum());
			pstmt.setString(16, qualificationRevocation.getCretGrade());
			pstmt.setString(17, qualificationRevocation.getApprovaldeptname());
			pstmt.setString(18, qualificationRevocation.getAddtypenum());
			pstmt.setString(19, qualificationRevocation.getSpare1());
			pstmt.setString(20, qualificationRevocation.getUltimateopinion());
			pstmt.setDate(21, qualificationRevocation.getUltimatedate());
			pstmt.setString(22, qualificationRevocation.getUltimateresults());
			pstmt.setInt(23, qualificationRevocation.getEconomicNum());
			pstmt.setString(24, qualificationRevocation.getLicenseNum());
			pstmt.setString(25, qualificationRevocation.getLegalMan());
			pstmt.setString(26, qualificationRevocation.getIdcardtypeNum());
			pstmt.setString(27, qualificationRevocation.getLegalmanidCard());
			pstmt.setString(28, qualificationRevocation.getLegalmanDuty());
			pstmt.setString(29, qualificationRevocation.getLegamanProtitle());
			pstmt.setString(30, qualificationRevocation.getFax());
			pstmt.setString(31, qualificationRevocation.getLinkMan());
			pstmt.setString(32, qualificationRevocation.getLinkTel());
			pstmt.setString(33, qualificationRevocation.getLinkPhone());
			pstmt.setString(34, qualificationRevocation.getEmail());
			pstmt.setString(35, qualificationRevocation.getUrl());
			pstmt.setString(36, qualificationRevocation.getDescription());
			pstmt.setDouble(37, qualificationRevocation.getFactRegPrin());
			pstmt.setString(38, qualificationRevocation.getOfficePhone());
			pstmt.setString(39, qualificationRevocation.getPapertypeName());
			pstmt.setString(40, qualificationRevocation.getEconomicPropertyName());
			pstmt.setString(41, qualificationRevocation.getPrincipalUnitName());
			pstmt.setString(42, qualificationRevocation.getTradetypeName());
			pstmt.setString(43, qualificationRevocation.getAddtypeName());
			pstmt.setString(44, qualificationRevocation.getRevocationReason());
			pstmt.setDate(45, new Date(new java.util.Date().getTime()));
			pstmt.setString(46, qualificationRevocation.getAddress());
			pstmt.setDouble(47, qualificationRevocation.getRegPrin());
			pstmt.setDouble(48, qualificationRevocation.getAssets());
			pstmt.setDate(49, qualificationRevocation.getCorpBirthDate());
			pstmt.setString(50, qualificationRevocation.getApprovaldept());
			check = pstmt.executeUpdate();
			if(check > 0) {
				System.out.println("打回log保存成功！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 将该资质的低级资质恢复
	 * @param corpId
	 * @param tradeboundnum
	 * @param i
	 */
	private void recoverQualification(String corpId, Integer tradeboundnum,
			int titlelevelnum) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TBCORPCERTDETAILINFO " +
					"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=? " ;
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			pstmt.setInt(2, tradeboundnum);
			pstmt.setInt(3, titlelevelnum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=? " +
						"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=?");
				pstmt.setString(1, "001");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, tradeboundnum);
				pstmt.setInt(4, titlelevelnum);
				pstmt.executeUpdate();
				
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set certtradestatusnum=? " +
						"where corpId=? and tradeboundnum=? and titlelevelnum=?");
				pstmt.setString(1, "001");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, tradeboundnum);
				pstmt.setInt(4, titlelevelnum);
				pstmt.executeUpdate(); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
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
