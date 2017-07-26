package com.tj.jst.inner.qualificationProductivity.writeOff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.writeOff.condition.WriteOffCondition;
import com.tj.jst.inner.qualificationProductivity.writeOff.service.IWriteOffService;
import com.tj.jst.inner.qualificationProductivity.writeOff.service.WriteOffServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * 企业资质注销
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class WriteOffAction extends BaseAction {
	
	private String corpCertId;
	private String[] ids;
	private CertificatePrint certificatePrint;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	private WriteOffCondition condition = new WriteOffCondition();
	
	public void setCondition(WriteOffCondition condition) {
		this.condition = condition;
	}

	public WriteOffCondition getCondition() {
		WriteOffCondition sessionCondition = (WriteOffCondition) get(getActionName());
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
		IWriteOffService service = new WriteOffServiceImpl();
		String departmentID = (String)this.get("departmentID");
		String personalID = (String)this.get("personalID");
		this.getCondition().setDeptId(departmentID);
		this.getCondition().setPersonalID(personalID);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), this.getCondition());
		if(personalID.equals("400105") || personalID.equals("400202") || personalID.equals("400223") || personalID.equals("400204") ){
			return "floorQueryPage";
		}else {
			return "queryPage";
		}
		
	}

	/**
	 * 批量注销
	 * @return
	 */
	public String batchWriteOff()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.baseBatchWriteOff(ids,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 大厅批量注销
	 * @return
	 */
	public String floorBatchWriteOff()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.floorBaseBatchWriteOff(ids,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 跳转审批页面
	 * @return
	 */
	public String approvalPage()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		certificatePrint = service.approvalPage(corpCertId);
		return "approvalPage";
	}
	
	/**
	 * 跳转大厅审批页面
	 * @return
	 */
	public String floorApprovalPage()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		certificatePrint = service.approvalPage(corpCertId);
		return "floorApprovalPage";
	}
	
	/**
	 * 审批通过
	 * @return
	 */
	public String applythrough()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.applythrough(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 大厅审批
	 * @return
	 */
	public String floorApplyThrough() {
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.floorApplythrough(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 申请退回
	 * @return
	 */
	public String applyBack()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.applyBack(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 大厅退回
	 * @return
	 */
	public String floorApplyBack(){
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.floorApplyBack(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 批量退回
	 * @return
	 */
	public String batchWriteOffReturn()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.batchWriteOffReturn(ids,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		IWriteOffService certifiedService = new WriteOffServiceImpl();
		//企业登记注册类型(字典表：TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
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

	public CertificatePrint getCertificatePrint() {
		return certificatePrint;
	}

	public void setCertificatePrint(CertificatePrint certificatePrint) {
		this.certificatePrint = certificatePrint;
	}

}
