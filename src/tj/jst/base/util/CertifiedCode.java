package com.tj.jst.base.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;

public class CertifiedCode {
	

	/**
	 * 查询流水号
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
					//更新
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
	
	
	//获取
	/**
	 * 
	 * @param econ	企业注册类型
	 * @param cretGrade	资质级别(字典表：TBCRETGRADEDIC)
	 * @param serNum	流水号
	 * @return 证书编号
	 */
	public static String getCertifiedCode(String econ,String cretGrade,int serNum)
	{
		String certifiedCode = "";
		String certNum = "";
		if(econ.startsWith("3"))
		{
			//以3开头为外商企业
			certifiedCode=certifiedCode+"DW";
		}else{
			//否则部位外商企业
			certifiedCode=certifiedCode+"D";
		}
		if(cretGrade.equals("1"))
		{
			//国家
			certNum=certNum+"1,";
		}else if(cretGrade.equals("2"))
		{
			//省
			certNum=certNum+"2,";
		}else
		{
			//地市
			certNum=certNum+"3,";
		}
		//如果为黑龙江省
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
		
		
		
		//从证书编号的第二位（如果是外商的话 从证书的第三位）开始往后的8位数字组成一个字符串，计算其校验码。
		//例如证书编号：D253000012，要参与计算校验码的数值是：25300001，最后一个数字：2即为这个证书编号的校验码。
		//计算校验码的公式：S = Sum(Ai * Wi) i = 0,1,2,3,4,5,6,7
		//其中Ai表示第i位置上的数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 5 1 4 2 6 8
		//以10对计算结果取模  Y = mod(S, 10) 其结果就是证书编号校验码
		
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
//		int random = rand.nextInt(10); //获取10以内随机数
//		certifiedCode=certifiedCode+random;
		return certifiedCode;
		
	}
	
}
