package com.tj.jst.outside.staffmanage.skilledworker.model;

import java.sql.Date;

/**
 * ��������
 * @author DarkFlameMaster
 *
 */
public class Skilledworker {
	
	private String personId;			//����
	private String personName;		//������Ա����
	private	String sexNum;			//������Ա�Ա�(�ֵ��TBSEXDIC)
	private String sexName;			//�Ա�
	private String idCardTypeNum; 	//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCardTypeName;	//֤����������
	private Date   birthday; 		//����
	private String nationAlityNum; 	//����(�ֵ��TBNATIONDIC)
	private String nationAlityName; //��������(�ֵ��TBNATIONDIC)
	private String eduLevelNum; 	//ѧ��(�ֵ��TBEDULEVELDIC)
	private String eduLevelName; 	//ѧ������(�ֵ��TBEDULEVELDIC)
	private String degreeNum; 		//ѧλ(�ֵ��TBDEGREEDIC)
	private String degreeName; 		//ѧλ����(�ֵ��TBDEGREEDIC)
	private String identityCard;	//������Ա���֤������18λ��
	private String skilledType;		//������������ֵ��TBSKILLEDWORkERTYPE��
	private String skilledTypeNum;	//�����������code
	private String skilledLevel;	//�������ּ����ֵ��TBSKILLEDWORKERLEVEL��
	private String skilledLevelNum;
	private String mobile;			//�ֻ�����
	private String userId;			//��ҵ����ID
	private String corpCode;		//��ҵ����
	private String corpName;		//��ҵ����
	
	
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
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
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
	public String getNationAlityName() {
		return nationAlityName;
	}
	public void setNationAlityName(String nationAlityName) {
		this.nationAlityName = nationAlityName;
	}
	public String getEduLevelNum() {
		return eduLevelNum;
	}
	public void setEduLevelNum(String eduLevelNum) {
		this.eduLevelNum = eduLevelNum;
	}
	public String getEduLevelName() {
		return eduLevelName;
	}
	public void setEduLevelName(String eduLevelName) {
		this.eduLevelName = eduLevelName;
	}
	public String getDegreeNum() {
		return degreeNum;
	}
	public void setDegreeNum(String degreeNum) {
		this.degreeNum = degreeNum;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getSkilledType() {
		return skilledType;
	}
	public void setSkilledType(String skilledType) {
		this.skilledType = skilledType;
	}
	public String getSkilledLevel() {
		return skilledLevel;
	}
	public void setSkilledLevel(String skilledLevel) {
		this.skilledLevel = skilledLevel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getSkilledTypeNum() {
		return skilledTypeNum;
	}
	public void setSkilledTypeNum(String skilledTypeNum) {
		this.skilledTypeNum = skilledTypeNum;
	}
	public String getSkilledLevelNum() {
		return skilledLevelNum;
	}
	public void setSkilledLevelNum(String skilledLevelNum) {
		this.skilledLevelNum = skilledLevelNum;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
}
