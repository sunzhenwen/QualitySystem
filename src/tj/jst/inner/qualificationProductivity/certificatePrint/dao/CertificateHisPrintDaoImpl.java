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
import com.tj.jst.outside.businessReport.qualitychange.util.Tools;

/**
 * ֤���ӡ
 * @author hhc
 *
 */
public class CertificateHisPrintDaoImpl extends BaseDao implements CertificateHisPrintDao {

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
				
					certificatePrint.setCorpName(rs.getString("CorpName")); //��ҵ����
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //��֯��������
					certificatePrint.setCertId(rs.getString("CertId")); //֤����
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //��������������
//					certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//��ҵ�Ǽ�ע����������
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //ע���ʱ�(��Ԫ)
					certificatePrint.setCREATEDATE(rs.getString("CREATEDATE")); 
//					certificatePrint.setUpdateType(rs.getString("UpdateType").trim()); //�ϴ�״̬
//					if(rs.getString("UpdateType").trim().equals("1"))
//					{
//						certificatePrint.setISPRINT("δ��ӡ");
//					}else
//					{
//						certificatePrint.setISPRINT("���ϴ���ӡ��");
//					}
//					certificatePrint.setPRINTCOUNT(Integer.parseInt(rs.getString("UpdateType").trim())-1);
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
	public CertificatePrint queryPrint(String certid) {
		// TODO Auto-generated method stub
		String sql = "select * from v_TBCORPCERTINFO where certid=? and endDate>=? "
				+ " order by EndDate asc ";
		CertificatePrint certificatePrint = new CertificatePrint();
		List<String> certNames = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, certid);
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
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
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //����Ӫҵִ��ע���
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
					
				}
				else
				{
					certNames.add(rs.getString("CertName"));
									
					//certificatePrint.setCertNames(certNames);//������𼰵ȼ�
				}
				i++;
			}
			
			//���ֹ���רҵ�а����һ�ж�
			int sum=0;
			for(int j=0;j<certNames.size();j++)
			{
				if(Tools.isContain(certNames.get(j), "���ֹ���רҵ�а�"))
				{
					sum=sum+1;
				}		
			}
			//System.out.println(sum);
			if(sum==3)
			{
				for(int j=0;j<certNames.size();j++)
				{
					if(Tools.isContain(certNames.get(j),"���ֹ���רҵ�а�"))
					{
						certNames.set(j, "���ֹ���רҵ�а�");
					}		
				}
				//certNames.add("���ֹ���רҵ�а�");
				certNames=Tools.toRepeatList(certNames);
			}
			certificatePrint.setCertNames(certNames);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return certificatePrint;
	}


}
