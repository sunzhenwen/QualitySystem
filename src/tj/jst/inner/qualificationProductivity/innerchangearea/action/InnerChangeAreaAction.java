package com.tj.jst.inner.qualificationProductivity.innerchangearea.action;

import java.sql.Date;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.condition.InnerChangeAreaCondition;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.service.IInnerChangeAreaService;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.service.InnerChangeAreaServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��������������ҵ������
 * 
 * @author DarkFlameMaster
 *
 */
public class InnerChangeAreaAction extends BaseAction {
	
	private String corpCode;
	private String message;
	private Corp corp;
	private String cityNum;
	private InnerChangeArea info;
	private String beforeCity;
	private String corpName;

	private InnerChangeAreaCondition condition = new InnerChangeAreaCondition();

	public void setCondition(InnerChangeAreaCondition condition) {
		this.condition = condition;
	}

	public InnerChangeAreaCondition getCondition() {
		InnerChangeAreaCondition sessionCondition = (InnerChangeAreaCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ʼҳ��
	 * 
	 * @return
	 */
	public String queryPage() {
		IInnerChangeAreaService service = new InnerChangeAreaServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�޸�ҳ��
	 * 
	 * @return
	 */
	public String changePage() {
		IInnerChangeAreaService service = new InnerChangeAreaServiceImpl();
		corp = service.queryCorp(corpCode);
		return "changePage";
	}

	/**
	 * �޸ķ���
	 * 
	 * @return
	 */
	public String change() {
		IInnerChangeAreaService service = new InnerChangeAreaServiceImpl();
		message = service.changeArea(corpCode, cityNum);
		InnerChangeArea test = new InnerChangeArea();
		Login login = (Login) this.get("login");
		String staffId = login.getName();
		String staffName = login.getDepartment();
		test.setStaffId(staffId);
		test.setStaffName(staffName);
		test.setChangeDate(new Date(new java.util.Date().getTime()));
		test.setAfterArea(cityNum);
		test.setBeforeArea(beforeCity);
		test.setCorpCode(corpCode);
		test.setCorpName(corpName);
		message = service.recordLog(test);
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

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public InnerChangeArea getInfo() {
		return info;
	}

	public void setInfo(InnerChangeArea info) {
		this.info = info;
	}

	public String getBeforeCity() {
		return beforeCity;
	}

	public void setBeforeCity(String beforeCity) {
		this.beforeCity = beforeCity;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
