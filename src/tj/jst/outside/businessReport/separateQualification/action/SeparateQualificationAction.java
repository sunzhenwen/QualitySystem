package com.tj.jst.outside.businessReport.separateQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;
import com.tj.jst.outside.businessReport.separateQualification.service.ISeparateQualificationService;
import com.tj.jst.outside.businessReport.separateQualification.service.SeparateQualificationServiceImpl;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public class SeparateQualificationAction extends BaseAction{
	
	private String addTypeNum;  				//�����ʸ�ȡ�÷�ʽ   006:��λ
	private String levelName;					//��������
	private String corpName;					//��ҵ����
	private String[] relationIds;				//��������ids
	private String check;						//����ѡ��check
	private String corpId;						//ͨ��CorpId��ȡ��˾������Ϣ
	private List<SeparateQualification> separateQualification;	//��������list
	private String message;						//��ʾ��Ϣ
	private String typeNum;						//�ж����ʵȼ�
	private String queryCorp ;                  //��ҵ���ƻ���֯��������֤��
	
	/**
	 * ��ת����������ҵ��ѯҳ��
	 * @return
	 */
	public String queryCorp() {
		return "queryCorp";
	}
	
	/**
	 * ��ѯ��������ҵ����������
	 * @return
	 */
	public String queryCorpQualification() {
		
		ISeparateQualificationService service = new SeparateQualificationServiceImpl();
		separateQualification = service.queryCorpQualification(queryCorp) ;
		if(0 == separateQualification.size()) {
			message = "���������ҵ���ƻ���֯��������֤�Ų���ȷ����ȷ�Ϻ����²�ѯ" ;
			return "queryCorp";
		}else{
			corpName = separateQualification.get(0).getCorpName();
			return "queryCorpQualification" ;
		}
		
	}
	
	/**
	 * ���������ϱ�
	 * @return
	 */
	public String submitCertified() {
		
		ISeparateQualificationService service = new SeparateQualificationServiceImpl();
		Login login = (Login)this.get("login");
		separateQualification = service.queryEXCorpQualification(relationIds);//�ӻ������֤������ѯ��������ҵ��������Ϣ
		this.setAddTypeNum("006");
		message = service.submitCertified(separateQualification,addTypeNum,login);
		
		return "goBusiness" ;
		
	}
	
	public String goBusiness(){
		return "goBusiness" ;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getQueryCorp() {
		return queryCorp;
	}

	public void setQueryCorp(String queryCorp) {
		this.queryCorp = queryCorp;
	}

	public List<SeparateQualification> getSeparateQualification() {
		return separateQualification;
	}

	public void setSeparateQualification(
			List<SeparateQualification> separateQualification) {
		this.separateQualification = separateQualification;
	}

	public String[] getRelationIds() {
		return relationIds;
	}

	public void setRelationIds(String[] relationIds) {
		this.relationIds = relationIds;
	}

}
