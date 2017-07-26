package com.tj.jst.outside.businessReport.queryQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.condition.QualificationCondition;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;
import com.tj.jst.outside.businessReport.queryQualification.service.IQueryQualificationService;
import com.tj.jst.outside.businessReport.queryQualification.service.QueryQualificationServiceImpl;

/**
 * ��ѯ��ҵ��ӵ�е�����
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationAction extends BaseAction {

	// ��ʾ��Ϣ
	private String message;
	// ��ҵ����ID
	private String CertDetailId;
	//
	private Qualification Qualification;
	// �����ʸ�����
	private List<DictionaryClass> CertTypeNums;
	// �����ʸ�ȼ�
	private List<DictionaryClass> TitleLevelNums;
	// �����ʸ��ȡ��ʽ
	private List<DictionaryClass> AddTypeNums;
	// רҵ���
	private List<DictionaryClass> TradeBoundNums;
	
	private String corpId;

	private QualificationCondition condition = new QualificationCondition();

	public void setCondition(QualificationCondition condition) {
		this.condition = condition;
	}

	public QualificationCondition getCondition() {
		QualificationCondition sessionCondition = (QualificationCondition) get(getActionName());
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
	public String queryQualificationPage() {

		IQueryQualificationService staffservice = new QueryQualificationServiceImpl();
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		// ��ҳ��ѯ
		currentPage = staffservice.queryCertifiedService(this.getCondition());
		// �����ʸ����Ͳ�ѯ
		CertTypeNums = staffservice.CertTypeNums();
		// �����ʸ�ȼ���ѯ
		TitleLevelNums = staffservice.TitleLevelNums();
		this.set(getActionName(), condition);
		return "queryApplicationPage";
	}
	
	public String detailCretPage(){
		IQueryQualificationService staffservice = new QueryQualificationServiceImpl();
		condition.setCorpId(corpId);
		currentPage = staffservice.queryCertifiedService(condition);
		return "detailCretPage";
	}

	/**
	 * ��ҵ��ӵ��������Ϣ��ϸҳ��
	 * 
	 * @return
	 */
	public String queryQualification() {
		IQueryQualificationService staffservice = new QueryQualificationServiceImpl();
		Qualification = staffservice.queryById(CertDetailId);
		return "queryApplicationListPage";
	}

	/**
	 * ����
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

	public String getCertDetailId() {
		return CertDetailId;
	}

	public void setCertDetailId(String CertDetailId) {
		this.CertDetailId = CertDetailId;
	}

	public Qualification getQualification() {
		return Qualification;
	}

	public void setQueryQualification(Qualification Qualification) {
		this.Qualification = Qualification;
	}

	public List<DictionaryClass> getCertTypeNums() {
		return CertTypeNums;
	}

	public void setCertTypeNums(List<DictionaryClass> certTypeNums) {
		CertTypeNums = certTypeNums;
	}

	public List<DictionaryClass> getTitleLevelNums() {
		return TitleLevelNums;
	}

	public void setTitleLevelNums(List<DictionaryClass> titleLevelNums) {
		TitleLevelNums = titleLevelNums;
	}

	public List<DictionaryClass> getAddTypeNums() {
		return AddTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		AddTypeNums = addTypeNums;
	}

	public List<DictionaryClass> getTradeBoundNums() {
		return TradeBoundNums;
	}

	public void setTradeBoundNums(List<DictionaryClass> tradeBoundNums) {
		TradeBoundNums = tradeBoundNums;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public void setQualification(Qualification qualification) {
		Qualification = qualification;
	}

	
	
}
