package com.tj.jst.outside.businessReport.queryWriteOffType.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryWriteOffType.condition.QueryWriteOffTypeCondition;
import com.tj.jst.outside.businessReport.queryWriteOffType.service.IQueryWriteOffTypeService;
import com.tj.jst.outside.businessReport.queryWriteOffType.service.QueryWriteOffTypeServiceImpl;

/**
 * ��ҵ����ע������״̬��ѯ
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class QueryWriteOffTypeAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
	private QueryWriteOffTypeCondition condition = new QueryWriteOffTypeCondition();
	
	public void setCondition(QueryWriteOffTypeCondition condition) {
		this.condition = condition;
	}

	public QueryWriteOffTypeCondition getCondition() {
		QueryWriteOffTypeCondition sessionCondition = (QueryWriteOffTypeCondition) get(getActionName());
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
		IQueryWriteOffTypeService service = new QueryWriteOffTypeServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IQueryWriteOffTypeService certifiedService = new QueryWriteOffTypeServiceImpl();
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
