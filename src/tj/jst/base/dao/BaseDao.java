package com.tj.jst.base.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 基础dao实现类
 * @author Administrator
 *
 */
public class BaseDao {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count;
	
	/**
	 * 基础数据库分页
	 * @param p_condition
	 * @return
	 */
	public Page basePagedQuery(Condition p_condition) {
		//获取当前页
		int _pageNo = p_condition.getPageNo();
		//每页包含的记录数
		int _pageSize = p_condition.getPageSize();
		//查询总记录数
		long _totalCount = this.count(p_condition);
		if (_totalCount < 1)
		{
			return new Page();
		}
		
		//获取读取下标
		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);

		// if startIndex >= totalCount then go to the last page
		if (_startIndex >= _totalCount) {
			return this.lastOfPagedQuery(p_condition);
		}
		
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM ("+p_condition.getCompleteSql()+") A WHERE ROWNUM <= '"+Page.getEndOfPage(_startIndex,_pageSize)+"')WHERE RN > '"+_startIndex+"'";
		
		List list = new ArrayList();
		try { 
        	conn = ConnectionFactory.getBasicConnection();
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery(sql);
        } catch (SQLException e) {
        	ConnectionFactory.closeConn(conn, pstmt, rs);
			e.printStackTrace();
		}
		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
	}
	
	/**
	 * 资质数据库分页
	 * @param p_condition
	 * @return
	 */
	public Page qualityPagedQuery(Condition p_condition) {
		//获取当前页
		int _pageNo = p_condition.getPageNo();
		//每页包含的记录数
		int _pageSize = p_condition.getPageSize();
		//查询总记录数
		long _totalCount = this.qualityCount(p_condition);
		if (_totalCount < 1)
		{
			return new Page();
		}
		
		//获取读取下标
		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);

		// if startIndex >= totalCount then go to the last page
		if (_startIndex >= _totalCount) {
			return this.lastQualityOfPagedQuery(p_condition);
		}
		
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM ("+p_condition.getCompleteSql()+") A WHERE ROWNUM <= '"+Page.getEndOfPage(_startIndex,_pageSize)+"')WHERE RN > '"+_startIndex+"'";
		List list = new ArrayList();
		try { 
        	conn = ConnectionFactory.getQualityConnection();
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery(sql);
        } catch (SQLException e) {
        	ConnectionFactory.closeConn(conn, pstmt, rs);
			e.printStackTrace();
		}
		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
	}
	
	/**  统计查询页数 **/
	private long qualityCount(Condition p_condition) {
		String countsql = p_condition.getCompleteCountSql();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return count;
	}
	
	/**  统计查询页数 **/
	private long count(Condition p_condition) {
		String countsql = p_condition.getCompleteCountSql();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return count;
	}
	
	public Page lastOfPagedQuery(Condition condition) {
		long totalCount = this.count(condition);
		int pageNo;
		if (totalCount % condition.getPageSize() == 0)
		{
			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
		}else{
			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
		}
		condition.setPageNo(pageNo);
		return basePagedQuery(condition);
		
	}
	
	public Page lastQualityOfPagedQuery(Condition condition) {
		long totalCount = this.qualityCount(condition);
		int pageNo;
		if (totalCount % condition.getPageSize() == 0)
		{
			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
		}else{
			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
		}
		condition.setPageNo(pageNo);
		return qualityPagedQuery(condition);
		
	}


	/**
	 * 岗位人员数据库分页(sql2005分页)
	 * @param p_condition
	 * @return
	 */
	public Page positionsPagedQuery(Condition p_condition) {
		//获取当前页
		int _pageNo = p_condition.getPageNo();
		//每页包含的记录数
		int _pageSize = p_condition.getPageSize();
		//查询总记录数
		long _totalCount = this.positionsCount(p_condition);
		if (_totalCount < 1)
		{
			return new Page();
		}
		
		//获取读取下标
		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);

		// if startIndex >= totalCount then go to the last page
		if (_startIndex >= _totalCount) {
			return this.lastOfPositionsPagedQuery(p_condition);
		}
		
		String sql = "select * from ("+p_condition.getCompleteSql()+") a where rownumber<='"+Page.getEndOfPage(_startIndex,_pageSize)+"' and rownumber>'"+_startIndex+"'";
		List list = new ArrayList();
		try { 
        	conn = ConnectionFactory.getStaffPositionsConnection();
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery();
        } catch (SQLException e) {
        	ConnectionFactory.closeConn(conn, pstmt, rs);
			e.printStackTrace();
		}
		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
	}
	
	/**  统计查询页数 **/
	private long positionsCount(Condition p_condition) {
		String countsql = p_condition.getCompleteCountSql();
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return count;
	}
	
	public Page lastOfPositionsPagedQuery(Condition condition) {
		long totalCount = this.positionsCount(condition);
		int pageNo;
		if (totalCount % condition.getPageSize() == 0)
		{
			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
		}else{
			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
		}
		condition.setPageNo(pageNo);
		return positionsPagedQuery(condition);
		
	}
}
