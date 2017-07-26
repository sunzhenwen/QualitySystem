package com.tj.jst.inner.qualificationProductivity.floorapproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * 大厅查询企业信息分页类
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpCondition extends Condition {

	private String corpName;// 企业名称
	private String corpCode;// 企业组织机构代码

	public FloorQueryCorpCondition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where SPARE1 is not null ");

		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode = '" + corpCode + "'");
		}
		String sql = "select * from V_CORPBASICINFO " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where SPARE1 is not null ");

		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode = '" + corpCode + "'");
		}
		String sqlCount = "select count(*) from V_CORPBASICINFO "
				+ sb.toString();
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
