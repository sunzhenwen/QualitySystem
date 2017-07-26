package com.tj.jst.outside.corpinto.foreign.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;
import com.tj.jst.outside.corpinto.foreign.service.ForeignCorpServiceImpl;
import com.tj.jst.outside.corpinto.foreign.service.IForeignCorpService;
/**
 * 外商投资企业
 * @author Administrator
 *
 */
public class ForeignCorpAction extends BaseAction{
	
	//外商企业组织机构代码
	private String corpCode;
	//外商投资企业
	private ForeignCorp foreignCorp;
	//国籍或地区
	private List<DictionaryClass> nations;
	//注册资本币种
	private List<DictionaryClass> principalUnit;
	//国家ID
	private String nationId;
	//外商投资者类型
	private List<DictionaryClass> ivestors;
	//提示消息
	private String message;
	//返回结果
	private String result;
	
	
	/**
	 * 新外商企业添加
	 * @return
	 */
	public String addForeignCorp(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		message = foreignCorpService.addForeignCorp(foreignCorp);
		return "addForeignCorp";
	}
	
	/**
	 * 外商企业修改
	 * @return
	 */
	public String modifyforeginCorp()
	{
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		message = foreignCorpService.modifyForeignCorp(foreignCorp);
		return "modifyForeignCorp";
	}
	
	/**
	 * 跳转外商企业注册流程图页面
	 * @return
	 */
	public String foreignFlowChart()
	{
		return "foreignFlowChart";
	}
	
	/**
	 * 跳转组织机构名称证查询页面
	 * @return
	 */
	public String queryCorpNamePage()
	{
		return "queryCorpNamePage";
	}
	
	/**
	 * 跳转外网登陆页面
	 * @return
	 */
	public String queryOutLoginPage()
	{
		return "outLogin";
	}
	
	/**
	 * 组织机构代码查询
	 * @return
	 */
	public String queryForeignCorpName(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		foreignCorp = foreignCorpService.queryCorpName(corpCode);
		String returnPage = "";
		
		//返回登陆页面
		if(foreignCorp.getCheckType() == 0){
			returnPage = "outLogin";
		}
		//跳转修改页面
		if(foreignCorp.getCheckType() == 1){
			//查询国籍或地区
			nations = foreignCorpService.queryNation();
			this.queryDictionary();
			returnPage = "foreignCorpModify";
		}
		//跳转注册添加页面
		if(foreignCorp.getCheckType() == 2){
			//查询国籍或地区
			nations = foreignCorpService.queryNation();
			this.queryDictionary();
			returnPage = "foreignCorpAdd";
		}
		return returnPage;
	}
	
	/**
	 * 查询字典表
	 */
	public void queryDictionary(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		//注册资本币种
		principalUnit = foreignCorpService.queryPrincipalUnit();
		//外商投资类型
		ivestors = foreignCorpService.queryIvestor();
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public ForeignCorp getForeignCorp() {
		return foreignCorp;
	}

	public void setForeignCorp(ForeignCorp foreignCorp) {
		this.foreignCorp = foreignCorp;
	}

	public List<DictionaryClass> getNations() {
		return nations;
	}

	public void setNations(List<DictionaryClass> nations) {
		this.nations = nations;
	}

	public List<DictionaryClass> getPrincipalUnit() {
		return principalUnit;
	}

	public void setPrincipalUnit(List<DictionaryClass> principalUnit) {
		this.principalUnit = principalUnit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}
	public List<DictionaryClass> getIvestors() {
		return ivestors;
	}

	public void setIvestors(List<DictionaryClass> ivestors) {
		this.ivestors = ivestors;
	}

	

}
