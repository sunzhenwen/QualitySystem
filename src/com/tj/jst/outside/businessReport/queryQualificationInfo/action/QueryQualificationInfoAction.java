package com.tj.jst.outside.businessReport.queryQualificationInfo.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.condition.QualificationInfoCondition;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;
import com.tj.jst.outside.businessReport.queryQualificationInfo.service.IQueryQualificationInfoService;
import com.tj.jst.outside.businessReport.queryQualificationInfo.service.QueryQualificationInfoServiceImpl;

/**
 * ��ҵ���ϱ�����״̬��ѯ
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoAction extends BaseAction {

	private String message = "";					//��ʾ��Ϣ
	private String NewQualId;						//��ҵ����ID
	private QualificationInfo Qualification;		//������Ϣ��ѯ
	private List<DictionaryClass> CretLevelNums;     //�����ʸ�����
	
	private QualificationInfoCondition condition = new QualificationInfoCondition();
	
	public void setCondition(QualificationInfoCondition condition) {
		this.condition = condition;
	}
	
	public QualificationInfoCondition getCondition() {
		QualificationInfoCondition sessionCondition = (QualificationInfoCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ת����ҵ������Ϣҳ�棻
	 * 
	 * @return
	 */
	public String queryQualificationInfoPage() {
		
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		this.getCondition().setCorpId((String)this.get("corpCode"));
		// ��ҳ��ѯ
		currentPage = staffservice.queryCertifiedService(this.getCondition());
		// �����ʸ����Ͳ�ѯ
		CretLevelNums = staffservice.CretLevelNums();
		this.set(getActionName(), condition);
		return "queryApplicationPage";
	}
	
	/**
	 * ��ҵ������������Ϣ����״̬��ϸҳ��
	 * 
	 * @return
	 */
	public String queryQualification() {
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		Qualification = staffservice.queryById(NewQualId);
		return "queryApplicationListPage";
	}
	
	/**
	 * ��ҵ����������Ϣɾ��
	 */
	public String deleteQualification(){
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		message = staffservice.deleteById(NewQualId);
		// ��ҳ��ѯ
		currentPage = staffservice.queryCertifiedService(this.getCondition());
		// �����ʸ����Ͳ�ѯ
		CretLevelNums = staffservice.CretLevelNums();
		this.set(getActionName(), condition);
		return "queryApplicationPage";
	}
	
	/**
	 * ����ҵ��������
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNewQualId() {
		return NewQualId;
	}

	public void setNewQualId(String newQualId) {
		NewQualId = newQualId;
	}

	public QualificationInfo getQualification() {
		return Qualification;
	}

	public void setQualification(QualificationInfo qualification) {
		Qualification = qualification;
	}

	public List<DictionaryClass> getCretLevelNums() {
		return CretLevelNums;
	}

	public void setCretLevelNums(List<DictionaryClass> cretLevelNums) {
		CretLevelNums = cretLevelNums;
	}

	
	
}
