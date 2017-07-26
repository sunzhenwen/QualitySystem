package com.tj.jst.inner.qualificationProductivity.certificatePrint.dao;

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
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ���Ҽ���ȷ��
 * @author hhc
 *
 */
public class CountryCertificatePrintDaoImpl extends BaseDao implements ICountryCertificatePrintDao {

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
					//certificatePrint.setCorpCertId(rs.getString("corpCertId")); //����
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
//					certificatePrint.setUntiManProTitle(rs.getString("UnitManProTitle")); //��ҵ������ְ��
					certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
					certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
					certificatePrint.setIsValid(rs.getInt("isValid")); //֤��״̬(�ֵ��TBCERTSTATEDIC)
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
//					certificatePrint.setRelationId(rs.getString("relationId"));
					certificatePrint.setQRCODE(rs.getString("qRCODE"));
					certificatePrint.setFBQRCODE(rs.getString("fBQRCODE"));
					certificatePrint.setPRINTNUMBER(rs.getString("pRINTNUMBER"));
					certificatePrint.setFBPRINTNUMBER(rs.getString("fBPRINTNUMBER"));
					certificatePrint.setUpdateType(rs.getString("updateType"));
					certificatePrint.setWriteOffType(rs.getString("writeOffType"));
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

	@Override
	public CertificatePrint confirmPage(String corpId,String certName) {
		CertificatePrint certificatePrint = new CertificatePrint();
		try {
			String sql = "select * from v_TBCORPCERTINFO where CORPID='"+corpId+"' and certName= '"+certName+"'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//certificatePrint.setCorpCertId(rs.getString("corpCertId")); //����
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
//				certificatePrint.setUntiManProTitle(rs.getString("UnitManProTitle")); //��ҵ������ְ��
				certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
				certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
				certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
				certificatePrint.setIsValid(rs.getInt("isValid")); //֤��״̬(�ֵ��TBCERTSTATEDIC)
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
//				certificatePrint.setRelationId(rs.getString("relationId"));
				certificatePrint.setQRCODE(rs.getString("qRCODE"));
				certificatePrint.setFBQRCODE(rs.getString("fBQRCODE"));
				certificatePrint.setPRINTNUMBER(rs.getString("pRINTNUMBER"));
				certificatePrint.setFBPRINTNUMBER(rs.getString("fBPRINTNUMBER"));
				certificatePrint.setUpdateType(rs.getString("updateType"));
				certificatePrint.setWriteOffType(rs.getString("writeOffType"));
				certificatePrint.setRelationId(rs.getString("relationId"));
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
	@Override
	public void confirm(CertificatePrint countryPrint) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			                                      
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTID=?,"
					+ "qualifType=? where relationId=? and corpId=?");
			pstmt.setString(1,countryPrint.getCertId());
			pstmt.setString(2,"9");
			pstmt.setString(3,countryPrint.getRelationId());
			pstmt.setString(4,countryPrint.getCorpId());
			pstmt.executeUpdate();
			
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set CERTID=?,ORGANDATE=?,"
					+ "ENDDATE=? where relationId=? and corpId=?");
			pstmt.setString(1,countryPrint.getCertId());	
			pstmt.setDate(2,countryPrint.getOrganDate());
			pstmt.setDate(3,countryPrint.getEndDate());
			pstmt.setString(4,countryPrint.getRelationId());
			pstmt.setString(5,countryPrint.getCorpId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? "
					+ "where certName=? and corpId=?");
			pstmt.setString(1,"9");	
			pstmt.setString(2,countryPrint.getCertName());
			pstmt.setString(3,countryPrint.getCorpId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.baseConfirm(countryPrint);
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
	 * ����ͨ��
	 */
	public void baseConfirm(CertificatePrint countryPrint) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTID=?,"
					+ "qualifType=? where relationId=? and corpId=?");
			pstmt.setString(1,countryPrint.getCertId());	
			pstmt.setString(2,"9");	
			pstmt.setString(3,countryPrint.getRelationId());
			pstmt.setString(4,countryPrint.getCorpId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set CERTID=?,ORGANDATE=?,"
					+ "ENDDATE=? where relationId=? and corpId=?");
			pstmt.setString(1,countryPrint.getCertId());	
			pstmt.setDate(2,countryPrint.getOrganDate());
			pstmt.setDate(3,countryPrint.getEndDate());
			pstmt.setString(4,countryPrint.getRelationId());
			pstmt.setString(5,countryPrint.getCorpId());
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
	 * �����˻�
	 */
	public void confirmBack(CertificatePrint countryPrint)
	{
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			                                      
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set "
					+ "qualifType=? where relationId=?");
			pstmt.setString(1,"10");
			pstmt.setString(2,countryPrint.getRelationId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? "
					+ "where newQualId=?");
			pstmt.setString(1,"10");	
			pstmt.setString(2,countryPrint.getRelationId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCORPCERTINFO where relationId=?");
			pstmt.setString(1,countryPrint.getRelationId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.baseConfirmBack(countryPrint);
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
	 * �����˻�
	 */
	public void baseConfirmBack(CertificatePrint countryPrint) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set "
					+ "qualifType=? where relationId=?");
			pstmt.setString(1,"10");	
			pstmt.setString(2,countryPrint.getRelationId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCORPCERTINFO where CORPCERTID=?");
			pstmt.setString(1,countryPrint.getCorpCertId());
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
}
