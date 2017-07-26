package com.tj.jst.inner.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.notforeign.service.CertifiedCorpServiceImpl;
import com.tj.jst.inner.notforeign.service.ICertifiedCorpService;

/**
 * ������֤����ҵ
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CertifiedCorpAction extends BaseAction {
	
	//��ҵ����
	private String corpName;
	//��ҵ
	private CertifiedCorp corp;
	//����������֤������
	private List<DictionaryClass> idCardType;
	//������ʾ��Ϣ
	private String message;
	//��ҵ��λ��Ϣ
	private String mark;
	private String provinceId;									//ʡCode
	private String cityNum;										//��Code
	private String countyNum;									//��Code
	private List<DictionaryClass> provinces;					//�ֵ䣺ʡ
	private List<DictionaryClass> citys;						//�ֵ䣺��
	private List<DictionaryClass> areas;						//�ֵ䣺��
	private List<DictionaryClass> economicNum;					//�ֵ䣺��ҵ�Ǽ�ע������
	private List<DictionaryClass> principalUnit;				//�ֵ䣺��ҵ�ʱ�����
	private String result;

	/**
	 * ��ת��ҵ�޸�ҳ��
	 * @return
	 */
	public String modifyCorpPage()
	{
		
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//֤������
		idCardType = corpService.queryIdCardType();
		String corpId = (String)this.get("corpId");
		corp = corpService.queryCorp(corpId);
		mark = corpService.perchCheck(corp.getCorpCode());
		if(mark.equals("�Ѿ�λ")){
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
	 * �Ѿ�ҵ��ҵ�޸�
	 * @return
	 */
	public String modifyCorp()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		message = corpService.modifyCorp(corp);
		return "goBusiness";
	}
	
	/**
	 * δ��λ��ҵ�޸�
	 */
	public String modifyCorpTwo()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//message = corpService.queryCorpCode(corp);		//��ѯ��ҵ��֯��������֤�Ƿ��ظ�
		message = corpService.modifyCorpTwo(corp);
		return "goBusiness";
	}

	/**
	 * ����ҵ�����ҳ��
	 * @return
	 */
	public String goBusiness()
	{
		return "goBusiness";
	}
	
	/**
	 * ��ѯ��
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
	 * ��ѯ��
	 */
	public String queryArea()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionary()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		//֤������
		idCardType = corpService.queryIdCardType();
		//��ҵ�Ǽ�ע������
		economicNum = corpService.queryEconomicNum();
		//ע���ʱ�����
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
