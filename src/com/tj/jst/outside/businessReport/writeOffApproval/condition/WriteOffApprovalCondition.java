package com.tj.jst.outside.businessReport.writeOffApproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业资质注销申请
 * @author Administrator
 *
 */
public class WriteOffApprovalCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	private String deptId;
	private String corpName;//企业名称
	private String licenseNum;//营业执照注册号
	private String legalMan;//法定代表人
	private String econmicNum;//经济性质
	private String certName;//资质类别及等级
	private String certId;//证书编号
	private String personalID;
	private String corpId;//企业主键
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" ORGANDATE desc ");
		//查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where (ISVALID=1 and corpId='"+corpId+"'"
				+ " and WRITEOFFTYPE=0) or (ISVALID=1 and corpId='"+corpId+"' and WRITEOFFTYPE=3) ");

		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '%"+licenseNum.trim()+"%'"); 
		}
		if(legalMan!= null && !"".equals(legalMan)){
			sb.append(" and legalMan like '%"+legalMan.trim()+"%'"); 
		}
		if(econmicNum != null && !"".equals(econmicNum)){
			sb.append(" and ECONOMICNUM = '"+econmicNum+"'");
		}
		if(certId != null && !"".equals(certId)){
			sb.append(" and certId like '%"+certId.trim()+"%'");
		}
		if(certName != null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and RECOVERDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and RECOVERDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		String sql = "select * from v_TBCORPCERTINFO "+sb.toString();
		
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where (ISVALID=1 and corpId='"+corpId+"' "
				+ "and WRITEOFFTYPE=0) or (ISVALID=1 and corpId='"+corpId+"' and WRITEOFFTYPE=3) ");
		
		
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '%"+licenseNum.trim()+"%'"); 
		}
		if(legalMan!= null && !"".equals(legalMan)){
			sb.append(" and legalMan like '%"+legalMan.trim()+"%'"); 
		}
		if(econmicNum != null && !"".equals(econmicNum)){
			sb.append(" and ECONOMICNUM = '"+econmicNum+"'");
		}
		if(certId != null && !"".equals(certId)){
			sb.append(" and certId like '%"+certId.trim()+"%'");
		}
		if(certName != null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and RECOVERDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and RECOVERDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		String sqlCount="select count(*) from v_TBCORPCERTINFO "+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}

	public String getEconmicNum() {
		return econmicNum;
	}

	public void setEconmicNum(String econmicNum) {
		this.econmicNum = econmicNum;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
