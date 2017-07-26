package com.tj.jst.inner.foreign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public class CertifiedForeignDaoImpl implements ICertifiedForeignCorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	/**
	 * �޸�������ҵ
	 */
	@Override
	public String modifyCorp(CertifiedForeignCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCorpForeigninfo set FOREIGNCORPNAME=?,MODIFYDATE=? where CORPID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getForeignCorpName()); 					//����Ͷ��������
			pstmt.setDate(2,new Date(new java.util.Date().getTime())); 		//�޸�ʱ��
			pstmt.setString(3,corp.getCorpId());				//����
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
			return message;
	}

	/**
	 * ������ҵ��ѯ
	 */
	@Override
	public CertifiedForeignCorp queryCorp(String corpID) {
		// TODO Auto-generated method stub
		CertifiedForeignCorp corp = new CertifiedForeignCorp();
		String sql = "select c.*,(select p.country from TBNATIONALDIC p where c.nationnum=p.code) as nationName,"
				+ "(select h.currency from TBPRINCIPALUNITDIC h where c.principalunitnum=h.code) as principalUnitName "
				+ "from TBCORPFOREIGNINFO c where c.corpId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				//����������ݿ���ڣ������޸�ҳ��
				corp.setCorpId(rs.getString("corpId"));								//����
				corp.setCorpName(rs.getString("corpName"));							//��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); 						//��֯��������
				corp.setForeignCorpName(rs.getString("foreignCorpName"));			//����Ͷ��������
				corp.setNationName(rs.getString("nationName")); 					//���һ����   ���ֵ��TBNATIONALDIC��
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));		//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				corp.setRegPrin(rs.getString("regPrin")); 							//����Ͷ��ע���ʽ���Ԫ��
				corp.setPercentTage(rs.getString("percentTage")); 					//����Ͷ����ռ������%��
				int num = Integer.parseInt(rs.getString("foreignIvestor"));
				if( num == 0 )
				{														//����Ͷ�������� 0��������ҵ��1��������Ȼ��
					corp.setForeignIvestor("������ҵ"); 
				}
				else
				{
					corp.setForeignIvestor("������Ȼ��"); 
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

}
