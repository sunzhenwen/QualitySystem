package com.tj.jst.outside.businessReport.updateQualification.model;

import java.sql.Date;

/**
 * �������ʷ�������
 * @author DarkFlameMaster
 *
 */
public class UpdateQualfication {
	
		//����
		private String newQualId;
		//��ҵ����
		private String corpId;
		//��ҵ����
		private String corpName;
		//��ҵסַ��������֤
		private String corpCode;
		//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
		private String provinceNum;
		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
		private String cityNum;
		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
		private String countyNum;
		//��ҵ���ڵ�ʡ����
		private String provinceName;
		//��ҵ����������
		private String cityName;
		//��ҵ����������
		private String countyName;
		//���ʲ�
		private String assets;
		//��е�豸
		private String machinery;
		//����״̬
		//1����ҵ���ύ������������
		//2�����ͳ���������
		//3���������������(ͨ��)�����������ţ�Ҳ����1�еĴ���������
		//4���������������(δͨ��)�����������ţ�Ҳ����1�еĴ���������
		//5����������ͨ��
		//6����������δͨ��
		private String qualifType;
		//�����������
		private String infancyOpinion;
		//�����������
		private String ultimateOpinion;
		//------------------------------------------���ʷ�������--------------------------------------
		
		//����
		private String certId;
		//������������
		private String certName;
		//��������(�ֵ��TBAPTITUDEKINDDIC)
		private int cretType;
		//������������
		private String cretTypeName;
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		private int cretLevel;
		//���ʵȼ�����
		private String cretLevelName;
		//��������(�ֵ��TBTRADETYPEDIC)
		private int cretSequence;
		//������������
		private String cretSequenceName;
		//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
		private int specialtyType;
		//����רҵ�������
		private String specialtyTypeName;
		//���ʼ���(�ֵ��TBCRETGRADEDIC)
		private String cretGrade;
		//���ʼ�������
		private String cretGradeName;
		//��������
		private String approvalDept;
		//������������
		private String approvalDeptName;
		//��������������
		private String twoApprovalDept;
		//������������������
		private String twoApprovalDeptName;
		//��������
		private Date creatDate;
		//�����ʸ�ȡ�÷�ʽ
		private String addTypeNum;
		//�����ʸ�ȡ�÷�ʽ����
		private String addTypeName;
		//�Ƿ�����͵ȼ�(1:�ǣ�2����)
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
		

}
