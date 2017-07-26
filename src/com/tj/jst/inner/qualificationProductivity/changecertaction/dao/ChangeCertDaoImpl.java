package com.tj.jst.inner.qualificationProductivity.changecertaction.dao;

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
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 大厅受理换证数据库类
 * 
 * @author Administrator
 *
 */
public class ChangeCertDaoImpl extends BaseDao implements IChangeCertDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// 主键
					certifiedService.setNewQualId(rs.getString("newQualId"));
					// 企业主键
					certifiedService.setCorpId(rs.getString("corpId"));
					// 企业名称
					certifiedService.setCorpName(rs.getString("corpName"));
					// 企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode"));
					// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService
							.setProvinceNum(rs.getString("provinceNum"));
					// 企业所在省名称
					certifiedService.setProvinceName(rs
							.getString("provinceName"));
					// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					// 企业所在市名称
					certifiedService.setCityName(rs.getString("cityName"));
					// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					// 企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName"));
					// 申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType"));
					// 服务事项主键
					certifiedService.setCertId(rs.getString("certId"));
					// 服务事项名称
					certifiedService.setCertName(rs.getString("certName"));
					// 资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					// 资质级别名称
					certifiedService.setCretGradeName(rs
							.getString("cretGradeName"));
					// 资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// 资质等级名称
					certifiedService.setCretLevelName(rs
							.getString("cretLevelName"));
					// 资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// 资质序列名称
					certifiedService.setCretSequenceName(rs
							.getString("cretSequenceName"));
					// 资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					// 资质类型名称
					certifiedService.setCretTypeName(rs
							.getString("cretTypeName"));
					// 资质专业类别
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// 资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs
							.getString("specialtyTypeName"));
					// 审批部门
					certifiedService.setApprovalDept(rs
							.getString("approvalDept"));
					// 审批部门名称
					certifiedService.setApprovalDeptName(rs
							.getString("approvalDeptName"));
					// 二级审批初审部门
					certifiedService.setTwoApprovalDept(rs
							.getString("twoApprovalDept"));
					// 二级审批初审部门名称
					certifiedService.setTwoApprovalDeptName(rs
							.getString("twoApprovalDeptName"));
					// 申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// 资质取得方式方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					// 资质取得方式名称
					certifiedService
							.setAddTypeName(rs.getString("addTypeName"));
					certifiedService.setAssets(rs.getString("assets"));
					certifiedService.setMachinery(rs.getString("machinery"));
					page.getData().add(certifiedService);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 审批页面
	 */
	@Override
	public NewQualification queryPerchInfo(String id) {
		// TODO Auto-generated method stub
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ id + "'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 主键
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				// 企业主键
				certifiedService.setCorpId(rs.getString("corpId").trim());
				// 企业名称
				certifiedService.setCorpName(rs.getString("corpName").trim());
				// 企业住址机构代码证
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum")
						.trim());
				// 企业所在省名称
				certifiedService.setProvinceName(rs.getString("provinceName")
						.trim());
				// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				// 企业所在市名称
				certifiedService.setCityName(rs.getString("cityName"));
				// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// 企业所在区名称
				certifiedService.setCountyName(rs.getString("countyName"));
				// 申请状态(1：已申请)
				certifiedService.setQualifType(rs.getString("qualifType")
						.trim());
				// 服务事项主键
				certifiedService.setCertId(rs.getString("certId").trim());
				// 服务事项名称
				certifiedService.setCertName(rs.getString("certName").trim());
				// 资质级别
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				// 资质级别名称
				certifiedService.setCretGradeName(rs.getString("cretGradeName")
						.trim());
				// 资质等级
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				// 资质等级名称
				certifiedService.setCretLevelName(rs.getString("cretLevelName")
						.trim());
				// 资质序列
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				// 资质序列名称
				certifiedService.setCretSequenceName(rs.getString(
						"cretSequenceName").trim());
				// 资质类型
				certifiedService.setCretType(rs.getInt("cretType"));
				// 资质类型名称
				certifiedService.setCretTypeName(rs.getString("cretTypeName")
						.trim());
				// 资质专业类别
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				// 资质专业类别名称
				certifiedService.setSpecialtyTypeName(rs.getString(
						"specialtyTypeName").trim());
				// 申请日期
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				// 资质资格取得方式
				certifiedService.setAddTypeNum(rs.getString("addTypeNum")
						.trim());
				// 资质资格取得方式名称
				certifiedService.setAddTypeName(rs.getString("addTypeName")
						.trim());
				// 审批部门Id
				certifiedService.setApprovalDept(rs.getString("approvalDept")
						.trim());
				// 审批部门名称
				certifiedService.setApprovalDeptName(rs.getString(
						"approvalDeptName").trim());
				// 企业登记注册类型
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// 二级审批部门
				certifiedService.setTwoApprovalDept(rs.getString(
						"twoApprovalDept").trim());
				// 二级审批部门名称
				certifiedService.setTwoApprovalDeptName(rs.getString(
						"twoApprovalDeptName").trim());
				// 初审人员
				certifiedService.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff"));
				// 初审人员Id
				certifiedService.setTwoApprovalStaffId(rs
						.getString("twoApprovalStaffId"));
				// 初审时间
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				// 初审状态
				certifiedService.setOneResults(rs.getString("oneResults"));
				// 初审建议
				certifiedService.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion"));
				// 企业登记注册类型
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// 工商营业执照注册号
				certifiedService.setLicenseNum(rs.getString("licenseNum"));
				// 法定代表人姓名
				certifiedService.setLegalMan(rs.getString("legalMan"));
				// 法定代表人证件类型
				certifiedService
						.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				// 法定代表人证件号码
				certifiedService.setLegalManIdCard(rs
						.getString("legalManIdCard"));
				// 法定代表人职务
				certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
				// 法定代表人职称
				certifiedService.setLegaManProtitle(rs
						.getString("legaManProtitle"));
				// 企业营业地址
				certifiedService.setAddress(rs.getString("address"));
				// 注册资本
				certifiedService.setRegPrin(rs.getString("REGPRIN"));
				certifiedService.setAssets(rs.getString("assets"));
				certifiedService.setMachinery(rs.getString("machinery"));
				certifiedService.setCreatDate(rs.getDate("creatDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certifiedService;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String perchApprovalSuccess(String id, String op , String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON='"+name+"' where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, op);
			pstmt.setString(3, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				message = "成功";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String perchApprovalFailed(String id, String op , String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='b',FLOORPERSON='"+name+"' where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, op);
			pstmt.setString(3, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				message = "成功";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public void batchApplythrough(List<NewQualification> list,String name)
	{
		// TODO Auto-generated method stub
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON=? where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++)
			{
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				pstmt.setString(2, list.get(i).getFloorOp());
				pstmt.setString(3, name);
				pstmt.setString(4, list.get(i).getNewQualId());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
            // 如果没有错误，则表示可以向下执行 手工提交
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 查询岗位人员
	 */
	@Override
	public int queryCountTitle(String userId) {
		// TODO Auto-generated method stub
		int countTitle = 0;
		try {
			String sql = "select count(*) from v_persontitleinfo where corpId='"
					+ userId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countTitle = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countTitle;
	}

	/**
	 * 查询建造师S
	 */
	@Override
	public int queryCountConstructor(String userName) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from V_CONSTRUCTOR where corpName='"
					+ userName + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}

	/**
	 * 查询岗位人员
	 */
	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from Position_Certificate where FEntName='"
					+ corpName.trim() + "'";
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}

	/**
	 * 查询技术工人
	 */
	@Override
	public int queryCountSkilledworker(String userId) {
		// TODO Auto-generated method stub
		int countSkilledworker = 0;
		try {
			String sql = "select count(*) from V_SKILLEDWORKER where corpId='"
					+ userId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countSkilledworker = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countSkilledworker;
	}

	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE")
						.trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEDIC where code like '104%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("codeName").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if (!cretSequenceId.equals("")) {
			String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"
					+ cretSequenceId + "%'";
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setName(rs.getString("SPECIALTYTYPE")
							.trim());
					dictionaryClass.setCode(rs.getString("code").trim());
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}

	@Override
	public List<DictionaryClass> queryCretGrades() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCRETGRADEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBADDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("GETMETHODNAME").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	@Override
	public List<NewQualification> queryQualification(String[] ids) {
		// TODO Auto-generated method stub
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			for (int i = 0; i < ids.length; i++) {
				String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
						+ ids[i] + "'";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// 主键
					certifiedService.setNewQualId(rs.getString("newQualId")
							.trim());
					// 企业主键
					certifiedService.setCorpId(rs.getString("corpId").trim());
					// 企业名称
					certifiedService.setCorpName(rs.getString("corpName")
							.trim());
					// 企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode")
							.trim());
					// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum")
							.trim());
					// 企业所在省名称
					certifiedService.setProvinceName(rs.getString(
							"provinceName").trim());
					// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum").trim());
					// 企业所在市名称
					certifiedService.setCityName(rs.getString("cityName")
							.trim());
					// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum")
							.trim());
					// 企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName")
							.trim());
					// 申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType")
							.trim());
					// 服务事项主键
					certifiedService.setCertId(rs.getString("certId").trim());
					// 服务事项名称
					certifiedService.setCertName(rs.getString("certName")
							.trim());
					// 资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade")
							.trim());
					// 资质级别名称
					certifiedService.setCretGradeName(rs.getString(
							"cretGradeName").trim());
					// 资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// 资质等级名称
					certifiedService.setCretLevelName(rs.getString(
							"cretLevelName").trim());
					// 资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// 资质序列名称
					certifiedService.setCretSequenceName(rs.getString(
							"cretSequenceName").trim());
					// 资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					// 资质类型名称
					certifiedService.setCretTypeName(rs.getString(
							"cretTypeName").trim());
					// 资质专业类别
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// 资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs.getString(
							"specialtyTypeName").trim());
					// 申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// 资质资格取得方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum")
							.trim());
					// 资质资格取得方式名称
					certifiedService.setAddTypeName(rs.getString("addTypeName")
							.trim());
					// 审批部门Id
					certifiedService.setApprovalDept(rs.getString(
							"approvalDept").trim());
					// 审批部门名称
					certifiedService.setApprovalDeptName(rs.getString(
							"approvalDeptName").trim());
					// 企业登记注册类型
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// 二级审批部门
					certifiedService.setTwoApprovalDept(rs.getString(
							"twoApprovalDept").trim());
					// 二级审批部门名称
					certifiedService.setTwoApprovalDeptName(rs.getString(
							"twoApprovalDeptName").trim());
					// 初审人员
					certifiedService.setTwoApprovalStaff(rs
							.getString("twoApprovalStaff"));
					// 初审人员Id
					certifiedService.setTwoApprovalStaffId(rs
							.getString("twoApprovalStaffId"));
					// 初审时间
					certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
					// 初审状态
					certifiedService.setOneResults(rs.getString("oneResults"));
					// 初审建议
					certifiedService.setOneUltimateOpinion(rs
							.getString("oneUltimateOpinion"));
					// 企业登记注册类型
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// 工商营业执照注册号
					certifiedService.setLicenseNum(rs.getString("licenseNum"));
					// 法定代表人姓名
					certifiedService.setLegalMan(rs.getString("legalMan"));
					// 法定代表人证件类型
					certifiedService.setIdCardTypeNum(rs
							.getString("idCardTypeNum"));
					// 法定代表人证件号码
					certifiedService.setLegalManIdCard(rs
							.getString("legalManIdCard"));
					// 法定代表人职务
					certifiedService.setLegaLManDuty(rs
							.getString("legaLManDuty"));
					// 法定代表人职称
					certifiedService.setLegaManProtitle(rs
							.getString("legaManProtitle"));
					// 企业营业地址
					certifiedService.setAddress(rs.getString("address"));
					// 注册资本
					certifiedService.setRegPrin(rs.getString("REGPRIN"));
					list.add(certifiedService);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public CorpInfo queryCorpInfo(String corpCode) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select  t.* , "
				+ "	(select e.corpregtype from TBECONTYPEDIC e where t.economicnum = e.code) as economicName"
				+ " from TBCORPBASICINFO t where t.corpCode = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码证
				corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum")); // 注册所在省
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在市
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode")); // 邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // 法定代表人证件类型
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // 发行代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty")); // 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // 法定代表人职称
				corp.setEconomicNum(rs.getString("economicName")); // 企业登记注册类型
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本（万元）
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本（万元）
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // 注册资本币种
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // 成立日期
				corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("Url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery")); // 机械设备
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

}
