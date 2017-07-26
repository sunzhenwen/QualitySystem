package com.tj.jst.inner.qualificationProductivity.certificatePrint.action;


import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.condition.CertificateHisPrintCondition;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.CertificateHisPrintDao;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.CertificateHisPrintDaoImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 证书打印
 * @author Bawson
 *
 */
public class CertificateHisPrintAction extends BaseAction {
	
	private String certId;
	private CertificatePrint certificatePrint;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	
	
	private CertificateHisPrintCondition condition = new CertificateHisPrintCondition();
	
	public void setCondition(CertificateHisPrintCondition condition) {
		this.condition = condition;
	}

	public CertificateHisPrintCondition getCondition() {
		CertificateHisPrintCondition sessionCondition = (CertificateHisPrintCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	public String queryPage()
	{
		CertificateHisPrintDao CertificateHisPrint = new CertificateHisPrintDaoImpl();
		//分页查询
		currentPage = CertificateHisPrint.pagedQuery(this.getCondition());
		System.out.println("-----开始时间："+this.getCondition().getStartTime());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}	
	
	public String queryPrint()
	{
		CertificateHisPrintDao CertificateHisPrint = new CertificateHisPrintDaoImpl();

		certificatePrint = CertificateHisPrint.queryPrint(certId);

		return "print";
	}
	
	
	
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		CertificateHisPrintDao CertificateHisPrint = new CertificateHisPrintDaoImpl();
		//企业登记注册类型(字典表：TBECONTYPEDIC)
		econmicNums = CertificateHisPrint.queryEconmicNums();
	}

	public List<DictionaryClass> getEconmicNums() {
		return econmicNums;
	}

	public void setEconmicNums(List<DictionaryClass> econmicNums) {
		this.econmicNums = econmicNums;
	}



	public CertificatePrint getCertificatePrint() {
		return certificatePrint;
	}

	public void setCertificatePrint(CertificatePrint certificatePrint) {
		this.certificatePrint = certificatePrint;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}


	
	
}
