package com.tj.jst.outside.corpinto.performance.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.performance.condition.PerformanceCondition;
import com.tj.jst.outside.corpinto.performance.model.Performance;
import com.tj.jst.outside.corpinto.performance.service.IPerformanceService;
import com.tj.jst.outside.corpinto.performance.service.PerformanceServiceImpl;

/**
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public class PerformanceAction extends BaseAction {
	
	private String perId;//����
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "querySuccess";
	}
	
	/**
	 * ���ҳ����ת
	 * @return
	 */
	public String addPage()
	{
		return "addPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		Login login = (Login)this.get("login");
		performance.setCorpId(login.getUserId());//��ҵId
		performance.setCorpName(login.getUserName());//��ҵ����
		performance.setCorpCode(login.getCorpCode());//��֯��������
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
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IPerformanceService service = new PerformanceServiceImpl();
		service.delete(perId);
		return "queryPage";
	}
	
	/**
	 * �����б�ҳ��
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
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
