package com.tj.jst.inner.system.qualificationRevocation.model;

import java.sql.Date;




/**
 * ��ҵ��ӵ�����ʴ��
 * ������
 * @author Administrator
 *
 */
public class QualificationRevocation {

	//��ҵ������Ϣ
	private String corpName;	//��ҵ����
	private String corpCode;	//��֯��������
	private String licenseNum;	//����Ӫҵִ��ע���
	private String provinceNum;	//ע������ʡ(��������ֱϽ��)(�ֵ��tbxzqdmdic)
	private String provinceName;
	private String cityNum;	//ע�����ڵ�(�С��ݡ���)(�ֵ��tbxzqdmdic)
	private String cityName;	//ע�����ڵ�(�С��ݡ���)(�ֵ��tbxzqdmdic)
	private String countyNum;	//ע��������(�����С���)(�ֵ��tbxzqdmdic)
	private String adminareaName;	//ע��������(�����С���)(�ֵ��tbxzqdmdic)
	private String address;	//��ҵӪҵ��ַ
	private String postalcode;	//��ҵӪҵ��ַ��������
	private String legalMan;	//��������������
	private String idcardtypeNum;	//����������֤������(�ֵ��tbidcardtypedic)
	private String papertypeName; //֤����������
	private String legalmanidCard;	//����������֤������
	private String legalmanDuty;	//����������ְ��
	private String legamanProtitle;	//����������ְ��
	private Integer economicNum;	//��ҵ�Ǽ�ע������(�ֵ��tbecontypedic)
	private Double regPrin;	//ע���ʱ�(��Ԫ)
	private Double factRegPrin;	//ʵ���ʱ�(��Ԫ)
	private String principalUnitNum;	//ע���ʱ�����(�ֵ��tbprincipalunitdic)
	private Date corpBirthDate;	//��������
	private String officePhone;	//�칫�绰
	private String fax;	//�������
	private String linkMan;	//��ϵ������
	private String linkTel;	//��ϵ�˰칫�绰
	private String linkPhone;	//��ϵ���ֻ�����
	private String email;	//��ϵ����
	private String url;	//��ҵ��ַ
	private String description;	//��ע
	private String corpId;	//��ҵid
	private Date updateTime;	//��������
	private String oldornew;	//0�������� 1��������
	private String datasource;	//������Դϵͳ
	private String locknumber1;	//ukey�洢�ֶ�
	private String spare1;	//�����ֶ�-��ҵ���ʹ�����Ϣϵͳ������ҵ������
	private Double assets;	//��ҵ���ʲ�
	private String machinery;	//��е�豸
	private Date creatDate;	//ע������
	private String checkforeign;	//�Ƿ�����Ͷ��	   0:�ǣ�1����"
	private String locknumber1_no;	//ukey��ǩ���
	private Date locknumber1_date;	//ukey��������
	private String economicPropertyName;//������������
	
	//������ر���
	private String certName;			//������𼰵ȼ�
	private Integer tradeboundnum; //רҵ���(�ֵ��tbtradetypebounddic����רҵ����д��)
	private Integer titlelevelnum; //�����ʸ�ȼ�(�ֵ��tbcerttitleleveldic)
	private String addtypenum; //�����ʸ�ȡ�÷�ʽ(�ֵ��tbaddtypedic)
	private String certtradestatusnum; //�����ʸ�״̬(�ֵ��tbcerttradestatusdic)
	private String tradetypeName;//��������
	private String tradetypeboundName;//רҵ���
	private String principalUnitName;//��������
	private String gradeName;//�������
	private String ultimateresults; //�������
	private Date ultimatedate; //����ʱ��
	private String ultimateopinion;//��������
	private String approvaldeptname; //������������
	private String approvaldept ; //��������id
	private String oneresults; //�����������
	private String oneultimateopinion; //�����������
	private Date oneappdate; //��������ʱ��
	private String twoapprovalstaff; //������������
	private String twoapprovalstaffid; //����������id
	private String twoapprovaldept;	//������������
	private String twoapprovaldeptname;	//����������������
	private String addtypeName;//���ʻ�ȡ��ʽ
	private String relationid;
	private String cretGrade;//���ʼ���
	private String certId;//֤����
	private String qualifType;//��������״̬ 
	
	private Date revocationDate;//���ʴ��ʱ��
	private String revocationReason;//���ԭ��
	private String revocationId; //���id
	
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
