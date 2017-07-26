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
 * ��ҵ
 * @author Administrator
 *
 */
public class CorpAction extends BaseAction {
	
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ
	private Corp corp;
	//ʡcode
	private String provinceId;
	//��code
	private String cityNum;
	//ʡ
	private List<DictionaryClass> provinces;
	//��
	private List<DictionaryClass> citys;
	//��
	private List<DictionaryClass> areas;
	//����������֤������
	private List<DictionaryClass> idCardType;
	//��ҵ�Ǽ�ע������
	private List<DictionaryClass> economicNum;
	//ע���ʱ�����
	private List<DictionaryClass> principalUnit;
	//������ʾ��Ϣ
	private String message;
	private String result;
	private int num;
	
	/**
	 * ����ҵ���
	 * @return
	 */
	public String addCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.addCorp(corp);
		return "addCorp";
	}
	
	/**
	 * ��ҵ�޸�
	 * @return
	 */
	public String modifyCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		return "modifyCorp";
	}
	
	/**
	 * ��ת��ҵע������ͼҳ��
	 * @return
	 */
	public String flowChart()
	{
		return "flowchart";
	}
	
	/**
	 * ��ת��֯��������֤��ѯҳ��
	 * @return
	 */
	public String queryCorpNamePage()
	{
		return "queryCorpNamePage";
	}
	
	/**
	 * ��ת������½ҳ��
	 * @return
	 */
	public String queryOutLoginPage()
	{
		return "outLogin";
	}
	
	/**
	 * ��֯���������ѯ
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
			message = "��ȷ���������֯��������֤��ͳһ������ô��룡";
			return "queryCorpNamePage";
		}else{
			if(corpCode.substring(corpCode.length() - 1 ).equals("x")){
				corpCode = corpCode.substring(0,corpCode.length()-1) + "X";
			}
			corp = corpService.queryCorpName(corpCode);
			String returnPage = "";
			List<CertifiedService> certifieds=qualityChangeService.queryQualityList(corp.getCorpId());
			//���ص�½ҳ��
			if(corp.getCheckType() == 0)
			{
				returnPage = "outLogin";
			}
			//��ת�޸�ҳ��
			if(corp.getCheckType() == 1)
			{
				//��ѯʡ
				provinces = corpService.queryProvince();
				//��ѯ������ʡ������
				citys = corpService.queryHLJCitys();
				this.queryDictionary();
				
				if(certifieds.size()>0){
					return "corpModifyLimit";
				}else{
					returnPage = "corpModify";
				}

			}
			//��תע�����ҳ��
			if(corp.getCheckType() == 2)
			{
				//��ѯʡ
				provinces = corpService.queryProvince();
				citys = corpService.queryHLJCitys();
				//��ѯ������ʡ������
				this.queryDictionary();
				returnPage = "corpAdd";
			}
			return returnPage;
		}
	}

	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		ICorpService corpService = new CorpServiceImpl();
		citys = corpService.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryArea()
    {
		ICorpService corpService = new CorpServiceImpl();
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
		ICorpService corpService = new CorpServiceImpl();
		//֤������
		idCardType = corpService.queryIdCardType();
		//��ҵ�Ǽ�ע������
		economicNum = corpService.queryEconomicNum();
		//ע���ʱ�����
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
