package com.tj.jst.outside.corpinto.foreign.model;

import java.util.Date;

/**
 * 外资企业基本信息
 * @author hhc
 *
 */
public class ForeignCorp {

	private String corpId; 			//主键
	private String corpName; 		//企业名称
	private String corpCode; 		//组织机构代码
	private String foreignCorpName; //外商投资者名称
	private String nationNume; 		//国籍或地区(字典表：TBNATIONALDIC)
	private String principalUnitNum; //注册资本币种(字典表：TBPRINCIPALUNITDIC)
	private String regPrin; 		//外商投入注册资金(万元)
	private String percentTage; 	//外商投资所占比例(%)
	private String foreignIvestor; 	//外商投资这类型         0:境外企业；1：境外自然人
	private Date createDate; 		//创建时间
	private Date modifyDate; 		//修改时间
	private int checkType;			//0：基础数据库存在，不允许添加、修改;
									//1：基础数据库里不存在，资质系统库存在语序修改;
									//2：所有数据库中都不存在，允许添加
	private String message;			//返回消息
	
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
