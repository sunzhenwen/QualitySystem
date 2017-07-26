package com.tj.jst.outside.corpinto.performance.model;

import java.sql.Date;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public class Performance {

	private String perId; //主键
	private String proName; //项目名称
	private String proType; //项目类型
	private Date startsDate; //开工时间
	private Date completedDate; //竣工时间
	private String proScale; //工程规模
	private String proCost; //工程造价
	private String construction; //建设单位
	private String contractor; //总承包单位
	private String design; //设计单位
	private String supervisor; //监理
	private String corpId; //企业Id
	private String corpName; //企业名称
	private String corpCode; //组织机构改代码
	private Date createDate; //创建时间
	
	public String getPerId() {
		return perId;
	}
	public void setPerId(String perId) {
		this.perId = perId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public Date getStartsDate() {
		return startsDate;
	}
	public void setStartsDate(Date startsDate) {
		this.startsDate = startsDate;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	public String getProScale() {
		return proScale;
	}
	public void setProScale(String proScale) {
		this.proScale = proScale;
	}
	public String getProCost() {
		return proCost;
	}
	public void setProCost(String proCost) {
		this.proCost = proCost;
	}
	public String getConstruction() {
		return construction;
	}
	public void setConstruction(String construction) {
		this.construction = construction;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
