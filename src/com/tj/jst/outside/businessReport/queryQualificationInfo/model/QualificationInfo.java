package com.tj.jst.outside.businessReport.queryQualificationInfo.model;

import java.sql.Date;

public class QualificationInfo {

	private String newQualId; // ��� ��������Id

	private String corpId; // ���� ��ҵId

	private String corpName; // ��ҵ����

	private String qualifType; // ����״̬ 1�����ύ���������� 2�����ͳ�����������
								// 3���������������(ͨ��)�����������ţ�Ҳ����1�еĴ��������š�
								// 4�� �������������(δͨ��)�����������ţ�Ҳ����1�еĴ��������š�
								// 5����������ͨ���� 6����������δͨ����

	private String infancyOpinion; // �����������

	private String ultimateOpinion; // �����������

	private String approvalStaff; // ������Ա

	private String addTypeNum; // ������������

	private String addTypeName; // ����������������

	private String cretName; // ������������

	private Date floorDate; // ��������ʱ��

	private Date ultimateDate; // ��������ʱ��

	private String floorOp; // �����������

	// ------------------------------------------���ʷ�������--------------------------------------
	// ����
	private String certId;
	// ������������
	private String certName;
	// ��������(�ֵ��TBAPTITUDEKINDDIC)
	private int cretType;
	// ������������
	private String cretTypeName;
	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private int cretLevel;
	// ���ʵȼ�����
	private String cretLevelName;
	// ��������(�ֵ��TBTRADETYPEDIC)
	private int cretSequence;
	// ������������
	private String cretSequenceName;
	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	private int specialtyType;
	// ����רҵ�������
	private String specialtyTypeName;
	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
	private String cretGrade;
	// ���ʼ�������
	private String cretGradeName;
	// ��������
	private String approvalDept;
	// ������������
	private String approvalDeptName;
	// ��������������
	private String twoApprovalDept;
	// ������������������
	private String twoApprovalDeptName;
	// ��������
	private Date creatDate;
	// �����������
	private String oneUltimateOpinion;
	// ��������ʱ��
	private Date oneAppDate;
	// ����������Ա
	private String twoApprovalStaff;
	// ����������ԱId
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
