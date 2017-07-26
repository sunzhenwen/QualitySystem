package com.tj.jst.inner.qualificationProductivity.changecertaction.action;

import java.util.Arrays;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.inner.qualificationProductivity.changecertaction.condition.ChangeCertCondition;
import com.tj.jst.inner.qualificationProductivity.changecertaction.service.ChangeCertServiceImpl;
import com.tj.jst.inner.qualificationProductivity.changecertaction.service.IChangeCertService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��������֤��Ϣ
 * 
 * @author Administrator
 *
 */
public class ChangeCertAction extends BaseAction {

	private String corpName;// ��ҵ����
	private String corpCode;// ��ҵ��֯��������֤
	private String id;// ��ѯ����
	private String op;// �������
	private String message;// ������Ϣ
	private NewQualification newQualification;// ��ĿModel��
	private CorpInfo corp;
	// ��������(�ֵ��TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// ��������(�ֵ��TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	// ��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// ְ����Ա����
	private int countTitle;
	// ע�Ὠ��ʦ����
	private int countConstructor;
	// ������������
	private int countSkilledworker;
	// ��λ��Ա
	private int countPositions;
	private String[] ids;

	private String acceptDate;

	private ChangeCertCondition condition = new ChangeCertCondition();

	public void setCondition(ChangeCertCondition condition) {
		this.condition = condition;
	}

	public ChangeCertCondition getCondition() {
		ChangeCertCondition sessionCondition = (ChangeCertCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IChangeCertService service = new ChangeCertServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		this.queryDictionaryClass();
		return "queryPage";
	}

	/**
	 * ������ϸ
	 * 
	 * @return
	 */
	public String queryInfo() {
		IChangeCertService service = new ChangeCertServiceImpl();
		newQualification = service.queryPerchInfo(id);
		corp = service.queryCorpInfo(newQualification.getCorpCode());
		// ��ѯְ����Ա����
		countTitle = service.queryCountTitle(newQualification.getCorpId());
		// ע�Ὠ��ʦ����
		countConstructor = service.queryCountConstructor(newQualification
				.getCorpName());
		// ��ѯ������������
		countSkilledworker = service.queryCountSkilledworker(newQualification
				.getCorpId());
		// ��λ��Ա
		countPositions = service.queryCountPositions(newQualification
				.getCorpName());
		condition.setCorpName(newQualification.getCountyName());
		return "queryInfo";
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IChangeCertService service = new ChangeCertServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalSuccess(id, op,login.getName());
		condition.setCorpName(corpName);
		return this.queryPage();
	}

	/**
	 * ������ͨ��
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IChangeCertService service = new ChangeCertServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalFailed(id, op,login.getName());
		condition.setCorpName(corpName);
		return this.queryPage();
	}

	/**
	 * ��������
	 */
	public String batchApplythrough() {
		IChangeCertService service = new ChangeCertServiceImpl();
		Login login = (Login) this.get("login");
		System.out.println("ids = " + Arrays.toString(ids));
		service.batchApplythrough(ids , login.getName());
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
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass() {
		IChangeCertService certifiedService = new ChangeCertServiceImpl();
		// ��������(�ֵ��TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		// ��������(�ֵ��TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		// ���ʼ���(�ֵ��TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		// ��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
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

	public List<DictionaryClass> getCretGrades() {
		return cretGrades;
	}

	public void setCretGrades(List<DictionaryClass> cretGrades) {
		this.cretGrades = cretGrades;
	}

	public List<DictionaryClass> getAddTypeNums() {
		return addTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		this.addTypeNums = addTypeNums;
	}

	public int getCountTitle() {
		return countTitle;
	}

	public void setCountTitle(int countTitle) {
		this.countTitle = countTitle;
	}

	public int getCountConstructor() {
		return countConstructor;
	}

	public void setCountConstructor(int countConstructor) {
		this.countConstructor = countConstructor;
	}

	public int getCountSkilledworker() {
		return countSkilledworker;
	}

	public void setCountSkilledworker(int countSkilledworker) {
		this.countSkilledworker = countSkilledworker;
	}

	public int getCountPositions() {
		return countPositions;
	}

	public void setCountPositions(int countPositions) {
		this.countPositions = countPositions;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}

	public CorpInfo getCorp() {
		return corp;
	}

	public void setCorp(CorpInfo corp) {
		this.corp = corp;
	}

}
