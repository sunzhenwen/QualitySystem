package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʷ���������ѯ��ҳ����
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryFloorApprovalCondition extends Condition {

	// ��ҵ����
	private String corpName;
	// ��ҵ��֯����
	private String corpCode;

	public QueryFloorApprovalCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 ");

		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode like '%" + corpCode.trim() + "%'");
		}
		String sql = "select * from TB_FLOORAPPROVAL " + sb.toString();
		System.out.println("sql = " + sql);
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
		String sqlCount = "select count(*) from TB_FLOORAPPROVAL "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
