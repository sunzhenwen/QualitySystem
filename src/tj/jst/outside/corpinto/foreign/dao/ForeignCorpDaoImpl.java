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
	
	//组织机构代码查询
	@Override
	public ForeignCorp queryCorpName(String corpCode) {
		// TODO Auto-generated method stub

		ForeignCorp foreigncorp = new ForeignCorp();
		//查询基础数据库
		try
		{
			String qsql = "select * from TBCorpForeigninfo where corpCode=?";
			qconn = ConnectionFactory.getBasicConnection();
			qpstmt = qconn.prepareStatement(qsql);
			qpstmt.setString(1, corpCode);
			qrs = qpstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(qrs.next())
			{
				foreigncorp.setCheckType(0);
				foreigncorp.setMessage("您所查询的企业已经过注册申请，请使用UKey登陆！");
			}else
			{
				//如果基础数据库不存在，查询资质系统数据库
				String sql = "select * from TBCorpForeigninfo where corpCode=?";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corpCode);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					//如果资质数据库存在，返回修改页面
					foreigncorp.setCorpId(rs.getString("corpId"));							 //主键	
					foreigncorp.setCorpName(rs.getString("corpName"));	 					 //企业名称
					foreigncorp.setCorpCode(rs.getString("corpCode")); 			 			//组织机构代码
					foreigncorp.setForeignCorpName(rs.getString("foreignCorpName"));
					foreigncorp.setNationNume(rs.getString("nationNum"));					//国籍或地区
					foreigncorp.setPrincipalUnitNum(rs.getString("principalUnitNum"));  	//注册资本币种
					foreigncorp.setRegPrin(rs.getString("regPrin"));  						//外商投入注册资金
					foreigncorp.setPercentTage(rs.getString("percentTage")); 				//外商投资所占比例
					foreigncorp.setForeignIvestor(rs.getString("foreignIvestor")); 			//外商投资者类型
					foreigncorp.setCheckType(1);
				}else
				{
					//如果资质数据库不存在，返回添加注册页面
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
	
	//查询国籍或地区
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
	
	//增加外商企业
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
			pstmt.setString(1,foreignCorp.getCorpName());				//企业名称
			pstmt.setString(2,foreignCorp.getCorpCode());				//组织机构代码
			pstmt.setString(3,foreignCorp.getForeignCorpName());		//外商投资者名称
			pstmt.setString(4,foreignCorp.getNationNume());				//国籍或地区（字典表：TBNATIONALDIC）
			pstmt.setString(5,foreignCorp.getPrincipalUnitNum());		//注册资本币种（字典表：TBPRINCIPALUNITDIC）
			pstmt.setString(6,foreignCorp.getRegPrin());				//外商投入资金（万元）
			pstmt.setString(7,foreignCorp.getPercentTage());			//外商投资所占比例（%）
			pstmt.setString(8,foreignCorp.getForeignIvestor());			//外商投资这类型
			pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//添加时间corpCode
			pstmt.setString(10, corpId);	//主键
			int check =  pstmt.executeUpdate();
			if(check == 1)
			{
				message = "注册成功,请到受理大厅审核！";
			}else
			{
				message = "注册失败！";
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
	
	//修改外商企业信息
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
			pstmt.setString(1,foreignCorp.getCorpName());				//企业名称
			pstmt.setString(2,foreignCorp.getCorpCode());				//组织机构代码
			pstmt.setString(3,foreignCorp.getForeignCorpName());		//外商投资者名称
			pstmt.setString(4,foreignCorp.getNationNume());				//国籍或地区（字典表：TBNATIONALDIC）
			pstmt.setString(5,foreignCorp.getPrincipalUnitNum());		//注册资本币种（字典表：TBPRINCIPALUNITDIC）
			pstmt.setString(6,foreignCorp.getRegPrin());				//外商投入资金（万元）
			pstmt.setString(7,foreignCorp.getPercentTage());			//外商投资所占比例（%）
			pstmt.setString(8,foreignCorp.getForeignIvestor());			//外商投资这类型
			pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//修改时间
			pstmt.setString(10,foreignCorp.getCorpId());	//ID
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
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
	
	//注册资本币种
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

	//外商投资者类型
	@Override
	public List<DictionaryClass> queryIvestor() {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		DictionaryClass dictionaryClass = new DictionaryClass();
		dictionaryClass.setName("境外企业");
		dictionaryClass.setCode("0");
		list.add(dictionaryClass);
		DictionaryClass dictionaryClass1 = new DictionaryClass();
		dictionaryClass1.setName("境外自然人");
		dictionaryClass1.setCode("1");
		list.add(dictionaryClass1);
		return list;
	}
	
	
	
	
	
}
