package com.tj.jst.outside.businessReport.newQualification.model;

import java.sql.Date;

/**
 * 上报资质服务事项
 * 
 * @author Administrator
 *
 */
public class NewQualification {

	// 主键
	private String newQualId;
	// 企业主键
	private String corpId;
	// 企业名称
	private String corpName;
	// 企业登记注册类型
	private int economicNum;
	// 工商营业执照号
	private String licenseNum;
	// 注册资本
	private String regPrin;
	// 企业住址机构代码证
	private String corpCode;
	// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
	private String provinceNum;
	// 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
	private String cityNum;
	// 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
	private String countyNum;
	// 企业所在的省名称
	private String provinceName;
	// 企业所在市名称
	private String cityName;
	// 企业所在区名称
	private String countyName;
	private String legalMan; // 法定代表人姓名
	private String idCardTypeNum;// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
	private String legalManIdCard;// 法定代表人证件号码
	private String legaLManDuty;// 法定代表人职务
	private String legaManProtitle;// 法定代表人职称
	private String address; // 企业营业地址
	private String assets; // 净资产
	private String machinery; // 机械设备
	private Date pushTwoDate; // 推送外审时间
	private String dateMark; // 判断日期标志位
	private String differDay;// 剩余日期
	// 申请状态
	// a: 企业提交到大厅受理
	// b: 大厅受理不通过
	// 1：待部门审批
	// 2：发送初审部门审批
	// 3：专业厅局审批完毕(通过)，返回终审部门，也就是1中的待审批部门
	// 4：专业厅局审批完毕(未通过)，返回终审部门，也就是1中的待审批部门
	// 5：审批通过(省级资质)
	// 6：审批未通过(省级资质)
	// 7：初级资质审批通过(国家级资质)
	// 8：初级资质审批未通过(国家级资质)
	// 9：资质审批通过(国家)
	// 10：资质审批未通过(国家)
	private String qualifType;
	// 大厅受理时间
	private Date floorDate;
	private String floorOp;

	// -------------------终审----------------------
	// 审批人员
	private String approvalStaff;
	// 审批人员Id
	private String approvalStaffId;
	// 审批部门
	private String approvalDept;
	// 审批部门名称
	private String approvalDeptName;
	// 终身审批意见
	private String ultimateOpinion;
	// 终审审批时间
	private Date ultimateDate;
	// 终审审批结果
	private String ultimateResults;
	// ------------------初审------------------------
	// 初审审批人员
	private String twoApprovalStaff;
	// 初审审批人员Id
	private String twoApprovalStaffId;
	// 二级审批初审部门
	private String twoApprovalDept;
	// 二级审批初审部门名称
	private String twoApprovalDeptName;
	// 初审审批意见
	private String oneUltimateOpinion;
	// 初审审批时间
	private Date oneAppDate;
	// 初审审批结果
	private String oneResults;
	// 截止日期
	private Date deadDate;

	// ------------------------------------------资质服务事项--------------------------------------

	// 主键
	private String certId;
	// 服务事项名称
	private String certName;
	// 证书编号
	private String certifiedCode;
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
	// 申请日期
	private Date creatDate;
	// 资质资格取得方式
	private String addTypeNum;
	// 资质资格取得方式名称
	private String addTypeName;
	// 是否是最低等级(1:是，2：否)
	private String lowestType;
	// 备用字段-企业资质管理信息系统——企业归属地
	private String spare1;
	// 发证日期
	private Date organDate;
	// 证书有效截止日期
	private Date endDate;

	// ----------------------------------------------------------资质升级审批使用--------------------------------------

	private int oldCretLevel; // 原资质等级
	private String oldCretLevelName;// 原资质等级名称
	private String oldCretGrade; // 原资质级别
	private String oldCretGradeName;// 原资质级别名称
	private int oldSpecialtyType; // 原资质专业类别
	private String oldSpecialtyTypeName;// 原资质专业类别名称
	private Date oldCreatDate; // 原资质申请时间
	private Date oldUltimateDate; // 原资审批时间
	
	// ----------------------------------------------------------资质分立/转移审批使用--------------------------------------
	
	private String preCorpCode ; //被分立/转移企业的组织机构代码证号
	private String preCorpName ; //被分立/转移企业的名称

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
