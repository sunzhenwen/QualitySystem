package com.tj.jst.outside.businessReport.newQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.service.INewQualificationService;
import com.tj.jst.outside.businessReport.newQualification.service.NewQualificationServiceImpl;

/**
 * ��ҵ���������ϱ�
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class NewQualificationAction extends BaseAction {

	private String addTypeNum; // �����ʸ�ȡ�÷�ʽ 001������ 002������ 003������
	private String levelName;// ��������
	private String corpName;// ��ҵ����
	private String[] certIds;// ��������ids
	private String check;
	private List<CertifiedService> certifieds;// ��������list
	private String message;// ��ʾ��Ϣ
	private String typeNum;// �жϱ�ʾ��
	private String corpCode;// ��ҵ��֯��������

	/**
	 * ��ת����ѡ��ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String newApplication() throws Exception {
		return "newApplicationPage";
	}

	/**
	 * ��������������ʷ��������ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService() throws Exception {
		INewQualificationService newQualificationService = new NewQualificationServiceImpl();

		if (check.equals("1")) {
			levelName = "����Ժס�����罨�����ܲ������";
			typeNum = "1";
		}
		if (check.equals("2")) {
			levelName = "ʡס�����罨�����ܲ������";
			typeNum = "2";
		}
		if (check.equals("3")) {
			levelName = "��(��)��ʡֱ���ء�ũ�ѡ�ɭ��ס�����罨�����ܲ������";
			typeNum = "3";
		}

		corpName = ((Login) this.get("login")).getUserName();
		corpCode = ((Login) this.get("login")).getCorpCode();

		// �°�
		if (addTypeNum.equals("001")) {
			certifieds = newQualificationService.queryCertifiedService(check,
					corpCode);
		}
		// ����
		if (addTypeNum.equals("003")) {
			String corpid = ((Login) this.get("login")).getUserId();
			certifieds = newQualificationService.queryCertifiedService(check,
					corpid, addTypeNum);
		}

		return "certifiedServicePage";
	}

	/**
	 * ���ʷ��������ύ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService() throws Exception {
		INewQualificationService newQualificationService = new NewQualificationServiceImpl();
		Login login = (Login) this.get("login");
		message = newQualificationService.submitCertifiedService(login,
				certIds, addTypeNum, typeNum);
		return "goBusiness";
	}

	public List<CertifiedService> getCertifieds() {
		return certifieds;
	}

	public void setCertifieds(List<CertifiedService> certifieds) {
		this.certifieds = certifieds;
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

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
