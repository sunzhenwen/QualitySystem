package com.tj.jst.login.model;


/**
 * ��½
 * @author hhc
 *
 */
public class Login {

	//��½��uKey
	private String uKey;
	//�û�����
	private String userId;
	//�û�����
	private String userName;
	//��֯��������֤
	private String corpCode;
	//����Ӫҵִ�պ�
	private String licenseNum;
	//��ҵ���ڵ�ʡ����
	private String provincenum;
	//��ҵ���ڵ�ʡ����
	private String provinceName;
	//��ҵ�����б���
	private String citynum;
	//��ҵ����������
	private String cityName;
	//��ҵ����������
	private String countynum;
	//��ҵ����������
	private String countyName;
	//��ҵ�Ǽ�ע������
	private int economicNum;
	//ע���ʱ�
	private String regPrin;
	//��ҵ������
	private String spare1;
	//��ҵ����������
	private String spareName;
	private String legalMan;		//��������������
	private String idCardTypeNum;//����������֤������(�ֵ��TBIDCARDTYPEDIC)
	private String legalManIdCard;//����������֤������
	private String legaLManDuty;//����������ְ��
	private String legaManProtitle;//����������ְ��
	private String address;		//��ҵӪҵ��ַ
	private String assets;		//���ʲ�
	private String machinery;	//��е�豸

	//�������� 0�������ݣ�1��������
	private String oldOrNew;
//------------------------------------------------------���ŵ�½��Ϣ------------------------------------------------
	private String Loginuserid;		//�û�Id
	private String name;			//�û���
	private String roleID;			//��ɫID
	private String departmentID;	//����ID
	private String popedomid;		//Ȩ�޼���
	private String department;		//��������
	private String personalID;		//��Աid
	private String rolename;		//��ɫ����
	private String ROLESYSTMID;		//ϵͳID
	private String rolesystemname;	//ϵͳ����
	private String checkType;	//��������   0���� 1ʡ�� 2 ����
	private String lockNumber1 ; //����
	
	public String getuKey() {
		return uKey;
	}
	public void setuKey(String uKey) {
		this.uKey = uKey;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProvincenum() {
		return provincenum;
	}
	public void setProvincenum(String provincenum) {
		this.provincenum = provincenum;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCitynum() {
		return citynum;
	}
	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountynum() {
		return countynum;
	}
	public void setCountynum(String countynum) {
		this.countynum = countynum;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getLoginuserid() {
		return Loginuserid;
	}
	public void setLoginuserid(String loginuserid) {
		Loginuserid = loginuserid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getPopedomid() {
		return popedomid;
	}
	public void setPopedomid(String popedomid) {
		this.popedomid = popedomid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPersonalID() {
		return personalID;
	}
	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getROLESYSTMID() {
		return ROLESYSTMID;
	}
	public void setROLESYSTMID(String rOLESYSTMID) {
		ROLESYSTMID = rOLESYSTMID;
	}
	public String getRolesystemname() {
		return rolesystemname;
	}
	public void setRolesystemname(String rolesystemname) {
		this.rolesystemname = rolesystemname;
	}
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
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
	public String getRegPrin() {
		return regPrin;
	}
	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}
	public String getOldOrNew() {
		return oldOrNew;
	}
	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
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
	public String getSpareName() {
		return spareName;
	}
	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getLockNumber1() {
		return lockNumber1;
	}
	public void setLockNumber1(String lockNumber1) {
		this.lockNumber1 = lockNumber1;
	}
	
}
