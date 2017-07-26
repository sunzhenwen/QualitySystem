package com.tj.jst.outside.businessReport.corpchangearea.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.businessReport.corpchangearea.service.CorpChangeAreaServiceImpl;
import com.tj.jst.outside.businessReport.corpchangearea.service.ICorpChangeAreaService;

/**
 * ��ҵ�����ر��Action��
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpChangeAreaAction extends BaseAction {

	private String corpName;// ��ҵ����
	private ChangeArea change;// �����
	private CertifiedCorp corp;// ��˾��Ϣ��
	private String message;// ��Ϣ
	private List<DictionaryClass> provinces;// ʡ
	private List<DictionaryClass> citys; // ��
	private String provinceId;// ʡID
	private String cityNum;// ��Id
	private String result;// ���

	/**
	 * �������ҳ��
	 * 
	 * @return
	 */
	public String queryPage() {
		String userName = (String)this.get("userName");
		ICorpChangeAreaService service = new CorpChangeAreaServiceImpl();
		corp = service.queryPage(userName);
		provinces = service.queryProvince();
		return "queryPage";
	}

	/**
	 * �ύ������Ϣ
	 * 
	 * @return
	 */
	public String approvalSubmit() {
		ICorpChangeAreaService service = new CorpChangeAreaServiceImpl();
		String userName = (String)this.get("userName");
		message = service.queryMark(userName);
		if (message.equals("ʡ��")){
			message = service.approvalUpdate(change,1);
		}else if(message.equals("������")){
			message = "���޷����п���б��!";
		}else{
			message = service.approvalUpdate(change,0);
		}
		
		return "query";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * ��ѯ��
	 * 
	 * @return
	 */
	public String queryCity() {
		ICorpChangeAreaService service = new CorpChangeAreaServiceImpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);
		result = json.toString();
		return "success";
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public ChangeArea getChange() {
		return change;
	}

	public void setChange(ChangeArea change) {
		this.change = change;
	}

	public CertifiedCorp getCorp() {
		return corp;
	}

	public void setCorp(CertifiedCorp corp) {
		this.corp = corp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
