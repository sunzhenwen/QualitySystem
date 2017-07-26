package com.tj.jst.outside.businessReport.writeOffApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.writeOffApproval.condition.WriteOffApprovalCondition;
import com.tj.jst.outside.businessReport.writeOffApproval.service.IWriteOffApprovalService;
import com.tj.jst.outside.businessReport.writeOffApproval.service.WriteOffApprovalServiceImpl;

/**
 * ��ҵ����ע������
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class WriteOffApprovalAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IWriteOffApprovalService service = new WriteOffApprovalServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ����ע������
	 * @return
	 */
	public String writeOffApp()
	{
		IWriteOffApprovalService service = new WriteOffApprovalServiceImpl();
		service.baseWriteOffApp(ids);
		return "query";
	}
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IWriteOffApprovalService certifiedService = new WriteOffApprovalServiceImpl();
		//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}
	
	/**
	 * ����ҵ��������
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
