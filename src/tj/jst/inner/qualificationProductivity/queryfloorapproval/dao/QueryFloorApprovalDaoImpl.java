package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;

/**
 * 历史大厅办理查询
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryFloorApprovalDaoImpl extends BaseDao implements
		IQueryFloorApprovalDao {

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
					FloorApproval floor = new FloorApproval();
					floor.setApprovalDate(rs.getDate("appDate"));
					floor.setCertMess(rs.getString("certMess"));
					floor.setCorpCode(rs.getString("corpCode"));
					floor.setCorpName(rs.getString("corpName"));
					floor.setNewQualId(rs.getString("newQualId"));
					// 服务事项名称
					floor.setCertName(rs.getString("certName"));
					if (rs.getString("CTN").equals("0")) {
						floor.setType("通过");
					}
					if (rs.getString("CTN").equals("1")) {
						floor.setType("不通过");
					}
					page.getData().add(floor);
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
	 * 查看审批详细
	 */
	@Override
	public FloorApproval queryInfo(String id) {
		// TODO Auto-generated method stub
		FloorApproval floor = new FloorApproval();
		try {
			String sql = "select * from TB_FLOORAPPROVAL where newQualId='"
					+ id + "'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				floor.setAppDept(rs.getString("appDept"));
				floor.setApprovalDate(rs.getDate("appDate"));
				floor.setApprovalOpinion(rs.getString("appOp"));
				floor.setApprovalPerson(rs.getString("appPer"));
				floor.setCorpCode(rs.getString("corpCode"));
				floor.setCorpName(rs.getString("corpName"));
				floor.setNewQualId(rs.getString("newQualId"));
				floor.setCertMess(rs.getString("certMess"));
				floor.setType(rs.getString("CTN"));
				if (rs.getString("CTN").equals("0")) {
					floor.setMes1(rs.getString("mess1"));
					floor.setMes2(rs.getString("mess2"));
					floor.setMes3(rs.getString("mess3"));
					floor.setMes4(rs.getString("mess4"));
					floor.setMes5(rs.getString("mess5"));
					floor.setMes6(rs.getString("mess6"));
					floor.setMes7(rs.getString("mess7"));
					floor.setMes8(rs.getString("mess8"));
					floor.setMes9(rs.getString("mess9"));
					floor.setMes10(rs.getString("mess10"));
					floor.setMes11(rs.getString("mess11"));
					floor.setMes12(rs.getString("mess12"));
					floor.setMes13(rs.getString("mess13"));
					floor.setMes14(rs.getString("mess14"));
				} else {
					floor.setMes1(rs.getString("mess1"));
					floor.setMes2(rs.getString("mess2"));
					floor.setMes3(rs.getString("mess3"));
					floor.setMes4(rs.getString("mess4"));
					floor.setMes5(rs.getString("mess5"));
					floor.setMes6(rs.getString("mess6"));
					floor.setMes7(rs.getString("mess7"));
					floor.setMes8(rs.getString("mess8"));
					floor.setMes9(rs.getString("mess9"));
					floor.setMes10(rs.getString("mess10"));
					floor.setMes11(rs.getString("mess11"));
					floor.setMes12(rs.getString("mess12"));
					floor.setMes13(rs.getString("mess13"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return floor;
	}

}
