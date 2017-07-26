package com.tj.jst.inner.qualificationProductivity.certificatePrint.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.condition.CountryCertificatePrintCondition;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.CountryCertificatePrintServiceImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.ICountryCertificatePrintService;

/**
 * ���Ҽ���ȷ��
 * @author hhc
 *
 */
@SuppressWarnings("serial")
public class CountryCertificatePrintAction extends BaseAction {
	
	private String corpCertId;
	private CertificatePrint countryPrint;
	private List<DictionaryClass> econmicNums; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
	private String corpId;
	private String certName;
	
	private CountryCertificatePrintCondition condition = new CountryCertificatePrintCondition();
	
	public void setCondition(CountryCertificatePrintCondition condition) {
		this.condition = condition;
	}

	public CountryCertificatePrintCondition getCondition() {
		CountryCertificatePrintCondition sessionCondition = (CountryCertificatePrintCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ICountryCertificatePrintService service = new CountryCertificatePrintServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}	
	
	/**
	 * ��תȷ��ҳ��
	 * @return
	 */
	public String confirmPage()
	{
		ICountryCertificatePrintService service = new CountryCertificatePrintServiceImpl();
		try {
			certName = URLDecoder.decode(certName,"utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countryPrint = service.confirmPage(corpId,certName);
		return "confirmPage";
	}
	
	/**
	 * ����ͨ��
	 * @return
	 */
	public String confirm()
	{
		ICountryCertificatePrintService service = new CountryCertificatePrintServiceImpl();
		service.confirm(countryPrint);
		return "confirm";
	}
	
	/**
	 * �����˻�
	 * @return
	 */
	public String confirmBack()
	{
		ICountryCertificatePrintService service = new CountryCertificatePrintServiceImpl();
		service.confirmBack(countryPrint);
		return "confirm";
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		ICountryCertificatePrintService certifiedService = new CountryCertificatePrintServiceImpl();
		//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}

	public String goBack()
	{
		return "confirm";
	}
	
	public List<DictionaryClass> getEconmicNums() {
		return econmicNums;
	}

	public void setEconmicNums(List<DictionaryClass> econmicNums) {
		this.econmicNums = econmicNums;
	}

	public String getCorpCertId() {
		return corpCertId;
	}

	public void setCorpCertId(String corpCertId) {
		this.corpCertId = corpCertId;
	}

	public CertificatePrint getCountryPrint() {
		return countryPrint;
	}

	public void setCountryPrint(CertificatePrint countryPrint) {
		this.countryPrint = countryPrint;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}
}
