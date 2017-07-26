package com.tj.jst.inner.qualificationProductivity.querychangeinfo.condition;

import com.tj.jst.base.page.Condition;

public class QueryChangeInfoCondition extends Condition {

	private String corpName;// 公司名称，查询用
	private String deptId;

	public QueryChangeInfoCondition() {

	}
	
	public QueryChangeInfoCondition(String deptId){
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where (AFTERCITYAREA='"+deptId+"' or BEFOREAREA='"+deptId+"' or '"+deptId+"' not like '%00%')");
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		String sql = "select * from TB_CHANGEAREA" + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where (AFTERCITYAREA='"+deptId+"' or BEFOREAREA='"+deptId+"' or '"+deptId+"' not like '%00%') ");
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_CHANGEAREA" + sb.toString();
		System.out.println("sqlCount =" + sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
