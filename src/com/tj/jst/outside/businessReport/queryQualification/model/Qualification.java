package com.tj.jst.outside.businessReport.queryQualification.model;

import java.sql.Date;

/**
 * ��ѯ��ҵ��ӵ�е�������Ϣ
 * 
 * @author DarkFlameMaster
 *
 */
public class Qualification {

	// ���
	private String CorpId;
	// ��ҵ����
	private String CorpName;
	// ��֯��������
	private String CorpCode;
	// �����ʸ����ͣ��ֵ��TBAPTITUDEKINDDIC��
	private String CertTypeNum;
	// �����ʸ�����
	private String CertTypeName;
	// ֤����
	private String CertId;
	// �����ʸ����У��ֵ��TBTRADETYPEDIC��
	private String TradeTypeNum;
	// �����ʸ���������
	private String TradeTypeName;
	// רҵ����ֵ��TBTRADETYPEBOUNDDIC��
	private String TradeBoundNum;
	// רҵ�������
	private String TradeBoundName;
	// �����ʸ�ȼ����ֵ��TBCERTTITLELEVELDIC��
	private String TitleLevelNum;
	// �����ʸ�ȼ�����
	private String TitleLevelName;
	// �����ʸ�ȼ��ȼ�
	private String TitleLevelLevel;
	// �״���׼�����ʸ��ĺ�
	private String NoteNumber;
	// �Ƿ���������
	private String IsMaster;
	// ��׼�����ʸ�����
	private String Mark;
	// �״���׼�����ʸ�����
	private Date NoteDate;
	// �����ʸ�ȡ�÷�ʽ���ֵ��TBADDTYPEDIC��
	private String AddTypeNum;
	// �����ʸ�ȡ�÷�ʽ����
	private String AddTypeName;
	// �����ʸ�״̬���ֵ��TBCERTTRADESTATUSDIC��
	private String CertTradeStatusNum;
	// �����ʸ�״̬����
	private String CertTradeStatusName;
	// �����ʸ�״̬���ʱ��
	private Date CertTradeModifyDate;
	// �����ʸ�״̬���ԭ��
	private String CertTradeModifyMark;
	// ����
	private String CertDetailId;
	// ����ʱ��
	private Date UpdateTime;
	// ������������
	private String OldorNew;
	// ���ݿ�
	private String DateSource;
	// ��������ʱ��
	private Date floorDate;
	// �����������
	private String floorOp;

	public String getCorpId() {
		return CorpId;
	}

	public void setCorpId(String corpId) {
		CorpId = corpId;
	}

	public String getCorpName() {
		return CorpName;
	}

	public void setCorpName(String corpName) {
		CorpName = corpName;
	}

	public String getCorpCode() {
		return CorpCode;
	}

	public void setCorpCode(String corpCode) {
		CorpCode = corpCode;
	}

	public String getCertTypeNum() {
		return CertTypeNum;
	}

	public void setCertTypeNum(String certTypeNum) {
		CertTypeNum = certTypeNum;
	}

	public String getCertTypeName() {
		return CertTypeName;
	}

	public void setCertTypeName(String certTypeName) {
		CertTypeName = certTypeName;
	}

	public String getCertId() {
		return CertId;
	}

	public void setCertId(String certId) {
		CertId = certId;
	}

	public String getTradeTypeNum() {
		return TradeTypeNum;
	}

	public void setTradeTypeNum(String tradeTypeNum) {
		TradeTypeNum = tradeTypeNum;
	}

	public String getTradeTypeName() {
		return TradeTypeName;
	}

	public void setTradeTypeName(String tradeTypeName) {
		TradeTypeName = tradeTypeName;
	}

	public String getTradeBoundNum() {
		return TradeBoundNum;
	}

	public void setTradeBoundNum(String tradeBoundNum) {
		TradeBoundNum = tradeBoundNum;
	}

	public String getTradeBoundName() {
		return TradeBoundName;
	}

	public void setTradeBoundName(String tradeBoundName) {
		TradeBoundName = tradeBoundName;
	}

	public String getTitleLevelNum() {
		return TitleLevelNum;
	}

	public void setTitleLevelNum(String titleLevelNum) {
		TitleLevelNum = titleLevelNum;
	}

	public String getTitleLevelName() {
		return TitleLevelName;
	}

	public void setTitleLevelName(String titleLevelName) {
		TitleLevelName = titleLevelName;
	}

	public String getNoteNumber() {
		return NoteNumber;
	}

	public void setNoteNumber(String noteNumber) {
		NoteNumber = noteNumber;
	}

	public String getIsMaster() {
		return IsMaster;
	}

	public void setIsMaster(String isMaster) {
		IsMaster = isMaster;
	}

	public String getMark() {
		return Mark;
	}

	public void setMark(String mark) {
		Mark = mark;
	}

	public Date getNoteDate() {
		return NoteDate;
	}

	public void setNoteDate(Date noteDate) {
		NoteDate = noteDate;
	}

	public String getAddTypeNum() {
		return AddTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		AddTypeNum = addTypeNum;
	}

	public String getAddTypeName() {
		return AddTypeName;
	}

	public void setAddTypeName(String addTypeName) {
		AddTypeName = addTypeName;
	}

	public String getCertTradeStatusNum() {
		return CertTradeStatusNum;
	}

	public void setCertTradeStatusNum(String certTradeStatusNum) {
		CertTradeStatusNum = certTradeStatusNum;
	}

	public String getCertTradeStatusName() {
		return CertTradeStatusName;
	}

	public void setCertTradeStatusName(String certTradeStatusName) {
		CertTradeStatusName = certTradeStatusName;
	}

	public Date getCertTradeModifyDate() {
		return CertTradeModifyDate;
	}

	public void setCertTradeModifyDate(Date certTradeModifyDate) {
		CertTradeModifyDate = certTradeModifyDate;
	}

	public String getCertTradeModifyMark() {
		return CertTradeModifyMark;
	}

	public void setCertTradeModifyMark(String certTradeModifyMark) {
		CertTradeModifyMark = certTradeModifyMark;
	}

	public String getCertDetailId() {
		return CertDetailId;
	}

	public void setCertDetailId(String certDetailId) {
		CertDetailId = certDetailId;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public String getOldorNew() {
		return OldorNew;
	}

	public void setOldorNew(String oldorNew) {
		OldorNew = oldorNew;
	}

	public String getDateSource() {
		return DateSource;
	}

	public void setDateSource(String dateSource) {
		DateSource = dateSource;
	}

	public String getTitleLevelLevel() {
		return TitleLevelLevel;
	}

	public void setTitleLevelLevel(String titleLevelLevel) {
		TitleLevelLevel = titleLevelLevel;
	}

	public Date getFloorDate() {
		return floorDate;
	}

	public void setFloorDate(Date floorDate) {
		this.floorDate = floorDate;
	}

	public String getFloorOp() {
		return floorOp;
	}

	public void setFloorOp(String floorOp) {
		this.floorOp = floorOp;
	}

}
