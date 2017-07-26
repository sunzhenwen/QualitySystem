package com.tj.jst.inner.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.notforeign.service.CertifiedCorpServiceImpl;
import com.tj.jst.inner.notforeign.service.ICertifiedCorpService;

/**
 * 经过认证的企业
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CertifiedCorpAction extends BaseAction {
	
	//企业名称
	private String corpName;
	//企业
	private CertifiedCorp corp;
	//法定代表人证件类型
	private List<DictionaryClass> idCardType;
	//返回提示信息
	private String message;
	//企业就位信息
	private String mark;
	private String provinceId;									//省Code
	private String cityNum;										//市Code
	private String countyNum;									//区Code
	private List<DictionaryClass> provinces;					//字典：省
	private List<DictionaryClass> citys;						//字典：市
	private List<DictionaryClass> areas;						//字典：区
	private List<DictionaryClass> economicNum;					//字典：企业登记注册类型
	private List<DictionaryClass> principalUnit;				//字典：企业资本比重
	private String result;

	/**
	 * 跳转企业修改页面
	 * @return
	 */
	public String modifyCorpPage()
	{
		
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//证件类型
		idCardType = corpService.queryIdCardType();
		String corpId = (String)this.get("corpId");
		corp = corpService.queryCorp(corpId);
		mark = corpService.perchCheck(corp.getCorpCode());
		if(mark.equals("已就位")){
			return "certifiedCorpModify";
		}else
		{
			this.queryDictionary();
			provinces = corpService.queryProvince();
			citys = corpService.queryCity(corp.getProvinceNum());
			areas = corpService.queryArea(corp.getCityNum());
			return "certifiedCorpModifyTwo";
		}
		
	}
	
	/**
	 * 已就业企业修改
	 * @return
	 */
	public String modifyCorp()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		message = corpService.modifyCorp(corp);
		return "goBusiness";
	}
	
	/**
	 * 未就位企业修改
	 */
	public String modifyCorpTwo()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//message = corpService.queryCorpCode(corp);		//查询企业组织机构代码证是否重复
		message = corpService.modifyCorpTwo(corp);
		return "goBusiness";
	}

	/**
	 * 返回业务办理页面
	 * @return
	 */
	public String goBusiness()
	{
		return "goBusiness";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		citys = corpService.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);
		result = json.toString();
		return "success";
    }
	
	/**
	 * 查询区
	 */
	public String queryArea()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
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
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//证件类型
		idCardType = corpService.queryIdCardType();
		//企业登记注册类型
		economicNum = corpService.queryEconomicNum();
		//注册资本币种
		principalUnit = corpService.queryPrincipalUnit();
	}
	
	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public CertifiedCorp getCorp() {
		return corp;
	}

	public void setCorp(CertifiedCorp corp) {
		this.corp = corp;
	}

	public List<DictionaryClass> getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(List<DictionaryClass> idCardType) {
		this.idCardType = idCardType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	
}
