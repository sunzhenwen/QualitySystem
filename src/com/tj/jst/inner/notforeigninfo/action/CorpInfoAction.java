package com.tj.jst.inner.notforeigninfo.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.condition.CorpCondition;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.inner.notforeigninfo.service.CorpInfoServiceImpl;
import com.tj.jst.inner.notforeigninfo.service.ICorpInfoService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;

/**
 * 内网企业信息操作
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpInfoAction extends BaseAction {

	private String corpName; // 企业名称
	private String corpCode;// 企业组织机构
	private CorpInfo corpInfo; // 企业
	private String provinceId; // 省Code
	private String cityNum; // 市Code
	private String countyNum; // 区Code
	private List<DictionaryClass> provinces; // 字典：省
	private List<DictionaryClass> citys; // 字典：市
	private List<DictionaryClass> areas; // 字典：区
	private List<DictionaryClass> idCardType; // 字典：证件类型
	private List<DictionaryClass> economicNum; // 字典：企业登记注册类型
	private List<DictionaryClass> principalUnit; // 字典：企业资本比重
	private String message; // 信息提示
	private String result;
	private String corpId; // 主键
	private String type;// 类型表示服

	private CorpCondition condition = new CorpCondition();

	public void setCondition(CorpCondition condition) {
		this.condition = condition;
	}

	public CorpCondition getCondition() {
		CorpCondition sessionCondition = (CorpCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 所有企业信息列表页面
	 */
	public String queryCorpInfo() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setCorpId(departmentID);
		currentPage = corpInfoService.pagedQuery(condition);
		this.set(getActionName(), condition);
		if (type.equals("1")) {
			return "queryCorpDetail";
		} else {
			return "queryCorpDetail";
		}

	}

	/**
	 * 新企业添加
	 * 
	 * @return
	 */
	public String addCorp() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		message = corpInfoService.queryCorpName(corpInfo);
		if (message.equals("您所添加的企业组织机构代码证已经被录入，请确认您填写的信息！")) {
			this.queryDictionary();
			provinces = corpInfoService.queryProvince();
			citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
			areas = corpInfoService.queryArea(corpInfo.getCityNum());
			return "corpAdd";
		} else {
			corpInfoService.addCorp(corpInfo);
			return "query";
		}
	}

	/**
	 * 跳转到企业添加页面
	 */
	public String addCorpPage() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		this.queryDictionary();
		provinces = corpInfoService.queryProvince();
		return "corpAdd";
	}

	/**
	 * 企业信息详细界面
	 * 
	 * @return
	 */
	public String detailCorpPage() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		CorpInfo corp = new CorpInfo();
		corp = corpInfoService.queryById(corpId);
		corpInfo = corp;
		provinces = corpInfoService.queryProvince();
		citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
		areas = corpInfoService.queryArea(corpInfo.getCityNum());
		this.queryDictionary();
		corpInfo = corp;
		return "corpDetail";
	}
	
	/**
	 * 企业信息详细界面
	 * 
	 * @return
	 */
	public String detailCorpPage2() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		CorpInfo corp = new CorpInfo();
		corp = corpInfoService.queryById(corpId);
		corpInfo = corp;
		provinces = corpInfoService.queryProvince();
		citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
		areas = corpInfoService.queryArea(corpInfo.getCityNum());
		this.queryDictionary();
		corpInfo = corp;
		return "corpDetail";
	}

	/**
	 * 跳转到企业修改页面
	 */
	public String modifyCorpPage() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		QualityChangeService qualityChangeService = new QualityChangeServiceImpl();
		CorpInfo corp = new CorpInfo();
		corp = corpInfoService.queryById(corpId);
		List<CertifiedService> certifieds = qualityChangeService
				.queryQualityList(corpId);
		corpInfo = corp;
		this.queryDictionary();
		provinces = corpInfoService.queryProvince();
		citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
		areas = corpInfoService.queryArea(corpInfo.getCityNum());
		if (certifieds.size() > 0) {
			return "corpModifyLimit";
		}
		return "corpModify";
	}

	/**
	 * 企业信息修改方法
	 */
	public String modifyCorp() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		message = corpInfoService.queryCorpInfoUsed(corpInfo.getCorpId(),
				corpInfo.getCorpName());
		provinces = corpInfoService.queryProvince();
		citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
		areas = corpInfoService.queryArea(corpInfo.getCityNum());
		this.queryDictionary();
		if (message.equals("对不起，您修改的证件信息：企业名称， 已经被使用，请核对您想要修改的信息！")) {
			return "corpModify";
		} else if (message.equals("修改失败，请确认您填写的信息是否符合要求！")) {
			return "corpModify";
		} else {
			corpInfoService.modify(corpInfo);
			return "query";
		}
	}

	/**
	 * 返回页面
	 */
	public String goList() {
		return "queryCorpInfo";
	}

	/**
	 * 查询市
	 * 
	 * @return
	 */
	public String queryCity() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		citys = corpInfoService.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);
		result = json.toString();
		return "success";
	}

	/**
	 * 查询区
	 */
	public String queryArea() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		areas = corpInfoService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);// 给result赋值，传递给页面
		result = json.toString();
		return "success";
	}

	/**
	 * 查询字典表
	 */
	public void queryDictionary() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		// 证件类型
		idCardType = corpInfoService.queryIdCardType();
		// 企业登记注册类型
		economicNum = corpInfoService.queryEconomicNum();
		// 注册资本币种
		principalUnit = corpInfoService.queryPrincipalUnit();
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public CorpInfo getCorpInfo() {
		return corpInfo;
	}

	public void setCorpInfo(CorpInfo corpInfo) {
		this.corpInfo = corpInfo;
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
