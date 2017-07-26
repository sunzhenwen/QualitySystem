package com.tj.jst.inner.qualificationProductivity.certificatePrint.model;

import java.sql.Date;
import java.util.List;

/**
 * ֤���ӡ
 * @author hhc
 *
 */
public class CertificatePrint {

	private String corpCertId; //����
	private String corpName; //��ҵ����
	private String corpCode; //��֯��������
	private int certTypeNum; //�����ʸ�����(�ֵ��TBAPTITUDEKINDDIC)
	private String certTypeName;//�����ʸ���������
	private String certId; //֤����
	private int titleLevelNum; //�����ʸ���ߵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private String titleLevelName;//�����ʸ���ߵȼ�
	private String techMan; //��������������
	private String techManDuty; //����������ְ��
	private String techManProTitle; //����������ְ�ƻ�ְҵ�ʸ�
	private String unitMan; //��ҵ����������
	private String unitManDuty; //��ҵ������ְ��
	private String untiManProTitle; //��ҵ������ְ��
	private String organName; //��֤����
	private Date organDate; //��֤����
	private Date endDate; //֤����Ч�ڽ�ֹ����
	private int isValid; //֤��״̬(�ֵ��TBCERTSTATEDIC)
	private String isValidName;//֤��״̬����
	private String descrpition; //��ע
	private String corpId; //��ҵID
	private Date upDateTime; //��������
	private String oldOrNew; //0�������� 1��������
	private String dataSource; //������Դϵͳ
	private String certName; //������𼰵ȼ�
	private String approvalDept; //��������
	private String approvalStaff; //������Ա����
	private String approvalStaffId; //������ԱId
	private Date ultimtDate; //����ʱ��
	private String cretGrade; //���ʼ���(�ֵ��TBCRETGRADEDIC)���ҡ�ʡ������
	private String cretGradeName;//���ʼ�������
	private String addTypeNum; //�����ʸ�ȡ�÷�ʽ(�ֵ��TBADDTYPEDIC)003����
	private String addTypeName;//�����ʸ�ȡ�÷�ʽ����
	private String licenseNum; //����Ӫҵִ��ע���
	private String approvalDeptName; //������������
	private String provinceNum; //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
	private String provinceName;//ʡ����
	private String cityNum; //ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
	private String cityName;//������
	private String countyNum; //ע��������(�����С���)(�ֵ��TBXZQDMDIC)
	private String countyName;//������
	private String address; //��ҵӪҵ��ַ
	private String legalMan; //��������������
	private String idCardTypeNum; //����������֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCardTypeName;//֤����������
	private String legalManIdCard; //����������֤������
	private String legalManDuty; //����������ְ��
	private String legaManProtitle; //����������ְ��
	private String econmicNum; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
	private String econmicName;//��ҵ�Ǽ�ע����������
	private String regPrin; //ע���ʱ�(��Ԫ)
	private String relationId;//����������Ϣ�������֤����Լ��������ݿ����
	private List<String> certNames;
	private Date printDate;
	private String year;//��ӡ��
	private String month;//��ӡ��
	private String day;//��ӡ��
	private String updateType;	
	private Date writeOffDate;//ע��ʱ��
	private String writeOffStaffName;//ע������
	private String writeOffStaffId;//ע����Id
	private Date recoverDate;//�ָ�ʱ��
	private String recoverStaffName;//�ָ�����
	private String recoverStaffId;//�ָ���Id
	private String writeOffType;//ע�����룺1��������;2������ͨ��
	private Date writeOffAppDate;//����ע��ʱ��
	private String writeAppOpinion;//ע���������
	private Date writeReturnDate;//�˻�ʱ��
	private String writeReturnStaffId;//�˻���Աid
	private String writeReturnStaffName;//�˻���Ա����
	private Date writeOffFloorDate;//��������ʱ��
	private String writeOffFloorOpinion;//�����������
	private String writeOffFloorStaffName;//����ע������
	private String writeOffFloorStaffId;//����ע����Id

	private String QRCODE;//������ά���ʶ
	private String FBQRCODE;//������ά���ʶ
	private String PRINTNUMBER;//������ˮ��
	private String FBPRINTNUMBER;//������ˮ��
	
	private String ISPRINT;//�Ƿ��ӡ
	private int PRINTCOUNT;//��ӡ����
	
	private String CREATEDATE;//�Ƿ��ӡ
	
	
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
