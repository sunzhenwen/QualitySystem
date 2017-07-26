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
 * ��ҵ����ע��
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class WriteOffAction extends BaseAction {
	
	private String corpCertId;
	private String[] ids;
	private CertificatePrint certificatePrint;
	private List<DictionaryClass> econmicNums; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		String departmentID = (String)this.get("departmentID");
		String personalID = (String)this.get("personalID");
		this.getCondition().setDeptId(departmentID);
		this.getCondition().setPersonalID(personalID);
		//��ҳ��ѯ
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
	 * ����ע��
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
	 * ��������ע��
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
	 * ��ת����ҳ��
	 * @return
	 */
	public String approvalPage()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		certificatePrint = service.approvalPage(corpCertId);
		return "approvalPage";
	}
	
	/**
	 * ��ת��������ҳ��
	 * @return
	 */
	public String floorApprovalPage()
	{
		IWriteOffService service = new WriteOffServiceImpl();
		certificatePrint = service.approvalPage(corpCertId);
		return "floorApprovalPage";
	}
	
	/**
	 * ����ͨ��
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
	 * ��������
	 * @return
	 */
	public String floorApplyThrough() {
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.floorApplythrough(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * �����˻�
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
	 * �����˻�
	 * @return
	 */
	public String floorApplyBack(){
		IWriteOffService service = new WriteOffServiceImpl();
		Login login = (Login)this.get("login");
		service.floorApplyBack(certificatePrint,login.getPersonalID(),login.getName());
		return "query";
	}
	
	/**
	 * �����˻�
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
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IWriteOffService certifiedService = new WriteOffServiceImpl();
		//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
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
