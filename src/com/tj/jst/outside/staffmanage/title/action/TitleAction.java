package com.tj.jst.outside.staffmanage.title.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.staffmanage.title.condition.TitleCondition;
import com.tj.jst.outside.staffmanage.title.model.Title;
import com.tj.jst.outside.staffmanage.title.service.ITitleService;
import com.tj.jst.outside.staffmanage.title.service.TitleServiceImpl;

/**
 * ְ����Ա
 * @author Administrator
 *
 */
public class TitleAction extends BaseAction {
	
	//ְ����Ա����
	private String personId;
	//ְ����Ա
	private Title title;
	//ְ����Աlist
	private List<Title> titleList;
	//�Ա�list
	private List<DictionaryClass> sexNums;
	//֤������
	private List<DictionaryClass> idCardTypeNums;
	
	//��ʾ��Ϣ
	private String message;
	
	private TitleCondition condition = new TitleCondition();
	
	public void setCondition(TitleCondition condition) {
		this.condition = condition;
	}

	public TitleCondition getCondition() {
		TitleCondition sessionCondition = (TitleCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯְ����Ա������Ϣ
	 * @return
	 */
	public String queryPage()
	{
		ITitleService staffService = new TitleServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "titleSuccess";
	}
	
	/**
	 * ��ת���ְ����Ա������Ϣҳ��
	 * @return
	 */
	public String addPage()
	{
		this.queryDictionaryClass();
		return "addPage";
	}
	
	/**
	 * ���ְ����Ա������Ϣ
	 * @return
	 */
	public String add()
	{
		ITitleService staffService = new TitleServiceImpl();
		Login login = (Login)this.get("login");
		this.getTitle().setCorpId(login.getUserId());
		this.getTitle().setCorpCode(login.getCorpCode());
		this.getTitle().setCorpName(login.getUserName());
		this.queryDictionaryClass();
		message = staffService.add(title);
		if (!message.equals("��ӳɹ���"))
		{
			message = "��֤�������Ѿ���" + message + "ʹ�ã��޷��ظ���ӣ���˶ԣ�";
			return "addPage";
		}else{
			message = "��ӳɹ���";
			return "queryPage";
		}
		
	}
	
	/**
	 * ��ת�޸�ְ����Ա��Ϣҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ITitleService staffService = new TitleServiceImpl();
		this.queryDictionaryClass();
		title = staffService.queryById(personId);
		return "modifyPage";
	}
	
	/**
	 * �޸�ְ����Ա��Ϣ
	 * @return
	 */
	public String modify()
	{
		ITitleService staffService = new TitleServiceImpl();
		Login login = (Login)this.get("login");
		title.setCorpCode(login.getCorpCode());
		title.setCorpName(login.getUserName());
		message = staffService.modify(title);
		this.queryDictionaryClass();
		if(!message.equals("�޸ĳɹ���")){
			message = "��֤�������Ѿ���" + message + "ʹ�ã��޷��ظ���ӣ���˶ԣ�";
			return "modifyPage";
		}else{
			message = "�޸ĳɹ���";
			return "queryPage";
		}
		
		
	}
	
	/**
	 * ɾ��ְ����Ա��Ϣ
	 * @return
	 */
	public String delete()
	{
		ITitleService staffService = new TitleServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
	}
	
	/**
	 * ����ְ����Ա�б�Ŀ¼
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

	public void queryDictionaryClass()
	{
		ITitleService staffService = new TitleServiceImpl();
		sexNums = staffService.querySexNums();
		idCardTypeNums = staffService.queryIdCardTypeNums();
	}
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

	public List<DictionaryClass> getSexNums() {
		return sexNums;
	}

	public void setSexNums(List<DictionaryClass> sexNums) {
		this.sexNums = sexNums;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

}
