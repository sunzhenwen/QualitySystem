package com.tj.jst.inner.qualificationProductivity.queryAllApplication.condition;

import com.tj.jst.base.page.Condition;

public class QueryAllApplicationCondition extends Condition {

	// ��ʼʱ��
	private String startDate;
	// ����ʱ��
	private String endDate;
	// ��ҵ����
	private String corpName;
	// ��������
	private String addTypeNum;
	// �����������
	private String oneResults;
	// �����������
	private String ultimateresults;
	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private String cretLevel;
	// ����������ԱID
	private String approvalStaffId;
	// �����㼶�ж�
	private String level;
	// ������������
	private String approvalDeptName;
	// ������������
	private String twoApprovalDeptName;

	public QueryAllApplicationCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem("CREATDATE desc");
		StringBuffer sb = new StringBuffer(" where 1=1");
		if (level != null && !"".equals(level)) {
			if (level.equals("1")) {
				sb.append(" and (TWOAPPROVALDEPT = 0)");
			} else if (level.equals("2")) {
				sb.append(" and (TWOAPPROVALDEPT != 0)");
			}
		}

		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and creatDate >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and creatDate <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (cretLevel != null && !"".equals(cretLevel)) {
			sb.append(" and cretLevel = '" + cretLevel + "'");
		}
		if (addTypeNum != null && !"".equals(addTypeNum)) {
			sb.append(" and addTypeNum = '" + addTypeNum + "'");
		}
		if (ultimateresults != null && !"".equals(ultimateresults)) {
			if(ultimateresults.equals("5")){
				sb.append(" and (qualiftype = '5' or qualiftype = '9')");
			}else if(ultimateresults.equals("6")){
				sb.append(" and (qualiftype = '6' or qualiftype = '10' or qualiftype = '8' or qualiftype = 'b')");
			}else if(ultimateresults.equals("a")){
				sb.append(" and qualiftype = 'a' ");
			}else if(ultimateresults.equals("2")){
				sb.append(" and qualiftype = '2' ");
			}else if(ultimateresults.equals("q")){
				sb.append(" and qualiftype = '1' and (cretGrade=1 or cretGrade=2)");
			}else if(ultimateresults.equals("w")){
				sb.append(" and qualiftype = '1' and cretGrade=3");
			}
		}
		String sql = "select * from V_QUALIFICATIONAPPLY " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem("CREATDATE desc");
		StringBuffer sb = new StringBuffer(" where 1=1");
		if (level != null && !"".equals(level)) {
			if (level.equals("1")) {
				sb.append(" and (TWOAPPROVALDEPT = 0)");
			} else if (level.equals("2")) {
				sb.append(" and (TWOAPPROVALDEPT != 0)");
			}
		}

		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and creatDate >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and creatDate <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (cretLevel != null && !"".equals(cretLevel)) {
			sb.append(" and cretLevel = '" + cretLevel + "'");
		}
		if (addTypeNum != null && !"".equals(addTypeNum)) {
			sb.append(" and addTypeNum = '" + addTypeNum + "'");
		}
		if (ultimateresults != null && !"".equals(ultimateresults)) {
			if(ultimateresults.equals("5")){
				sb.append(" and (qualiftype = '5' or qualiftype = '9')");
			}else if(ultimateresults.equals("6")){
				sb.append(" and (qualiftype = '6' or qualiftype = '10' or qualiftype = '8' or qualiftype = 'b')");
			}else if(ultimateresults.equals("a")){
				sb.append(" and qualiftype = 'a' ");
			}else if(ultimateresults.equals("2")){
				sb.append(" and qualiftype = '2' ");
			}else if(ultimateresults.equals("q")){
				sb.append(" and qualiftype = '1' and (cretGrade=1 or cretGrade=2)");
			}else if(ultimateresults.equals("w")){
				sb.append(" and qualiftype = '1' and cretGrade=3");
			}
		}
		String sqlCount = "select count(*) from V_QUALIFICATIONAPPLY "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}

	public String getOneResults() {
		return oneResults;
	}

	public void setOneResults(String oneResults) {
		this.oneResults = oneResults;
	}

	public String getUltimateresults() {
		return ultimateresults;
	}

	public void setUltimateresults(String ultimateresults) {
		this.ultimateresults = ultimateresults;
	}

	public String getCretLevel() {
		return cretLevel;
	}

	public void setCretLevel(String cretLevel) {
		this.cretLevel = cretLevel;
	}

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getApprovalDeptName() {
		return approvalDeptName;
	}

	public void setApprovalDeptName(String approvalDeptName) {
		this.approvalDeptName = approvalDeptName;
	}

	public String getTwoApprovalDeptName() {
		return twoApprovalDeptName;
	}

	public void setTwoApprovalDeptName(String twoApprovalDeptName) {
		this.twoApprovalDeptName = twoApprovalDeptName;
	}

}
