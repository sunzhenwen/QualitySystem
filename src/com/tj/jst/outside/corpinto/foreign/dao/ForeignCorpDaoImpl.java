package com.tj.jst.outside.corpinto.foreign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;
public class ForeignCorpDaoImpl implements IForeignCorpDao{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;
	
	//��֯���������ѯ
	@Override
	public ForeignCorp queryCorpName(String corpCode) {
		// TODO Auto-generated method stub

		ForeignCorp foreigncorp = new ForeignCorp();
		//��ѯ�������ݿ�
		try
		{
			String qsql = "select * from TBCorpForeigninfo where corpCode=?";
			qconn = ConnectionFactory.getBasicConnection();
			qpstmt = qconn.prepareStatement(qsql);
			qpstmt.setString(1, corpCode);
			qrs = qpstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(qrs.next())
			{
				foreigncorp.setCheckType(0);
				foreigncorp.setMessage("������ѯ����ҵ�Ѿ���ע�����룬��ʹ��UKey��½��");
			}else
			{
				//����������ݿⲻ���ڣ���ѯ����ϵͳ���ݿ�
				String sql = "select * from TBCorpForeigninfo where corpCode=?";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corpCode);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					//����������ݿ���ڣ������޸�ҳ��
					foreigncorp.setCorpId(rs.getString("corpId"));							 //����	
					foreigncorp.setCorpName(rs.getString("corpName"));	 					 //��ҵ����
					foreigncorp.setCorpCode(rs.getString("corpCode")); 			 			//��֯��������
					foreigncorp.setForeignCorpName(rs.getString("foreignCorpName"));
					foreigncorp.setNationNume(rs.getString("nationNum"));					//���������
					foreigncorp.setPrincipalUnitNum(rs.getString("principalUnitNum"));  	//ע���ʱ�����
					foreigncorp.setRegPrin(rs.getString("regPrin"));  						//����Ͷ��ע���ʽ�
					foreigncorp.setPercentTage(rs.getString("percentTage")); 				//����Ͷ����ռ����
					foreigncorp.setForeignIvestor(rs.getString("foreignIvestor")); 			//����Ͷ��������
					foreigncorp.setCheckType(1);
				}else
				{
					//����������ݿⲻ���ڣ��������ע��ҳ��
					foreigncorp.setCheckType(2);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return foreigncorp;
	}
	
	//��ѯ���������
	@Override
	public List<DictionaryClass> queryNation() {
		// TODO Auto-generated method stub
		String sql = "select * from TBNATIONALDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("country"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//����������ҵ
	@Override
	public String addForeignCorp(ForeignCorp foreignCorp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql ="insert into TBCorpForeigninfo(CORPNAME,CORPCODE,"
				+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,"
				+ "FOREIGNIVESTOR,CREATEDATE,CORPID) values "
				+ "(?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,foreignCorp.getCorpName());				//��ҵ����
			pstmt.setString(2,foreignCorp.getCorpCode());				//��֯��������
			pstmt.setString(3,foreignCorp.getForeignCorpName());		//����Ͷ��������
			pstmt.setString(4,foreignCorp.getNationNume());				//������������ֵ��TBNATIONALDIC��
			pstmt.setString(5,foreignCorp.getPrincipalUnitNum());		//ע���ʱ����֣��ֵ��TBPRINCIPALUNITDIC��
			pstmt.setString(6,foreignCorp.getRegPrin());				//����Ͷ���ʽ���Ԫ��
			pstmt.setString(7,foreignCorp.getPercentTage());			//����Ͷ����ռ������%��
			pstmt.setString(8,foreignCorp.getForeignIvestor());			//����Ͷ��������
			pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//���ʱ��corpCode
			pstmt.setString(10, corpId);	//����
			int check =  pstmt.executeUpdate();
			if(check == 1)
			{
				message = "ע��ɹ�,�뵽���������ˣ�";
			}else
			{
				message = "ע��ʧ�ܣ�";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//�޸�������ҵ��Ϣ
	@Override
	public String modifyForeignCorp(ForeignCorp foreignCorp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCorpForeigninfo set CORPNAME = ? "
				+ ", CORPCODE= ? , FOREIGNCORPNAME = ? , NATIONNUM = ? "
				+ ",PRINCIPALUNITNUM = ? , REGPRIN = ? , PERCENTTAGE = ? , "
				+ "FOREIGNIVESTOR = ? , MODIFYDATE = ? where CORPID=? " ;
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,foreignCorp.getCorpName());				//��ҵ����
			pstmt.setString(2,foreignCorp.getCorpCode());				//��֯��������
			pstmt.setString(3,foreignCorp.getForeignCorpName());		//����Ͷ��������
			pstmt.setString(4,foreignCorp.getNationNume());				//������������ֵ��TBNATIONALDIC��
			pstmt.setString(5,foreignCorp.getPrincipalUnitNum());		//ע���ʱ����֣��ֵ��TBPRINCIPALUNITDIC��
			pstmt.setString(6,foreignCorp.getRegPrin());				//����Ͷ���ʽ���Ԫ��
			pstmt.setString(7,foreignCorp.getPercentTage());			//����Ͷ����ռ������%��
			pstmt.setString(8,foreignCorp.getForeignIvestor());			//����Ͷ��������
			pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
			pstmt.setString(10,foreignCorp.getCorpId());	//ID
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//ע���ʱ�����
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//����Ͷ��������
	@Override
	public List<DictionaryClass> queryIvestor() {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		DictionaryClass dictionaryClass = new DictionaryClass();
		dictionaryClass.setName("������ҵ");
		dictionaryClass.setCode("0");
		list.add(dictionaryClass);
		DictionaryClass dictionaryClass1 = new DictionaryClass();
		dictionaryClass1.setName("������Ȼ��");
		dictionaryClass1.setCode("1");
		list.add(dictionaryClass1);
		return list;
	}
	
	
	
	
	
}
