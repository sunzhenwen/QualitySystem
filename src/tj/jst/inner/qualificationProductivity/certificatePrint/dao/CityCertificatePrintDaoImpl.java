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
 * 地市证书打印
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
					//certificatePrint.setCorpCertId(rs.getString("corpCertId")); //主键
					certificatePrint.setCorpName(rs.getString("CorpName")); //企业名称
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //组织机构代码
					//certificatePrint.setCertTypeNum(rs.getInt("CertTypeNum")); //资质资格类型(字典表：TBAPTITUDEKINDDIC)
					//certificatePrint.setCertTypeName(rs.getString("CertTypeName"));//资质资格类型名称
					certificatePrint.setCertId(rs.getString("CertId")); //证书编号
					//certificatePrint.setTitleLevelNum(rs.getInt("TitleLevelNum")); //资质资格最高等级(字典表：TBCERTTITLELEVELDIC)
					//certificatePrint.setTitleLevelName(rs.getString("TitleLevelName"));//资质资格最高等级
					//certificatePrint.setTechMan(rs.getString("TechMan")); //技术负责人姓名
					//certificatePrint.setTechManDuty(rs.getString("TechManDuty")); //技术负责人职务
					//certificatePrint.setTechManProTitle(rs.getString("TechManProTitle")); //技术负责人职称或职业资格
					//certificatePrint.setUnitMan(rs.getString("UnitMan")); //企业负责人姓名
					//certificatePrint.setUnitManDuty(rs.getString("UnitManDuty")); //企业负责人职务
					//certificatePrint.setUntiManProTitle(rs.getString("UnitManProTitle")); //企业负责人职称
					//certificatePrint.setOrganName(rs.getString("OrganName")); //发证机关
					//certificatePrint.setOrganDate(rs.getDate("OrganDate")); //发证日期
					//certificatePrint.setEndDate(rs.getDate("EndDate")); //证书有效期截止日期
					//certificatePrint.setIsValid(rs.getInt("corpCertId")); //证书状态(字典表：TBCERTSTATEDIC)
					//certificatePrint.setIsValidName(rs.getString("IsValidName"));//证书状态名称
					//certificatePrint.setDescrpition(rs.getString("Descrpition")); //备注
					//certificatePrint.setCorpId(rs.getString("CorpId")); //企业ID
					//certificatePrint.setUpDateTime(rs.getDate("UpDateTime")); //操作日期
					//certificatePrint.setOldOrNew(rs.getString("OldOrNew")); //0：老数据 1：新数据
					//certificatePrint.setDataSource(rs.getString("DataSource")); //数据来源系统
					//certificatePrint.setCertName(rs.getString("CertName")); //资质类别及等级
					//certificatePrint.setApprovalDept(rs.getString("ApprovalDept")); //审批部门
					//certificatePrint.setApprovalStaff(rs.getString("ApprovalStaff")); //审批人员名称
					//certificatePrint.setApprovalStaffId(rs.getString("ApprovalStaffId")); //审批人员Id
					//certificatePrint.setUltimtDate(rs.getDate("ULTIMATEDATE")); //审批时间
					//certificatePrint.setCretGrade(rs.getString("CretGrade")); //资质级别(字典表：TBCRETGRADEDIC)国家、省、地市
					//certificatePrint.setCretGradeName(rs.getString("CretGradeName"));//资质级别名称
					//certificatePrint.setAddTypeNum(rs.getString("AddTypeNum")); //资质资格取得方式(字典表：TBADDTYPEDIC)003增项
					//certificatePrint.setAddTypeName(rs.getString("AddTypeName"));//资质资格取得方式名称
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //工商营业执照注册号
					//certificatePrint.setApprovalDeptName(rs.getString("ApprovalDeptName")); //审批部门名称
					//certificatePrint.setProvinceNum(rs.getString("ProvinceNum")); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					//certificatePrint.setProvinceName(rs.getString("ProvinceName"));//省名称
					//certificatePrint.setCityNum(rs.getString("CityNum")); //注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
					//certificatePrint.setCityName(rs.getString("CityName"));//市名称
					//certificatePrint.setCountyNum(rs.getString("CountyNum")); //注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
					//certificatePrint.setCountyName(rs.getString("CountyName"));//县名称
					//certificatePrint.setAddress(rs.getString("Address")); //企业营业地址
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //法定代表人姓名
					//certificatePrint.setIdCardTypeNum(rs.getString("IdCardTypeNum")); //法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
					//certificatePrint.setIdCardTypeName(rs.getString("IdCardTypeName"));//证件类型名称
					//certificatePrint.setLegalManIdCard(rs.getString("LegalManIdCard")); //法定代表人证件号码
					//certificatePrint.setLegalManDuty(rs.getString("LegalManDuty")); //法定代表人职务
					//certificatePrint.setLegaManProtitle(rs.getString("LegaManProtitle")); //法定代表人职称
					//certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //企业登记注册类型(字典表：TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//企业登记注册类型名称
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //注册资本(万元)
					certificatePrint.setUpdateType(rs.getString("UpdateType").trim()); //上传状态
					if("1".equals(rs.getString("UpdateType").trim()))
					{
						certificatePrint.setISPRINT("未打印");
					}else
					{
						certificatePrint.setISPRINT("已上传打印过");
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
					certificatePrint.setCorpName(rs.getString("CorpName")); //企业名称
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //企业组织机构代码
					certificatePrint.setCertId(rs.getString("CertId")); //证书编号
					certificatePrint.setOrganName(rs.getString("OrganName")); //发证机关
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //发证日期
					certificatePrint.setEndDate(rs.getDate("EndDate")); //证书有效期截止日期
					certNames.add(rs.getString("CertName"));
					certificatePrint.setCertNames(certNames);//资质类别及等级
					//certificatePrint.setCertName(rs.getString("CertName")); //资质类别及等级
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //工商营业执照注册号
					//certificatePrint.setProvinceName(rs.getString("ProvinceName"));//省名称
					//certificatePrint.setCityName(rs.getString("CityName"));//市名称
					//certificatePrint.setCountyName(rs.getString("CountyName"));//县名称
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
					
				}else
				{
					certNames.add(rs.getString("CertName"));
					certificatePrint.setCertNames(certNames);//资质类别及等级
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
