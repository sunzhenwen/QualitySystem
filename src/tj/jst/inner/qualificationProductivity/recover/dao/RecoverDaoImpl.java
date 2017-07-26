package com.tj.jst.inner.qualificationProductivity.recover.dao;

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
 * ��ҵ���ʻָ�
 * @author Administrator
 *
 */
public class RecoverDaoImpl extends BaseDao implements IRecoverDao {

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
					certificatePrint.setWriteOffDate(rs.getDate("writeOffDate"));
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
		String sql = "select * from v_TBCORPCERTINFO1 where corpcertid=?";
		
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

	
	public void batchRecover(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,recoverDate=?,"
						+ "recoverStaffName=?,recoverStaffId=?,WRITEOFFTYPE=? where RELATIONID=?");
				pstmt.setInt(1,1);	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "0");
				pstmt.setString(6,list.get(i).getRelationId());
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
						+ "recoverDate=?,recoverStaffName=?,recoverStaffId=? where RELATIONID=?");
				pstmt.setString(1,"001");
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
	public void baseBatchRecover(List<CertificatePrint> list,String personalId,String personalName) {
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			for(int i=0;i<list.size();i++)
			{
				
				pstmt = conn.prepareStatement("update TBCORPCERTINFO set ISVALID=?,recoverDate=?,"
						+ "recoverStaffName=?,recoverStaffId=?,WRITEOFFTYPE=? where CORPCERTID=?");
				pstmt.setInt(1,1);	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5, "0");
				pstmt.setString(6,list.get(i).getCorpCertId());
				
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=?,"
						+ "recoverDate=?,recoverStaffName=?,recoverStaffId=? where RELATIONID=?");
				pstmt.setString(1,"001");	
				pstmt.setDate(2, new Date(new java.util.Date().getTime()));
				pstmt.setString(3, personalName);
				pstmt.setString(4, personalId);
				pstmt.setString(5,list.get(i).getRelationId());
				pstmt.executeUpdate();
			}
			
			conn.commit();
			this.batchRecover(list,personalId,personalName);
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
}
