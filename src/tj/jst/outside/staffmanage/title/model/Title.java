package com.tj.jst.outside.staffmanage.title.model;

import java.sql.Date;

/**
 * ְ����Ա
 * @author hhc
 *
 */
public class Title {

	private String personId; 		//����
	private String personName; 		//����
	private String sexNum; 			//�Ա�(�ֵ��TBSEXDIC)
	private String sexName;			//�Ա�����
	private String idCardTypeNum; 	//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCardTypeName;	//֤����������
	private String idCard; 			//���֤��(����Ϊ18λ)
	private String mobile; 			//�ֻ�����
	private String corpName;		//��ҵ����
	
	//ְ��
	private String titleName;
	//ְ��רҵ
	private String titleMajor;
	//ְ�Ƽ���
	private String titleLevel;
	//��ҵѧУ
	private String graduatedSchool;
	//��ѧרҵ
	private String studyMajor;
	//��ҵʱ��
	private Date graduatedDate;
	//������ҵid
	private String corpId;
	//������ҵ��֯��������֤��
	private String corpCode;
	
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getTitleMajor() {
		return titleMajor;
	}
	public void setTitleMajor(String titleMajor) {
		this.titleMajor = titleMajor;
	}
	public String getTitleLevel() {
		return titleLevel;
	}
	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}
	public String getGraduatedSchool() {
		return graduatedSchool;
	}
	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}
	public String getStudyMajor() {
		return studyMajor;
	}
	public void setStudyMajor(String studyMajor) {
		this.studyMajor = studyMajor;
	}
	public Date getGraduatedDate() {
		return graduatedDate;
	}
	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
}
