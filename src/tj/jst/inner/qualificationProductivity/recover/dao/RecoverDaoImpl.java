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
 * 企业资质恢复
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
					certificatePrint.setCorpCertId(rs.getString("corpCertId")); //主键
					certificatePrint.setCorpName(rs.getString("CorpName")); //企业名称
					certificatePrint.setCorpCode(rs.getString("CorpCode")); //组织机构代码
//					certificatePrint.setCertTypeNum(rs.getInt("CertTypeNum")); //资质资格类型(字典表：TBAPTITUDEKINDDIC)
//					certificatePrint.setCertTypeName(rs.getString("CertTypeName"));//资质资格类型名称
					certificatePrint.setCertId(rs.getString("CertId")); //证书编号
//					certificatePrint.setTitleLevelNum(rs.getInt("TitleLevelNum")); //资质资格最高等级(字典表：TBCERTTITLELEVELDIC)
//					certificatePrint.setTitleLevelName(rs.getString("TitleLevelName"));//资质资格最高等级
//					certificatePrint.setTechMan(rs.getString("TechMan")); //技术负责人姓名
//					certificatePrint.setTechManDuty(rs.getString("TechManDuty")); //技术负责人职务
//					certificatePrint.setTechManProTitle(rs.getString("TechManProTitle")); //技术负责人职称或职业资格
//					certificatePrint.setUnitMan(rs.getString("UnitMan")); //企业负责人姓名
//					certificatePrint.setUnitManDuty(rs.getString("UnitManDuty")); //企业负责人职务
//					certificatePrint.setUntiManProTitle(rs.getString("UntiManProTitle")); //企业负责人职称
					certificatePrint.setOrganName(rs.getString("OrganName")); //发证机关
					certificatePrint.setOrganDate(rs.getDate("OrganDate")); //发证日期
					certificatePrint.setEndDate(rs.getDate("EndDate")); //证书有效期截止日期
//					certificatePrint.setIsValid(rs.getInt("corpCertId")); //证书状态(字典表：TBCERTSTATEDIC)
//					certificatePrint.setIsValidName(rs.getString("IsValidName"));//证书状态名称
//					certificatePrint.setDescrpition(rs.getString("Descrpition")); //备注
					certificatePrint.setCorpId(rs.getString("CorpId")); //企业ID
//					certificatePrint.setUpDateTime(rs.getDate("UpDateTime")); //操作日期
//					certificatePrint.setOldOrNew(rs.getString("OldOrNew")); //0：老数据 1：新数据
//					certificatePrint.setDataSource(rs.getString("DataSource")); //数据来源系统
					certificatePrint.setCertName(rs.getString("CertName")); //资质类别及等级
//					certificatePrint.setApprovalDept(rs.getString("ApprovalDept")); //审批部门
//					certificatePrint.setApprovalStaff(rs.getString("ApprovalStaff")); //审批人员名称
//					certificatePrint.setApprovalStaffId(rs.getString("ApprovalStaffId")); //审批人员Id
//					certificatePrint.setUltimtDate(rs.getDate("ULTIMATEDATE")); //审批时间
					certificatePrint.setCretGrade(rs.getString("CretGrade")); //资质级别(字典表：TBCRETGRADEDIC)国家、省、地市
//					certificatePrint.setCretGradeName(rs.getString("CretGradeName"));//资质级别名称
//					certificatePrint.setAddTypeNum(rs.getString("AddTypeNum")); //资质资格取得方式(字典表：TBADDTYPEDIC)003增项
//					certificatePrint.setAddTypeName(rs.getString("AddTypeName"));//资质资格取得方式名称
					certificatePrint.setLicenseNum(rs.getString("LicenseNum")); //工商营业执照注册号
//					certificatePrint.setApprovalDeptName(rs.getString("ApprovalDeptName")); //审批部门名称
//					certificatePrint.setProvinceNum(rs.getString("ProvinceNum")); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
//					certificatePrint.setProvinceName(rs.getString("ProvinceName"));//省名称
//					certificatePrint.setCityNum(rs.getString("CityNum")); //注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
//					certificatePrint.setCityName(rs.getString("CityName"));//市名称
//					certificatePrint.setCountyNum(rs.getString("CountyNum")); //注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
//					certificatePrint.setCountyName(rs.getString("CountyName"));//县名称
					certificatePrint.setAddress(rs.getString("Address")); //企业营业地址
					certificatePrint.setLegalMan(rs.getString("LegalMan")); //法定代表人姓名
//					certificatePrint.setIdCardTypeNum(rs.getString("IdCardTypeNum")); //法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
//					certificatePrint.setIdCardTypeName(rs.getString("IdCardTypeName"));//证件类型名称
//					certificatePrint.setLegalManIdCard(rs.getString("LegalManIdCard")); //法定代表人证件号码
//					certificatePrint.setLegalManDuty(rs.getString("LegalManDuty")); //法定代表人职务
//					certificatePrint.setLegaManProtitle(rs.getString("LegaManProtitle")); //法定代表人职称
					certificatePrint.setEconmicNum(rs.getString("ECONOMICNUM")); //企业登记注册类型(字典表：TBECONTYPEDIC)
					certificatePrint.setEconmicName(rs.getString("EconmicName"));//企业登记注册类型名称
					certificatePrint.setRegPrin(rs.getString("RegPrin")); //注册资本(万元)
					certificatePrint.setRelationId(rs.getString("relationId"));
//					certificatePrint.setRecoverDate(rs.getDate("recoverDate"));//恢复时间
//					certificatePrint.setRecoverStaffId(rs.getString("recoverStaffId"));//恢复人Id
//					certificatePrint.setRecoverStaffName(rs.getString("recoverStaffName"));//回复人姓名
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
					certificatePrint.setCorpCertId(rs.getString("corpCertId"));//主键
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
