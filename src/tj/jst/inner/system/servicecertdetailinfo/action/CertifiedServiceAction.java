package com.tj.jst.inner.system.servicecertdetailinfo.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.condition.CertifiedServiceCondition;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;
import com.tj.jst.inner.system.servicecertdetailinfo.service.CertifiedServiceImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.service.ICertifiedService;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CertifiedServiceAction extends BaseAction {
	
	//���ʷ�����������
	private String certId;
	private String[] certIds;
	//���ʷ�������
	private CertifiedService certifiedService;
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
	//��������list
	private List<DictionaryClass> depts = new ArrayList<DictionaryClass>();
	//������������list
	private List<DictionaryClass> twoDepts = new ArrayList<DictionaryClass>();
	private String result;
	
	private CertifiedServiceCondition condition = new CertifiedServiceCondition();
	
	public void setCondition(CertifiedServiceCondition condition) {
		this.condition = condition;
	}

	public CertifiedServiceCondition getCondition() {
		CertifiedServiceCondition sessionCondition = (CertifiedServiceCondition) get(getActionName());
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
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		//��ҳ��ѯ
		currentPage = certifiedServiceImpl.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	
	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addCertifiedServicePage()
	{
		this.queryDept();
		this.queryTwoDept();
    	this.queryDictionaryClass();
		return "addPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String addCertifiedService()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		certifiedServiceImpl.addCertifiedService(certifiedService);
		return "query";
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyCertifiedServicePage()
	{
		
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		this.queryDept();
		this.queryTwoDept();
		this.queryDictionaryClass();
		certifiedService = certifiedServiceImpl.queryById(certId);
		return "modifyPage";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modifyCertifiedService()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		certifiedServiceImpl.modifyCertifiedService(certifiedService);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delectCertifiedService()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		certifiedServiceImpl.delectCertifiedService(certIds);
		return "query";
	}

	public String goBack()
	{
		return "query";
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		ICertifiedService certifiedService = new CertifiedServiceImpl();
		//��������(�ֵ��TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		//��������(�ֵ��TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		//���ʼ���(�ֵ��TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
	}
	
	/**
	 * ��ȡ��������
	 */
	public void queryDept()
	{
		//��ò�����Ϣ
//		RoleServiceImplService role =new RoleServiceImplService();
//		List<StringArray> department= new ArrayList<StringArray>();
//    	department=role.getRoleServiceImplPort().getDepartment();
		ICertifiedService cs = new CertifiedServiceImpl();
		List<Department> department = cs.getDepartment();
		for(int j=0;j<department.size();j++){
	    	 DictionaryClass dictionaryClass = new DictionaryClass();
	    	 dictionaryClass.setCode(department.get(j).getId());
	    	 dictionaryClass.setName(department.get(j).getName());
	    	 depts.add(dictionaryClass);
	    }
	}
	
	/**
	 * ��ȡ������������
	 */
	public void queryTwoDept()
	{
//		//��ò�����Ϣ
//		RoleServiceImplService role =new RoleServiceImplService();
//		List<StringArray> department= new ArrayList<StringArray>();
//    	department=role.getRoleServiceImplPort().getDepartment();
//    	//ת��Ϊ��ά����
//    	String[][] data=new String[department.size()][2];
		ICertifiedService cs = new CertifiedServiceImpl();
		List<Department> department = cs.getDepartment();
		for(int j=0;j<department.size();j++){
				
		     DictionaryClass dictionaryClass = new DictionaryClass();
	    	 dictionaryClass.setCode(department.get(j).getId());
	    	 dictionaryClass.setName(department.get(j).getName());
	    	 twoDepts.add(dictionaryClass);
	    }
	}
	
	public String querySpecialtyTypes()
	{
		ICertifiedService certifiedService = new CertifiedServiceImpl();
		//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
		specialtyTypes = certifiedService.querySpecialtyTypes(cretSequenceId);
		JSONArray json = JSONArray.fromObject(specialtyTypes);//��result��ֵ�����ݸ�ҳ�� 
		result = json.toString();
        return "success";
	}
	
	public CertifiedService getCertifiedService() {
		return certifiedService;
	}

	public void setCertifiedService(CertifiedService certifiedService) {
		this.certifiedService = certifiedService;
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

	public String getCretSequenceId() {
		return cretSequenceId;
	}

	public void setCretSequenceId(String cretSequenceId) {
		this.cretSequenceId = cretSequenceId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
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
}
