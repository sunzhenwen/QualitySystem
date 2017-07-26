package com.tj.jst.inner.system.qualificationRevocation.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.qualificationRevocation.service.IRevocationHistoryService;
import com.tj.jst.inner.system.qualificationRevocation.service.RevocationHistoryServiceImpl;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RevocationHistoryAction extends BaseAction {
	
	private QualificationRevocation qualificationRevocation;
	private String revocationId ; //���ʴ����ʷ����
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//��������(�ֵ��TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	//��������list
	private List<DictionaryClass> depts = new ArrayList<DictionaryClass>();
	//������������list
	private List<DictionaryClass> twoDepts = new ArrayList<DictionaryClass>();
	private String result;
	private String message ;
	
	private RevocationHistoryCondition historyCondition = new RevocationHistoryCondition();
	
	public RevocationHistoryCondition getHistoryCondition() {
		RevocationHistoryCondition historySessionCondition = (RevocationHistoryCondition) get(getActionName());
		if (historySessionCondition != null)
		{
			historyCondition = historySessionCondition;
		}
		return historyCondition;
	}

	public void setHistoryCondition(RevocationHistoryCondition historyCondition) {
		this.historyCondition = historyCondition;
	}
	
	
	/**
	 * ���ʴ����ʷ��ѯ
	 * @return
	 */
	public String historyList(){
		
		IRevocationHistoryService service = new RevocationHistoryServiceImpl();
		String dept = (String)this.get("departmentID");
		historyCondition = new RevocationHistoryCondition(dept);
		//��ҳ��ѯ
		currentPage = service.pagedQueryHistory(this.getHistoryCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), historyCondition);
		
		return "historyList" ;
	}
	
	/**
	 * ���ʴ����ʷ��ϸ
	 * @return
	 */
	public String revocationHistoryPage () {
		
		IRevocationHistoryService service = new RevocationHistoryServiceImpl();
		qualificationRevocation = service.revocationHistoryPage(revocationId);
		
		return "revocationHistoryPage" ;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack() {
		return "query";
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IRevocationHistoryService certifiedService = new RevocationHistoryServiceImpl();
		//��������(�ֵ��TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		//��������(�ֵ��TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		//���ʼ���(�ֵ��TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
	}
	
	public List<DictionaryClass> getCretTypes() {
		return cretTypes;
	}

	public void setCretTypes(List<DictionaryClass> cretTypes) {
		this.cretTypes = cretTypes;
	}

	public List<DictionaryClass> getCretLevels() {
		return cretLevels;
	}

	public void setCretLevels(List<DictionaryClass> cretLevels) {
		this.cretLevels = cretLevels;
	}

	public List<DictionaryClass> getCretSequences() {
		return cretSequences;
	}

	public void setCretSequences(List<DictionaryClass> cretSequences) {
		this.cretSequences = cretSequences;
	}

	public List<DictionaryClass> getSpecialtyTypes() {
		return specialtyTypes;
	}

	public void setSpecialtyTypes(List<DictionaryClass> specialtyTypes) {
		this.specialtyTypes = specialtyTypes;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<DictionaryClass> getCretGrades() {
		return cretGrades;
	}

	public void setCretGrades(List<DictionaryClass> cretGrades) {
		this.cretGrades = cretGrades;
	}

	public List<DictionaryClass> getDepts() {
		return depts;
	}

	public void setDepts(List<DictionaryClass> depts) {
		this.depts = depts;
	}

	public List<DictionaryClass> getTwoDepts() {
		return twoDepts;
	}

	public void setTwoDepts(List<DictionaryClass> twoDepts) {
		this.twoDepts = twoDepts;
	}

	public QualificationRevocation getQualificationRevocation() {
		return qualificationRevocation;
	}

	public void setQualificationRevocation(
			QualificationRevocation qualificationRevocation) {
		this.qualificationRevocation = qualificationRevocation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRevocationId() {
		return revocationId;
	}

	public void setRevocationId(String revocationId) {
		this.revocationId = revocationId;
	}

}
