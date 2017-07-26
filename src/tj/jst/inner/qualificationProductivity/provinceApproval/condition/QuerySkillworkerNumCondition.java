package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import com.tj.jst.base.page.Condition;

public class QuerySkillworkerNumCondition extends Condition {

	private String idcards;

	public QuerySkillworkerNumCondition(String idcards) {
		// TODO Auto-generated constructor stub
		this.idcards = idcards;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		if (idcards != null && !"".equals(idcards)) {
			sb.append(" where identityCard in (" + idcards + ")");
		}else{
			sb.append(" where 1=2");
		}
		String sql = "select * from V_SKILLEDWORKER " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		if (idcards != null && !"".equals(idcards)) {
			sb.append(" where identityCard in (" + idcards + ")");
		}else{
			sb.append(" where 1=2");
		}
		String sqlCount = "select count(*) from V_SKILLEDWORKER "
				+ sb.toString();
		return sqlCount;

	}

	public String getIdcards() {
		return idcards;
	}

	public void setIdcards(String idcards) {
		this.idcards = idcards;
	}

}
