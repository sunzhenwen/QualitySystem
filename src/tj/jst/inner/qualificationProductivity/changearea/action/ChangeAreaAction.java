package com.tj.jst.inner.qualificationProductivity.changearea.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.changearea.condition.ChangeAreaCondition;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.inner.qualificationProductivity.changearea.service.ChangeAreaServiceImpl;
import com.tj.jst.inner.qualificationProductivity.changearea.service.IChangeAreaService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class ChangeAreaAction extends BaseAction {

	private String deptId;// ��ѯ����
	private ChangeArea change;// Model��
	private String cityName;// ��ʡ�����������
	private String provinceName;// ��ʡ���ʡ����
	private String message;// ������Ϣ
	private String changeId;// ����
	private Corp corp;// ��ҵModel��

	private ChangeAreaCondition condition = new ChangeAreaCondition();

	public void setCondition(ChangeAreaCondition condition) {
		this.condition = condition;
	}

	public ChangeAreaCondition getCondition() {
		ChangeAreaCondition sessionCondition = (ChangeAreaCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ѯ����ҳ��
	 * 
	 * @return
	 */
	public String queryPage() {
		IChangeAreaService service = new ChangeAreaServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		currentPage = service.queryPage(this.getCondition());
		this.set(getActionName(), this.getCondition());
		return "queryPage";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public String approvalPage() {
		IChangeAreaService service = new ChangeAreaServiceImpl();
		change = service.queryById(changeId);
		if(change.getAfterProvinceArea() != null){
			provinceName = service.queryCityName(change.getAfterProvinceArea().trim());
		}
		if(change.getAfterCityArea() != null){
			cityName = service.queryCityName(change.getAfterCityArea().trim());
		}
		return "approvalPage";
	}

	/**
	 * ����ͨ������
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IChangeAreaService service = new ChangeAreaServiceImpl();
		message = service.approvalSuccess(change);
		// ����д֤���ŷ���
		change = service.queryById(change.getChangeId());
		if (change.getProcess().equals("6")) {
			// ֤���Ÿı�
			corp = service.queryCorp(change.getCorpName());
			message = service.changeCorpArea(corp,change.getAfterCityArea());
		}
		return "query";
	}

	/**
	 * ������ͨ������
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IChangeAreaService service = new ChangeAreaServiceImpl();
		message = service.approvalFailed(change);
		return "query";
	}

	/**
	 * ���ط���
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public ChangeArea getChange() {
		return change;
	}

	public void setChange(ChangeArea change) {
		this.change = change;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

}
