package com.tj.jst.inner.foreign.model;

/**
 * ������֤��������ҵ
 * @author DarkFlameMaster
 *
 */
public class CertifiedForeignCorp {

	private String corpId; 			//����
	private String corpName; 		//��ҵ����
	private String corpCode; 		//��֯��������
	private String foreignCorpName; //����Ͷ��������
	private String nationNum; 		//���������(�ֵ��TBNATIONALDIC)
	private String nationName;		//�������������
	private String principalUnitNum; //ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
	private String principalUnitName;//ע���������
	private String regPrin; 		//����Ͷ��ע���ʽ�(��Ԫ)
	private String percentTage; 	//����Ͷ����ռ����(%)
	private String foreignIvestor; 	//����Ͷ��������         0:������ҵ��1��������Ȼ��
	private String oldOrNew; 		//0�������� 1��������
	private String modifyDate; 		//�޸�����
	private String message;			//������Ϣ
	
	
	
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
	public String getForeignCorpName() {
		return foreignCorpName;
	}
	public void setForeignCorpName(String foreignCorpName) {
		this.foreignCorpName = foreignCorpName;
	}
	public String getNationNum() {
		return nationNum;
	}
	public void setNationNum(String nationNume) {
		this.nationNum = nationNume;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getPrincipalUnitNum() {
		return principalUnitNum;
	}
	public void setPrincipalUnitNum(String principalUnitNum) {
		this.principalUnitNum = principalUnitNum;
	}
	public String getPrincipalUnitName() {
		return principalUnitName;
	}
	public void setPrincipalUnitName(String principalUnitName) {
		this.principalUnitName = principalUnitName;
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
	public String getOldOrNew() {
		return oldOrNew;
	}
	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
