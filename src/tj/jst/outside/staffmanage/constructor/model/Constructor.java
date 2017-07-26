package com.tj.jst.outside.staffmanage.constructor.model;

import java.sql.Date;

/**
 * ע�Ὠ��ʦ
 * @author hhc
 *
 */
public class Constructor {

	private String personId; 			//����
	private String personName; 		//����
	private String sexNum; 			//�Ա�(�ֵ��TBSEXDIC)
	private String sexName;			//�Ա�����
	private String idCardTypeNum; 	//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCardTypeName;	//֤����������
	private String idCard; 			//���֤��(����Ϊ18λ)
	private Date birthday; 		//����
	private String nationAlityNum; 	//����(�ֵ��TBNATIONDIC)
	private String nationAlityName; //��������(�ֵ��TBNATIONDIC)
	private String eduLevelNum; 	//ѧ��(�ֵ��TBEDULEVELDIC)
	private String eduLevelName; 	//ѧ������(�ֵ��TBEDULEVELDIC)
	private String degreeNum; 		//ѧλ(�ֵ��TBDEGREEDIC)
	private String degreeName; 		//ѧλ����(�ֵ��TBDEGREEDIC)
	private String mobile; 			//�ֻ�����
	
	
	private String sepecialtyTypNum;//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	private String sepecialtyTypName;//ע�����ͼ��ȼ�����
	private String certNum; 		//ע��֤����
	private Date awardDate; 		//��֤����
	private String awardDepart; 	//��֤��λ
	private String stampNum; 		//ִҵӡ�º�
	private Date effectDate; 		//ע����Ч��
	private String callingTypeNum;  //������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
	private String callingTypeName;	//������ҵ��ҵ��������
	private String corpName; 		//������ҵ����
	private String corpCode; 		//������ҵ��֯��������
	private String certId; 			//������ҵ֤����
	private String regTradeTypeNum; //ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
	private String regTradeTypeName;//ע��רҵ�������
	private Date tradeTypeAwardDate; //ע�Ὺʼ����(1-8)
	private Date tradeTypeEffectDate; //ע���ֹ����(1-8)
	private String qState; 			//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
	private String stateName;		//ְҵ�ʸ�״̬����

	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getSexNum() {
		return sexNum;
	}
	public void setSexNum(String sexNum) {
		this.sexNum = sexNum;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNationAlityNum() {
		return nationAlityNum;
	}
	public void setNationAlityNum(String nationAlityNum) {
		this.nationAlityNum = nationAlityNum;
	}
	public String getEduLevelNum() {
		return eduLevelNum;
	}
	public void setEduLevelNum(String eduLevelNum) {
		this.eduLevelNum = eduLevelNum;
	}
	public String getDegreeNum() {
		return degreeNum;
	}
	public void setDegreeNum(String degreeNum) {
		this.degreeNum = degreeNum;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSepecialtyTypNum() {
		return sepecialtyTypNum;
	}
	public void setSepecialtyTypNum(String sepecialtyTypNum) {
		this.sepecialtyTypNum = sepecialtyTypNum;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	
	public Date getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}
	public String getAwardDepart() {
		return awardDepart;
	}
	public void setAwardDepart(String awardDepart) {
		this.awardDepart = awardDepart;
	}
	public String getStampNum() {
		return stampNum;
	}
	public void setStampNum(String stampNum) {
		this.stampNum = stampNum;
	}
	public String getCallingTypeNum() {
		return callingTypeNum;
	}
	public void setCallingTypeNum(String callingTypeNum) {
		this.callingTypeNum = callingTypeNum;
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
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getRegTradeTypeNum() {
		return regTradeTypeNum;
	}
	public void setRegTradeTypeNum(String regTradeTypeNum) {
		this.regTradeTypeNum = regTradeTypeNum;
	}
	public String getqState() {
		return qState;
	}
	public void setqState(String qState) {
		this.qState = qState;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	public String getIdCardTypeName() {
		return idCardTypeName;
	}
	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}
	public String getNationAlityName() {
		return nationAlityName;
	}
	public void setNationAlityName(String nationAlityName) {
		this.nationAlityName = nationAlityName;
	}
	public String getEduLevelName() {
		return eduLevelName;
	}
	public void setEduLevelName(String eduLevelName) {
		this.eduLevelName = eduLevelName;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getSepecialtyTypName() {
		return sepecialtyTypName;
	}
	public void setSepecialtyTypName(String sepecialtyTypName) {
		this.sepecialtyTypName = sepecialtyTypName;
	}
	public String getCallingTypeName() {
		return callingTypeName;
	}
	public void setCallingTypeName(String callingTypeName) {
		this.callingTypeName = callingTypeName;
	}
	public String getRegTradeTypeName() {
		return regTradeTypeName;
	}
	public void setRegTradeTypeName(String regTradeTypeName) {
		this.regTradeTypeName = regTradeTypeName;
	}

	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Date getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
	public Date getTradeTypeAwardDate() {
		return tradeTypeAwardDate;
	}
	public void setTradeTypeAwardDate(Date tradeTypeAwardDate) {
		this.tradeTypeAwardDate = tradeTypeAwardDate;
	}
	public Date getTradeTypeEffectDate() {
		return tradeTypeEffectDate;
	}
	public void setTradeTypeEffectDate(Date tradeTypeEffectDate) {
		this.tradeTypeEffectDate = tradeTypeEffectDate;
	}

}
