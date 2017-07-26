package com.tj.jst.inner.qualificationProductivity.certificatePrint.dao;

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
 * ����֤���ӡ
 * @author hhc
 *
 */
public class CityCertificatePrintDaoImpl extends BaseDao implements ICityCertificatePrintDao {

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
					//certificatePrint.setCertTypeNum(rs.getInt("CertTypeNum")); //�����ʸ�����(�ֵ��TBAPTITUDEKINDDIC)
					//certificatePrint.setCertTypeName(rs.getString("CertTypeName"));//�����ʸ���������
					certificatePrint.setCertId(rs.getString("CertId")); //֤����
					//certificatePrint.setTitleLevelNum(rs.getInt("TitleLevelNum")); //�����ʸ���ߵȼ�(�ֵ��TBCERTTITLELEVELDIC)
					//certificatePrint.setTitleLevelName(rs.getString("TitleLevelName"));//�����ʸ���ߵȼ�
					//certificatePrint.setTechMan(rs.getString("TechMan")); //��������������
					//certificatePrint.setTechManDuty(rs.getString("TechManDuty")); //����������ְ��
					//certificatePrint.setTechManProTitle(rs.getString("TechManProTitle")); //����������ְ�ƻ�ְҵ�ʸ�
					//certificatePrint.setUnitMan(rs.getString("UnitMan")); //��ҵ����������
					//certificatePrint.setUnitManDuty(rs.getString("UnitManDuty")); //��ҵ������ְ��
					//certificatePrint.setUntiManProTitle(rs.getString("UnitManProTitle")); //��ҵ������ְ��
					//certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
					//certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
					//certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
					//certificatePrint.setIsValid(rs.getInt("corpCertId")); //֤��״̬(�ֵ��TBCERTSTATEDIC)
					//certificatePrint.setIsValidName(rs.getString("IsValidName"));//֤��״̬����
					//certificatePrint.setDescrpition(rs.getString("Descrpition")); //��ע
					//certificatePrint.setCorpId(rs.getString("CorpId")); //��ҵID
					//certificatePrint.setUpDateTime(rs.getDate("UpDateTime")); //��������
					//certificatePrint.setOldOrNew(rs.getString("OldOrNew")); //0�������� 1��������
					//certificatePrint.setDataSource(rs.getString("DataSource")); //������Դϵͳ
					//certificatePrint.setCertName(rs.getString("CertName")); //������𼰵ȼ�
					//certificatePrint.setApprovalDept(rs.getString("ApprovalDept")); //��������
					//certificatePrint.setApprovalStaff(rs.getString("ApprovalStaff")); //������Ա����
					//certificatePrint.setApprovalStaffId(rs.getString("ApprovalStaffId")); //������ԱId
					//certificatePrint.setUltimtDate(rs.getDate("ULTIMATEDATE")); //����ʱ��
					//certificatePrint.setCretGrade(rs.getString("CretGrade")); //���ʼ���(�ֵ��TBCRETGRADEDIC)���ҡ�ʡ������
					//certificatePrint.setCretGradeName(rs.getString("CretGradeName"));//���ʼ�������
					//certificatePrint.setAddTypeNum(rs.getString("AddTypeNum")); //�����ʸ�ȡ�÷�ʽ(�ֵ��TBADDTYPEDIC)003����
					//certificatePrint.setAddTypeName(rs.getString("AddTypeName"));//�����ʸ�ȡ�÷�ʽ����
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
					//certificatePrint.setApprovalDeptName(rs.getString("ApprovalDeptName")); //������������
					//certificatePrint.setProvinceNum(rs.getString("ProvinceNum")); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					//certificatePrint.setProvinceName(rs.getString("ProvinceName"));//ʡ����
					//certificatePrint.setCityNum(rs.getString("CityNum")); //ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					//certificatePrint.setCityName(rs.getString("CityName"));//������
					//certificatePrint.setCountyNum(rs.getString("CountyNum")); //ע��������(�����С���)(�ֵ��TBXZQDMDIC)
					//certificatePrint.setCountyName(rs.getString("CountyName"));//������
					//certificatePrint.setAddress(rs.getString("Address")); //��ҵӪҵ��ַ
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //��������������
					//certificatePrint.setIdCardTypeNum(rs.getString("IdCardTypeNum")); //����������֤������(�ֵ��TBIDCARDTYPEDIC)
					//certificatePrint.setIdCardTypeName(rs.getString("IdCardTypeName"));//֤����������
					//certificatePrint.setLegalManIdCard(rs.getString("LegalManIdCard")); //����������֤������
					//certificatePrint.setLegalManDuty(rs.getString("LegalManDuty")); //����������ְ��
					//certificatePrint.setLegaManProtitle(rs.getString("LegaManProtitle")); //����������ְ��
					//certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//��ҵ�Ǽ�ע����������
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //ע���ʱ�(��Ԫ)
					certificatePrint.setUpdateType(rs.getString("UpdateType").trim()); //�ϴ�״̬
					if("1".equals(rs.getString("UpdateType").trim()))
					{
						certificatePrint.setISPRINT("δ��ӡ");
					}else
					{
						certificatePrint.setISPRINT("���ϴ���ӡ��");
					}
					certificatePrint.setPRINTCOUNT(Integer.parseInt(rs.getString("UpdateType").trim())-1);
					
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
	public CertificatePrint queryPrint(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "select * from v_TBCORPCERTINFO where corpCode=? and endDate>=? "
				+ "and cretgrade=? order by EndDate asc ";
		CertificatePrint certificatePrint = new CertificatePrint();
		List<String> certNames = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, "3");
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				if(i==0)
				{
					certificatePrint.setCorpName(rs.getString("CorpName")); //��ҵ����
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //��ҵ��֯��������
					certificatePrint.setCertId(rs.getString("CertId")); //֤����
					certificatePrint.setOrganName(rs.getString("OrganName")); //��֤����
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //��֤����
					certificatePrint.setEndDate(rs.getDate("EndDate")); //֤����Ч�ڽ�ֹ����
					certNames.add(rs.getString("CertName"));
					certificatePrint.setCertNames(certNames);//������𼰵ȼ�
					//certificatePrint.setCertName(rs.getString("CertName")); //������𼰵ȼ�
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
					//certificatePrint.setProvinceName(rs.getString("ProvinceName"));//ʡ����
					//certificatePrint.setCityName(rs.getString("CityName"));//������
					//certificatePrint.setCountyName(rs.getString("CountyName"));//������
					certificatePrint.setAddress(rs.getString("Address")); //��ҵӪҵ��ַ
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //��������������
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//��ҵ�Ǽ�ע����������
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //ע���ʱ�(��Ԫ)
					certificatePrint.setUpdateType(rs.getString("updatetype").trim()); //�Ƿ��ӡ��
					certificatePrint.setPrintDate(new Date(new java.util.Date().getTime()));
					certificatePrint.setQRCODE(rs.getString("QRCODE"));
					certificatePrint.setFBQRCODE(rs.getString("FBQRCODE"));
					certificatePrint.setPRINTNUMBER(rs.getString("PRINTNUMBER"));
					certificatePrint.setFBPRINTNUMBER(rs.getString("FBPRINTNUMBER"));
					
				}else
				{
					certNames.add(rs.getString("CertName"));
					certificatePrint.setCertNames(certNames);//������𼰵ȼ�
				}
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return certificatePrint;
	}
	
	public void updateCertificateNumber(String certid, String type,String number) 
	{
		String sql="";
		if(type.equals("QRCODE"))
		{
			sql = " update TBCORPCERTINFO "
				+ " set  QRCODE=? "
				+ " where certid=? ";
		}
		if(type.equals("FBQRCODE"))
		{
			sql = " update TBCORPCERTINFO "
				+ " set  FBQRCODE=? "
				+ " where certid=? ";
		}
		if(type.equals("PRINTNUMBER"))
		{
			sql = " update TBCORPCERTINFO "
				+ " set  PRINTNUMBER=? "
				+ " where certid=? ";
		}
		if(type.equals("FBPRINTNUMBER"))
		{
			sql = " update TBCORPCERTINFO "
				+ " set  FBPRINTNUMBER=? "
				+ " where certid=? ";
		}

		try 
		{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,number);
			pstmt.setString(2,certid);
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
	}
	
	
	
	
	
}
