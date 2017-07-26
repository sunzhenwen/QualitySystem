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
 * ��ҵ������Ϣ�޸�
 * @author Administrator
 *
 */
public class ModifyQualificationAction extends BaseAction {
	
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
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
	//������������
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
	 * ��ҵ������Ϣ�б�
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
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyApplication () {
		
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		newQualification = service.modifyApplication(newQualId);
		//��ѯʡ 
		provinces = service.queryProvince();
		citys = service.queryCity(newQualification.getProvinceNum());
		areas = service.queryArea(newQualification.getCityNum());
		this.queryDictionary();
		return "modifyPage";
	}
	
	/**
	 * ��ҵ����������Ϣ�޸Ĳ���
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
	
	//��ѯʡ provinces = service.queryProvince();
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		citys = service.queryCity(provinceId);
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
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionary()
	{
		IModifyQualificationService service = new ModifyQualificationServiceImpl();
		//֤������
		idCardType = service.queryIdCardType();
		//��ҵ�Ǽ�ע������
		economicNum = service.queryEconomicNum();
		//ע���ʱ�����
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
