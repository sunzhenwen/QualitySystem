package com.tj.jst.base.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ�����
 * @author hhc
 *
 */
public class ConnectionFactory {
	
	//����ϵͳ����Դ
	private static ComboPooledDataSource qualityDataSource;
	//�������ݿ�����Դ
	private static ComboPooledDataSource basicDataSource;
	//��λ��Ա����Դ
	private static ComboPooledDataSource staffPositionsDataSource;
	
	//����������������Դ
	private static ComboPooledDataSource hzDataShareDataSource;
	
	
	private ConnectionFactory() {
	}

	static {
		//����ϵͳ����Դ
		qualityDataSource = new ComboPooledDataSource("qualityDataSource");
		//�������ݿ�����Դ
		basicDataSource = new ComboPooledDataSource("basicDataSource");
		//��λ��Ա���ݿ�
		staffPositionsDataSource = new ComboPooledDataSource("staffPositionsDataSource");
		
		hzDataShareDataSource = new ComboPooledDataSource("hzDataShareDataSource");
	}

	/**
	 * ȡ�ø�λ��Ա���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getStaffPositionsConnection() throws SQLException {
		return staffPositionsDataSource.getConnection();
	}
	
	/**
	 * ȡ������ϵͳ���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getQualityConnection() throws SQLException {
		return qualityDataSource.getConnection();
	}

	/**
	 * ȡ�û������ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getBasicConnection() throws SQLException {
		return basicDataSource.getConnection();
	}
	
	
	/**
	 * ȡ�������������ľݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getHzDataShareConnection() throws SQLException {
		return hzDataShareDataSource.getConnection();
	}
	
	/**
	 * �ر����ݿ�����
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void closeConn(Connection conn,Statement pst,ResultSet rs){  
		try{
			if(rs!=null){  
				rs.close();  
	        }  
	        if(pst!=null){  
	        	pst.close();  
	        }  
	        if(conn!=null && !conn.isClosed()){  
	        	conn.close();  
	        }  
		}catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
