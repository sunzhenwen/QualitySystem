package com.tj.jst.inner.system.statistics.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class StatisticsDaoImpl extends BaseDao implements IStatisticsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 统计企业数量
	 */
	@Override
	public int countCorps() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from ( "
				+ "select distinct t.* from v_corpbasicinfo t "
				+ "left join tbcorpcertinfo a on t.corpcode = a.corpcode"
				+ " where t.locknumber1 is not null and a.corpcertid is not null and a.certtypenum = '3' ) " ;
		int countCorps = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countCorps = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countCorps;
	}
	
	/**
	 * 统计技术人员数量
	 */
	@Override
	public int countSkillWorkers() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from V_SKILLEDWORKER" ;
		int countSkillWorkers = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countSkillWorkers = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countSkillWorkers;
	}
	@Override
	public int countTitles() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from v_persontitleinfo" ;
		int countTitles = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countTitles = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countTitles;
	}
	
	/**
	 * 地市证书数量
	 */
	@Override
	public int countCertificateCity() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from (select distinct certid from TBCORPCERTINFO where certid like 'D3%')" ;
		int countCertificateCity = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countCertificateCity = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countCertificateCity;
	}
	
	/**
	 * 省级证书数量
	 */
	@Override
	public int countCertificateProvince() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from (select distinct certid from TBCORPCERTINFO where certid like 'D2%')" ;
		int countCertificateProvince = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countCertificateProvince = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countCertificateProvince;
	}
	
	/**
	 * 省级证书数量
	 */
	@Override
	public int countCertificateCountry() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from (select distinct certid from TBCORPCERTINFO where certid like 'D1%')" ;
		int countCertificateCountry = 0 ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countCertificateCountry = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return countCertificateCountry;
	}

	
}
