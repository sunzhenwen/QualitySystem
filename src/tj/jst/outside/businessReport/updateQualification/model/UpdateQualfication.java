package com.tj.jst.outside.businessReport.updateQualification.model;

import java.sql.Date;

/**
 * 升级资质服务事项
 * @author DarkFlameMaster
 *
 */
public class UpdateQualfication {
	
		//主键
		private String newQualId;
		//企业主键
		private String corpId;
		//企业名称
		private String corpName;
		//企业住址机构代码证
		private String corpCode;
		//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
		private String provinceNum;
		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
		private String cityNum;
		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
		private String countyNum;
		//企业所在的省名称
		private String provinceName;
		//企业所在市名称
		private String cityName;
		//企业所在区名称
		private String countyName;
		//净资产
		private String assets;
		//机械设备
		private String machinery;
		//申请状态
		//1：企业已提交，待部门审批
		//2：发送初审部门审批
		//3：初审部门审批完毕(通过)，返回终审部门，也就是1中的待审批部门
		//4：初审部门审批完毕(未通过)，返回终审部门，也就是1中的待审批部门
		//5：终审审批通过
		//6：终审审批未通过
		private String qualifType;
		//初审审批意见
		private String infancyOpinion;
		//终身审批意见
		private String ultimateOpinion;
		//------------------------------------------资质服务事项--------------------------------------
		
		//主键
		private String certId;
		//服务事项名称
		private String certName;
		//资质类型(字典表：TBAPTITUDEKINDDIC)
		private int cretType;
		//资质类型名称
		private String cretTypeName;
		//资质等级(字典表：TBCERTTITLELEVELDIC)
		private int cretLevel;
		//资质等级名称
		private String cretLevelName;
		//资质序列(字典表：TBTRADETYPEDIC)
		private int cretSequence;
		//资质序列名称
		private String cretSequenceName;
		//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
		private int specialtyType;
		//资质专业类别名称
		private String specialtyTypeName;
		//资质级别(字典表：TBCRETGRADEDIC)
		private String cretGrade;
		//资质级别名称
		private String cretGradeName;
		//审批部门
		private String approvalDept;
		//审批部门名称
		private String approvalDeptName;
		//二级审批初审部门
		private String twoApprovalDept;
		//二级审批初审部门名称
		private String twoApprovalDeptName;
		//申请日期
		private Date creatDate;
		//资质资格取得方式
		private String addTypeNum;
		//资质资格取得方式名称
		private String addTypeName;
		//是否是最低等级(1:是，2：否)
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
