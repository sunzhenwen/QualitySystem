package com.tj.jst.outside.businessReport.queryWriteOffType.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryWriteOffType.condition.QueryWriteOffTypeCondition;
import com.tj.jst.outside.businessReport.queryWriteOffType.service.IQueryWriteOffTypeService;
import com.tj.jst.outside.businessReport.queryWriteOffType.service.QueryWriteOffTypeServiceImpl;

/**
 * 企业资质注销申请状态查询
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class QueryWriteOffTypeAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IQueryWriteOffTypeService service = new QueryWriteOffTypeServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		IQueryWriteOffTypeService certifiedService = new QueryWriteOffTypeServiceImpl();
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
