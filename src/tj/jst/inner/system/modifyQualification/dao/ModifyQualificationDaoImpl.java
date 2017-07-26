package com.tj.jst.inner.system.modifyQualification.dao;

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
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class ModifyQualificationDaoImpl extends BaseDao implements IModifyQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 企业登记注册类型
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		String sql = "select code,corpregtype from TBECONTYPEDIC where code not like '%00'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 注册资本币种
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {

			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	//查询黑龙江所有市 
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		String sql = "select * from TBXZQDMDIC where code like '23%00' and code != '230000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 企业申请信息列表
	 */
	@Override
	public Page queryPage(ModifyQualificationCondition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					NewQualification newQualification = new NewQualification();
					newQualification.setCorpId(rs.getString("corpId"));
					newQualification.setCorpName(rs.getString("corpName"));
					newQualification.setCorpCode(rs.getString("corpCode"));
					newQualification.setProvinceNum(rs.getString("provinceNum"));
					newQualification.setProvinceName(rs.getString("provinceName"));
					newQualification.setCityNum(rs.getString("cityNum"));
					newQualification.setCityName(rs.getString("cityName"));
					newQualification.setCountyNum(rs.getString("countyNum"));
					newQualification.setCountyName(rs.getString("countyName"));
					newQualification.setQualifType(rs.getString("qualifType"));
					newQualification.setCertId(rs.getString("certId"));
					newQualification.setCertName(rs.getString("certName"));
					newQualification.setCretType(rs.getInt("cretType"));
					newQualification.setCretLevel(rs.getInt("cretLevel"));
					newQualification.setCretSequence(rs.getInt("cretSequence"));
					newQualification.setSpecialtyType(rs.getInt("specialtyType"));
					newQualification.setCretGrade(rs.getString("cretGrade"));
					newQualification.setApprovalDept(rs.getString("approvalDept"));
					newQualification.setCreatDate(rs.getDate("creatDate"));
					newQualification.setNewQualId(rs.getString("newQualId"));
					newQualification.setAddTypeNum(rs.getString("addTypeNum"));
					newQualification.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
					newQualification.setApprovalDeptName(rs.getString("approvalDeptName"));
					newQualification.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
					newQualification.setSpare1(rs.getString("spare1"));
					newQualification.setEconomicNum(rs.getInt("economicNum"));
					newQualification.setAddress(rs.getString("address"));
					newQualification.setLicenseNum(rs.getString("licenseNum"));
					newQualification.setLegalMan(rs.getString("legalMan"));
					newQualification.setIdCardTypeNum(rs.getString("idCardTypeNum"));
					newQualification.setLegalManIdCard(rs.getString("legalManIdCard"));
					newQualification.setLegaLManDuty(rs.getString("legaLManDuty"));
					newQualification.setLegaManProtitle(rs.getString("legaManProtitle"));
					// 注册资本
					newQualification.setRegPrin(rs.getString("regPrin"));
					newQualification.setAssets(rs.getString("assets"));
					newQualification.setMachinery(rs.getString("machinery"));
					page.getData().add(newQualification);
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
	 * 跳转修改页面
	 */
	@Override
	public NewQualification modifyApplication(String newQualId) {
		// TODO Auto-generated method stub
		String sql = "select * from TBQUALIFICATIONAPPLY where newQualId = ?" ;
		NewQualification newQualification = new NewQualification();
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newQualId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				newQualification.setCorpId(rs.getString("corpId"));
				newQualification.setCorpName(rs.getString("corpName"));
				newQualification.setCorpCode(rs.getString("corpCode"));
				newQualification.setProvinceNum(rs.getString("provinceNum"));
				newQualification.setProvinceName(rs.getString("provinceName"));
				newQualification.setCityNum(rs.getString("cityNum"));
				newQualification.setCityName(rs.getString("cityName"));
				newQualification.setCountyNum(rs.getString("countyNum"));
				newQualification.setCountyName(rs.getString("countyName"));
				newQualification.setQualifType(rs.getString("qualifType"));
				newQualification.setCertId(rs.getString("certId"));
				newQualification.setCertName(rs.getString("certName"));
				newQualification.setCretType(rs.getInt("cretType"));
				newQualification.setCretLevel(rs.getInt("cretLevel"));
				newQualification.setCretSequence(rs.getInt("cretSequence"));
				newQualification.setSpecialtyType(rs.getInt("specialtyType"));
				newQualification.setCretGrade(rs.getString("cretGrade"));
				newQualification.setApprovalDept(rs.getString("approvalDept"));
				newQualification.setCreatDate(rs.getDate("creatDate"));
				newQualification.setNewQualId(rs.getString("newQualId"));
				newQualification.setAddTypeNum(rs.getString("addTypeNum"));
				newQualification.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
				newQualification.setApprovalDeptName(rs.getString("approvalDeptName"));
				newQualification.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
				newQualification.setSpare1(rs.getString("spare1"));
				newQualification.setEconomicNum(rs.getInt("economicNum"));
				newQualification.setAddress(rs.getString("address"));
				newQualification.setLicenseNum(rs.getString("licenseNum"));
				newQualification.setLegalMan(rs.getString("legalMan"));
				newQualification.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				newQualification.setLegalManIdCard(rs.getString("legalManIdCard"));
				newQualification.setLegaLManDuty(rs.getString("legaLManDuty"));
				newQualification.setLegaManProtitle(rs.getString("legaManProtitle"));
				// 注册资本
				newQualification.setRegPrin(rs.getString("regPrin"));
				newQualification.setAssets(rs.getString("assets"));
				newQualification.setMachinery(rs.getString("machinery"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn,pstmt,null);
		}
		
		return newQualification;
	}

	/**
	 * 企业资质申请信息修改操作
	 */
	@Override
	public String modify(NewQualification newQualification) {
		// TODO Auto-generated method stub
		
		newQualification = this.getCountyName(newQualification);
		
		String message = "" ;
		int check = 0 ;
		String sql = "update TBQUALIFICATIONAPPLY set cityNum=?,cityName=?,countyNum=?,countyName=?" +
				" where corpId=? " ;
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newQualification.getCityNum());
			pstmt.setString(2, newQualification.getCityName());
			pstmt.setString(3, newQualification.getCountyNum());
			pstmt.setString(4, newQualification.getCountyName());
			pstmt.setString(5, newQualification.getCorpId());
			check = pstmt.executeUpdate();
			
			if(check >0){
				message = "修改成功！" ;
			}else{
				message = "修改失败！" ;
				return message;
			}
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("update TBCORPBASICINFO set cityNum=?,countyNum=? where corpId=? ");
			pstmt.setString(1, newQualification.getCityNum());
			pstmt.setString(2, newQualification.getCountyNum());
			pstmt.setString(3, newQualification.getCorpId());
			check = pstmt.executeUpdate();
			
			if(check == 1){
				message = "修改成功！" ;
			}else{
				message = "修改失败！" ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	private NewQualification getCountyName(NewQualification newQualification) {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code = ?" ;
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newQualification.getCountyNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				newQualification.setCountyName(rs.getString("name"));
			}
			
			pstmt.setString(1, newQualification.getCityNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				newQualification.setCityName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		
		
		return newQualification;
	}
}
