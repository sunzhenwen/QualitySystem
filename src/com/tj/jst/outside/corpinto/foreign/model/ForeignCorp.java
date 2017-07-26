package com.tj.jst.outside.corpinto.foreign.model;

import java.util.Date;

/**
 * ������ҵ������Ϣ
 * @author hhc
 *
 */
public class ForeignCorp {

	private String corpId; 			//����
	private String corpName; 		//��ҵ����
	private String corpCode; 		//��֯��������
	private String foreignCorpName; //����Ͷ��������
	private String nationNume; 		//���������(�ֵ��TBNATIONALDIC)
	private String principalUnitNum; //ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
	private String regPrin; 		//����Ͷ��ע���ʽ�(��Ԫ)
	private String percentTage; 	//����Ͷ����ռ����(%)
	private String foreignIvestor; 	//����Ͷ��������         0:������ҵ��1��������Ȼ��
	private Date createDate; 		//����ʱ��
	private Date modifyDate; 		//�޸�ʱ��
	private int checkType;			//0���������ݿ���ڣ���������ӡ��޸�;
									//1���������ݿ��ﲻ���ڣ�����ϵͳ����������޸�;
									//2���������ݿ��ж������ڣ��������
	private String message;			//������Ϣ
	
	public String getCorpId() {
		return corpId;
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
	public String getForeignCorpName() {
		return foreignCorpName;
	}
	public void setForeignCorpName(String foreignCorpName) {
		this.foreignCorpName = foreignCorpName;
	}
	public String getNationNume() {
		return nationNume;
	}
	public void setNationNume(String nationNume) {
		this.nationNume = nationNume;
	}
	public String getPrincipalUnitNum() {
		return principalUnitNum;
	}
	public void setPrincipalUnitNum(String principalUnitNum) {
		this.principalUnitNum = principalUnitNum;
	}
	
	public String getRegPrin() {
		return regPrin;
	}
	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}
	public String getPercentTage() {
		return percentTage;
	}
	public void setPercentTage(String percentTage) {
		this.percentTage = percentTage;
	}
	public String getForeignIvestor() {
		return foreignIvestor;
	}
	public void setForeignIvestor(String foreignIvestor) {
		this.foreignIvestor = foreignIvestor;
	}
	public Date getCreateDate() { 
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
