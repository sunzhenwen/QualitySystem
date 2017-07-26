package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * 技术人员
 * @author DarkFlameMaster
 *
 */
public class QuerySkilledworkerCondition extends Condition {

	private String corpId;
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"'");
		
		
		String sql = "select * from V_SKILLEDWORKER "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer("where corpId='"+corpId+"'");
		
		
		String sqlCount="select count(*) from V_SKILLEDWORKER "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
