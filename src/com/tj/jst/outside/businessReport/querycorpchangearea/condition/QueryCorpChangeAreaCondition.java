package com.tj.jst.outside.businessReport.querycorpchangearea.condition;

import com.tj.jst.base.page.Condition;

public class QueryCorpChangeAreaCondition extends Condition {

	private String corpName;// 公司名称，查询用

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where corpName='" + corpName
				+ "'  ");
		String sql = "select * from TB_CHANGEAREA" + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where corpName='" + corpName
				+ "'  ");
		String sqlCount = "select count(*) from TB_CHANGEAREA" + sb.toString();
		System.out.println(sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
