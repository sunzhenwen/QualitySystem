/**
 * 
 */
package com.tj.jst.outside.businessReport.qualitychange.dao;

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
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;

/**
 * @author Administrator
 *
 */
public class QualityChangeDaoImpl extends BaseDao implements QualityChangeDao{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Connection qconn = null;
	PreparedStatement qstmt = null;
	ResultSet qrs = null;
	
	
//	@Override
//	public List<CertifiedService> queryQualityList(String corpId) 
//	{
//		
//		String sql =  " select * from V_SERVICECERTDETAIL a "
//					+ " where a.type=0  "
//					+ " and exists(select * from hlj_tjgx01.tbcorpcertdetailinfo where corpid=? "
//					+ "and oldornew=1 "
//					+ "and a.specialtytype=tradeboundnum and a.cretlevel=titlelevelnum) ";
//		List<CertifiedService> list = new ArrayList<CertifiedService>();
//		try {
//			conn = ConnectionFactory.getQualityConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,corpId);	
//			rs = pstmt.executeQuery();
//			while(rs.next())
//			{
//				CertifiedService certifiedService = new CertifiedService();
//				certifiedService.setCertId(rs.getString("certId"));		//������������
//				certifiedService.setCertName(rs.getString("certName"));	//������������
//				list.add(certifiedService);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally
//		{
//			ConnectionFactory.closeConn(conn, pstmt, null);
//		}
//		return list;
//	}
	//��ҵ�Ǽ�ע������
	@Override
	public DictionaryClass queryEconomicName(String code){
		String sql = "select code,corpregtype from TBECONTYPEDIC"
				+ "   where code=? ";
		//List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		DictionaryClass dictionaryClass = new DictionaryClass();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
			
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return dictionaryClass;
	}
	
	
	
	@Override
	public List<CertifiedService> queryQualityList(String corpId) 
	{
		
		List<CertifiedService> corpCertdetailInfoList = new ArrayList<CertifiedService>();
		corpCertdetailInfoList=queryCorpCertdetailInfoList(corpId);
		
		List<CertifiedService> certifiedServiceList = new ArrayList<CertifiedService>();
		for(CertifiedService tmp:corpCertdetailInfoList)
		{
			CertifiedService certifiedService=queryV_SERVICECERTDETAIL_One(tmp.getTRADEBOUNDNUM(),tmp.getTITLELEVELNUM());
			certifiedServiceList.add(certifiedService);
		}
		
		return certifiedServiceList;
	}
	
	public CertifiedService queryV_SERVICECERTDETAIL_One(String specialtytype,String cretlevel) 
	{
		
		String sql =  " select * from V_SERVICECERTDETAIL a "
					+ " where a.type=0  "
					+ " and a.specialtytype=? "
					+ " and a.cretlevel=? ";
		CertifiedService certifiedService = new CertifiedService();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,specialtytype);
			pstmt.setString(2,cretlevel);
			rs = pstmt.executeQuery();
			while(rs.next())
			{				
				certifiedService.setCertId(rs.getString("certId"));		//������������
				certifiedService.setCertName(rs.getString("certName"));	//������������
				certifiedService.setCretGrade(rs.getString("cretGrade"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certifiedService;
	}
	
	
	
	//��ѯ������corpID��tbcorpcertdetailinfo����е�����רҵ�͵ȼ�
	public List<CertifiedService> queryCorpCertdetailInfoList(String corpId) 
	{
		
		String sql =  " select distinct TRADEBOUNDNUM,TITLELEVELNUM  "
					+ " from tbcorpcertdetailinfo   "
					+ " where corpid=? "
					+ " and oldornew=1 "
					+ " and certtradestatusnum = 001"
					+ " order by TRADEBOUNDNUM,TITLELEVELNUM ";
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpId);	
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				CertifiedService certifiedService = new CertifiedService();
				certifiedService.setTRADEBOUNDNUM(rs.getString("TRADEBOUNDNUM"));//רҵ���
				certifiedService.setTITLELEVELNUM(rs.getString("TITLELEVELNUM"));//�ȼ�
				list.add(certifiedService);
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
	
	
	//�����ҵ
	@Override
	public String addQualityChange(TB_QUALITY_CHANGE qualityChange) 
	{
		String message = "";
		String sql = " insert into TB_QUALITY_CHANGE (QUALITY_CHANGE_ID, "
				+ "CORPID,"
				+ " CORPNAME, LICENSENUM, ADDRESS, REGPRIN, ECONOMICNUM, LEGALMAN, "
				+ " CHANGE_CORPNAME, CHANGE_LICENSENUM, CHANGE_ADDRESS, CHANGE_REGPRIN, CHANGE_ECONOMICNUM, CHANGE_LEGALMAN,"				
				+ "  ECONOMICNAME,CHANGE_ECONOMICNAME, LEVELSET,BZ,STATE,SPARE1,  "
				+ "  SPARENAME,CHANGE_SPARE1,CHANGE_SPARENAME,IS_CODE_MERGE,OLD_CORPCODE,NEW_CORPCODE "
				+ ") "			
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChange.getQUALITY_CHANGE_ID());			
			pstmt.setString(2,qualityChange.getCORPID());	//��ҵ����
			
			pstmt.setString(3,qualityChange.getCORPNAME());	//��ҵ����
			pstmt.setString(4,qualityChange.getLICENSENUM());//����Ӫҵִ��ע���
			pstmt.setString(5,qualityChange.getADDRESS());		//��ҵӪҵ��ַ
			pstmt.setString(6,qualityChange.getREGPRIN()); 		//ע���ʱ�(��Ԫ)
			pstmt.setString(7,qualityChange.getECONOMICNUM());	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setString(8,qualityChange.getLEGALMAN());	//��������������
	
			pstmt.setString(9,qualityChange.getCHANGE_CORPNAME());	//��ҵ����
			pstmt.setString(10,qualityChange.getCHANGE_LICENSENUM());//����Ӫҵִ��ע���
			pstmt.setString(11,qualityChange.getCHANGE_ADDRESS());		//��ҵӪҵ��ַ
			pstmt.setString(12,qualityChange.getCHANGE_REGPRIN()); 		//ע���ʱ�(��Ԫ)
			pstmt.setString(13,qualityChange.getCHANGE_ECONOMICNUM());	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)			
			pstmt.setString(14,qualityChange.getCHANGE_LEGALMAN());	
			
			pstmt.setString(15,qualityChange.getECONOMICNAME());	
			pstmt.setString(16,qualityChange.getCHANGE_ECONOMICNAME());	
			pstmt.setString(17,qualityChange.getLEVELSET());	
			pstmt.setString(18,qualityChange.getBZ());	
			pstmt.setString(19,qualityChange.getSTATE());
			pstmt.setString(20,qualityChange.getSPARE1());
			pstmt.setString(21,qualityChange.getSPARENAME());
			pstmt.setString(22,qualityChange.getCHANGE_SPARE1());
			pstmt.setString(23,qualityChange.getCHANGE_SPARENAME());
			pstmt.setString(24,qualityChange.getIS_CODE_MERGE());
			pstmt.setString(25,qualityChange.getOLD_CORPCODE());
			pstmt.setString(26,qualityChange.getNEW_CORPCODE());
			int check = pstmt.executeUpdate();
			if(check>0)
			{
				message = "����ɹ�,�뵽��������ˣ�";
			}else
			{
				message = "����ʧ�ܣ�";
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



	
	@Override
	public List<TB_QUALITY_CHANGE> queryQualityChange(String level,String city) 
	{
		// TODO �Զ����ɵķ������
		List<TB_QUALITY_CHANGE> list = new ArrayList<TB_QUALITY_CHANGE>();
		if(level.equals("1")){
			list=queryQualityChangeByCountry();
		}
		if(level.equals("2")){
			list=queryQualityChangeByProvince();
		}
		if(level.equals("3")){
			list=queryQualityChangeByCity(city);
		}
		if(level.equals("4")){
			list=queryQualityChangeByCountry();
			list.addAll(queryQualityChangeByProvince());
		}
		return list;
	}
	
	//��ʾ��ѯ����������
	public List<TB_QUALITY_CHANGE> queryQualityChangeByCountry() 
	{
		// TODO �Զ����ɵķ������
		String sql = " select "
				+ " QUALITY_CHANGE_ID,CORPID, "
				+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
				+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
				+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
				+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
				+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
				+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
				+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
				+ " LEVELSET,BZ,STATE,SPARE1"
				+ " from TB_QUALITY_CHANGE "
				+ " where instr(levelset,',1,')>0"
				+ " and bz=2 "
				+ " and state=1";
		List<TB_QUALITY_CHANGE> list = new ArrayList<TB_QUALITY_CHANGE>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
				qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
				qualityChange.setCORPID(rs.getString("CORPID"));
				
				qualityChange.setCORPNAME(rs.getString("CORPNAME"));
				qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
				qualityChange.setADDRESS(rs.getString("ADDRESS"));
				qualityChange.setREGPRIN(rs.getString("REGPRIN"));
				qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
				qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
				qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
				
				qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
				qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
				qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
				qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
				qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
				qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
				
				qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
				qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
				
				
				qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
				qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
				qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
				
				qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
				qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
				qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
				
				qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
				qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
				qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
				
				qualityChange.setLEVELSET(rs.getString("LEVELSET"));
				qualityChange.setSTATE(rs.getString("STATE"));
				qualityChange.setBZ(rs.getString("BZ"));
				qualityChange.setSPARE1(rs.getString("SPARE1"));
				qualityChange.setLEVELNAME("��������");
				list.add(qualityChange);
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
	
	//��ʾ��ѯʡ��������
	public List<TB_QUALITY_CHANGE> queryQualityChangeByProvince() 
	{
		// TODO �Զ����ɵķ������
		String sql = " select  "
				+ " QUALITY_CHANGE_ID,CORPID, "
				+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
				+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
				+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
				+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
				+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
				+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
				+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
				+ " LEVELSET,BZ,STATE,SPARE1"
				+ " from TB_QUALITY_CHANGE  "
				+ " where instr(levelset,',2,')>0 "
				+ " and bz=5 "
				+ " and state in('1','4') ";
		List<TB_QUALITY_CHANGE> list = new ArrayList<TB_QUALITY_CHANGE>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
				qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
				qualityChange.setCORPID(rs.getString("CORPID"));
				
				qualityChange.setCORPNAME(rs.getString("CORPNAME"));
				qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
				qualityChange.setADDRESS(rs.getString("ADDRESS"));
				qualityChange.setREGPRIN(rs.getString("REGPRIN"));
				qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
				qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
				qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
				
				qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
				qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
				qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
				qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
				qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
				qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
				
				qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
				qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
				
				
				qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
				qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
				qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
				
				qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
				qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
				qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
				
				qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
				qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
				qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
				
				qualityChange.setLEVELSET(rs.getString("LEVELSET"));
				qualityChange.setSTATE(rs.getString("STATE"));
				qualityChange.setBZ(rs.getString("BZ"));
				qualityChange.setSPARE1(rs.getString("SPARE1"));
				qualityChange.setLEVELNAME("ʡ������");
				list.add(qualityChange);
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
	
	
	//��ʾ��ѯʡ��������
	public List<TB_QUALITY_CHANGE> queryQualityChangeByCity(String city) 
	{
		// TODO �Զ����ɵķ������
		String sql = " select "
				+ " QUALITY_CHANGE_ID,CORPID, "
				+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
				+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
				+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
				+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
				+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
				+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
				+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
				+ " LEVELSET,BZ,STATE,SPARE1"
				+ " from TB_QUALITY_CHANGE "
				+ " where instr(levelset,',3,')>0 "
				+ " and bz=8 "
				+ " and state in('1','4','7')"
				+ " and spare1=? ";
		List<TB_QUALITY_CHANGE> list = new ArrayList<TB_QUALITY_CHANGE>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
				qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
				qualityChange.setCORPID(rs.getString("CORPID"));
				
				qualityChange.setCORPNAME(rs.getString("CORPNAME"));
				qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
				qualityChange.setADDRESS(rs.getString("ADDRESS"));
				qualityChange.setREGPRIN(rs.getString("REGPRIN"));
				qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
				qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
				qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
				
				qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
				qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
				qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
				qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
				qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
				qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
				
				qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
				qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
				
				
				qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
				qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
				qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
				
				qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
				qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
				qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
				
				qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
				qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
				qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
				
				qualityChange.setLEVELSET(rs.getString("LEVELSET"));
				qualityChange.setSTATE(rs.getString("STATE"));
				qualityChange.setBZ(rs.getString("BZ"));
				qualityChange.setSPARE1(rs.getString("SPARE1"));
				qualityChange.setLEVELNAME("��������");
				list.add(qualityChange);
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
	
	//��ʾ��ѯʡ��������
	public List<TB_QUALITY_CHANGE> selectQualityChange(String name) 
	{
		// TODO �Զ����ɵķ������
		String sql =  " select  "
					+ " QUALITY_CHANGE_ID,CORPID, "
					+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
					+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
					+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
					+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
					+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
					+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
					+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
					+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
					+ " LEVELSET,BZ,STATE,SPARE1"
					+ "	 from TB_QUALITY_CHANGE "
					+ "  where staff_country=? "
					+ "  or staff_province=? "
					+ "  or staff_city=? "
					+ "  and state in('3','6','9','4','7','10') ";
		List<TB_QUALITY_CHANGE> list = new ArrayList<TB_QUALITY_CHANGE>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
				qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
				qualityChange.setCORPID(rs.getString("CORPID"));
				
				qualityChange.setCORPNAME(rs.getString("CORPNAME"));
				qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
				qualityChange.setADDRESS(rs.getString("ADDRESS"));
				qualityChange.setREGPRIN(rs.getString("REGPRIN"));
				qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
				qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
				qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
				
				qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
				qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
				qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
				qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
				qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
				qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
				
				qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
				qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
				
				
				qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
				qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
				qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
				qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
				qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
				qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
				
				qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
				qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
				qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
				
				qualityChange.setLEVELSET(rs.getString("LEVELSET"));
				qualityChange.setSTATE(rs.getString("STATE"));
				qualityChange.setBZ(rs.getString("BZ"));
				qualityChange.setSPARE1(rs.getString("SPARE1"));
				if(rs.getString("STATE").equals("3")){
					qualityChange.setLEVELNAME("����������ͨ��");
				}
				if(rs.getString("STATE").equals("4"))
				{
					qualityChange.setLEVELNAME("��������ͨ��");
				}
				if(rs.getString("STATE").equals("6")){
					qualityChange.setLEVELNAME("ʡ��������ͨ��");
				}
				if(rs.getString("STATE").equals("7"))
				{
					qualityChange.setLEVELNAME("ʡ������ͨ��");
				}
				if(rs.getString("STATE").equals("9")){
					qualityChange.setLEVELNAME("����������ͨ��");
				}
				if(rs.getString("STATE").equals("10"))
				{
					qualityChange.setLEVELNAME("��������ͨ��");
				}
				//qualityChange.setLEVELNAME("��������");
				list.add(qualityChange);
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
	
	
	public TB_QUALITY_CHANGE queryQualityChangeById(String quality_change_id) 
	{
		// TODO �Զ����ɵķ������
		String sql = " select "
					+ " QUALITY_CHANGE_ID,CORPID, "
					+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
					+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
					+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
					+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
					+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
					+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
					+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
					+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
					+ " LEVELSET,BZ,STATE,SPARE1, "
					+ " SPARENAME,CHANGE_SPARE1,CHANGE_SPARENAME,IS_CODE_MERGE "
					+ " from TB_QUALITY_CHANGE "
					+ " where quality_change_id=? ";
		TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quality_change_id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				//TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
				qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
				qualityChange.setCORPID(rs.getString("CORPID"));
				
				qualityChange.setCORPNAME(rs.getString("CORPNAME"));
				qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
				qualityChange.setADDRESS(rs.getString("ADDRESS"));
				qualityChange.setREGPRIN(rs.getString("REGPRIN"));
				qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
				qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
				qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
				
				qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
				qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
				qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
				qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
				qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
				qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
				
				qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
				qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
				
				qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
				qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
				qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
				qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
				qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
				qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
				
				qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
				qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
				qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
				
				qualityChange.setLEVELSET(rs.getString("LEVELSET"));
				qualityChange.setSTATE(rs.getString("STATE"));
				qualityChange.setBZ(rs.getString("BZ"));
				qualityChange.setSPARE1(rs.getString("SPARE1"));
				qualityChange.setSPARENAME(rs.getString("SPARENAME"));
				qualityChange.setCHANGE_SPARE1(rs.getString("CHANGE_SPARE1"));
				qualityChange.setCHANGE_SPARENAME(rs.getString("CHANGE_SPARENAME"));
				
				qualityChange.setIS_CODE_MERGE(rs.getString("IS_CODE_MERGE"));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return qualityChange;
	}
	
	
	public String updateQualityChange(TB_QUALITY_CHANGE  qualityChange){
		String message = "";
		String sql = " update TB_QUALITY_CHANGE "
					+ " set  approval_country=?,"
					+ "      approval_province=?,"
					+ "      approval_city=?,  "
					+ "      staff_country=?,  "
					+ "      staff_province=?, "
					+ "      staff_city=?,  "
					+ "      bz=?, "
					+ "      state=?, "
					+ "      update_time=to_date(?,'yyyy-MM-dd HH24:mi:ss'), "
					+ "      approvaltime_country=to_date(?,'yyyy-MM-dd HH24:mi:ss'), "
					+ "      approvaltime_province=to_date(?,'yyyy-MM-dd HH24:mi:ss'), "
					+ "      approvaltime_city=to_date(?,'yyyy-MM-dd HH24:mi:ss')  "
					+ " where quality_change_id=? ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChange.getAPPROVAL_COUNTRY());
			pstmt.setString(2,qualityChange.getAPPROVAL_PROVINCE());
			pstmt.setString(3,qualityChange.getAPPROVAL_CITY());	
			pstmt.setString(4,qualityChange.getSTAFF_COUNTRY());	
			pstmt.setString(5,qualityChange.getSTAFF_PROVINCE());	
			pstmt.setString(6,qualityChange.getSTAFF_CITY());	
			pstmt.setString(7,qualityChange.getBZ());	
			pstmt.setString(8,qualityChange.getSTATE());
			pstmt.setString(9,qualityChange.getUPDATE_TIME());
			pstmt.setString(10,qualityChange.getAPPROVALTIME_COUNTRY());	
			pstmt.setString(11,qualityChange.getAPPROVALTIME_PROVINCE());
			pstmt.setString(12,qualityChange.getAPPROVALTIME_CITY());
			pstmt.setString(13,qualityChange.getQUALITY_CHANGE_ID());
			int check = pstmt.executeUpdate();
			if(check > 0)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
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
	
	
	
	
	
	public String updateQualityCertificate(TB_QUALITY_CHANGE qualityChange) {
		String message = "";
		updateCorpBasicInfo(qualityChange);
		QualificationApply(qualityChange);
		updateCorpCertDetailInfo(qualityChange);
		updateCorpCertInfo(qualityChange);
		return message;
	}
	
	public String QualificationApply (TB_QUALITY_CHANGE qualityChange)
	{
		String message = "";
		int check=0;
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
			{
				String sql = " update TBQUALIFICATIONAPPLY "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?,"
						+ " ADDRESS=?,"
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=?, "
						+ " CORPCODE=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());
				pstmt.setString(7,qualityChange.getCHANGE_LICENSENUM());	
				pstmt.setString(8,qualityChange.getCORPID());	
			}else
			{
				String sql = " update TBQUALIFICATIONAPPLY "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?,"
						+ " ADDRESS=?,"
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());	
				pstmt.setString(7,qualityChange.getCORPID());	
			}
			check = pstmt.executeUpdate();
			if(check > 0)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return message;
	}
	
	
	
	public String updateCorpBasicInfoSpare(TB_QUALITY_CHANGE qualityChange) {
		String message = "";
		int check=0;
		String sql =  " update tbcorpbasicinfo "
					+ " set "
					+ " SPARE1=? "
					+ " where corpid=? "
					+ " and oldornew=1  ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChange.getCHANGE_SPARE1());
			pstmt.setString(2,qualityChange.getCORPID());	
			
			check = pstmt.executeUpdate();
			if(check > 0)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		if(check>0)
		{
			try 
			{
				String sql2 =  " update tbcorpbasicinfo "
						+ " set "
						+ " SPARE1=? "
						+ " where corpid=? "
						+ " and oldornew=1  ";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_SPARE1());
				pstmt.setString(2,qualityChange.getCORPID());
				
				check = pstmt.executeUpdate();
				if(check > 0)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		
		
		return message;
	}
	
	
	
	public String updateCorpBasicInfo(TB_QUALITY_CHANGE qualityChange){
		String message = "";
		int check=0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
			{
				String sql = " update tbcorpbasicinfo "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?,"
						+ " ADDRESS=?,"
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=?, "
						+ " CORPCODE=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());
				pstmt.setString(7,qualityChange.getCHANGE_LICENSENUM());	
				pstmt.setString(8,qualityChange.getCORPID());	
			}else
			{
				String sql = " update tbcorpbasicinfo "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?,"
						+ " ADDRESS=?,"
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());	
				pstmt.setString(7,qualityChange.getCORPID());	
			}
			check = pstmt.executeUpdate();
			if(check > 0)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		if(check > 0)
		{
			try 
			{

				conn = ConnectionFactory.getQualityConnection();
				if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
				{
					String sql = " update tbcorpbasicinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?,"
							+ " ADDRESS=?,"
							+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=?, "
							+ " CORPCODE=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
					pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
					pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());
					pstmt.setString(7,qualityChange.getCHANGE_LICENSENUM());	
					pstmt.setString(8,qualityChange.getCORPID());	
				}else
				{
					String sql = " update tbcorpbasicinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?,"
							+ " ADDRESS=?,"
							+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
					pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
					pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());	
					pstmt.setString(7,qualityChange.getCORPID());	
				}
				check = pstmt.executeUpdate();
				if(check > 0)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}
	
	public String updateCorpCertDetailInfo(TB_QUALITY_CHANGE qualityChange){
		String message = "";
		int check=0;
		//+ " and certtradestatusnum='001' "
	try {
		
		conn = ConnectionFactory.getBasicConnection();
		if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
		{
			String sql = " update tbcorpcertdetailinfo "
					+ " set "
					+ " CORPNAME=?, "
					+ " LICENSENUM=?,"
					+ " ADDRESS=?,"
					//+ " REGPRIN=?, "
					+ " ECONOMICNUM=?, "
					+ " LEGALMAN=?, "
					+ " CORPCODE=? "
					+ " where corpid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
			pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
			pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
			//pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
			pstmt.setString(4,qualityChange.getCHANGE_ECONOMICNUM());	
			pstmt.setString(5,qualityChange.getCHANGE_LEGALMAN());
			pstmt.setString(6,qualityChange.getCHANGE_LICENSENUM());
			pstmt.setString(7,qualityChange.getCORPID());
		}
		else
		{
			String sql = " update tbcorpcertdetailinfo "
					+ " set "
					+ " CORPNAME=?, "
					+ " LICENSENUM=?,"
					+ " ADDRESS=?,"
					//+ " REGPRIN=?, "
					+ " ECONOMICNUM=?, "
					+ " LEGALMAN=? "
					+ " where corpid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
			pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
			pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
			//pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
			pstmt.setString(4,qualityChange.getCHANGE_ECONOMICNUM());	
			pstmt.setString(5,qualityChange.getCHANGE_LEGALMAN());	
			pstmt.setString(6,qualityChange.getCORPID());
		}

			
		check = pstmt.executeUpdate();
		if(check > 0)
		{
			message = "�޸ĳɹ���";
		}else
		{
			message = "�޸�ʧ�ܣ�";
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(check>0)
		{
			try 
			{
				conn = ConnectionFactory.getQualityConnection();
				if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
				{
					String sql = " update tbcorpcertdetailinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?,"
							+ " ADDRESS=?,"
							//+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=?, "
							+ " CORPCODE=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
					//pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
					pstmt.setString(4,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(5,qualityChange.getCHANGE_LEGALMAN());
					pstmt.setString(6,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(7,qualityChange.getCORPID());
				}
				else
				{
					String sql = " update tbcorpcertdetailinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?,"
							+ " ADDRESS=?,"
							//+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());	
					//pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());	
					pstmt.setString(4,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(5,qualityChange.getCHANGE_LEGALMAN());	
					pstmt.setString(6,qualityChange.getCORPID());
				}					
				check = pstmt.executeUpdate();
				if(check > 0)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
				} catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					ConnectionFactory.closeConn(conn, pstmt, null);
				}
		}	
		return message;
	}
	
	
	public String updateCorpCertInfo(TB_QUALITY_CHANGE qualityChange){
		String message = "";
		int check=0;
		try 
		{
			conn = ConnectionFactory.getBasicConnection();
			if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
			{
				String sql = " update tbcorpcertinfo "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?, "
						+ " ADDRESS=?, "
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=?, "
						+ " CORPCODE=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());		
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());		
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());
				pstmt.setString(7,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(8,qualityChange.getCORPID());	
			}
			else
			{
				String sql = " update tbcorpcertinfo "
						+ " set "
						+ " CORPNAME=?, "
						+ " LICENSENUM=?, "
						+ " ADDRESS=?, "
						+ " REGPRIN=?, "
						+ " ECONOMICNUM=?, "
						+ " LEGALMAN=? "
						+ " where corpid=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
				pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
				pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());		
				pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());		
				pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
				pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());	
				pstmt.setString(7,qualityChange.getCORPID());
			}
			
		check = pstmt.executeUpdate();
			System.out.println("check = " + check);
			if(check > 0)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(check>0)
		{
			try 
			{
				conn = ConnectionFactory.getQualityConnection();
				if(qualityChange.getIS_CODE_MERGE().trim().equals("1"))
				{
					String sql = " update tbcorpcertinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?, "
							+ " ADDRESS=?, "
							+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=?, "
							+ " CORPCODE=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());		
					pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());		
					pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());
					pstmt.setString(7,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(8,qualityChange.getCORPID());	
				}
				else
				{
					String sql = " update tbcorpcertinfo "
							+ " set "
							+ " CORPNAME=?, "
							+ " LICENSENUM=?, "
							+ " ADDRESS=?, "
							+ " REGPRIN=?, "
							+ " ECONOMICNUM=?, "
							+ " LEGALMAN=? "
							+ " where corpid=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,qualityChange.getCHANGE_CORPNAME());
					pstmt.setString(2,qualityChange.getCHANGE_LICENSENUM());
					pstmt.setString(3,qualityChange.getCHANGE_ADDRESS());		
					pstmt.setString(4,qualityChange.getCHANGE_REGPRIN());		
					pstmt.setString(5,qualityChange.getCHANGE_ECONOMICNUM());	
					pstmt.setString(6,qualityChange.getCHANGE_LEGALMAN());	
					pstmt.setString(7,qualityChange.getCORPID());
				}
				check = pstmt.executeUpdate();
				//System.out.println("check = " + check);
				if(check > 0)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		
		return message;
	}



	@Override
	public Page corpQualityChangeQuery(Condition condition) 
	{
		// TODO �Զ����ɵķ������
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
					qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
					qualityChange.setCORPID(rs.getString("CORPID"));					
					qualityChange.setCORPNAME(rs.getString("CORPNAME"));
					qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
					qualityChange.setADDRESS(rs.getString("ADDRESS"));
					qualityChange.setREGPRIN(rs.getString("REGPRIN"));
					qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
					qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
					qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));					
					qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
					qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
					qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
					qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
					qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
					qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
					qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));					
					qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
					qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
					qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
					qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
					qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));					
					qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
					qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
					qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));				
					qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
					qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
					qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));					
					qualityChange.setLEVELSET(rs.getString("LEVELSET"));
					qualityChange.setSTATE(rs.getString("STATE"));
					qualityChange.setBZ(rs.getString("BZ"));
					qualityChange.setSPARE1(rs.getString("SPARE1"));
//					if(Tools.isContain(rs.getString("LEVELSET"),",1,")&&Tools.isContain(rs.getString("LEVELSET"),",2,")&&Tools.isContain(rs.getString("LEVELSET"),",3,"))
//					{
//						qualityChange.setLEVELNAME("��,ʡ,����");
//					}
					
					if(rs.getString("BZ").equals("2"))
					{
						qualityChange.setACCEPT_DEPARTMENT("��������");
					}
					
					if(rs.getString("BZ").equals("5"))
					{
						qualityChange.setACCEPT_DEPARTMENT("ʡ����������");
					}
					
					if(rs.getString("BZ").equals("8"))
					{
						qualityChange.setACCEPT_DEPARTMENT("��������");
					}
					if(rs.getString("STATE").equals("1"))
					{
						qualityChange.setACCEPT_STATE("���������");
					}
					if(rs.getString("BZ").equals("2")&&rs.getString("STATE").equals("4"))
					{
						qualityChange.setACCEPT_STATE("��������ͨ��");
					}
					if(rs.getString("BZ").equals("5")&&rs.getString("STATE").equals("7"))
					{
						qualityChange.setACCEPT_STATE("ʡ����������ͨ��");
					}
					if(rs.getString("BZ").equals("8")&&rs.getString("STATE").equals("10"))
					{
						qualityChange.setACCEPT_STATE("��������ͨ��");
					}
					if(rs.getString("BZ").equals("2")&&rs.getString("STATE").equals("3"))
					{
						qualityChange.setACCEPT_STATE("����������ͨ��");
					}
					if(rs.getString("BZ").equals("5")&&rs.getString("STATE").equals("6"))
					{
						qualityChange.setACCEPT_STATE("ʡ������������ͨ��");
					}
					if(rs.getString("BZ").equals("8")&&rs.getString("STATE").equals("9"))
					{
						qualityChange.setACCEPT_STATE("����������ͨ��");
					}
					
					if(rs.getString("BZ").equals("5")&&rs.getString("STATE").equals("4"))
					{
						qualityChange.setACCEPT_STATE("��������ͨ����ʡ����������");
					}
					if(rs.getString("BZ").equals("8")&&rs.getString("STATE").equals("4"))
					{
						qualityChange.setACCEPT_STATE("��������ͨ������������");
					}
					
					if(rs.getString("BZ").equals("8")&&rs.getString("STATE").equals("7"))
					{
						qualityChange.setACCEPT_STATE("ʡ����������ͨ������������");
					}
					
					
					//qualityChange.setLEVELNAME("��������");
					page.getData().add(qualityChange);
				}
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	public Page selectQualityChange(Condition condition) 
	{
		// TODO �Զ����ɵķ������
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
					qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
					qualityChange.setCORPID(rs.getString("CORPID"));
					
					qualityChange.setCORPNAME(rs.getString("CORPNAME"));
					qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
					qualityChange.setADDRESS(rs.getString("ADDRESS"));
					qualityChange.setREGPRIN(rs.getString("REGPRIN"));
					qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
					qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
					qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
					
					qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
					qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
					qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
					qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
					qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
					qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
					qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
					
					qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
					qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
					
					
					qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
					qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
					qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
					qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
					qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
					qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
					
					qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
					qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
					qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
					
					qualityChange.setLEVELSET(rs.getString("LEVELSET"));
					qualityChange.setSTATE(rs.getString("STATE"));
					qualityChange.setBZ(rs.getString("BZ"));
					qualityChange.setSPARE1(rs.getString("SPARE1"));
					if(rs.getString("STATE").equals("3")){
						qualityChange.setLEVELNAME("����������ͨ��");
					}
					if(rs.getString("STATE").equals("4"))
					{
						qualityChange.setLEVELNAME("��������ͨ��");
					}
					if(rs.getString("STATE").equals("6")){
						qualityChange.setLEVELNAME("ʡ��������ͨ��");
					}
					if(rs.getString("STATE").equals("7"))
					{
						qualityChange.setLEVELNAME("ʡ������ͨ��");
					}
					if(rs.getString("STATE").equals("9")){
						qualityChange.setLEVELNAME("����������ͨ��");
					}
					if(rs.getString("STATE").equals("10"))
					{
						qualityChange.setLEVELNAME("��������ͨ��");
					}
					page.getData().add(qualityChange);
				}
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	
	public Page queryQualityChange(Condition condition) 
	{
		// TODO �Զ����ɵķ������
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					TB_QUALITY_CHANGE qualityChange = new TB_QUALITY_CHANGE();
					qualityChange.setQUALITY_CHANGE_ID(rs.getString("QUALITY_CHANGE_ID"));
					qualityChange.setCORPID(rs.getString("CORPID"));
					
					qualityChange.setCORPNAME(rs.getString("CORPNAME"));
					qualityChange.setLICENSENUM(rs.getString("LICENSENUM"));				
					qualityChange.setADDRESS(rs.getString("ADDRESS"));
					qualityChange.setREGPRIN(rs.getString("REGPRIN"));
					qualityChange.setECONOMICNUM(rs.getString("ECONOMICNUM"));
					qualityChange.setECONOMICNAME(rs.getString("ECONOMICNAME"));
					qualityChange.setLEGALMAN(rs.getString("LEGALMAN"));
					
					qualityChange.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
					qualityChange.setCHANGE_LICENSENUM(rs.getString("CHANGE_LICENSENUM"));				
					qualityChange.setCHANGE_ADDRESS(rs.getString("CHANGE_ADDRESS"));
					qualityChange.setCHANGE_REGPRIN(rs.getString("CHANGE_REGPRIN"));
					qualityChange.setCHANGE_ECONOMICNUM(rs.getString("CHANGE_ECONOMICNUM"));
					qualityChange.setCHANGE_ECONOMICNAME(rs.getString("CHANGE_ECONOMICNAME"));
					qualityChange.setCHANGE_LEGALMAN(rs.getString("CHANGE_LEGALMAN"));
					
					qualityChange.setCREATE_TIME(rs.getString("CREATE_TIME"));
					qualityChange.setUPDATE_TIME(rs.getString("UPDATE_TIME"));
					
					
					qualityChange.setAPPROVAL_COUNTRY(rs.getString("APPROVAL_COUNTRY"));
					qualityChange.setAPPROVAL_PROVINCE(rs.getString("APPROVAL_PROVINCE"));
					qualityChange.setAPPROVAL_CITY(rs.getString("APPROVAL_CITY"));
					qualityChange.setAPPROVALTIME_COUNTRY(rs.getString("APPROVALTIME_COUNTRY"));
					qualityChange.setAPPROVALTIME_PROVINCE(rs.getString("APPROVALTIME_PROVINCE"));
					qualityChange.setAPPROVALTIME_CITY(rs.getString("APPROVALTIME_CITY"));
					
					qualityChange.setSTAFF_COUNTRY(rs.getString("STAFF_COUNTRY"));
					qualityChange.setSTAFF_PROVINCE(rs.getString("STAFF_PROVINCE"));
					qualityChange.setSTAFF_CITY(rs.getString("STAFF_CITY"));
					
					qualityChange.setLEVELSET(rs.getString("LEVELSET"));
					qualityChange.setSTATE(rs.getString("STATE"));
					qualityChange.setBZ(rs.getString("BZ"));
					qualityChange.setSPARE1(rs.getString("SPARE1"));
					if(rs.getString("BZ").equals("2")){
						qualityChange.setLEVELNAME("��������");
					}
					if(rs.getString("BZ").equals("5")){
						qualityChange.setLEVELNAME("ʡ������");
					}
					if(rs.getString("BZ").equals("8")){
						qualityChange.setLEVELNAME("��������");
					}
					page.getData().add(qualityChange);
				}
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}



	@Override
	public String changeCorpCretInfoSpare(TB_QUALITY_CHANGE qualityChange) {
		// TODO Auto-generated method stub
		String message = "";
		int check=0;
		String sql0 = "select * from TBCORPCERTINFO where corpid = ? ";
		String sql =  " update TBCORPCERTINFO "
					+ " set "
					+ " SPARE1=? "
					+ " where corpcertid=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql0);
			pstmt.setString(1,qualityChange.getCORPID());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("SPARE1") != null)
				{
					qconn = ConnectionFactory.getBasicConnection();
					qstmt = qconn.prepareStatement(sql);
					qstmt.setString(1,qualityChange.getCHANGE_SPARE1());
					qstmt.setString(2,rs.getString("corpcertid"));	
					check = qstmt.executeUpdate();
					if(check > 0)
					{
						message = "�޸ĳɹ���";
					}else
					{
						message = "�޸�ʧ�ܣ�";
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(qconn, qstmt, null);
		}
		
		if(check>0)
		{
			try 
			{
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql0);
				pstmt.setString(1,qualityChange.getCORPID());
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					qconn = ConnectionFactory.getQualityConnection();
					qstmt = qconn.prepareStatement(sql);
					qstmt.setString(1,qualityChange.getCHANGE_SPARE1());
					qstmt.setString(2,rs.getString("corpcertid"));	
					check = qstmt.executeUpdate();
					if(check > 0)
					{
						message = "�޸ĳɹ���";
					}else
					{
						message = "�޸�ʧ�ܣ�";
					}
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
				ConnectionFactory.closeConn(qconn, qstmt, null);
			}
		}
		return message;
	}



	@Override
	public String getCheckType(String userId) 
	{
		String sql = "select CHECKTYPE from SYSTEMBASIC_DEPARTMENT"
				+ "   where ID=? ";
		//List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String checkType="";
		try 
		{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{	
				checkType=rs.getString("CHECKTYPE");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn,pstmt,rs);
		}	
		return checkType;
	}



	@Override
	public String deleteQualityChangeById(String qualityChangeId) {
		String message = "";
		String sql = " delete from  TB_QUALITY_CHANGE "
					+ " where state=1 and quality_change_id=? ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityChangeId);
			int check = pstmt.executeUpdate();
			if(check > 0)
			{
				message = "ɾ���ɹ���";
			}else
			{
				message = "ɾ��ʧ�ܣ�";
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
	
}
