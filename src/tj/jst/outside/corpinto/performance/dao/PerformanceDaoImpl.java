package com.tj.jst.outside.corpinto.performance.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.performance.model.Performance;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public class PerformanceDaoImpl extends BaseDao implements IPerformanceDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 分页查询
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Performance performance = new Performance();
					performance.setPerId(rs.getString("perId")); //主键
					performance.setProName(rs.getString("proName")); //项目名称
					performance.setProType(rs.getString("proType")); //项目类型
					performance.setStartsDate(rs.getDate("startsDate"));//开工时间
					performance.setCompletedDate(rs.getDate("completedDate"));//竣工时间
					performance.setProScale(rs.getString("proScale")); //工程规模
					performance.setProCost(rs.getString("proCost")); //工程造价
					performance.setConstruction(rs.getString("construction")); //建设单位
					performance.setContractor(rs.getString("contractor")); //总承包单位
					performance.setDesign(rs.getString("design"));//设计单位
					performance.setSupervisor(rs.getString("supervisor"));//监理
					performance.setCorpId(rs.getString("corpId"));//企业Id
					performance.setCorpName(rs.getString("corpName"));//企业名称
					performance.setCorpCode(rs.getString("corpCode"));//组织机构改代码
					performance.setCreateDate(rs.getDate("createDate"));//创建时间
				    page.getData().add(performance);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	@Override
	public void add(Performance performance) {
		// TODO Auto-generated method stub
		String sql = "insert into TBCORPPERFORMANCE(proName,proType,startsDate,completedDate,"
				+ "proScale,proCost,construction,contractor,design,supervisor,corpId,corpName,"
				+ "corpCode,createDate,perId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String perId = UUID.randomUUID().toString();
		try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,performance.getProName());	
				pstmt.setString(2,performance.getProType()); 	
				pstmt.setDate(3,performance.getStartsDate());
				pstmt.setDate(4,performance.getCompletedDate());
				pstmt.setString(5,performance.getProScale());		
				pstmt.setDouble(6, Double.parseDouble(performance.getProCost()));
				pstmt.setString(7,performance.getConstruction());		
				pstmt.setString(8,performance.getContractor());
				pstmt.setString(9,performance.getDesign());
				pstmt.setString(10,performance.getSupervisor());
				pstmt.setString(11,performance.getCorpId());
				pstmt.setString(12,performance.getCorpName());
				pstmt.setString(13,performance.getCorpCode());
				pstmt.setDate(14,new Date(new java.util.Date().getTime()));
				pstmt.setString(15,perId);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	//删除
	@Override
	public void delete(String perId) {
		// TODO Auto-generated method stub
		String sql = "delete from TBCORPPERFORMANCE where perId=?";
		try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,perId);	
				pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 详细
	 */
	@Override
	public Performance detailed(String perId) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCORPPERFORMANCE where perId=?";
		Performance performance = new Performance();
		try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,perId);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					performance.setProName(rs.getString("proName"));	
					performance.setProType(rs.getString("proType")); 	
					performance.setStartsDate(rs.getDate("startsDate"));
					performance.setCompletedDate(rs.getDate("completedDate"));
					performance.setProScale(rs.getString("proScale"));		
					DecimalFormat df = new DecimalFormat("#.000");//保留两位小数
					BigDecimal bg=new BigDecimal(Double.toString(rs.getDouble("proCost")));
					df.format(bg);
					performance.setProCost(bg.toPlainString());
					performance.setConstruction(rs.getString("construction"));		
					performance.setContractor(rs.getString("contractor"));
					performance.setDesign(rs.getString("design"));
					performance.setSupervisor(rs.getString("supervisor"));
					performance.setCorpId(rs.getString("corpId"));
					performance.setCorpName(rs.getString("corpName"));
					performance.setCorpCode(rs.getString("corpCode"));
					performance.setCreateDate(rs.getDate("createDate"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return performance;
	}

}
