package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

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
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 大厅审批数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class FloorApprovalDaoImpl extends BaseDao implements IFloorApprovalDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页方法
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
	 * 审批详细
	 */
	@Override
	public NewQualification queryInfo(String id) {
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
				certifiedService.setCityName(rs.getString("cityName").trim());
				// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// 企业所在区名称
				certifiedService.setCountyName(rs.getString("countyName")
						.trim());
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
	 * 审批成功
	 */
	@Override
	public String approvalSuccess(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TB_FLOORAPPROVAL(NEWQUALID,CORPCODE,CORPNAME,APPPER,APPDATE,APPDEPT,APPOP,CTN,MESS1,MESS2,MESS3,MESS4,MESS5,MESS6,MESS7,MESS8,MESS9,MESS10,MESS11,MESS12,MESS13,MESS14,CERTMESS,CERTNAME) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, floor.getNewQualId());
			pstmt.setString(2, floor.getCorpCode());
			pstmt.setString(3, floor.getCorpName());
			pstmt.setString(4, floor.getApprovalPerson());
			pstmt.setDate(5, floor.getApprovalDate());
			pstmt.setString(6, floor.getAppDept());
			pstmt.setString(7, floor.getApprovalOpinion());
			pstmt.setString(8, "0");
			pstmt.setString(9, floor.getMes1());
			pstmt.setString(10, floor.getMes2());
			pstmt.setString(11, floor.getMes3());
			pstmt.setString(12, floor.getMes4());
			pstmt.setString(13, floor.getMes5());
			pstmt.setString(14, floor.getMes6());
			pstmt.setString(15, floor.getMes7());
			pstmt.setString(16, floor.getMes8());
			pstmt.setString(17, floor.getMes9());
			pstmt.setString(18, floor.getMes10());
			pstmt.setString(19, floor.getMes11());
			pstmt.setString(20, floor.getMes12());
			pstmt.setString(21, floor.getMes13());
			pstmt.setString(22, floor.getMes14());
			pstmt.setString(23, floor.getCertMess());
			pstmt.setString(24, floor.getCertName());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "添加成功 ！";
			} else {
				message = "添加失败!";
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
	 * 审批失败
	 */
	@Override
	public String approvalFailed(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TB_FLOORAPPROVAL(NEWQUALID,CORPCODE,CORPNAME,APPPER,APPDATE,APPDEPT,APPOP,CTN,MESS1,MESS2,MESS3,MESS4,MESS5,MESS6,MESS7,MESS8,MESS9,MESS10,MESS11,MESS12,CERTMESS,MESS13) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, floor.getNewQualId());
			pstmt.setString(2, floor.getCorpCode());
			pstmt.setString(3, floor.getCorpName());
			pstmt.setString(4, floor.getApprovalPerson());
			pstmt.setDate(5, floor.getApprovalDate());
			pstmt.setString(6, floor.getAppDept());
			pstmt.setString(7, floor.getApprovalOpinion());
			pstmt.setString(8, "1");
			pstmt.setString(9, floor.getMes1());
			pstmt.setString(10, floor.getMes2());
			pstmt.setString(11, floor.getMes3());
			pstmt.setString(12, floor.getMes4());
			pstmt.setString(13, floor.getMes5());
			pstmt.setString(14, floor.getMes6());
			pstmt.setString(15, floor.getMes7());
			pstmt.setString(16, floor.getMes8());
			pstmt.setString(17, floor.getMes9());
			pstmt.setString(18, floor.getMes10());
			pstmt.setString(19, floor.getMes11());
			pstmt.setString(20, floor.getMes12());
			pstmt.setString(21, floor.getCertMess());
			pstmt.setString(22, floor.getMes13());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "添加成功 ！";
			} else {
				message = "添加失败!";
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
	 * 完成后更改状态
	 */
	@Override
	public String changeType(String approvalId, String type, String name, String approvalOpinion) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set QUALIFTYPE='" + type
				+ "' , FLOORDATE=? , FLOORPERSON=? , FLOOROP='" + approvalOpinion + "' WHERE NEWQUALID = '"
				+ approvalId + "'";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, name);
			int check = pstmt.executeUpdate();
			if (check == 0) {
				message = "添加成功 ！";
			} else {
				message = "添加失败!";
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

	@Override
	public int queryCountConstructor(String userId) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from V_CONSTRUCTOR where corpName='"
					+ userId + "'";
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

	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from Position_Certificate where FIsDeleted = 0 and FEntName='"
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

	/**
	 * 查询资质就位信息
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
				certifiedService.setCityName(rs.getString("cityName").trim());
				// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// 企业所在区名称
				certifiedService.setCountyName(rs.getString("countyName")
						.trim());
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
	 * 资质就位审批通过
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON=? where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, op);
			pstmt.setString(3, name);
			pstmt.setString(4, id);
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
	 * 资质就位审批不通过
	 */
	@Override
	public String perchApprovalFailed(String id, String op, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='b' where NEWQUALID=?";
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

	@Override
	public List<NewQualification> queryQualification(String[] ids) {
		// TODO Auto-generated method stub
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId=?";
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
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
		
		String corpCodeTest = list.get(0).getCorpCode() ; //获取list中第一个对象的企业组织机构代码号
		for( int i=0; i<list.size(); i++ ){
			if(!corpCodeTest.equals(list.get(i).getCorpCode())){  //判断list中的所有企业是否是同一个企业
				System.out.println("批量审批不是同一家企业");
				return null ;
			}
		}
		
		return list;
	}

}
