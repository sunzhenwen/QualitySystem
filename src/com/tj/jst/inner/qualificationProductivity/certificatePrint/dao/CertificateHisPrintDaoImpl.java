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
 * 证书打印
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
				
					certificatePrint.setCorpName(rs.getString("CorpName")); //企业名称
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //组织机构代码
					certificatePrint.setCertId(rs.getString("CertId")); //证书编号
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //工商营业执照注册号
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //法定代表人姓名
//					certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //企业登记注册类型(字典表：TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//企业登记注册类型名称
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //注册资本(万元)
					certificatePrint.setCREATEDATE(rs.getString("CREATEDATE")); 
//					certificatePrint.setUpdateType(rs.getString("UpdateType").trim()); //上传状态
//					if(rs.getString("UpdateType").trim().equals("1"))
//					{
//						certificatePrint.setISPRINT("未打印");
//					}else
//					{
//						certificatePrint.setISPRINT("已上传打印过");
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
					certificatePrint.setCorpName(rs.getString("CorpName")); //企业名称
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //企业组织机构代码
					certificatePrint.setCertId(rs.getString("CertId")); //证书编号
					certificatePrint.setOrganName(rs.getString("OrganName")); //发证机关
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //发证日期
					certificatePrint.setEndDate(rs.getDate("EndDate")); //证书有效期截止日期
					certNames.add(rs.getString("CertName"));
					certificatePrint.setCertNames(certNames);//资质类别及等级
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //工商营业执照注册号
					certificatePrint.setAddress(rs.getString("Address")); //企业营业地址
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //法定代表人姓名
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//企业登记注册类型名称
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //注册资本(万元)
					certificatePrint.setUpdateType(rs.getString("updatetype").trim()); //是否打印过
					certificatePrint.setPrintDate(new Date(new java.util.Date().getTime()));
					certificatePrint.setQRCODE(rs.getString("QRCODE"));
					certificatePrint.setFBQRCODE(rs.getString("FBQRCODE"));
					certificatePrint.setPRINTNUMBER(rs.getString("PRINTNUMBER"));
					certificatePrint.setFBPRINTNUMBER(rs.getString("FBPRINTNUMBER"));
					
				}
				else
				{
					certNames.add(rs.getString("CertName"));
									
					//certificatePrint.setCertNames(certNames);//资质类别及等级
				}
				i++;
			}
			
			//特种工程专业承包五合一判断
			int sum=0;
			for(int j=0;j<certNames.size();j++)
			{
				if(Tools.isContain(certNames.get(j), "特种工程专业承包"))
				{
					sum=sum+1;
				}		
			}
			//System.out.println(sum);
			if(sum==3)
			{
				for(int j=0;j<certNames.size();j++)
				{
					if(Tools.isContain(certNames.get(j),"特种工程专业承包"))
					{
						certNames.set(j, "特种工程专业承包");
					}		
				}
				//certNames.add("特种工程专业承包");
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
