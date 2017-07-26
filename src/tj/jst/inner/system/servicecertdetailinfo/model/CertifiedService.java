package com.tj.jst.inner.system.servicecertdetailinfo.model;

import java.sql.Date;

/**
 * 资质服务事项维护
 * 
 * @author Administrator
 *
 */
public class CertifiedService {

	// 主键
	private String certId;
	// 服务事项名称
	private String certName;
	//原资质名称
	private String oldCertName;
	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	private int cretType;
	// 资质类型名称
	private String cretTypeName;
	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	private int cretLevel;
	// 资质等级名称
	private String cretLevelName;
	// 资质序列(字典表：TBTRADETYPEDIC)
	private int cretSequence;
	// 资质序列名称
	private String cretSequenceName;
	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private int specialtyType;
	// 资质专业类别名称
	private String specialtyTypeName;
	// 资质级别(字典表：TBCRETGRADEDIC)
	private String cretGrade;
	// 资质级别名称
	private String cretGradeName;
	// 审批部门
	private String approvalDept;
	// 审批部门名称
	private String approvalDeptName;
	// 二级审批初审部门(1：无,其余按部门code)
	private String twoApprovalDept;
	// 二级审批部门名称
	private String twoApprovalDeptName;
	// 添加时间
	private Date createDate;
	// 修改时间
	private Date modifyDate;
	// 0：再用，1：已删除
	private String type;
	// 是否是最低等级(1:是，2：否)
	private String lowestType;
	// 审批条件
	private String approvalCondition;
	// 审批流程
	private String approvalProcess;
	// 是否可升级
	private String isUpgrade;
	// 是否是最高等级
	private String isMax;

	private String TRADEBOUNDNUM;// 资质专业类别
	private String TITLELEVELNUM;// 资质等级

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public int getCretType() {
		return cretType;
	}

	public void setCretType(int cretType) {
		this.cretType = cretType;
	}

	public int getCretLevel() {
		return cretLevel;
	}

	public void setCretLevel(int cretLevel) {
		this.cretLevel = cretLevel;
	}

	public int getCretSequence() {
		return cretSequence;
	}

	public void setCretSequence(int cretSequence) {
		this.cretSequence = cretSequence;
	}

	public int getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(int specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getCretGrade() {
		return cretGrade;
	}

	public void setCretGrade(String cretGrade) {
		this.cretGrade = cretGrade;
	}

	public String getApprovalDept() {
		return approvalDept;
	}

	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCretTypeName() {
		return cretTypeName;
	}

	public void setCretTypeName(String cretTypeName) {
		this.cretTypeName = cretTypeName;
	}

	public String getCretLevelName() {
		return cretLevelName;
	}

	public void setCretLevelName(String cretLevelName) {
		this.cretLevelName = cretLevelName;
	}

	public String getCretSequenceName() {
		return cretSequenceName;
	}

	public void setCretSequenceName(String cretSequenceName) {
		this.cretSequenceName = cretSequenceName;
	}

	public String getSpecialtyTypeName() {
		return specialtyTypeName;
	}

	public void setSpecialtyTypeName(String specialtyTypeName) {
		this.specialtyTypeName = specialtyTypeName;
	}

	public String getCretGradeName() {
		return cretGradeName;
	}

	public void setCretGradeName(String cretGradeName) {
		this.cretGradeName = cretGradeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLowestType() {
		return lowestType;
	}

	public void setLowestType(String lowestType) {
		this.lowestType = lowestType;
	}

	public String getTwoApprovalDept() {
		return twoApprovalDept;
	}

	public void setTwoApprovalDept(String twoApprovalDept) {
		this.twoApprovalDept = twoApprovalDept;
	}

	public String getApprovalCondition() {
		return approvalCondition;
	}

	public void setApprovalCondition(String approvalCondition) {
		this.approvalCondition = approvalCondition;
	}

	public String getApprovalProcess() {
		return approvalProcess;
	}

	public void setApprovalProcess(String approvalProcess) {
		this.approvalProcess = approvalProcess;
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

	public String getIsUpgrade() {
		return isUpgrade;
	}

	public void setIsUpgrade(String isUpgrade) {
		this.isUpgrade = isUpgrade;
	}

	public String getTRADEBOUNDNUM() {
		return TRADEBOUNDNUM;
	}

	public void setTRADEBOUNDNUM(String tRADEBOUNDNUM) {
		TRADEBOUNDNUM = tRADEBOUNDNUM;
	}

	public String getTITLELEVELNUM() {
		return TITLELEVELNUM;
	}

	public void setTITLELEVELNUM(String tITLELEVELNUM) {
		TITLELEVELNUM = tITLELEVELNUM;
	}

	public String getIsMax() {
		return isMax;
	}

	public void setIsMx(String isMax) {
		this.isMax = isMax;
	}

	public String getOldCertName() {
		return oldCertName;
	}

	public void setOldCertName(String oldCertName) {
		this.oldCertName = oldCertName;
	}

	public void setIsMax(String isMax) {
		this.isMax = isMax;
	}

}
