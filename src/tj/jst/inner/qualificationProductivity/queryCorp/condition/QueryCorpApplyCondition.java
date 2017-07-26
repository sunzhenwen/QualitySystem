package com.tj.jst.inner.qualificationProductivity.queryCorp.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ѯ��ҵ���걨��������Ϣ��ҳ��
 * 
 * @author Administrator
 *
 */
public class QueryCorpApplyCondition extends Condition {

	private String corpCode;// ��ҵ��֯��������֤

	public QueryCorpApplyCondition() {

	}

	public QueryCorpApplyCondition(String corpCode) {
		this.corpCode = corpCode;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(
				" where corpCode='"
						+ corpCode
						+ "' and ( QUALIFTYPE = 'a' or QUALIFTYPE = '1') and ADDTYPENUM=007 ");
		String sql = "select * from V_QUALIFICATIONAPPLY " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(
				" where corpCode='"
						+ corpCode
						+ "' and ( QUALIFTYPE = 'a' or QUALIFTYPE = '1') and ADDTYPENUM=007 ");
		String sqlCount = "select count(*) from V_QUALIFICATIONAPPLY "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
