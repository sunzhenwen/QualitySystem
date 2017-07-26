package com.tj.jst.inner.system.servicecertdetailinfo.model;

import java.sql.Date;

/**
 * ���ʷ�������ά��
 * 
 * @author Administrator
 *
 */
public class CertifiedService {

	// ����
	private String certId;
	// ������������
	private String certName;
	//ԭ��������
	private String oldCertName;
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
	// ��������������(1����,���ఴ����code)
	private String twoApprovalDept;
	// ����������������
	private String twoApprovalDeptName;
	// ���ʱ��
	private Date createDate;
	// �޸�ʱ��
	private Date modifyDate;
	// 0�����ã�1����ɾ��
	private String type;
	// �Ƿ�����͵ȼ�(1:�ǣ�2����)
	private String lowestType;
	// ��������
	private String approvalCondition;
	// ��������
	private String approvalProcess;
	// �Ƿ������
	private String isUpgrade;
	// �Ƿ�����ߵȼ�
	private String isMax;

	private String TRADEBOUNDNUM;// ����רҵ���
	private String TITLELEVELNUM;// ���ʵȼ�

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
