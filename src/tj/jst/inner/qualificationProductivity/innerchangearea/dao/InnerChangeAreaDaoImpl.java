package com.tj.jst.inner.qualificationProductivity.innerchangearea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 内网主动修改企业归属地数据库方法
 * 
 * @author DarkFlameMaster
 *
 */
public class InnerChangeAreaDaoImpl extends BaseDao implements
		IInnerChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页信息
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Corp corp = new Corp();
					corp.setCorpName(rs.getString("corpName")); // 企业名称
					corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
					corp.setSapre1(rs.getString("SPARE1"));// 企业归属地
					page.getData().add(corp);
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
	 * 查询企业信息
	 */
	@Override
	public Corp queryCorp(String corpCode) {
		// TODO Auto-generated method stub
		Corp corp = new Corp();
		String sql = "select * from TBCORPBASICINFO where corpCode='"
				+ corpCode + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
				corp.setSapre1(rs.getString("SPARE1"));// 企业归属地
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	/**
	 * 更改企业归属地
	 */
	@Override
	public String changeArea(String corpCode, String cityNum) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCORPBASICINFO set SPARE1='" + cityNum
				+ "' where CORPCODE='" + corpCode + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "成功！";
			} else {
				message = "失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 记录日志
	 */
	@Override
	public String recordLog(InnerChangeArea info) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TB_INNERCHANGEAREA(CORPCODE,CORPNAME,"
				+ "BEFOREAREA,AFTERAREA,STAFFID,STAFFNAME,CHANGEDATE) "
				+ "values (?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getCorpCode());
			pstmt.setString(2, info.getCorpName());
			pstmt.setString(3, info.getBeforeArea());
			pstmt.setString(4, info.getAfterArea());
			pstmt.setString(5, info.getStaffId());
			pstmt.setString(6, info.getStaffName());
			pstmt.setDate(7, info.getChangeDate());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "日志记录成功！";
			} else {
				message = "日志记录失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 日志记录查询
	 */
	@Override
	public Page queryInfoPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					InnerChangeArea info = new InnerChangeArea();
					info.setAfterArea(rs.getString("afterArea"));
					info.setBeforeArea(rs.getString("beforeArea"));
					info.setChangeDate(rs.getDate("changeDate"));
					info.setCorpCode(rs.getString("corpCode"));
					info.setCorpName(rs.getString("corpName"));
					info.setStaffId(rs.getString("staffId"));
					info.setStaffName(rs.getString("staffName"));
					page.getData().add(info);
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
}
