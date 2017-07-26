package com.tj.jst.base.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;

public class CertifiedCode {
	

	/**
	 * ��ѯ��ˮ��
	 */
	public static int querySerNum()
	{
		int serNum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(SERIALNUM) as SERIALNUM from TBSERIALNUM";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				serNum = rs.getInt("SERIALNUM");
				int upNum = serNum;
				if(serNum<100000)
				{
					//����
					String upSql = "update TBSERIALNUM set SERIALNUM=?";
					pstmt = conn.prepareStatement(upSql);
					pstmt.setInt(1, ++upNum);
					pstmt.executeUpdate();
				}else
				{
					serNum = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return serNum;
	}
	
	
	//��ȡ
	/**
	 * 
	 * @param econ	��ҵע������
	 * @param cretGrade	���ʼ���(�ֵ��TBCRETGRADEDIC)
	 * @param serNum	��ˮ��
	 * @return ֤����
	 */
	public static String getCertifiedCode(String econ,String cretGrade,int serNum)
	{
		String certifiedCode = "";
		String certNum = "";
		if(econ.startsWith("3"))
		{
			//��3��ͷΪ������ҵ
			certifiedCode=certifiedCode+"DW";
		}else{
			//����λ������ҵ
			certifiedCode=certifiedCode+"D";
		}
		if(cretGrade.equals("1"))
		{
			//����
			certNum=certNum+"1,";
		}else if(cretGrade.equals("2"))
		{
			//ʡ
			certNum=certNum+"2,";
		}else
		{
			//����
			certNum=certNum+"3,";
		}
		//���Ϊ������ʡ
		certNum=certNum+"2,3,";
		
		if(serNum==0)
		{
			serNum = serNum+1;
		}
		String strSer = serNum+"";
		System.out.println(strSer.length());
		if(strSer.length()==1){
			certNum=certNum+"0,0,0,0,"+strSer;
		}else if(strSer.length()==2)
		{
			certNum=certNum+"0,0,0,"+strSer.substring(0, 1)+","+strSer.substring(1, 2);
		}else if(strSer.length()==3)
		{
			certNum=certNum+"0,0,"+strSer.substring(0, 1)+","+strSer.substring(1, 2)+","+strSer.subSequence(2, 3);
		}else if(strSer.length()==4)
		{
			certNum=certNum+"0,"+strSer.substring(0, 1)+","+strSer.substring(1, 2)+","+strSer.subSequence(2, 3)+","+strSer.substring(3, 4);
		}else
		{
			certNum=certNum+strSer.substring(0, 1)+","+strSer.substring(1, 2)+","+strSer.subSequence(2, 3)+","+strSer.substring(3, 4)+","+strSer.substring(4, 5);
		}
		
		
		
		//��֤���ŵĵڶ�λ����������̵Ļ� ��֤��ĵ���λ����ʼ�����8λ�������һ���ַ�����������У���롣
		//����֤���ţ�D253000012��Ҫ�������У�������ֵ�ǣ�25300001�����һ�����֣�2��Ϊ���֤���ŵ�У���롣
		//����У����Ĺ�ʽ��S = Sum(Ai * Wi) i = 0,1,2,3,4,5,6,7
		//����Ai��ʾ��iλ���ϵ�����ֵ��Wi��ʾ��iλ���ϵļ�Ȩ���ӣ����λ��Ӧ��ֵ����Ϊ�� 7 9 5 1 4 2 6 8
		//��10�Լ�����ȡģ  Y = mod(S, 10) ��������֤����У����
		
		String[] num = certNum.split(",");
		System.out.println(num.length);
		System.out.println(certNum);
		int one = Integer.parseInt(num[0])*7;
		int two = Integer.parseInt(num[1])*9;
		int three = Integer.parseInt(num[2])*5;
		int four = Integer.parseInt(num[3])*1;
		int five = Integer.parseInt(num[4])*4;
		int six = Integer.parseInt(num[5])*2;
		int seven = Integer.parseInt(num[6])*6;
		int eight = Integer.parseInt(num[7])*8;
		int sum = one+two+three+four+five+six+seven+eight;
		int mod = sum%10;
		certifiedCode = certifiedCode+certNum.replaceAll(",", "")+mod;
//		Random rand = new Random();
//		int random = rand.nextInt(10); //��ȡ10���������
//		certifiedCode=certifiedCode+random;
		return certifiedCode;
		
	}
	
}
