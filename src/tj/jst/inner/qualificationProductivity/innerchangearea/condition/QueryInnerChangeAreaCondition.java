package com.tj.jst.inner.qualificationProductivity.innerchangearea.condition;

import com.tj.jst.base.page.Condition;

public class QueryInnerChangeAreaCondition extends Condition {

	private String corpCode;
	private String corpName;

	public QueryInnerChangeAreaCondition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode like '%" + corpCode.trim() + "%'");
		}
		String sql = "select * from TB_INNERCHANGEAREA " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode like '%" + corpCode.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_INNERCHANGEAREA "
				+ sb.toString();
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
