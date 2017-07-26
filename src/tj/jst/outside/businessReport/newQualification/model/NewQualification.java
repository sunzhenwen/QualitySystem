package com.tj.jst.outside.businessReport.newQualification.model;

import java.sql.Date;

/**
 * �ϱ����ʷ�������
 * 
 * @author Administrator
 *
 */
public class NewQualification {

	// ����
	private String newQualId;
	// ��ҵ����
	private String corpId;
	// ��ҵ����
	private String corpName;
	// ��ҵ�Ǽ�ע������
	private int economicNum;
	// ����Ӫҵִ�պ�
	private String licenseNum;
	// ע���ʱ�
	private String regPrin;
	// ��ҵסַ��������֤
	private String corpCode;
	// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
	private String provinceNum;
	// ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
	private String cityNum;
	// ע��������(�����С���)(�ֵ��TBXZQDMDIC)
	private String countyNum;
	// ��ҵ���ڵ�ʡ����
	private String provinceName;
	// ��ҵ����������
	private String cityName;
	// ��ҵ����������
	private String countyName;
	private String legalMan; // ��������������
	private String idCardTypeNum;// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
	private String legalManIdCard;// ����������֤������
	private String legaLManDuty;// ����������ְ��
	private String legaManProtitle;// ����������ְ��
	private String address; // ��ҵӪҵ��ַ
	private String assets; // ���ʲ�
	private String machinery; // ��е�豸
	private Date pushTwoDate; // ��������ʱ��
	private String dateMark; // �ж����ڱ�־λ
	private String differDay;// ʣ������
	// ����״̬
	// a: ��ҵ�ύ����������
	// b: ��������ͨ��
	// 1������������
	// 2�����ͳ���������
	// 3��רҵ�����������(ͨ��)�����������ţ�Ҳ����1�еĴ���������
	// 4��רҵ�����������(δͨ��)�����������ţ�Ҳ����1�еĴ���������
	// 5������ͨ��(ʡ������)
	// 6������δͨ��(ʡ������)
	// 7��������������ͨ��(���Ҽ�����)
	// 8��������������δͨ��(���Ҽ�����)
	// 9����������ͨ��(����)
	// 10����������δͨ��(����)
	private String qualifType;
	// ��������ʱ��
	private Date floorDate;
	private String floorOp;

	// -------------------����----------------------
	// ������Ա
	private String approvalStaff;
	// ������ԱId
	private String approvalStaffId;
	// ��������
	private String approvalDept;
	// ������������
	private String approvalDeptName;
	// �����������
	private String ultimateOpinion;
	// ��������ʱ��
	private Date ultimateDate;
	// �����������
	private String ultimateResults;
	// ------------------����------------------------
	// ����������Ա
	private String twoApprovalStaff;
	// ����������ԱId
	private String twoApprovalStaffId;
	// ��������������
	private String twoApprovalDept;
	// ������������������
	private String twoApprovalDeptName;
	// �����������
	private String oneUltimateOpinion;
	// ��������ʱ��
	private Date oneAppDate;
	// �����������
	private String oneResults;
	// ��ֹ����
	private Date deadDate;

	// ------------------------------------------���ʷ�������--------------------------------------

	// ����
	private String certId;
	// ������������
	private String certName;
	// ֤����
	private String certifiedCode;
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
	private Date creatDate;
	// �����ʸ�ȡ�÷�ʽ
	private String addTypeNum;
	// �����ʸ�ȡ�÷�ʽ����
	private String addTypeName;
	// �Ƿ�����͵ȼ�(1:�ǣ�2����)
	private String lowestType;
	// �����ֶ�-��ҵ���ʹ�����Ϣϵͳ������ҵ������
	private String spare1;
	// ��֤����
	private Date organDate;
	// ֤����Ч��ֹ����
	private Date endDate;

	// ----------------------------------------------------------������������ʹ��--------------------------------------

	private int oldCretLevel; // ԭ���ʵȼ�
	private String oldCretLevelName;// ԭ���ʵȼ�����
	private String oldCretGrade; // ԭ���ʼ���
	private String oldCretGradeName;// ԭ���ʼ�������
	private int oldSpecialtyType; // ԭ����רҵ���
	private String oldSpecialtyTypeName;// ԭ����רҵ�������
	private Date oldCreatDate; // ԭ��������ʱ��
	private Date oldUltimateDate; // ԭ������ʱ��
	
	// ----------------------------------------------------------���ʷ���/ת������ʹ��--------------------------------------
	
	private String preCorpCode ; //������/ת����ҵ����֯��������֤��
	private String preCorpName ; //������/ת����ҵ������

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

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
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

	public String getQualifType() {
		return qualifType;
	}

	public void setQualifType(String qualifType) {
		this.qualifType = qualifType;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
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

	public String getTwoApprovalDept() {
		return twoApprovalDept;
	}

	public void setTwoApprovalDept(String twoApprovalDept) {
		this.twoApprovalDept = twoApprovalDept;
	}

	public Date getUltimateDate() {
		return ultimateDate;
	}

	public void setUltimateDate(Date ultimateDate) {
		this.ultimateDate = ultimateDate;
	}

	public String getOneResults() {
		return oneResults;
	}

	public void setOneResults(String oneResults) {
		this.oneResults = oneResults;
	}

	public String getUltimateOpinion() {
		return ultimateOpinion;
	}

	public void setUltimateOpinion(String ultimateOpinion) {
		this.ultimateOpinion = ultimateOpinion;
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

	public String getLowestType() {
		return lowestType;
	}

	public void setLowestType(String lowestType) {
		this.lowestType = lowestType;
	}

	public String getApprovalStaff() {
		return approvalStaff;
	}

	public void setApprovalStaff(String approvalStaff) {
		this.approvalStaff = approvalStaff;
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

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public String getTwoApprovalStaffId() {
		return twoApprovalStaffId;
	}

	public void setTwoApprovalStaffId(String twoApprovalStaffId) {
		this.twoApprovalStaffId = twoApprovalStaffId;
	}

	public String getSpare1() {
		return spare1;
	}

	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	public String getUltimateResults() {
		return ultimateResults;
	}

	public void setUltimateResults(String ultimateResults) {
		this.ultimateResults = ultimateResults;
	}

	public String getCertifiedCode() {
		return certifiedCode;
	}

	public void setCertifiedCode(String certifiedCode) {
		this.certifiedCode = certifiedCode;
	}

	public int getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(int economicNum) {
		this.economicNum = economicNum;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}

	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}

	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}

	public String getLegalManIdCard() {
		return legalManIdCard;
	}

	public void setLegalManIdCard(String legalManIdCard) {
		this.legalManIdCard = legalManIdCard;
	}

	public String getLegaLManDuty() {
		return legaLManDuty;
	}

	public void setLegaLManDuty(String legaLManDuty) {
		this.legaLManDuty = legaLManDuty;
	}

	public String getLegaManProtitle() {
		return legaManProtitle;
	}

	public void setLegaManProtitle(String legaManProtitle) {
		this.legaManProtitle = legaManProtitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getRegPrin() {
		return regPrin;
	}

	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}

	public Date getOrganDate() {
		return organDate;
	}

	public void setOrganDate(Date organDate) {
		this.organDate = organDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getOldCretLevel() {
		return oldCretLevel;
	}

	public void setOldCretLevel(int oldCretLevel) {
		this.oldCretLevel = oldCretLevel;
	}

	public String getOldCretLevelName() {
		return oldCretLevelName;
	}

	public void setOldCretLevelName(String oldCretLevelName) {
		this.oldCretLevelName = oldCretLevelName;
	}

	public String getOldCretGrade() {
		return oldCretGrade;
	}

	public void setOldCretGrade(String oldCretGrade) {
		this.oldCretGrade = oldCretGrade;
	}

	public String getOldCretGradeName() {
		return oldCretGradeName;
	}

	public void setOldCretGradeName(String oldCretGradeName) {
		this.oldCretGradeName = oldCretGradeName;
	}

	public int getOldSpecialtyType() {
		return oldSpecialtyType;
	}

	public void setOldSpecialtyType(int oldSpecialtyType) {
		this.oldSpecialtyType = oldSpecialtyType;
	}

	public String getOldSpecialtyTypeName() {
		return oldSpecialtyTypeName;
	}

	public void setOldSpecialtyTypeName(String oldSpecialtyTypeName) {
		this.oldSpecialtyTypeName = oldSpecialtyTypeName;
	}

	public Date getOldCreatDate() {
		return oldCreatDate;
	}

	public void setOldCreatDate(Date oldCreatDate) {
		this.oldCreatDate = oldCreatDate;
	}

	public Date getOldUltimateDate() {
		return oldUltimateDate;
	}

	public void setOldUltimateDate(Date oldUltimateDate) {
		this.oldUltimateDate = oldUltimateDate;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public String getMachinery() {
		return machinery;
	}

	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}

	public Date getPushTwoDate() {
		return pushTwoDate;
	}

	public void setPushTwoDate(Date pushTwoDate) {
		this.pushTwoDate = pushTwoDate;
	}

	public String getDateMark() {
		return dateMark;
	}

	public void setDateMark(String dateMark) {
		this.dateMark = dateMark;
	}

	public Date getDeadDate() {
		return deadDate;
	}

	public void setDeadDate(Date deadDate) {
		this.deadDate = deadDate;
	}

	public String getDifferDay() {
		return differDay;
	}

	public void setDifferDay(String differDay) {
		this.differDay = differDay;
	}

	public Date getFloorDate() {
		return floorDate;
	}

	public void setFloorDate(Date floorDate) {
		this.floorDate = floorDate;
	}

	public String getFloorOp() {
		return floorOp;
	}

	public void setFloorOp(String floorOp) {
		this.floorOp = floorOp;
	}

	public String getPreCorpCode() {
		return preCorpCode;
	}

	public void setPreCorpCode(String preCorpCode) {
		this.preCorpCode = preCorpCode;
	}

	public String getPreCorpName() {
		return preCorpName;
	}

	public void setPreCorpName(String preCorpName) {
		this.preCorpName = preCorpName;
	}

}
