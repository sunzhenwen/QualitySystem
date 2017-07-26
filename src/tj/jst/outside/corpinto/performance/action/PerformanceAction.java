package com.tj.jst.outside.corpinto.performance.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.performance.condition.PerformanceCondition;
import com.tj.jst.outside.corpinto.performance.model.Performance;
import com.tj.jst.outside.corpinto.performance.service.IPerformanceService;
import com.tj.jst.outside.corpinto.performance.service.PerformanceServiceImpl;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public class PerformanceAction extends BaseAction {
	
	private String perId;//主键
	private Performance performance;
	
	private PerformanceCondition condition = new PerformanceCondition();
	
	public void setCondition(PerformanceCondition condition) {
		this.condition = condition;
	}

	public PerformanceCondition getCondition() {
		PerformanceCondition sessionCondition = (PerformanceCondition) get(getActionName());
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
		IPerformanceService service = new PerformanceServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "querySuccess";
	}
	
	/**
	 * 添加页面跳转
	 * @return
	 */
	public String addPage()
	{
		return "addPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		Login login = (Login)this.get("login");
		performance.setCorpId(login.getUserId());//企业Id
		performance.setCorpName(login.getUserName());//企业名称
		performance.setCorpCode(login.getCorpCode());//组织机构代码
		service.add(performance);
		return "queryPage";
	}
	
	public String detailed()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		performance = service.detailed(perId);
		return "detailed";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		service.delete(perId);
		return "queryPage";
	}
	
	/**
	 * 返回列表页面
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
	}
	
	/**
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
}
