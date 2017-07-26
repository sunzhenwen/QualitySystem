package com.tj.jst.inner.qualificationProductivity.writeOff.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ��ҵ����ע��
 * @author Administrator
 *
 */
public class WriteOffDaoImpl extends BaseDao implements IWriteOffDao {

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
					CertificatePrint certificatePrint = new CertificatePrint();
					certificatePrint.setCorpCertId(rs.getString("corpCertId")); //����
					certificatePrint.setCorpName(rs.getString("CorpName")); //��ҵ����
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //��֯��������
//					certificatePrint.setCertTypeNum(rs.getInt("CertTypeNum")); //�����ʸ�����(�ֵ��TBAPTITUDEKINDDIC)
//					certificatePrint.setCertTypeName(rs.getString("CertTypeName"));//�����ʸ���������
					certificatePrint.setCertId(rs.getString("CertId")); //֤����
//					certificatePrint.setTitleLevelNum(rs.getInt("TitleLevelNum")); //�����ʸ���ߵȼ�(�ֵ��TBCERTTITLELEVELDIC)
//					certificatePrint.setTitleLevelName(rs.getString("TitleLevelName"));//�����ʸ���ߵȼ�
//					certificatePrint.setTechMan(rs.getString("TechMan")); //��������������
//					certificatePrint.setTechManDuty(rs.getString("TechManDuty")); //����������ְ��
//					certificatePrint.setTechManProTitle(rs.getString("TechManProTitle")); //����������ְ�ƻ�ְҵ�ʸ�
//					certificatePrint.setUnitMan(rs.getString("UnitMan")); //��ҵ����������
//					certificatePrint.setUnitManDuty(rs.getString("UnitManDuty")); //��ҵ������ְ��
//					certificatePrint.setUntiManProTitle(rs.getString("UntiManProTitle")); //��ҵ������ְ��
					certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
					certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
//					certificatePrint.setIsValid(rs.getInt("corpCertId")); //֤��״̬(�ֵ��TBCERTSTATEDIC)
//					certificatePrint.setIsValidName(rs.getString("IsValidName"));//֤��״̬����
//					certificatePrint.setDescrpition(rs.getString("Descrpition")); //��ע
					certificatePrint.setCorpId(rs.getString("CorpId")); //��ҵID
//					certificatePrint.setUpDateTime(rs.getDate("UpDateTime")); //��������
//					certificatePrint.setOldOrNew(rs.getString("OldOrNew")); //0�������� 1��������
//					certificatePrint.setDataSource(rs.getString("DataSource")); //������Դϵͳ
					certificatePrint.setCertName(rs.getString("CertName")); //������𼰵ȼ�
//					certificatePrint.setApprovalDept(rs.getString("ApprovalDept")); //��������
//					certificatePrint.setApprovalStaff(rs.getString("ApprovalStaff")); //������Ա����
//					certificatePrint.setApprovalStaffId(rs.getString("ApprovalStaffId")); //������ԱId
//					certificatePrint.setUltimtDate(rs.getDate("ULTIMATEDATE")); //����ʱ��
					certificatePrint.setCretGrade(rs.getString("CretGrade")); //���ʼ���(�ֵ��TBCRETGRADEDIC)���ҡ�ʡ������
//					certificatePrint.setCretGradeName(rs.getString("CretGradeName"));//���ʼ�������
//					certificatePrint.setAddTypeNum(rs.getString("AddTypeNum")); //�����ʸ�ȡ�÷�ʽ(�ֵ��TBADDTYPEDIC)003����
//					certificatePrint.setAddTypeName(rs.getString("AddTypeName"));//�����ʸ�ȡ�÷�ʽ����
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
//					certificatePrint.setApprovalDeptName(rs.getString("ApprovalDeptName")); //������������
//					certificatePrint.setProvinceNum(rs.getString("ProvinceNum")); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
//					certificatePrint.setProvinceName(rs.getString("ProvinceName"));//ʡ����
//					certificatePrint.setCityNum(rs.getString("CityNum")); //ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
//					certificatePrint.setCityName(rs.getString("CityName"));//������
//					certificatePrint.setCountyNum(rs.getString("CountyNum")); //ע��������(�����С���)(�ֵ��TBXZQDMDIC)
//					certificatePrint.setCountyName(rs.getString("CountyName"));//������
					certificatePrint.setAddress(rs.getString("Address")); //��ҵӪҵ��ַ
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //��������������
//					certificatePrint.setIdCardTypeNum(rs.getString("IdCardTypeNum")); //����������֤������(�ֵ��TBIDCARDTYPEDIC)
//					certificatePrint.setIdCardTypeName(rs.getString("IdCardTypeName"));//֤����������
//					certificatePrint.setLegalManIdCard(rs.getString("LegalManIdCard")); //����������֤������
//					certificatePrint.setLegalManDuty(rs.getString("LegalManDuty")); //����������ְ��
//					certificatePrint.setLegaManProtitle(rs.getString("LegaManProtitle")); //����������ְ��
					certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//��ҵ�Ǽ�ע����������
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //ע���ʱ�(��Ԫ)
					certificatePrint.setRelationId(rs.getString("relationId"));
//					certificatePrint.setRecoverDate(rs.getDate("recoverDate"));//�ָ�ʱ��
//					certificatePrint.setRecoverStaffId(rs.getString("recoverStaffId"));//�ָ���Id
//					certificatePrint.setRecoverStaffName(rs.getString("recoverStaffName"));//�ظ�������
					certificatePrint.setWriteOffType(rs.getString("writeOffType"));
					certificatePrint.setWriteOffAppDate(rs.getDate("writeOffAppDate"));
					//certificatePrint.setspare1
					certificatePrint.setIsValid(rs.getInt("isValid"));
					page.getData().add(certificatePrint);
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

	@Override
	public List<CertificatePrint> queryCertinfo(String[] ids) {
		// TODO Auto-generated method stub
		String sql = "select * from v_TBCORPCERTINFO where corpcertid=?";
		
		List<CertificatePrint> list = new ArrayList<CertificatePrint>();
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<ids.length;i++)
			{
				pstmt.setString(1, ids[i]);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					CertificatePrint certificatePrint = new CertificatePrint();
					certificatePrint.setCorpCertId(rs.getString("corpCertId"));//����
					certificatePrint.setRelationId(rs.getString("relationId"));
					list.add(certificatePrint);
				}
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

	/**
	 * ����ͨ��
	 * @param list
	 * @param personalId
	 * @param personalName
	 */
	public void batchWriteOff(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,writeOffDate=?,"
						+ "writeOffStaffName=?,writeOffStaffId=?,WRITEOFFTYPE=?,WRITEAPPOPINION=? "
						+ "where RELATIONID=?");
				pstmt.setInt(1,2);	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "2");
				pstmt.setString(6, "����ע��");
				pstmt.setString(7,list.get(i).getRelationId());
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
						+ "writeOffDate=?,writeOffStaffName=?,writeOffStaffId=? where RELATIONID=?");
				pstmt.setString(1,"002");
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5,list.get(i).getRelationId());
				pstmt.executeUpdate();
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	@Override
	public void baseBatchWriteOff(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,writeOffDate=?,"
						+ "writeOffStaffName=?,writeOffStaffId=?,WRITEOFFTYPE=?,WRITEAPPOPINION=? "
						+ "where CORPCERTID=?");
				pstmt.setInt(1,2);	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "2");
				pstmt.setString(6, "����ע��");
				pstmt.setString(7,list.get(i).getCorpCertId());
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
						+ "writeOffDate=?,writeOffStaffName=?,writeOffStaffId=? where RELATIONID=?");
				pstmt.setString(1,"002");	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5,list.get(i).getRelationId());
				pstmt.executeUpdate();
			}
			
			conn.commit();
			this.batchWriteOff(list,personalId,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ������������
	 * �޸Ļ�����
	 */
	@Override
	public void floorBaseBatchWriteOff(List<CertificatePrint> list,
			String personalId, String personalName) {
		// TODO Auto-generated method stub

		try {
			
				conn = ConnectionFactory.getBasicConnection();
				conn.setAutoCommit(false);
				for (int i=0 ;i<list.size(); i++) {
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set writeOffFloorDate=?,"
							+ "writeOffFloorStaffName=?,writeOffFloorStaffId=?,WRITEOFFTYPE=?,writeOffFloorOpinion=? "
							+ "where CORPCERTID=?");
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				pstmt.setString(2, personalName);
				pstmt.setString(3, personalId);
				pstmt.setString(4, "4");
				pstmt.setString(5, "ͬ��");
				pstmt.setString(6,list.get(i).getCorpCertId());
				pstmt.executeUpdate();
			}
			conn.commit();
			this.floorBaseBatchWriteOff1(list, personalId, personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	
		
	}
	
	/**
	 * ������������
	 * �޸����ʿ�
	 */
	public void floorBaseBatchWriteOff1(List<CertificatePrint> list,
			String personalId, String personalName) {
		// TODO Auto-generated method stub
		
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			for (int i=0 ;i<list.size(); i++) {
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set writeOffFloorDate=?,"
						+ "writeOffFloorStaffName=?,writeOffFloorStaffId=?,WRITEOFFTYPE=?,writeOffFloorOpinion=? "
						+ "where relationId=?");
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				pstmt.setString(2, personalName);
				pstmt.setString(3, personalId);
				pstmt.setString(4, "4");
				pstmt.setString(5, "ͬ��");
				pstmt.setString(6,list.get(i).getRelationId());
				pstmt.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		
	}
	
	
	@Override
	public List<DictionaryClass> queryEconmicNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBECONTYPEDIC where code not like '%00'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("CORPREGTYPE").trim());
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
	
	/**
	 * �˻�
	 */
	@Override
	public void baseWriteOffReturn(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
						+ "WRITERETURNDATE=?,WRITERETURNSTAFFNAME=?,WRITERETURNSTAFFID=?,"
						+ "WRITEAPPOPINION=? where CORPCERTID=?");
				pstmt.setString(1,"3");	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "ע�������˻�");
				pstmt.setString(6,list.get(i).getCorpCertId());
				pstmt.executeUpdate();
			}
			
			conn.commit();
			this.batchWriteOffReturn(list,personalId,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * �˻�
	 */
	public void batchWriteOffReturn(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
						+ "WRITERETURNDATE=?,WRITERETURNSTAFFNAME=?,WRITERETURNSTAFFID=?,"
						+ "WRITEAPPOPINION=? where RELATIONID=?");
				pstmt.setString(1,"3");	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "ע�������˻�");
				pstmt.setString(6,list.get(i).getRelationId());
				pstmt.executeUpdate();
				
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ��ת����ҳ���ѯ
	 */
	@Override
	public CertificatePrint approvalPage(String corpCertId) {
		CertificatePrint certificatePrint = new CertificatePrint();
		try {
			String sql = "select * from v_TBCORPCERTINFO where corpcertid=? ";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCertId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				certificatePrint.setCorpCertId(rs.getString("corpCertId")); //����
				certificatePrint.setCorpName(rs.getString("CorpName")); //��ҵ����
				certificatePrint.setCorpCode(rs.getString("CorpCode")); //��֯��������
//				certificatePrint.setCertTypeNum(rs.getInt("CertTypeNum")); //�����ʸ�����(�ֵ��TBAPTITUDEKINDDIC)
//				certificatePrint.setCertTypeName(rs.getString("CertTypeName"));//�����ʸ���������
				certificatePrint.setCertId(rs.getString("CertId")); //֤����
//				certificatePrint.setTitleLevelNum(rs.getInt("TitleLevelNum")); //�����ʸ���ߵȼ�(�ֵ��TBCERTTITLELEVELDIC)
//				certificatePrint.setTitleLevelName(rs.getString("TitleLevelName"));//�����ʸ���ߵȼ�
//				certificatePrint.setTechMan(rs.getString("TechMan")); //��������������
//				certificatePrint.setTechManDuty(rs.getString("TechManDuty")); //����������ְ��
//				certificatePrint.setTechManProTitle(rs.getString("TechManProTitle")); //����������ְ�ƻ�ְҵ�ʸ�
//				certificatePrint.setUnitMan(rs.getString("UnitMan")); //��ҵ����������
//				certificatePrint.setUnitManDuty(rs.getString("UnitManDuty")); //��ҵ������ְ��
//				certificatePrint.setUntiManProTitle(rs.getString("UntiManProTitle")); //��ҵ������ְ��
				certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
				certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
				certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
//				certificatePrint.setIsValid(rs.getInt("corpCertId")); //֤��״̬(�ֵ��TBCERTSTATEDIC)
//				certificatePrint.setIsValidName(rs.getString("IsValidName"));//֤��״̬����
//				certificatePrint.setDescrpition(rs.getString("Descrpition")); //��ע
				certificatePrint.setCorpId(rs.getString("CorpId")); //��ҵID
//				certificatePrint.setUpDateTime(rs.getDate("UpDateTime")); //��������
//				certificatePrint.setOldOrNew(rs.getString("OldOrNew")); //0�������� 1��������
//				certificatePrint.setDataSource(rs.getString("DataSource")); //������Դϵͳ
				certificatePrint.setCertName(rs.getString("CertName")); //������𼰵ȼ�
//				certificatePrint.setApprovalDept(rs.getString("ApprovalDept")); //��������
//				certificatePrint.setApprovalStaff(rs.getString("ApprovalStaff")); //������Ա����
//				certificatePrint.setApprovalStaffId(rs.getString("ApprovalStaffId")); //������ԱId
//				certificatePrint.setUltimtDate(rs.getDate("ULTIMATEDATE")); //����ʱ��
				certificatePrint.setCretGrade(rs.getString("CretGrade")); //���ʼ���(�ֵ��TBCRETGRADEDIC)���ҡ�ʡ������
//				certificatePrint.setCretGradeName(rs.getString("CretGradeName"));//���ʼ�������
//				certificatePrint.setAddTypeNum(rs.getString("AddTypeNum")); //�����ʸ�ȡ�÷�ʽ(�ֵ��TBADDTYPEDIC)003����
//				certificatePrint.setAddTypeName(rs.getString("AddTypeName"));//�����ʸ�ȡ�÷�ʽ����
				certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
//				certificatePrint.setApprovalDeptName(rs.getString("ApprovalDeptName")); //������������
//				certificatePrint.setProvinceNum(rs.getString("ProvinceNum")); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
//				certificatePrint.setProvinceName(rs.getString("ProvinceName"));//ʡ����
//				certificatePrint.setCityNum(rs.getString("CityNum")); //ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
//				certificatePrint.setCityName(rs.getString("CityName"));//������
//				certificatePrint.setCountyNum(rs.getString("CountyNum")); //ע��������(�����С���)(�ֵ��TBXZQDMDIC)
//				certificatePrint.setCountyName(rs.getString("CountyName"));//������
				certificatePrint.setAddress(rs.getString("Address")); //��ҵӪҵ��ַ
				certificatePrint.setLegalMan(rs.getString("LegalMan")); //��������������
//				certificatePrint.setIdCardTypeNum(rs.getString("IdCardTypeNum")); //����������֤������(�ֵ��TBIDCARDTYPEDIC)
//				certificatePrint.setIdCardTypeName(rs.getString("IdCardTypeName"));//֤����������
//				certificatePrint.setLegalManIdCard(rs.getString("LegalManIdCard")); //����������֤������
//				certificatePrint.setLegalManDuty(rs.getString("LegalManDuty")); //����������ְ��
//				certificatePrint.setLegaManProtitle(rs.getString("LegaManProtitle")); //����������ְ��
				certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				certificatePrint.setEconmicName(rs.getString("EconmicName"));//��ҵ�Ǽ�ע����������
				certificatePrint.setRegPrin(rs.getString("RegPrin")); //ע���ʱ�(��Ԫ)
				certificatePrint.setRelationId(rs.getString("relationId"));
//				certificatePrint.setRecoverDate(rs.getDate("recoverDate"));//�ָ�ʱ��
//				certificatePrint.setRecoverStaffId(rs.getString("recoverStaffId"));//�ָ���Id
//				certificatePrint.setRecoverStaffName(rs.getString("recoverStaffName"));//�ظ�������
				certificatePrint.setWriteOffType(rs.getString("writeOffType"));
				certificatePrint.setWriteOffAppDate(rs.getDate("writeOffAppDate"));
				//certificatePrint.setspare1
				certificatePrint.setIsValid(rs.getInt("isValid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certificatePrint;
	}
	
	/**
	 * ����ͨ��
	 */
	public void applythrough(CertificatePrint certificatePrint,String personalId,String personalName)
	{
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,writeOffDate=?,"
						+ "writeOffStaffName=?,writeOffStaffId=?,WRITEOFFTYPE=?,WRITEAPPOPINION=? "
						+ "where CORPCERTID=?");
			pstmt.setInt(1,2);	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5, "2");
			pstmt.setString(6, certificatePrint.getWriteAppOpinion());
			pstmt.setString(7,certificatePrint.getCorpCertId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
					+ "writeOffDate=?,writeOffStaffName=?,writeOffStaffId=? where RELATIONID=?");
			pstmt.setString(1,"002");	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5,certificatePrint.getRelationId());
			pstmt.executeUpdate();
			conn.commit();
			this.batchWriteOffForId(certificatePrint,personalId,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ��������ͨ��
	 * �޸Ļ�����
	 */
	@Override
	public void floorApplythrough(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub

		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set writeOffFloorDate=?,"
						+ "writeOffFloorStaffName=?,writeOffFloorStaffId=?,WRITEOFFTYPE=?,writeOffFloorOpinion=? "
						+ "where CORPCERTID=?");
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, personalName);
			pstmt.setString(3, personalID);
			pstmt.setString(4, "4");
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getCorpCertId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.floorApplythrough1(certificatePrint,personalID,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	
		
	}
	
	/**
	 * ��������ͨ��
	 * �޸����ʿ�
	 */
	public void floorApplythrough1(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub

		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set writeOffFloorDate=?,"
						+ "writeOffFloorStaffName=?,writeOffFloorStaffId=?,WRITEOFFTYPE=?,writeOffFloorOpinion=? "
						+ "where relationId=?");
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, personalName);
			pstmt.setString(3, personalID);
			pstmt.setString(4, "4");
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getRelationId());
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	
		
	}
	
	public void batchWriteOffForId(CertificatePrint certificatePrint,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,writeOffDate=?,"
						+ "writeOffStaffName=?,writeOffStaffId=?,WRITEOFFTYPE=?,WRITEAPPOPINION=? "
						+ "where RELATIONID=?");
			pstmt.setInt(1,2);	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5, "2");
			pstmt.setString(6, certificatePrint.getWriteAppOpinion());
			pstmt.setString(7,certificatePrint.getRelationId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
					+ "writeOffDate=?,writeOffStaffName=?,writeOffStaffId=? where RELATIONID=?");
			pstmt.setString(1,"002");
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5,certificatePrint.getRelationId());
			pstmt.executeUpdate();
			
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}


	/**
	 * �˻�
	 */
	@Override
	public void applyBack(CertificatePrint certificatePrint,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
						+ "WRITERETURNDATE=?,WRITERETURNSTAFFNAME=?,WRITERETURNSTAFFID=?,"
						+ "WRITEAPPOPINION=? where CORPCERTID=?");
			pstmt.setString(1,"3");	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getCorpCertId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.applyBackForId(certificatePrint,personalId,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * �˻�
	 */
	public void applyBackForId(CertificatePrint certificatePrint,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
						+ "WRITERETURNDATE=?,WRITERETURNSTAFFNAME=?,WRITERETURNSTAFFID=?,"
						+ "WRITEAPPOPINION=? where RELATIONID=?");
			pstmt.setString(1,"3");	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalId);
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getRelationId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ���������˻�
	 * �޸Ļ�����
	 */
	@Override
	public void floorApplyBack(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub

		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
						+ "writeOffFloorDate=?,writeOffFloorStaffName=?,writeOffFloorStaffId=?,"
						+ "writeOffFloorOpinion=? where CORPCERTID=?");
			pstmt.setString(1,"5");	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalID);
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getCorpCertId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.floorApplyBack1(certificatePrint,personalID,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	
		
	}
	
	/**
	 * ���������˻�
	 * �޸����ʿ�
	 */
	public void floorApplyBack1(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub
		
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set WRITEOFFTYPE=?,"
					+ "writeOffFloorDate=?,writeOffFloorStaffName=?,writeOffFloorStaffId=?,"
					+ "writeOffFloorOpinion=? where CORPCERTID=?");
			pstmt.setString(1,"5");	
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, personalName);
			pstmt.setString(4, personalID);
			pstmt.setString(5, certificatePrint.getWriteAppOpinion());
			pstmt.setString(6,certificatePrint.getCorpCertId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.applyBackForId(certificatePrint,personalID,personalName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		
	}



	
}
