package com.tj.jst.inner.qualificationProductivity.querychangeinfo.dao;

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
 * 内网查询历史归属地变更记录
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryChangeInfoDaoImpl extends BaseDao implements
		IQueryChangeInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
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
					change.setBeforeDate(rs.getDate("beforeDate"));
					change.setAfterDate(rs.getDate("afterDate"));
					change.setLastDate(rs.getDate("lastDate"));
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

	/**
	 * 查询详细
	 */
	@Override
	public ChangeArea queryInfo(String changeId) {
		// TODO Auto-generated method stub
		ChangeArea change = new ChangeArea();
		String sql = "select * from TB_CHANGEAREA where changeId = '"
				+ changeId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				change.setAfterCityArea(rs.getString("afterCityArea"));
				change.setChangeId(rs.getString("changeId"));
				change.setCorpName(rs.getString("corpName"));
				change.setBeforeArea(rs.getString("beforeArea"));
				change.setAfterProvinceArea(rs.getString("afterProvinceArea"));
				change.setBeforeOp(rs.getString("beforeOp"));
				change.setAfterOp(rs.getString("afterOp"));
				change.setLastOp(rs.getString("lastOp"));
				change.setStatus(rs.getString("status"));
				change.setProcess(rs.getString("process"));
				change.setMark(rs.getString("mark"));
				change.setBeforeDate(rs.getDate("beforeDate"));
				change.setAfterDate(rs.getDate("afterDate"));
				change.setLastDate(rs.getDate("lastDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return change;
	}

}
