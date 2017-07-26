package com.tj.jst.outside.corpinto.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;
import com.tj.jst.outside.corpinto.notforeign.service.CorpServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.service.ICorpService;

/**
 * 企业
 * @author Administrator
 *
 */
public class CorpAction extends BaseAction {
	
	//企业组织机构代码
	private String corpCode;
	//企业
	private Corp corp;
	//省code
	private String provinceId;
	//市code
	private String cityNum;
	//省
	private List<DictionaryClass> provinces;
	//市
	private List<DictionaryClass> citys;
	//区
	private List<DictionaryClass> areas;
	//法定代表人证件类型
	private List<DictionaryClass> idCardType;
	//企业登记注册类型
	private List<DictionaryClass> economicNum;
	//注册资本币种
	private List<DictionaryClass> principalUnit;
	//返回提示信息
	private String message;
	private String result;
	private int num;
	
	/**
	 * 新企业添加
	 * @return
	 */
	public String addCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.addCorp(corp);
		return "addCorp";
	}
	
	/**
	 * 企业修改
	 * @return
	 */
	public String modifyCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		return "modifyCorp";
	}
	
	/**
	 * 跳转企业注册流程图页面
	 * @return
	 */
	public String flowChart()
	{
		return "flowchart";
	}
	
	/**
	 * 跳转组织机构代码证查询页面
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
	public String queryCorpName()
	{
		corpCode = corpCode.trim().toUpperCase();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA----corpCode = " + corpCode);
		ICorpService corpService = new CorpServiceImpl();
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl();
		num = corpCode.length();
		if((num != 10) && (num != 18)){
			message = "请确认输入的组织机构代码证或统一社会信用代码！";
			return "queryCorpNamePage";
		}else{
			if(corpCode.substring(corpCode.length() - 1 ).equals("x")){
				corpCode = corpCode.substring(0,corpCode.length()-1) + "X";
			}
			corp = corpService.queryCorpName(corpCode);
			String returnPage = "";
			List<CertifiedService> certifieds=qualityChangeService.queryQualityList(corp.getCorpId());
			//返回登陆页面
			if(corp.getCheckType() == 0)
			{
				returnPage = "outLogin";
			}
			//跳转修改页面
			if(corp.getCheckType() == 1)
			{
				//查询省
				provinces = corpService.queryProvince();
				//查询黑龙江省所有市
				citys = corpService.queryHLJCitys();
				this.queryDictionary();
				
				if(certifieds.size()>0){
					return "corpModifyLimit";
				}else{
					returnPage = "corpModify";
				}

			}
			//跳转注册添加页面
			if(corp.getCheckType() == 2)
			{
				//查询省
				provinces = corpService.queryProvince();
				citys = corpService.queryHLJCitys();
				//查询黑龙江省所有市
				this.queryDictionary();
				returnPage = "corpAdd";
			}
			return returnPage;
		}
	}

	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		ICorpService corpService = new CorpServiceImpl();
		citys = corpService.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询区
	 * @return
	 */
	public String queryArea()
    {
		ICorpService corpService = new CorpServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询字典表
	 */
	public void queryDictionary()
	{
		ICorpService corpService = new CorpServiceImpl();
		//证件类型
		idCardType = corpService.queryIdCardType();
		//企业登记注册类型
		economicNum = corpService.queryEconomicNum();
		//注册资本币种
		principalUnit = corpService.queryPrincipalUnit();
	}
	
	
	
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public List<DictionaryClass> getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(List<DictionaryClass> idCardType) {
		this.idCardType = idCardType;
	}

	public List<DictionaryClass> getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(List<DictionaryClass> economicNum) {
		this.economicNum = economicNum;
	}

	public List<DictionaryClass> getPrincipalUnit() {
		return principalUnit;
	}

	public void setPrincipalUnit(List<DictionaryClass> principalUnit) {
		this.principalUnit = principalUnit;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
