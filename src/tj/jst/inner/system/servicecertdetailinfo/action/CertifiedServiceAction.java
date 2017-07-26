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
 * 资质服务事项维护
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CertifiedServiceAction extends BaseAction {
	
	//资质服务事项主键
	private String certId;
	private String[] certIds;
	//资质服务事项
	private CertifiedService certifiedService;
	//资质序列code
	private String cretSequenceId;
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//资质序列(字典表：TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	//资质级别(字典表：TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	//审批部门list
	private List<DictionaryClass> depts = new ArrayList<DictionaryClass>();
	//二级审批部门list
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		//分页查询
		currentPage = certifiedServiceImpl.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	
	/**
	 * 跳转添加页面
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
	 * 添加
	 * @return
	 */
	public String addCertifiedService()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		certifiedServiceImpl.addCertifiedService(certifiedService);
		return "query";
	}
	
	/**
	 * 跳转修改页面
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
	 * 修改
	 * @return
	 */
	public String modifyCertifiedService()
	{
		ICertifiedService certifiedServiceImpl = new CertifiedServiceImpl();
		certifiedServiceImpl.modifyCertifiedService(certifiedService);
		return "query";
	}
	
	/**
	 * 删除
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
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		ICertifiedService certifiedService = new CertifiedServiceImpl();
		//资质类型(字典表：TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		//资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		//资质序列(字典表：TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		//资质级别(字典表：TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
	}
	
	/**
	 * 获取审批部门
	 */
	public void queryDept()
	{
		//获得部门信息
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
	 * 获取二级审批部门
	 */
	public void queryTwoDept()
	{
//		//获得部门信息
//		RoleServiceImplService role =new RoleServiceImplService();
//		List<StringArray> department= new ArrayList<StringArray>();
//    	department=role.getRoleServiceImplPort().getDepartment();
//    	//转换为二维数组
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
		//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
		specialtyTypes = certifiedService.querySpecialtyTypes(cretSequenceId);
		JSONArray json = JSONArray.fromObject(specialtyTypes);//给result赋值，传递给页面 
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
