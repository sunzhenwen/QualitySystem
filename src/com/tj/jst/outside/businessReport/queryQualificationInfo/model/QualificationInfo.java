package com.tj.jst.outside.businessReport.queryQualificationInfo.model;

import java.sql.Date;

public class QualificationInfo {

	private String newQualId; // 外键 资质申请Id

	private String corpId; // 主键 企业Id

	private String corpName; // 企业名称

	private String qualifType; // 申请状态 1：已提交，待审批。 2：发送初审部门审批。
								// 3：初审部门审批完毕(通过)，返回终审部门，也就是1中的待审批部门。
								// 4： 初审部门审批完毕(未通过)，返回终审部门，也就是1中的待审批部门。
								// 5：终审审批通过。 6：终审审批未通过。

	private String infancyOpinion; // 初审审批意见

	private String ultimateOpinion; // 终身审批意见

	private String approvalStaff; // 审批人员

	private String addTypeNum; // 资质申请类型

	private String addTypeName; // 资质申请类型名称

	private String cretName; // 服务事项名称

	private Date floorDate; // 大厅审批时间

	private Date ultimateDate; // 终审审批时间

	private String floorOp; // 大厅审批意见

	// ------------------------------------------资质服务事项--------------------------------------
	// 主键
	private String certId;
	// 服务事项名称
	private String certName;
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
	// 二级审批初审部门
	private String twoApprovalDept;
	// 二级审批初审部门名称
	private String twoApprovalDeptName;
	// 申请日期
	private Date creatDate;
	// 初审审批意见
	private String oneUltimateOpinion;
	// 初审审批时间
	private Date oneAppDate;
	// 初审审批人员
	private String twoApprovalStaff;
	// 初审审批人员Id
	private String twoApprovalStaffId;

	public String getNewQualId() {
		return newQualId;
	}

	public void setNewQualId(String newQualId) {
		this.newQualId = newQualId;
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

	public String getQualifType() {
		return qualifType;
	}

	public void setQualifType(String qualifType) {
		this.qualifType = qualifType;
	}

	public String getInfancyOpinion() {
		return infancyOpinion;
	}

	public void setInfancyOpinion(String infancyOpinion) {
		this.infancyOpinion = infancyOpinion;
	}

	public String getUltimateOpinion() {
		return ultimateOpinion;
	}

	public void setUltimateOpinion(String ultimateOpinion) {
		this.ultimateOpinion = ultimateOpinion;
	}

	public String getApprovalStaff() {
		return approvalStaff;
	}

	public void setApprovalStaff(String approvalStaff) {
		this.approvalStaff = approvalStaff;
	}

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

	public String getCretTypeName() {
		return cretTypeName;
	}

	public void setCretTypeName(String cretTypeName) {
		this.cretTypeName = cretTypeName;
	}

	public int getCretLevel() {
		return cretLevel;
	}

	public void setCretLevel(int cretLevel) {
		this.cretLevel = cretLevel;
	}

	public String getCretLevelName() {
		return cretLevelName;
	}

	public void setCretLevelName(String cretLevelName) {
		this.cretLevelName = cretLevelName;
	}

	public int getCretSequence() {
		return cretSequence;
	}

	public void setCretSequence(int cretSequence) {
		this.cretSequence = cretSequence;
	}

	public String getCretSequenceName() {
		return cretSequenceName;
	}

	public void setCretSequenceName(String cretSequenceName) {
		this.cretSequenceName = cretSequenceName;
	}

	public int getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(int specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getSpecialtyTypeName() {
		return specialtyTypeName;
	}

	public void setSpecialtyTypeName(String specialtyTypeName) {
		this.specialtyTypeName = specialtyTypeName;
	}

	public String getCretGrade() {
		return cretGrade;
	}

	public void setCretGrade(String cretGrade) {
		this.cretGrade = cretGrade;
	}

	public String getCretGradeName() {
		return cretGradeName;
	}

	public void setCretGradeName(String cretGradeName) {
		this.cretGradeName = cretGradeName;
	}

	public String getApprovalDept() {
		return approvalDept;
	}

	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}

	public String getApprovalDeptName() {
		return approvalDeptName;
	}

	public void setApprovalDeptName(String approvalDeptName) {
		this.approvalDeptName = approvalDeptName;
	}

	public String getTwoApprovalDept() {
		return twoApprovalDept;
	}

	public void setTwoApprovalDept(String twoApprovalDept) {
		this.twoApprovalDept = twoApprovalDept;
	}

	public String getTwoApprovalDeptName() {
		return twoApprovalDeptName;
	}

	public void setTwoApprovalDeptName(String twoApprovalDeptName) {
		this.twoApprovalDeptName = twoApprovalDeptName;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getOneUltimateOpinion() {
		return oneUltimateOpinion;
	}

	public void setOneUltimateOpinion(String oneUltimateOpinion) {
		this.oneUltimateOpinion = oneUltimateOpinion;
	}

	public Date getOneAppDate() {
		return oneAppDate;
	}

	public void setOneAppDate(Date oneAppDate) {
		this.oneAppDate = oneAppDate;
	}

	public String getTwoApprovalStaff() {
		return twoApprovalStaff;
	}

	public void setTwoApprovalStaff(String twoApprovalStaff) {
		this.twoApprovalStaff = twoApprovalStaff;
	}

	public String getTwoApprovalStaffId() {
		return twoApprovalStaffId;
	}

	public void setTwoApprovalStaffId(String twoApprovalStaffId) {
		this.twoApprovalStaffId = twoApprovalStaffId;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}

	public String getAddTypeName() {
		return addTypeName;
	}

	public void setAddTypeName(String addTypeName) {
		this.addTypeName = addTypeName;
	}

	public String getCretName() {
		return cretName;
	}

	public void setCretName(String cretName) {
		this.cretName = cretName;
	}

	public Date getFloorDate() {
		return floorDate;
	}

	public void setFloorDate(Date floorDate) {
		this.floorDate = floorDate;
	}

	public Date getUltimateDate() {
		return ultimateDate;
	}

	public void setUltimateDate(Date ultimateDate) {
		this.ultimateDate = ultimateDate;
	}

	public String getFloorOp() {
		return floorOp;
	}

	public void setFloorOp(String floorOp) {
		this.floorOp = floorOp;
	}

}
