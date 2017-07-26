package com.tj.jst.base.util.judgedate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;

/**
 * 判断时间方法
 * 
 * @author DarkFlameMaster
 *
 */
public class JudgeDateAction extends BaseDao {

	/**
	 * 计算截止的最晚工作日期
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date getDeadDate(Date date) {

		String sql1 = "select * from ( select * from SYSTEM_WORKDAY where daystr>'";
		String sql2 = "'and rownum <=14 order by daystr desc ) where rownum=1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql1 + date + sql2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				date = rs.getDate("DAYSTR");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return date;

	}

	/**
	 * 相差的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDifferDate(Date date) {
		Date nowDate = new Date(new java.util.Date().getTime());
		int days = (int) ((date.getTime() - nowDate.getTime()) / 86400000) + 1;
		return days;
	}

}
