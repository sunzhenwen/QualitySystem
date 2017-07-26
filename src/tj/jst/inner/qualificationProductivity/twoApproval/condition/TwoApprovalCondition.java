package com.tj.jst.inner.qualificationProductivity.twoApproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * 省级资质审批
 * @author Administrator
 *
 */
public class TwoApprovalCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//企业名称
	private String corpName;
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	private String cretType;
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	private String cretLevel;
	//资质序列(字典表：TBTRADETYPEDIC)
	private String cretSequence;
	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private String specialtyType;
	//资质级别(字典表：TBCRETGRADEDIC)
	private String cretGrade;
	//申请类型
	private String addTypeNum;
	//部门Id
	private String deptId;
	
//	public TwoApprovalCondition()
//	{
//		
//	}
//	
//	public TwoApprovalCondition(String deptId)
//	{
//		this.deptId = deptId;
//	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where rtrim(TWOAPPROVALDEPT)='"+deptId.trim()+"' and QUALIFTYPE='2'");
		this.setOrderByItem(" CREATDATE desc ");
		//StringBuffer sb=new StringBuffer(" where QUALIFTYPE='2'");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(cretType != null && !"".equals(cretType)){
			sb.append(" and cretType = '"+cretType+"'");
		}
		if(cretLevel != null && !"".equals(cretLevel)){
			sb.append(" and cretLevel = '"+cretLevel+"'");
		}
		if(cretSequence != null && !"".equals(cretSequence)){
			sb.append(" and cretSequence = '"+cretSequence+"'");
		}
		if(specialtyType != null && !"".equals(specialtyType)){
			sb.append(" and specialtyType = '"+specialtyType+"'");
		}
		if(cretGrade != null && !"".equals(cretGrade)){
			sb.append(" and cretGrade = '"+cretGrade+"'");
		}
		if(addTypeNum != null && !"".equals(addTypeNum)){
			sb.append(" and addTypeNum = '"+addTypeNum+"'");
		}
		
		String sql = "select * from V_QUALIFICATIONAPPLY "+sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where rtrim(TWOAPPROVALDEPT)='"+deptId.trim()+"' and QUALIFTYPE='2'");
		//StringBuffer sb=new StringBuffer(" where QUALIFTYPE='2'");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(cretType != null && !"".equals(cretType)){
			sb.append(" and cretType = '"+cretType+"'");
		}
		if(cretLevel != null && !"".equals(cretLevel)){
			sb.append(" and cretLevel = '"+cretLevel+"'");
		}
		if(cretSequence != null && !"".equals(cretSequence)){
			sb.append(" and cretSequence = '"+cretSequence+"'");
		}
		if(specialtyType != null && !"".equals(specialtyType)){
			sb.append(" and specialtyType = '"+specialtyType+"'");
		}
		if(cretGrade != null && !"".equals(cretGrade)){
			sb.append(" and cretGrade = '"+cretGrade+"'");
		}
		if(addTypeNum != null && !"".equals(addTypeNum)){
			sb.append(" and addTypeNum = '"+addTypeNum+"'");
		}
		
		String sqlCount="select count(*) from V_QUALIFICATIONAPPLY "+sb.toString();
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

	public String getCretType() {
		return cretType;
	}

	public void setCretType(String cretType) {
		this.cretType = cretType;
	}

	public String getCretLevel() {
		return cretLevel;
	}

	public void setCretLevel(String cretLevel) {
		this.cretLevel = cretLevel;
	}

	public String getCretSequence() {
		return cretSequence;
	}

	public void setCretSequence(String cretSequence) {
		this.cretSequence = cretSequence;
	}

	public String getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getCretGrade() {
		return cretGrade;
	}

	public void setCretGrade(String cretGrade) {
		this.cretGrade = cretGrade;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
