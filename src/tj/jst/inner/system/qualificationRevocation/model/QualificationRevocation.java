package com.tj.jst.inner.system.qualificationRevocation.model;

import java.sql.Date;




/**
 * 企业已拥有资质打回
 * 孙振文
 * @author Administrator
 *
 */
public class QualificationRevocation {

	//企业基本信息
	private String corpName;	//企业名称
	private String corpCode;	//组织机构代码
	private String licenseNum;	//工商营业执照注册号
	private String provinceNum;	//注册所在省(自治区、直辖市)(字典表：tbxzqdmdic)
	private String provinceName;
	private String cityNum;	//注册所在地(市、州、盟)(字典表：tbxzqdmdic)
	private String cityName;	//注册所在地(市、州、盟)(字典表：tbxzqdmdic)
	private String countyNum;	//注册所在县(区、市、旗)(字典表：tbxzqdmdic)
	private String adminareaName;	//注册所在县(区、市、旗)(字典表：tbxzqdmdic)
	private String address;	//企业营业地址
	private String postalcode;	//企业营业地址邮政编码
	private String legalMan;	//法定代表人姓名
	private String idcardtypeNum;	//法定代表人证件类型(字典表：tbidcardtypedic)
	private String papertypeName; //证件类型名称
	private String legalmanidCard;	//法定代表人证件号码
	private String legalmanDuty;	//法定代表人职务
	private String legamanProtitle;	//法定代表人职称
	private Integer economicNum;	//企业登记注册类型(字典表：tbecontypedic)
	private Double regPrin;	//注册资本(万元)
	private Double factRegPrin;	//实收资本(万元)
	private String principalUnitNum;	//注册资本币种(字典表：tbprincipalunitdic)
	private Date corpBirthDate;	//成立日期
	private String officePhone;	//办公电话
	private String fax;	//传真号码
	private String linkMan;	//联系人姓名
	private String linkTel;	//联系人办公电话
	private String linkPhone;	//联系人手机号码
	private String email;	//联系邮箱
	private String url;	//企业网址
	private String description;	//备注
	private String corpId;	//企业id
	private Date updateTime;	//操作日期
	private String oldornew;	//0：老数据 1：新数据
	private String datasource;	//数据来源系统
	private String locknumber1;	//ukey存储字段
	private String spare1;	//备用字段-企业资质管理信息系统——企业归属地
	private Double assets;	//企业净资产
	private String machinery;	//机械设备
	private Date creatDate;	//注册日期
	private String checkforeign;	//是否外商投资	   0:是；1：否"
	private String locknumber1_no;	//ukey标签编号
	private Date locknumber1_date;	//ukey发往日期
	private String economicPropertyName;//经济类型名称
	
	//资质相关变量
	private String certName;			//资质类别及等级
	private Integer tradeboundnum; //专业类别(字典表：tbtradetypebounddic【无专业不填写】)
	private Integer titlelevelnum; //资质资格等级(字典表：tbcerttitleleveldic)
	private String addtypenum; //资质资格取得方式(字典表：tbaddtypedic)
	private String certtradestatusnum; //资质资格状态(字典表：tbcerttradestatusdic)
	private String tradetypeName;//序列名称
	private String tradetypeboundName;//专业类别
	private String principalUnitName;//币种名称
	private String gradeName;//资质类别
	private String ultimateresults; //审批结果
	private Date ultimatedate; //审批时间
	private String ultimateopinion;//审批建议
	private String approvaldeptname; //审批部门名称
	private String approvaldept ; //审批部门id
	private String oneresults; //初审审批结果
	private String oneultimateopinion; //初审审批意见
	private Date oneappdate; //初审审批时间
	private String twoapprovalstaff; //初审审批人名
	private String twoapprovalstaffid; //初审审批人id
	private String twoapprovaldept;	//二级审批部门
	private String twoapprovaldeptname;	//二级审批部门名称
	private String addtypeName;//资质获取方式
	private String relationid;
	private String cretGrade;//资质级别
	private String certId;//证书编号
	private String qualifType;//资质申请状态 
	
	private Date revocationDate;//资质打回时间
	private String revocationReason;//打回原因
	private String revocationId; //打回id
	
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
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getLegalMan() {
		return legalMan;
	}
	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}
	public String getIdcardtypeNum() {
		return idcardtypeNum;
	}
	public void setIdcardtypeNum(String idcardtypeNum) {
		this.idcardtypeNum = idcardtypeNum;
	}
	public String getLegalmanidCard() {
		return legalmanidCard;
	}
	public void setLegalmanidCard(String legalmanidCard) {
		this.legalmanidCard = legalmanidCard;
	}
	public String getLegalmanDuty() {
		return legalmanDuty;
	}
	public void setLegalmanDuty(String legalmanDuty) {
		this.legalmanDuty = legalmanDuty;
	}
	public String getLegamanProtitle() {
		return legamanProtitle;
	}
	public void setLegamanProtitle(String legamanProtitle) {
		this.legamanProtitle = legamanProtitle;
	}
	public Integer getEconomicNum() {
		return economicNum;
	}
	public void setEconomicNum(Integer economicNum) {
		this.economicNum = economicNum;
	}
	public Double getRegPrin() {
		return regPrin;
	}
	public void setRegPrin(Double regPrin) {
		this.regPrin = regPrin;
	}
	public Double getFactRegPrin() {
		return factRegPrin;
	}
	public void setFactRegPrin(Double factRegPrin) {
		this.factRegPrin = factRegPrin;
	}
	public String getPrincipalUnitNum() {
		return principalUnitNum;
	}
	public void setPrincipalUnitNum(String principalUnitNum) {
		this.principalUnitNum = principalUnitNum;
	}
	public Date getCorpBirthDate() {
		return corpBirthDate;
	}
	public void setCorpBirthDate(Date corpBirthDate) {
		this.corpBirthDate = corpBirthDate;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOldornew() {
		return oldornew;
	}
	public void setOldornew(String oldornew) {
		this.oldornew = oldornew;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getLocknumber1() {
		return locknumber1;
	}
	public void setLocknumber1(String locknumber1) {
		this.locknumber1 = locknumber1;
	}
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	public Double getAssets() {
		return assets;
	}
	public void setAssets(Double assets) {
		this.assets = assets;
	}
	public String getMachinery() {
		return machinery;
	}
	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public String getCheckforeign() {
		return checkforeign;
	}
	public void setCheckforeign(String checkforeign) {
		this.checkforeign = checkforeign;
	}
	public String getLocknumber1_no() {
		return locknumber1_no;
	}
	public void setLocknumber1_no(String locknumber1_no) {
		this.locknumber1_no = locknumber1_no;
	}
	public Date getLocknumber1_date() {
		return locknumber1_date;
	}
	public void setLocknumber1_date(Date locknumber1_date) {
		this.locknumber1_date = locknumber1_date;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public Integer getTradeboundnum() {
		return tradeboundnum;
	}
	public void setTradeboundnum(Integer tradeboundnum) {
		this.tradeboundnum = tradeboundnum;
	}
	public Integer getTitlelevelnum() {
		return titlelevelnum;
	}
	public void setTitlelevelnum(Integer titlelevelnum) {
		this.titlelevelnum = titlelevelnum;
	}
	public String getAddtypenum() {
		return addtypenum;
	}
	public void setAddtypenum(String addtypenum) {
		this.addtypenum = addtypenum;
	}
	public String getCerttradestatusnum() {
		return certtradestatusnum;
	}
	public void setCerttradestatusnum(String certtradestatusnum) {
		this.certtradestatusnum = certtradestatusnum;
	}
	public String getUltimateresults() {
		return ultimateresults;
	}
	public void setUltimateresults(String ultimateresults) {
		this.ultimateresults = ultimateresults;
	}
	public Date getUltimatedate() {
		return ultimatedate;
	}
	public void setUltimatedate(Date ultimatedate) {
		this.ultimatedate = ultimatedate;
	}
	public String getApprovaldeptname() {
		return approvaldeptname;
	}
	public void setApprovaldeptname(String approvaldeptname) {
		this.approvaldeptname = approvaldeptname;
	}
	public String getOneresults() {
		return oneresults;
	}
	public void setOneresults(String oneresults) {
		this.oneresults = oneresults;
	}
	public String getOneultimateopinion() {
		return oneultimateopinion;
	}
	public void setOneultimateopinion(String oneultimateopinion) {
		this.oneultimateopinion = oneultimateopinion;
	}
	public Date getOneappdate() {
		return oneappdate;
	}
	public void setOneappdate(Date oneappdate) {
		this.oneappdate = oneappdate;
	}
	public String getTwoapprovalstaff() {
		return twoapprovalstaff;
	}
	public void setTwoapprovalstaff(String twoapprovalstaff) {
		this.twoapprovalstaff = twoapprovalstaff;
	}
	public String getTwoapprovalstaffid() {
		return twoapprovalstaffid;
	}
	public void setTwoapprovalstaffid(String twoapprovalstaffid) {
		this.twoapprovalstaffid = twoapprovalstaffid;
	}
	public String getTwoapprovaldept() {
		return twoapprovaldept;
	}
	public void setTwoapprovaldept(String twoapprovaldept) {
		this.twoapprovaldept = twoapprovaldept;
	}
	public String getTwoapprovaldeptname() {
		return twoapprovaldeptname;
	}
	public void setTwoapprovaldeptname(String twoapprovaldeptname) {
		this.twoapprovaldeptname = twoapprovaldeptname;
	}
	public Date getRevocationDate() {
		return revocationDate;
	}
	public void setRevocationDate(Date revocationDate) {
		this.revocationDate = revocationDate;
	}
	public String getRevocationReason() {
		return revocationReason;
	}
	public void setRevocationReason(String revocationReason) {
		this.revocationReason = revocationReason;
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
	public String getAdminareaName() {
		return adminareaName;
	}
	public void setAdminareaName(String adminareaName) {
		this.adminareaName = adminareaName;
	}
	public String getEconomicPropertyName() {
		return economicPropertyName;
	}
	public void setEconomicPropertyName(String economicPropertyName) {
		this.economicPropertyName = economicPropertyName;
	}
	public String getTradetypeName() {
		return tradetypeName;
	}
	public void setTradetypeName(String tradetypeName) {
		this.tradetypeName = tradetypeName;
	}
	public String getTradetypeboundName() {
		return tradetypeboundName;
	}
	public void setTradetypeboundName(String tradetypeboundName) {
		this.tradetypeboundName = tradetypeboundName;
	}
	public String getPrincipalUnitName() {
		return principalUnitName;
	}
	public void setPrincipalUnitName(String principalUnitName) {
		this.principalUnitName = principalUnitName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getAddtypeName() {
		return addtypeName;
	}
	public void setAddtypeName(String addtypeName) {
		this.addtypeName = addtypeName;
	}
	public String getUltimateopinion() {
		return ultimateopinion;
	}
	public void setUltimateopinion(String ultimateopinion) {
		this.ultimateopinion = ultimateopinion;
	}
	public String getPapertypeName() {
		return papertypeName;
	}
	public void setPapertypeName(String papertypeName) {
		this.papertypeName = papertypeName;
	}
	public String getRelationid() {
		return relationid;
	}
	public void setRelationid(String relationid) {
		this.relationid = relationid;
	}
	public String getCretGrade() {
		return cretGrade;
	}
	public void setCretGrade(String cretGrade) {
		this.cretGrade = cretGrade;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getQualifType() {
		return qualifType;
	}
	public void setQualifType(String qualifType) {
		this.qualifType = qualifType;
	}
	public String getRevocationId() {
		return revocationId;
	}
	public void setRevocationId(String revocationId) {
		this.revocationId = revocationId;
	}
	public String getApprovaldept() {
		return approvaldept;
	}
	public void setApprovaldept(String approvaldept) {
		this.approvaldept = approvaldept;
	}


	
}
