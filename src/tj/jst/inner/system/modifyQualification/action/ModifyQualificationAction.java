package com.tj.jst.inner.system.modifyQualification.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.inner.system.modifyQualification.service.IModifyQualificationService;
import com.tj.jst.inner.system.modifyQualification.service.ModifyQualificationServiceImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业申请信息修改
 * @author Administrator
 *
 */
public class ModifyQualificationAction extends BaseAction {
	
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
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
	//资质申请主键
	private String newQualId ;
	private NewQualification newQualification ;
	
	private ModifyQualificationCondition condition = new ModifyQualificationCondition();
	
	public void setCondition(ModifyQualificationCondition condition) {
		this.condition = condition;
	}

	public ModifyQualificationCondition getCondition() {
		ModifyQualificationCondition sessionCondition = (ModifyQualificationCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 企业申请信息列表
	 * @return
	 */
	public String queryPage() {
		
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		currentPage = service.queryPage(this.getCondition());
		this.queryDictionary();
		this.set(getActionName(), condition);
		
		return "queryPage" ;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String modifyApplication () {
		
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		newQualification = service.modifyApplication(newQualId);
		//查询省 
		provinces = service.queryProvince();
		citys = service.queryCity(newQualification.getProvinceNum());
		areas = service.queryArea(newQualification.getCityNum());
		this.queryDictionary();
		return "modifyPage";
	}
	
	/**
	 * 企业资质申请信息修改操作
	 * @return
	 */
	public String modify() {
		
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		message = service.modify(newQualification);
		currentPage = service.queryPage(this.getCondition());
		this.queryDictionary();
		this.set(getActionName(), condition);
		return "queryPage" ;
	}
	
	//查询省 provinces = service.queryProvince();
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		citys = service.queryCity(provinceId);
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
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询字典表
	 */
	public void queryDictionary()
	{
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		//证件类型
		idCardType = service.queryIdCardType();
		//企业登记注册类型
		economicNum = service.queryEconomicNum();
		//注册资本币种
		principalUnit = service.queryPrincipalUnit();
	}
	
	public String goBack() {
		return "query" ;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public String getNewQualId() {
		return newQualId;
	}

	public void setNewQualId(String newQualId) {
		this.newQualId = newQualId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		ModifyQualificationAction.serialVersionUID = serialVersionUID;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
	}
	
}
