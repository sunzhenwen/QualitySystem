package com.tj.jst.outside.corpinto.performance.model;

import java.sql.Date;

/**
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public class Performance {

	private String perId; //����
	private String proName; //��Ŀ����
	private String proType; //��Ŀ����
	private Date startsDate; //����ʱ��
	private Date completedDate; //����ʱ��
	private String proScale; //���̹�ģ
	private String proCost; //�������
	private String construction; //���赥λ
	private String contractor; //�ܳа���λ
	private String design; //��Ƶ�λ
	private String supervisor; //����
	private String corpId; //��ҵId
	private String corpName; //��ҵ����
	private String corpCode; //��֯�����Ĵ���
	private Date createDate; //����ʱ��
	
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
