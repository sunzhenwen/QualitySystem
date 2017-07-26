package com.tj.jst.inner.qualificationProductivity.changearea.condition;

import com.tj.jst.base.page.Condition;

public class ChangeAreaCondition extends Condition {

	private String deptId;// key所在审批单位

	public ChangeAreaCondition(String deptId) {
		this.deptId = deptId;
	}

	public ChangeAreaCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(
				"  where ( beforeArea='"
						+ deptId
						+ "' and PROCESS = 1 and STATUS = 1) or (afterCityArea = '"+deptId+"'and PROCESS = 2 and STATUS = 1) or (STATUS = 2 and PROCESS = 1 and '"
						+ deptId
						+ "' not like '%00%') or (STATUS = 1 and  process = 4 and '"
						+ deptId + "' not like '%00%')");
		String sql = "select * from TB_CHANGEAREA" + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(
				"  where ( beforeArea='"
						+ deptId
						+ "' and PROCESS = 1 and STATUS =1) or (afterCityArea = '"+deptId+"'and PROCESS = 2 and STATUS =1) or (STATUS = 2 and PROCESS = 1 and '"
						+ deptId
						+ "' not like '%00%') or (STATUS = 1 and  process = 4 and '"
						+ deptId + "' not like '%00%')");
		String sqlCount = "select count(*) from TB_CHANGEAREA" + sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
