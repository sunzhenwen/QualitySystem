package com.tj.jst.inner.qualificationProductivity.certificatePrint.model;

import java.sql.Date;
import java.util.List;

/**
 * 证书打印
 * @author hhc
 *
 */
public class CertificatePrint {

	private String corpCertId; //主键
	private String corpName; //企业名称
	private String corpCode; //组织机构代码
	private int certTypeNum; //资质资格类型(字典表：TBAPTITUDEKINDDIC)
	private String certTypeName;//资质资格类型名称
	private String certId; //证书编号
	private int titleLevelNum; //资质资格最高等级(字典表：TBCERTTITLELEVELDIC)
	private String titleLevelName;//资质资格最高等级
	private String techMan; //技术负责人姓名
	private String techManDuty; //技术负责人职务
	private String techManProTitle; //技术负责人职称或职业资格
	private String unitMan; //企业负责人姓名
	private String unitManDuty; //企业负责人职务
	private String untiManProTitle; //企业负责人职称
	private String organName; //发证机关
	private Date organDate; //发证日期
	private Date endDate; //证书有效期截止日期
	private int isValid; //证书状态(字典表：TBCERTSTATEDIC)
	private String isValidName;//证书状态名称
	private String descrpition; //备注
	private String corpId; //企业ID
	private Date upDateTime; //操作日期
	private String oldOrNew; //0：老数据 1：新数据
	private String dataSource; //数据来源系统
	private String certName; //资质类别及等级
	private String approvalDept; //审批部门
	private String approvalStaff; //审批人员名称
	private String approvalStaffId; //审批人员Id
	private Date ultimtDate; //审批时间
	private String cretGrade; //资质级别(字典表：TBCRETGRADEDIC)国家、省、地市
	private String cretGradeName;//资质级别名称
	private String addTypeNum; //资质资格取得方式(字典表：TBADDTYPEDIC)003增项
	private String addTypeName;//资质资格取得方式名称
	private String licenseNum; //工商营业执照注册号
	private String approvalDeptName; //审批部门名称
	private String provinceNum; //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
	private String provinceName;//省名称
	private String cityNum; //注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
	private String cityName;//市名称
	private String countyNum; //注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
	private String countyName;//县名称
	private String address; //企业营业地址
	private String legalMan; //法定代表人姓名
	private String idCardTypeNum; //法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCardTypeName;//证件类型名称
	private String legalManIdCard; //法定代表人证件号码
	private String legalManDuty; //法定代表人职务
	private String legaManProtitle; //法定代表人职称
	private String econmicNum; //企业登记注册类型(字典表：TBECONTYPEDIC)
	private String econmicName;//企业登记注册类型名称
	private String regPrin; //注册资本(万元)
	private String relationId;//用于资质信息表和资质证书表以及基础数据库关联
	private List<String> certNames;
	private Date printDate;
	private String year;//打印年
	private String month;//打印月
	private String day;//打印日
	private String updateType;	
	private Date writeOffDate;//注销时间
	private String writeOffStaffName;//注销人名
	private String writeOffStaffId;//注销人Id
	private Date recoverDate;//恢复时间
	private String recoverStaffName;//恢复人名
	private String recoverStaffId;//恢复人Id
	private String writeOffType;//注销申请：1、已申请;2：申请通过
	private Date writeOffAppDate;//申请注销时间
	private String writeAppOpinion;//注销审批意见
	private Date writeReturnDate;//退回时间
	private String writeReturnStaffId;//退回人员id
	private String writeReturnStaffName;//退回人员名字
	private Date writeOffFloorDate;//大厅审批时间
	private String writeOffFloorOpinion;//大厅审批意见
	private String writeOffFloorStaffName;//大厅注销人名
	private String writeOffFloorStaffId;//大厅注销人Id

	private String QRCODE;//正本二维码标识
	private String FBQRCODE;//副本二维码标识
	private String PRINTNUMBER;//正本流水号
	private String FBPRINTNUMBER;//副本流水号
	
	private String ISPRINT;//是否打印
	private int PRINTCOUNT;//打印次数
	
	private String CREATEDATE;//是否打印
	
	
	public String getCorpCertId() {
		return corpCertId;
	}
	public void setCorpCertId(String corpCertId) {
		this.corpCertId = corpCertId;
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
	public int getCertTypeNum() {
		return certTypeNum;
	}
	public void setCertTypeNum(int certTypeNum) {
		this.certTypeNum = certTypeNum;
	}
	public String getCertTypeName() {
		return certTypeName;
	}
	public void setCertTypeName(String certTypeName) {
		this.certTypeName = certTypeName;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public int getTitleLevelNum() {
		return titleLevelNum;
	}
	public void setTitleLevelNum(int titleLevelNum) {
		this.titleLevelNum = titleLevelNum;
	}
	public String getTitleLevelName() {
		return titleLevelName;
	}
	public void setTitleLevelName(String titleLevelName) {
		this.titleLevelName = titleLevelName;
	}
	public String getTechMan() {
		return techMan;
	}
	public void setTechMan(String techMan) {
		this.techMan = techMan;
	}
	public String getTechManDuty() {
		return techManDuty;
	}
	public void setTechManDuty(String techManDuty) {
		this.techManDuty = techManDuty;
	}
	public String getTechManProTitle() {
		return techManProTitle;
	}
	public void setTechManProTitle(String techManProTitle) {
		this.techManProTitle = techManProTitle;
	}
	public String getUnitMan() {
		return unitMan;
	}
	public void setUnitMan(String unitMan) {
		this.unitMan = unitMan;
	}
	public String getUnitManDuty() {
		return unitManDuty;
	}
	public void setUnitManDuty(String unitManDuty) {
		this.unitManDuty = unitManDuty;
	}
	public String getUntiManProTitle() {
		return untiManProTitle;
	}
	public void setUntiManProTitle(String untiManProTitle) {
		this.untiManProTitle = untiManProTitle;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
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
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public String getIsValidName() {
		return isValidName;
	}
	public void setIsValidName(String isValidName) {
		this.isValidName = isValidName;
	}
	public String getDescrpition() {
		return descrpition;
	}
	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public Date getUpDateTime() {
		return upDateTime;
	}
	public void setUpDateTime(Date upDateTime) {
		this.upDateTime = upDateTime;
	}
	public String getOldOrNew() {
		return oldOrNew;
	}
	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getApprovalDept() {
		return approvalDept;
	}
	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}
	public String getApprovalStaff() {
		return approvalStaff;
	}
	public void setApprovalStaff(String approvalStaff) {
		this.approvalStaff = approvalStaff;
	}
	public String getApprovalStaffId() {
		return approvalStaffId;
	}
	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}
	public Date getUltimtDate() {
		return ultimtDate;
	}
	public void setUltimtDate(Date ultimtDate) {
		this.ultimtDate = ultimtDate;
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
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getApprovalDeptName() {
		return approvalDeptName;
	}
	public void setApprovalDeptName(String approvalDeptName) {
		this.approvalDeptName = approvalDeptName;
	}
	public String getProvinceNum() {
		return provinceNum;
	}
	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityNum() {
		return cityNum;
	}
	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyNum() {
		return countyNum;
	}
	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getIdCardTypeName() {
		return idCardTypeName;
	}
	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}
	public String getLegalManIdCard() {
		return legalManIdCard;
	}
	public void setLegalManIdCard(String legalManIdCard) {
		this.legalManIdCard = legalManIdCard;
	}
	public String getLegalManDuty() {
		return legalManDuty;
	}
	public void setLegalManDuty(String legalManDuty) {
		this.legalManDuty = legalManDuty;
	}
	public String getLegaManProtitle() {
		return legaManProtitle;
	}
	public void setLegaManProtitle(String legaManProtitle) {
		this.legaManProtitle = legaManProtitle;
	}
	public String getEconmicNum() {
		return econmicNum;
	}
	public void setEconmicNum(String econmicNum) {
		this.econmicNum = econmicNum;
	}
	public String getEconmicName() {
		return econmicName;
	}
	public void setEconmicName(String econmicName) {
		this.econmicName = econmicName;
	}
	public String getRegPrin() {
		return regPrin;
	}
	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public List<String> getCertNames() {
		return certNames;
	}
	public void setCertNames(List<String> certNames) {
		this.certNames = certNames;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public Date getWriteOffDate() {
		return writeOffDate;
	}
	public void setWriteOffDate(Date writeOffDate) {
		this.writeOffDate = writeOffDate;
	}
	public String getWriteOffStaffName() {
		return writeOffStaffName;
	}
	public void setWriteOffStaffName(String writeOffStaffName) {
		this.writeOffStaffName = writeOffStaffName;
	}
	public String getWriteOffStaffId() {
		return writeOffStaffId;
	}
	public void setWriteOffStaffId(String writeOffStaffId) {
		this.writeOffStaffId = writeOffStaffId;
	}
	public Date getRecoverDate() {
		return recoverDate;
	}
	public void setRecoverDate(Date recoverDate) {
		this.recoverDate = recoverDate;
	}
	public String getRecoverStaffName() {
		return recoverStaffName;
	}
	public void setRecoverStaffName(String recoverStaffName) {
		this.recoverStaffName = recoverStaffName;
	}
	public String getRecoverStaffId() {
		return recoverStaffId;
	}
	public void setRecoverStaffId(String recoverStaffId) {
		this.recoverStaffId = recoverStaffId;
	}
	public String getWriteOffType() {
		return writeOffType;
	}
	public void setWriteOffType(String writeOffType) {
		this.writeOffType = writeOffType;
	}
	public Date getWriteOffAppDate() {
		return writeOffAppDate;
	}
	public void setWriteOffAppDate(Date writeOffAppDate) {
		this.writeOffAppDate = writeOffAppDate;
	}
	public String getWriteAppOpinion() {
		return writeAppOpinion;
	}
	public void setWriteAppOpinion(String writeAppOpinion) {
		this.writeAppOpinion = writeAppOpinion;
	}
	public Date getWriteReturnDate() {
		return writeReturnDate;
	}
	public void setWriteReturnDate(Date writeReturnDate) {
		this.writeReturnDate = writeReturnDate;
	}
	public String getWriteReturnStaffId() {
		return writeReturnStaffId;
	}
	public void setWriteReturnStaffId(String writeReturnStaffId) {
		this.writeReturnStaffId = writeReturnStaffId;
	}
	public String getWriteReturnStaffName() {
		return writeReturnStaffName;
	}
	public void setWriteReturnStaffName(String writeReturnStaffName) {
		this.writeReturnStaffName = writeReturnStaffName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public String getQRCODE() {
		return QRCODE;
	}
	public void setQRCODE(String qRCODE) {
		QRCODE = qRCODE;
	}
	public String getFBQRCODE() {
		return FBQRCODE;
	}
	public void setFBQRCODE(String fBQRCODE) {
		FBQRCODE = fBQRCODE;
	}
	public String getPRINTNUMBER() {
		return PRINTNUMBER;
	}
	public void setPRINTNUMBER(String pRINTNUMBER) {
		PRINTNUMBER = pRINTNUMBER;
	}
	public String getFBPRINTNUMBER() {
		return FBPRINTNUMBER;
	}
	public void setFBPRINTNUMBER(String fBPRINTNUMBER) {
		FBPRINTNUMBER = fBPRINTNUMBER;
	}
	public String getISPRINT() {
		return ISPRINT;
	}
	public void setISPRINT(String iSPRINT) {
		ISPRINT = iSPRINT;
	}
	public int getPRINTCOUNT() {
		return PRINTCOUNT;
	}
	public void setPRINTCOUNT(int pRINTCOUNT) {
		PRINTCOUNT = pRINTCOUNT;
	}
	public String getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(String cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}
	public Date getWriteOffFloorDate() {
		return writeOffFloorDate;
	}
	public void setWriteOffFloorDate(Date writeOffFloorDate) {
		this.writeOffFloorDate = writeOffFloorDate;
	}
	public String getWriteOffFloorOpinion() {
		return writeOffFloorOpinion;
	}
	public void setWriteOffFloorOpinion(String writeOffFloorOpinion) {
		this.writeOffFloorOpinion = writeOffFloorOpinion;
	}
	public String getWriteOffFloorStaffName() {
		return writeOffFloorStaffName;
	}
	public void setWriteOffFloorStaffName(String writeOffFloorStaffName) {
		this.writeOffFloorStaffName = writeOffFloorStaffName;
	}
	public String getWriteOffFloorStaffId() {
		return writeOffFloorStaffId;
	}
	public void setWriteOffFloorStaffId(String writeOffFloorStaffId) {
		this.writeOffFloorStaffId = writeOffFloorStaffId;
	}

}
