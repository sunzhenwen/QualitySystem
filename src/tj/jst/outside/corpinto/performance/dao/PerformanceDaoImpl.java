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
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public class PerformanceDaoImpl extends BaseDao implements IPerformanceDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ҳ��ѯ
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Performance performance = new Performance();
					performance.setPerId(rs.getString("perId")); //����
					performance.setProName(rs.getString("proName")); //��Ŀ����
					performance.setProType(rs.getString("proType")); //��Ŀ����
					performance.setStartsDate(rs.getDate("startsDate"));//����ʱ��
					performance.setCompletedDate(rs.getDate("completedDate"));//����ʱ��
					performance.setProScale(rs.getString("proScale")); //���̹�ģ
					performance.setProCost(rs.getString("proCost")); //�������
					performance.setConstruction(rs.getString("construction")); //���赥λ
					performance.setContractor(rs.getString("contractor")); //�ܳа���λ
					performance.setDesign(rs.getString("design"));//��Ƶ�λ
					performance.setSupervisor(rs.getString("supervisor"));//����
					performance.setCorpId(rs.getString("corpId"));//��ҵId
					performance.setCorpName(rs.getString("corpName"));//��ҵ����
					performance.setCorpCode(rs.getString("corpCode"));//��֯�����Ĵ���
					performance.setCreateDate(rs.getDate("createDate"));//����ʱ��
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

	//ɾ��
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
	 * ��ϸ
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
					DecimalFormat df = new DecimalFormat("#.000");//������λС��
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
