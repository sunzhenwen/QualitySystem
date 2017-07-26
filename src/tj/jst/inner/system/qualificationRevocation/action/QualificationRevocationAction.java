package com.tj.jst.inner.system.qualificationRevocation.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.cityApproval.condition.CityApprovalCondition;
import com.tj.jst.inner.system.qualificationRevocation.condition.QualificationRevocationCondition;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.qualificationRevocation.service.IQualificationRevocationService;
import com.tj.jst.inner.system.qualificationRevocation.service.QualificationRevocationServiceImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class QualificationRevocationAction extends BaseAction {
	
	private String corpId ;
	private QualificationRevocation qualificationRevocation;
	private String relationId;
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
	
	private QualificationRevocationCondition condition = new QualificationRevocationCondition();
	
	public void setCondition(QualificationRevocationCondition condition) {
		this.condition = condition;
	}

	public QualificationRevocationCondition getCondition() {
		QualificationRevocationCondition sessionCondition = (QualificationRevocationCondition) get(getActionName());
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
		IQualificationRevocationService qualificationRevocationServiceImpl = new QualificationRevocationServiceImpl();
		//��ҳ��ѯ
		// ��ȡ��ԱId
		String personalID = (String)this.get("personalID");
		// ��ȡ����Id
		String dept = (String)this.get("departmentID");
		if (dept.equals("230100") || dept.equals("20")) {
			condition = new QualificationRevocationCondition(dept, personalID);
		} else {
			condition = new QualificationRevocationCondition(dept);
		}
		currentPage = qualificationRevocationServiceImpl.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * ��ת�˻�ҳ��
	 * @return
	 */
	public String revocationPage () {
		
		IQualificationRevocationService service = new QualificationRevocationServiceImpl();
		qualificationRevocation = service.revocationPage(relationId);
		return "revocationPage" ;
	}
	
	/**
	 * ���ʴ�ز���
	 * @return
	 */
	public String revocation () {
		IQualificationRevocationService qualificationRevocationServiceImpl = new QualificationRevocationServiceImpl();
		message = qualificationRevocationServiceImpl.revocation(qualificationRevocation);
		//��ҳ��ѯ
		currentPage = qualificationRevocationServiceImpl.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
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
		IQualificationRevocationService certifiedService = new QualificationRevocationServiceImpl();
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

}
