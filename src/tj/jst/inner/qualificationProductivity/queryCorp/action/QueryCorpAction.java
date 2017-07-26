package com.tj.jst.inner.qualificationProductivity.queryCorp.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.queryCorp.condition.QueryCorpCondition;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.IQueryCorpService;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.QueryCorpServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 查询所有企业信息
 * @author DarkFlameMaster
 *
 */
public class QueryCorpAction extends BaseAction {

	private String[] certIds;					//服务事项ids
	private String message;						//信息
	private List<Corp> list;					//企业信息
	private List<DictionaryClass> certName;
	
	private String provinceId;                 //省code
	private List<DictionaryClass> provinces;   //省
	private List<DictionaryClass> citys;       //市
	private String result;
	private String provinceNum ;
	private String cityNum ;
	

	

	private QueryCorpCondition condition = new QueryCorpCondition(list,certIds);
	
	public void setCondition(QueryCorpCondition condition){
		this.condition = condition;
	}
	
	public QueryCorpCondition getCondition(){
		QueryCorpCondition sessionCondition = (QueryCorpCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	

	/**
	 * 初始分页
	 * @return
	 */
	public String queryPage(){
		IQueryCorpService service = new QueryCorpServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "basicpage";
	}
	
	/**
	 * 确认所选择的资质提交,进行分页
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService()throws Exception{
		IQueryCorpService service = new QueryCorpServiceImpl();
		if(certIds != null)
		{
			list = service.submitCertifiedService(certIds);
			condition.setCertIds(certIds);
			certName = service.certName(certIds);
			if(list.size() != 0){
				condition.setList(list);
			}
		}
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		provinces = service.queryProvince();
		citys = service.queryCity("230000");
		certName = service.certName(condition.getCertIds());
		return "basicpage";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IQueryCorpService service = new QueryCorpServiceImpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }


	public String[] getCertIds() {
		return certIds;
	}


	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<Corp> getList() {
		return list;
	}


	public void setList(List<Corp> list) {
		this.list = list;
	}

	public List<DictionaryClass> getCertName() {
		return certName;
	}

	public void setCertName(List<DictionaryClass> certName) {
		this.certName = certName;
	}
	
	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
}
