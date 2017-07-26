package com.tj.jst.outside.businessReport.querycorpchangearea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

/**
 * 企业查询归属地变更Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpChangeAreaDaoImpl extends BaseDao implements
		IQueryCorpChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ChangeArea change = new ChangeArea();
					change.setAfterCityArea(rs.getString("afterCityArea"));
					change.setChangeId(rs.getString("changeId"));
					change.setCorpName(rs.getString("corpName"));
					change.setBeforeArea(rs.getString("beforeArea"));
					change.setAfterProvinceArea(rs
							.getString("afterProvinceArea"));
					change.setBeforeOp(rs.getString("beforeOp"));
					change.setAfterOp(rs.getString("afterOp"));
					change.setLastOp(rs.getString("lastOp"));
					change.setStatus(rs.getString("status"));
					change.setProcess(rs.getString("process"));
					page.getData().add(change);
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

	@Override
	public String deleteChange(String changeId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from TB_CHANGEAREA where changeId = '" + changeId
				+ "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
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
