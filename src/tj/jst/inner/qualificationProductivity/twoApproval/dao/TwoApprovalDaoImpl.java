package com.tj.jst.inner.qualificationProductivity.twoApproval.dao;

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
import com.tj.jst.base.util.judgedate.JudgeDateAction;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 省级资质审批
 * 
 * @author Administrator
 *
 */
public class TwoApprovalDaoImpl extends BaseDao implements ITwoApprovalDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection baseConn = null;
	PreparedStatement basePstmt = null;

	public Page pagedQuery(Condition condition) {

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
					// 推送外审时间
					certifiedService.setPushTwoDate(rs.getDate("pushTwoDate"));
					// 最晚截止时间
					certifiedService.setDeadDate(JudgeDateAction.getDeadDate(rs
							.getDate("pushTwoDate")));
					// 判断是否是超期
					if (rs.getDate("floorDate") != null) {
						// 截止日期
						certifiedService.setDeadDate(JudgeDateAction
								.getDeadDate(rs.getDate("floorDate")));
						// 判断是否超期
						int days = JudgeDateAction
								.getDifferDate(JudgeDateAction.getDeadDate(rs
										.getDate("floorDate")));
						if (days > 5) {
							certifiedService.setDateMark("0");
						} else if (days >= 0 && days <= 5) {
							certifiedService.setDateMark("1");
						} else if (days < 0) {
							certifiedService.setDateMark("2");
						}
						certifiedService.setDifferDay(Integer.toString(days));
					}

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
	 * 跳转审批页面查询
	 */
	public NewQualification queryapproval(String newQualId) {
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ newQualId + "'";
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
				// 审批部门
				certifiedService.setApprovalDept(rs.getString("approvalDept"));
				// 审批部门名称
				certifiedService.setApprovalDeptName(rs
						.getString("approvalDeptName"));
				// 二级审批初审部门
				certifiedService.setTwoApprovalDept(rs
						.getString("twoApprovalDept"));
				// 二级审批初审部门名称
				certifiedService.setTwoApprovalDeptName(rs
						.getString("twoApprovalDeptName"));
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
	 * 
	 * @return
	 */
	public void applythrough(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ONEULTIMATEOPINION=?,"
							+ "ONEAPPDATE=?,TWOAPPROVALSTAFF=?,TWOAPPROVALSTAFFID=?,ONERESULTS=? where NEWQUALID=?");

			// 审批状态
			pstmt.setString(1, "3");
			// 初审审批意见
			pstmt.setString(2, newQualification.getOneUltimateOpinion());
			// 初审审批时间
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			// 初审审批人员
			pstmt.setString(4, newQualification.getTwoApprovalStaff());
			// 初审审批人员Id
			pstmt.setString(5, newQualification.getTwoApprovalStaffId());
			// 初审审批结果
			pstmt.setString(6, "3");
			pstmt.setString(7, newQualification.getNewQualId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 申请退回
	 * 
	 * @return
	 */
	public void applyBack(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ONEULTIMATEOPINION=?,"
							+ "ONEAPPDATE=?,TWOAPPROVALSTAFF=?,TWOAPPROVALSTAFFID=?,ONERESULTS=? where NEWQUALID=?");
			// 审批状态
			pstmt.setString(1, "4");
			// 初审审批意见
			pstmt.setString(2, newQualification.getOneUltimateOpinion());
			// 初审审批时间
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			// 初审审批人员
			pstmt.setString(4, newQualification.getTwoApprovalStaff());
			// 初审审批人员Id
			pstmt.setString(5, newQualification.getTwoApprovalStaffId());
			// 初审审批结果
			pstmt.setString(6, "4");
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 推送外审
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? where NEWQUALID=?");
			pstmt.setString(1, "2");
			pstmt.setString(2, newQualification.getNewQualId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	// 查询职称人员
	public int queryCountTitle(String userId) {
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

	// 查询注册建造师
	public int queryCountConstructor(String userId) {
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

	// 查询技术工人总数
	public int queryCountSkilledworker(String userId) {
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

	// 资质类型(字典表：TBAPTITUDEKINDDIC)
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

	// 资质等级(字典表：TBCERTTITLELEVELDIC)
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

	// 资质序列(字典表：TBTRADETYPEDIC)
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

	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
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

	// 资质级别(字典表：TBCRETGRADEDIC)
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

	// 申请类型(字典表：TBADDTYPEDIC)
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

	// 查询岗位人员
	public int queryCountPositions(String corpName) {
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

	// 查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification) {
		// TODO Auto-generated method stub
		// String sql =
		// "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
		// +
		// "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
		// +
		// "where qualifType=? and corpId=? and cretLevel=? and cretGrade=? and specialtyType=? ";
		String sql = "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
				+ "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
				+ "where qualifType=? and corpId=? and cretLevel=? and specialtyType=? ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "5");
			pstmt.setString(2, newQualification.getCorpId());
			if (newQualification.getCretLevel() == 76) {
				pstmt.setInt(3, 75);
			}
			if (newQualification.getCretLevel() == 77) {
				pstmt.setInt(3, 76);
			}
			if (newQualification.getCretLevel() == 78) {
				pstmt.setInt(3, 77);
			}
			pstmt.setInt(4, newQualification.getSpecialtyType());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				newQualification.setCorpId(rs.getString("corpId"));
				newQualification.setCorpName(rs.getString("corpName"));
				newQualification.setOldCretLevel(rs.getInt("cretLevel"));
				newQualification.setOldCretLevelName(rs
						.getString("cretLevelName"));
				newQualification.setOldCretGrade(rs.getString("cretGrade"));
				newQualification.setOldCretGradeName(rs
						.getString("cretGradeName"));
				newQualification
						.setOldSpecialtyType(rs.getInt("specialtyType"));
				newQualification.setOldSpecialtyTypeName(rs
						.getString("specialtyTypeName"));
				newQualification.setOldCreatDate(rs.getDate("CREATDATE"));
				newQualification.setOldUltimateDate(rs.getDate("ULTIMATEDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return newQualification;
	}

	// 根据ids插叙已提交的资质服务事项
	public List<NewQualification> queryQualification(String[] ids) {
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
}
