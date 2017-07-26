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
	 * 修改外商企业
	 */
	@Override
	public String modifyCorp(CertifiedForeignCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCorpForeigninfo set FOREIGNCORPNAME=?,MODIFYDATE=? where CORPID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getForeignCorpName()); 					//外商投资者名称
			pstmt.setDate(2,new Date(new java.util.Date().getTime())); 		//修改时间
			pstmt.setString(3,corp.getCorpId());				//主键
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
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
	 * 外商企业查询
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
				//如果资质数据库存在，返回修改页面
				corp.setCorpId(rs.getString("corpId"));								//主键
				corp.setCorpName(rs.getString("corpName"));							//企业名称
				corp.setCorpCode(rs.getString("corpCode")); 						//组织机构代码
				corp.setForeignCorpName(rs.getString("foreignCorpName"));			//外商投资者名称
				corp.setNationName(rs.getString("nationName")); 					//国家或地区   （字典表：TBNATIONALDIC）
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));		//注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setRegPrin(rs.getString("regPrin")); 							//外商投入注册资金（万元）
				corp.setPercentTage(rs.getString("percentTage")); 					//外商投资所占比例（%）
				int num = Integer.parseInt(rs.getString("foreignIvestor"));
				if( num == 0 )
				{														//外商投资者类型 0、境外企业；1、境外自然人
					corp.setForeignIvestor("境外企业"); 
				}
				else
				{
					corp.setForeignIvestor("境外自然人"); 
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
