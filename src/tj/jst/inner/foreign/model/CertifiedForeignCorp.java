package com.tj.jst.inner.foreign.model;

/**
 * 经过认证的外商企业
 * @author DarkFlameMaster
 *
 */
public class CertifiedForeignCorp {

	private String corpId; 			//主键
	private String corpName; 		//企业名称
	private String corpCode; 		//组织机构代码
	private String foreignCorpName; //外商投资者名称
	private String nationNum; 		//国籍或地区(字典表：TBNATIONALDIC)
	private String nationName;		//国籍或地区名称
	private String principalUnitNum; //注册资本币种(字典表：TBPRINCIPALUNITDIC)
	private String principalUnitName;//注册币种名称
	private String regPrin; 		//外商投入注册资金(万元)
	private String percentTage; 	//外商投资所占比例(%)
	private String foreignIvestor; 	//外商投资这类型         0:境外企业；1：境外自然人
	private String oldOrNew; 		//0：老数据 1：新数据
	private String modifyDate; 		//修改日期
	private String message;			//返回消息
	
	
	
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
