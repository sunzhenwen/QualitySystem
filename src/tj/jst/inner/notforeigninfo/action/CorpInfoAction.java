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
 * ������ҵ��Ϣ����
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpInfoAction extends BaseAction {

	private String corpName; // ��ҵ����
	private String corpCode;// ��ҵ��֯����
	private CorpInfo corpInfo; // ��ҵ
	private String provinceId; // ʡCode
	private String cityNum; // ��Code
	private String countyNum; // ��Code
	private List<DictionaryClass> provinces; // �ֵ䣺ʡ
	private List<DictionaryClass> citys; // �ֵ䣺��
	private List<DictionaryClass> areas; // �ֵ䣺��
	private List<DictionaryClass> idCardType; // �ֵ䣺֤������
	private List<DictionaryClass> economicNum; // �ֵ䣺��ҵ�Ǽ�ע������
	private List<DictionaryClass> principalUnit; // �ֵ䣺��ҵ�ʱ�����
	private String message; // ��Ϣ��ʾ
	private String result;
	private String corpId; // ����
	private String type;// ���ͱ�ʾ��

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
	 * ������ҵ��Ϣ�б�ҳ��
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
	 * ����ҵ���
	 * 
	 * @return
	 */
	public String addCorp() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		message = corpInfoService.queryCorpName(corpInfo);
		if (message.equals("������ӵ���ҵ��֯��������֤�Ѿ���¼�룬��ȷ������д����Ϣ��")) {
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
	 * ��ת����ҵ���ҳ��
	 */
	public String addCorpPage() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		this.queryDictionary();
		provinces = corpInfoService.queryProvince();
		return "corpAdd";
	}

	/**
	 * ��ҵ��Ϣ��ϸ����
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
	 * ��ҵ��Ϣ��ϸ����
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
	 * ��ת����ҵ�޸�ҳ��
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
	 * ��ҵ��Ϣ�޸ķ���
	 */
	public String modifyCorp() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		message = corpInfoService.queryCorpInfoUsed(corpInfo.getCorpId(),
				corpInfo.getCorpName());
		provinces = corpInfoService.queryProvince();
		citys = corpInfoService.queryCity(corpInfo.getProvinceNum());
		areas = corpInfoService.queryArea(corpInfo.getCityNum());
		this.queryDictionary();
		if (message.equals("�Բ������޸ĵ�֤����Ϣ����ҵ���ƣ� �Ѿ���ʹ�ã���˶�����Ҫ�޸ĵ���Ϣ��")) {
			return "corpModify";
		} else if (message.equals("�޸�ʧ�ܣ���ȷ������д����Ϣ�Ƿ����Ҫ��")) {
			return "corpModify";
		} else {
			corpInfoService.modify(corpInfo);
			return "query";
		}
	}

	/**
	 * ����ҳ��
	 */
	public String goList() {
		return "queryCorpInfo";
	}

	/**
	 * ��ѯ��
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
	 * ��ѯ��
	 */
	public String queryArea() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		areas = corpInfoService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);// ��result��ֵ�����ݸ�ҳ��
		result = json.toString();
		return "success";
	}

	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionary() {
		ICorpInfoService corpInfoService = new CorpInfoServiceImpl();
		// ֤������
		idCardType = corpInfoService.queryIdCardType();
		// ��ҵ�Ǽ�ע������
		economicNum = corpInfoService.queryEconomicNum();
		// ע���ʱ�����
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
