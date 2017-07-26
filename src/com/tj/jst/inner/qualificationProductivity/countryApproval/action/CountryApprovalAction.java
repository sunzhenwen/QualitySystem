package com.tj.jst.inner.qualificationProductivity.countryApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.countryApproval.condition.CountryApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.countryApproval.service.CountryApprovalServiceImpl;
import com.tj.jst.inner.qualificationProductivity.countryApproval.service.ICountryApprovalService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ������������
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CountryApprovalAction extends BaseAction {
	
	//����
	private String newQualId;
	private String[] ids;
	private NewQualification newQualification;
	//��������code
	private String cretSequenceId;
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
	//��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	//ְ����Ա����
	private int countTitle;
	//ע�Ὠ��ʦ����
	private int countConstructor;
	//ע�Ὠ��ʦlist
	private List<Constructor> constructors;
	//��λ��Ա
	private int countPositions;
	//������������
	private int countSkilledworker;
	//��ǰ������Ա
	private String approvalStaff;
	//������ԱId
	private String approvalStaffId;
	private String corpId;
		
	private CountryApprovalCondition condition = new CountryApprovalCondition();
	
	public void setCondition(CountryApprovalCondition condition) {
		this.condition = condition;
	}

	public CountryApprovalCondition getCondition() {
		CountryApprovalCondition sessionCondition = (CountryApprovalCondition) get(getActionName());
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
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		//��ҳ��ѯ
		currentPage = provinceApprovalService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public String approvalPage()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		String returnPage = "";
		newQualification = provinceApprovalService.queryApproval(newQualId);
		
		Login login = (Login)this.get("login");
		//��ǰ������Ա
		approvalStaff = login.getName();
		//������ԱId
		approvalStaffId = login.getPersonalID();
		//��ѯְ����Ա����
		countTitle = provinceApprovalService.queryCountTitle(newQualification.getCorpId());
		//ע�Ὠ��ʦ����
		countConstructor = provinceApprovalService.queryCountConstructor(newQualification.getCorpName());
		//��λ��Ա
		countPositions = provinceApprovalService.queryCountPositions(newQualification.getCorpName());
		//��ѯ������������
		countSkilledworker = provinceApprovalService.queryCountSkilledworker(newQualification.getCorpId());
		
		
		//����Ҫ��������
		if(newQualification.getTwoApprovalDept().equals("0"))
		{
			//����ύ��ʽΪ����
			if(newQualification.getAddTypeNum().equals("002"))
			{
				
				newQualification = provinceApprovalService.queryOldCretLevel(newQualification);
//				//���ʵȼ�
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getOldCretLevel()+" "+newQualification.getOldCretLevelName());
//				//�����ʸ񼶱�
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getOldCretGrade()+" "+newQualification.getOldCretGradeName());
//				//רҵ���
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getOldSpecialtyType()+" "+newQualification.getOldSpecialtyTypeName());
//				//��ҵ
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getCorpId()+" "+newQualification.getCorpName());
//				//����ʱ��
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getOldCreatDate());
//				//����ͨ��ʱ��
//				System.out.println("�����ʸ�ȼ�= "+newQualification.getOldUltimateDate());
				returnPage = "approvalLevelPage";
			}else
			{
				returnPage = "approvalPage";
			}
		}
		
		//��Ҫ��������
		if(!newQualification.getTwoApprovalDept().equals("0"))
		{
			//����ύ��ʽΪ����
			if(newQualification.getAddTypeNum().equals("002"))
			{
				
				newQualification = provinceApprovalService.queryOldCretLevel(newQualification);
				returnPage = "deliveryLevelPage";
			}else
			{
				returnPage = "deliveryPage";
			}
		}
		
		//��������
		if(newQualification.getQualifType().equals("3") || newQualification.getQualifType().equals("4"))
		{
			//����ύ��ʽΪ����
			if(newQualification.getAddTypeNum().equals("002"))
			{
				
				newQualification = provinceApprovalService.queryOldCretLevel(newQualification);
				returnPage = "ultimateApprovalLevelPage";
			}else
			{
				returnPage = "ultimateApproval";
			}
		}
		return returnPage;
	}
	
	/**
	 * ����ͨ��(�����������)
	 * @return
	 */
	public String applyThrough()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		provinceApprovalService.applyThrough(newQualification);
		return "query";
	}
	/**
	 * �����˻�(�����������)
	 * @return
	 */
	public String applyThroughBack()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		provinceApprovalService.applyThroughBack(newQualification);
		return "query";
	}
	/**
	 * ��������
	 * @return
	 */
	public String pushApply()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		provinceApprovalService.pushApply(newQualification);
		return "query";
	}
	/**
	 * ����ͨ��(��������������������)
	 * @return
	 */
	public String applyUltimateThrough()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		provinceApprovalService.applyUltimateThrough(newQualification);
		return "query";
	}
	/**
	 * �����˻�(�������������˻�)
	 * @return
	 */
	public String applyUltimateThroughBack()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		provinceApprovalService.applyUltimateThroughBack(newQualification);
		return "query";
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String batchApplythrough()
	{
		ICountryApprovalService provinceApprovalService = new CountryApprovalServiceImpl();
		Login login = (Login)this.get("login");
		//��ǰ������Ա
		approvalStaff = login.getName();
		//������ԱId
		approvalStaffId = login.getPersonalID();
		provinceApprovalService.batchApplythrough(ids,approvalStaff,approvalStaffId);
		return "query";
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		ICountryApprovalService certifiedService = new CountryApprovalServiceImpl();
		//��������(�ֵ��TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		//��������(�ֵ��TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		//���ʼ���(�ֵ��TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		//��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}

	public String getCretSequenceId() {
		return cretSequenceId;
	}

	public void setCretSequenceId(String cretSequenceId) {
		this.cretSequenceId = cretSequenceId;
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

	public String getNewQualId() {
		return newQualId;
	}

	public void setNewQualId(String newQualId) {
		this.newQualId = newQualId;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
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

	public List<DictionaryClass> getAddTypeNums() {
		return addTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		this.addTypeNums = addTypeNums;
	}

	public String getApprovalStaff() {
		return approvalStaff;
	}

	public void setApprovalStaff(String approvalStaff) {
		this.approvalStaff = approvalStaff;
	}

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public List<Constructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Constructor> constructors) {
		this.constructors = constructors;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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
}
