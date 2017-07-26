package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.page.Condition;

/**
 * 注册建造师分页工具类
 * @author Administrator
 *
 */
public class QueryConstructorCondition extends Condition {

	//企业id
	private String corpName;
	
	public QueryConstructorCondition()
	{
		
	}
	
	public QueryConstructorCondition(String corpName)
	{
		this.corpName = corpName;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    } 
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpName='"+corpName+"' ");
		
		String sql = "select * from V_CONSTRUCTOR"+sb.toString();
		System.out.println("sql= "+sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    } 
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpName='"+corpName+"' ");
		
		String sqlCount="select count(*) from V_CONSTRUCTOR "+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
