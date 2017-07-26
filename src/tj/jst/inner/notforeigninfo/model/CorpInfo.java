package com.tj.jst.inner.notforeigninfo.model;

import java.sql.Date;

/**
 * ��ҵ������Ϣ
 * @author DarkFlameMaster
 *
 */
public class CorpInfo {

	private String corpId; 			//����
	private String corpName; 		//��ҵ����
	private String corpCode; 		//��֯��������
	private String licenseNum; 		//����Ӫҵִ��ע���
	private String licenseName;
	private String provinceNum; 	//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
	private String provinceName;
	private String cityNum; 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
	private String cityName;
	private String countyNum; 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
	private String countyName;
	private String address; 		//��ҵӪҵ��ַ
	private String postalCode; 		//��ҵӪҵ��ַ��������
	private String legalMan; 		//��������������
	private String idCardTypeNum; 	//����������֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCardTypeName;
	private String legalManIdCard; 	//����������֤������
	private String legalManDuty; 	//����������ְ��
	private String legaManProtitle; //����������ְ��
	private String economicNum; 	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
	private String economicName;
	private String regPrin; 		//ע���ʱ�(��Ԫ)
	private String factRegPrin; 	//ʵ���ʱ�(��Ԫ)
	private String principalUnitNum; //ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
	private String principalUnitName;
	private Date corpBirthDate; 	//��������
	private String officePhone; 	//�칫�绰
	private String fax; 			//�������
	private String linkMan; 		//��ϵ������
	private String linkTel; 		//��ϵ�˰칫�绰
	private String linkPhone; 		//��ϵ���ֻ�����
	private String email; 			//��ϵ����
	private String url; 			//��ҵ��ַ
	private String description; 	//��ע
	private String oldOrNew; 		//0�������� 1��������
	private String createDate; 		//�������
	private String modifyDate; 		//�޸�����
	private int checkType;			//0���������ݿ���ڣ���������ӡ��޸�;
									//1���������ݿ��ﲻ���ڣ�����ϵͳ����������޸�;
									//2���������ݿ��ж������ڣ��������
	private String message;			//������Ϣ
	private String assets;			//���ʲ�
	private String machinery;		//��е�豸
	
	
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	public String getEconomicNum() {
		return economicNum;
	}
	public void setEconomicNum(String economicNum) {
		this.economicNum = economicNum;
	}
	public String getRegPrin() {
		return regPrin;
	}
	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}
	public String getFactRegPrin() {
		return factRegPrin;
	}
	public void setFactRegPrin(String factRegPrin) {
		this.factRegPrin = factRegPrin;
	}
	public String getPrincipalUnitNum() {
		return principalUnitNum;
	}
	public void setPrincipalUnitNum(String principalUnitNum) {
		this.principalUnitNum = principalUnitNum;
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
	public String getOldOrNew() {
		return oldOrNew;
	}
	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getCheckType() {
		return checkType;
	}
	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCorpBirthDate() {
		return corpBirthDate;
	}
	public void setCorpBirthDate(Date corpBirthDate) {
		this.corpBirthDate = corpBirthDate;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
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
	public String getIdCardTypeName() {
		return idCardTypeName;
	}
	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}
	public String getEconomicName() {
		return economicName;
	}
	public void setEconomicName(String economicName) {
		this.economicName = economicName;
	}
	public String getPrincipalUnitName() {
		return principalUnitName;
	}
	public void setPrincipalUnitName(String principalUnitName) {
		this.principalUnitName = principalUnitName;
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
