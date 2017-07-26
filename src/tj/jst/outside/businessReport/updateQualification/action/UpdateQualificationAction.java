package com.tj.jst.outside.businessReport.updateQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.updateQualification.service.IUpdateQualificationService;
import com.tj.jst.outside.businessReport.updateQualification.service.UpdateQualificationServiceImpl;

public class UpdateQualificationAction extends BaseAction {

	private String addTypeNum;   //���ʻ�÷�ʽ �� 002 ��������
	private String levelName;//��������
	private String corpName;//��ҵ����
	private String corpId;  //��ҵID
	private String[] certIds;//��������ids
	private String check;
	private List<CertifiedService> certifieds;//��������list
	private String message;//��ʾ��Ϣ
	
	
	/**
	 * ��ת����ѡ��ҳ��
	 * @return
	 * @throws Exception
	 */
	public String updateApplication()throws Exception{
		return "updateApplicationPage";
    }
	
	/**
	 * ��ת���ʷ�������ѡ��ҳ��
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService()throws Exception{
		
		IUpdateQualificationService updateQualificationService = new UpdateQualificationServiceImpl();
		if(check.equals("1"))
		{
			levelName = "����Ժס�����罨�����ܲ������";
			check = "1";
		}
		if(check.equals("2"))
		{
			levelName = "ʡס�����罨�����ܲ������";
			check = "2";
		}
		if(check.equals("3"))
		{
			levelName = "��(��)��ʡֱ���ء�ũ�ѡ�ɭ��ס�����罨�����ܲ������";
			check = "3";
		}
		corpName = ((Login)this.get("login")).getUserName();
		corpId = ((Login)this.get("login")).getUserId();
		certifieds = updateQualificationService.queryCertifiedService(check,corpId);
		return "certifiedServicePage";
	}
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService()throws Exception{
		IUpdateQualificationService updateQualificationService = new UpdateQualificationServiceImpl();
		Login login = (Login)this.get("login");
		message = updateQualificationService.submitCertifiedService(login, certIds, addTypeNum,check);
		return "goBusiness";
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

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public List<CertifiedService> getCertifieds() {
		return certifieds;
	}

	public void setCertifieds(List<CertifiedService> certifieds) {
		this.certifieds = certifieds;
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
	
	
	
}
