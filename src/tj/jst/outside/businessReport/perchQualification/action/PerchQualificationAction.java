package com.tj.jst.outside.businessReport.perchQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.perchQualification.service.IPerchQualificationService;
import com.tj.jst.outside.businessReport.perchQualification.service.PerchQualificationServiceImpl;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public class PerchQualificationAction extends BaseAction{
	
	private String addTypeNum;  				//�����ʸ�ȡ�÷�ʽ   007:��λ
	private String levelName;					//��������
	private String corpName;					//��ҵ����
	private String[] certIds;					//��������ids
	private String check;						//����ѡ��check
	private String corpId;						//ͨ��CorpId��ȡ��˾������Ϣ
	private List<CertifiedService> certifieds;	//��������list
	private String message;						//��ʾ��Ϣ
	private String typeNum;						//�ж����ʵȼ�
	
	/**
	 * ��ת���ʾ�λҳ��
	 * @return
	 * @throws Exception
	 */
	public String perchApplication()throws Exception{
		return "perchApplicationPage";
	}
	
	/**
	 * ���ʾ�λ��������ҳ��
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService()throws Exception{
		IPerchQualificationService perchQualification = new PerchQualificationServiceImpl();
		if(check.equals("1"))
		{
			levelName = "����Ժס�����罨�����ܲ������";
			typeNum = "1";
		}
		if(check.equals("2"))
		{
			levelName = "ʡס�����罨�����ܲ������";
			typeNum = "2";
		}
		if(check.equals("3"))
		{
			levelName = "��(��)��ʡֱ���ء�ũ�ѡ�ɭ��ס�����罨�����ܲ������";
			typeNum = "3";
		}
		corpName = ((Login)this.get("login")).getUserName();
		corpId = ((Login)this.get("login")).getUserId();
		certifieds = perchQualification.queryCertifiedService(check,corpId);
		return "certifiedServicePage";
	}
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService()throws Exception{
		IPerchQualificationService perchQualification = new PerchQualificationServiceImpl();
		Login login = (Login)this.get("login");
		message = perchQualification.submitCertifiedService(login, certIds, addTypeNum, typeNum);
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

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

}
