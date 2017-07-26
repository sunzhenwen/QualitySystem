package com.tj.jst.outside.businessReport.writeOffApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.writeOffApproval.condition.WriteOffApprovalCondition;
import com.tj.jst.outside.businessReport.writeOffApproval.service.IWriteOffApprovalService;
import com.tj.jst.outside.businessReport.writeOffApproval.service.WriteOffApprovalServiceImpl;

/**
 * 企业资质注销申请
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class WriteOffApprovalAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	private WriteOffApprovalCondition condition = new WriteOffApprovalCondition();
	
	public void setCondition(WriteOffApprovalCondition condition) {
		this.condition = condition;
	}

	public WriteOffApprovalCondition getCondition() {
		WriteOffApprovalCondition sessionCondition = (WriteOffApprovalCondition) get(getActionName());
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
		IWriteOffApprovalService service = new WriteOffApprovalServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 批量注销申请
	 * @return
	 */
	public String writeOffApp()
	{
		IWriteOffApprovalService service = new WriteOffApprovalServiceImpl();
		service.baseWriteOffApp(ids);
		return "query";
	}
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		IWriteOffApprovalService certifiedService = new WriteOffApprovalServiceImpl();
		//企业登记注册类型(字典表：TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}
	
	/**
	 * 返回业务办理界面
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
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

}
