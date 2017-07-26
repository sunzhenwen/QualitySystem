package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import com.tj.jst.base.page.Condition;

public class QueryPosNumCondition extends Condition {

	private String idcards;

	public QueryPosNumCondition(String idcards) {
		// TODO Auto-generated constructor stub
		this.idcards = idcards;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		if (idcards != null && !"".equals(idcards)) {
			sb.append(" where FCardId in (" + idcards + ") and FIsDeleted = 0 ");
		}else{
			sb.append(" where 1=2");
		}
		String sql = "select row_number() over(order by FRegDate desc) as rownumber,fPersonID, FName, FCardID, FSex, FEntName, FDuty , FCertNumber FROM Position_Certificate"
				+ sb.toString();
		System.out.println("sql= " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		if (idcards != null && !"".equals(idcards)) {
			sb.append(" where FCardId in (" + idcards + ") and FIsDeleted = 0 ");
		}else{
			sb.append(" where 1=2");
		}
		String sqlCount = "select count(*) from Position_Certificate "
				+ sb.toString();
		System.out.println("sqlCount= " + sqlCount);
		return sqlCount;
	}

}
