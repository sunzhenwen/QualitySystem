package com.tj.jst.outside.businessReport.queryQualificationInfo.dao;

import java.sql.Connection;
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
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * 企业申请的资质信息状态查询
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoDaoImpl extends BaseDao implements
		IQueryQualificationInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 资质查询
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					QualificationInfo queryQualification = new QualificationInfo();
					queryQualification.setNewQualId(rs.getString("NEWQUALID")); // 企业申请信息ID
					queryQualification.setCorpId(rs.getString("CORPID")); // 企业代码证ID
					queryQualification.setCorpName(rs.getString("CorpName")); // 企业名称
					String num = rs.getString("qualifType").trim();
					switch (num) {
					case "1":
						queryQualification.setQualifType("待部门审批。"); // 审批结果
						break;
					case "2":
						queryQualification.setQualifType("发送专业厅局初审。"); // 审批结果
						break;
					case "3":
						queryQualification
								.setQualifType("专业厅局初审完毕(通过)，送至资质审批部门。"); // 审批结果
						break;
					case "4":
						queryQualification
								.setQualifType("专业厅局初审完毕(未通过)，送至资质审批部门。"); // 审批结果
						break;
					case "5":
						queryQualification.setQualifType("审批通过。"); // 审批结果
						break;
					case "6":
						queryQualification.setQualifType("审批未通过。"); // 审批结果
						break;
					case "7":
						queryQualification.setQualifType("专业厅局初审通过。"); // 审批结果
						break;
					case "8":
						queryQualification.setQualifType("专业厅局初审未通过。"); // 审批结果
						break;
					case "9":
						queryQualification.setQualifType("资质审批通过。"); // 审批结果
						break;
					case "10":
						queryQualification.setQualifType("资质审批未通过。"); // 审批结果
						break;
					case "a":
						queryQualification.setQualifType("企业已提交，待行政大厅受理。"); // 审批结果
						break;
					case "b":
						queryQualification.setQualifType("大厅审批未通过。"); // 审批结果
						break;
					default:
						queryQualification.setQualifType("错误数据。");
						break;
					}
					queryQualification.setCretLevelName(rs
							.getString("cretLevelName")); // 资质等级名称
					queryQualification.setCretTypeName(rs
							.getString("cretTypeName")); // 资质资格名称
					queryQualification.setCreatDate(rs.getDate("creatDate")); // 申请日期
					queryQualification.setOneAppDate(rs.getDate("oneAppDate")); // 初审审批时间
					queryQualification.setCretLevelName(rs
							.getString("CretLevelName")); // 资质序列名称
					queryQualification.setAddTypeName(rs
							.getString("addTypeName")); // 资质申请类型
					queryQualification.setSpecialtyTypeName(rs
							.getString("SpecialtyTypeName")); // 资质序列名称
					queryQualification.setFloorDate(rs.getDate("floorDate"));
					queryQualification.setOneAppDate(rs.getDate("oneAppDate"));
					queryQualification.setUltimateDate(rs
							.getDate("ultimateDate"));
					queryQualification.setCertName(rs.getString("certName"));
					page.getData().add(queryQualification);
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
	 * 资质资格类型查询
	 */
	@Override
	public List<DictionaryClass> CretLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * 通过ID来寻找企业资质详细信息
	 */
	@Override
	public QualificationInfo queryById(String NewQualId) {
		// TODO Auto-generated method stub
		String message = "";

		String sql = "select t.*,"
				+ "(select b.qualificationstype from TBAPTITUDEKINDDIC b where b.code=t.crettype) as cretTypeName,"
				+ "(select c.codename from TBTRADETYPEDIC c where c.code=t.CRETSEQUENCE) as cretSequenceName,"
				+ "(select d.rating from TBCERTTITLELEVELDIC d where d.code=t.CRETLEVEL and d.qualificationstype='建筑业') as cretLevelName,"
				+ "(select e.name from TBCRETGRADEDIC e where e.code=t.cretgrade) as cretGradeName,"
				+ "(select f.specialtytype from TBTRADETYPEBOUNDDIC f where f.code=t.specialtytype) as specialtyTypeName,"
				+ "(select g.getmethodname from TBADDTYPEDIC g where g.code=t.addtypenum) as addtypeName"
				+ " from TBQUALIFICATIONAPPLY t where t.NEWQUALID=?";
		QualificationInfo qualification = new QualificationInfo();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NewQualId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 写信息
				qualification.setNewQualId(rs.getString("newQualId")); // 主键
				qualification.setCorpId(rs.getString("corpId")); // 企业ID
				qualification.setCorpName(rs.getString("corpName")); // 企业名称
				if (rs.getString("qualifType").trim().equals("1")) {
					qualification.setQualifType("待部门审批。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("2")) {
					qualification.setQualifType("专业厅局部门审批。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("3")) {
					qualification.setQualifType("专业厅局部门审批完毕(通过)，送至资质审批部门。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("4")) {
					qualification.setQualifType("专业厅局部门审批完毕(未通过)，送至资质审批部门。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("5")) {
					qualification.setQualifType("资质审批通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("6")) {
					qualification.setQualifType("资质审批未通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("7")) {
					qualification.setQualifType("专业厅局初审通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("8")) {
					qualification.setQualifType("专业厅局初审未通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("9")) {
					qualification.setQualifType("资质审批通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("10")) {
					qualification.setQualifType("资质审批未通过。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("a")) {
					qualification.setQualifType("企业已提交，待行政大厅审批。"); // 审批结果
				} else if (rs.getString("qualifType").trim().equals("b")) {
					qualification.setQualifType("大厅审批未通过"); // 审批结果
				}
				qualification.setCretLevelName(rs.getString("cretLevelName")); // 资质等级
				qualification.setCretName(rs.getString("certName")); // 服务事项名称
				qualification.setCretTypeName(rs.getString("cretTypeName")); // 资质种类
				qualification.setCretSequenceName(rs
						.getString("cretSequenceName")); // 资质序列名称
				qualification.setSpecialtyTypeName(rs
						.getString("specialtyTypeName")); // 资质专业类别名称
				qualification.setCretGradeName(rs.getString("cretGradeName")); // 资质级别名称
				qualification.setApprovalDeptName(rs
						.getString("approvalDeptName")); // 审批部门名称
				qualification.setCreatDate(rs.getDate("creatDate")); // 申请日期
				qualification.setTwoApprovalDeptName(rs
						.getString("twoApprovalDeptName")); // 二审审批部门名称
				qualification.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion")); // 初审审批意见
				qualification.setOneAppDate(rs.getDate("oneAppDate")); // 初审审批时间
				qualification.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff")); // 初审审批人员
				qualification.setUltimateOpinion(rs
						.getString("ultimateOpinion")); // 终审审批意见
				qualification.setApprovalStaff(rs.getString("approvalStaff")); // 终审审批人员
				qualification.setFloorDate(rs.getDate("floorDate"));// 大厅受理时间
				qualification.setFloorOp(rs.getString("floorOp"));// 大厅受理意见
				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return qualification;
	}

	/**
	 * 通过Id 来判断所选的删除信息
	 */
	@Override
	public String deleteById(String NewQualId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from TBQUALIFICATIONAPPLY where NEWQUALID = ? and (QUALIFTYPE = '1' or QUALIFTYPE = 'a' )";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NewQualId);
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "删除成功！";
			} else {
				message = "删除失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

}
