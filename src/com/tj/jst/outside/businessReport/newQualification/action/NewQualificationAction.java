package com.tj.jst.outside.businessReport.newQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.service.INewQualificationService;
import com.tj.jst.outside.businessReport.newQualification.service.NewQualificationServiceImpl;

/**
 * 企业资质申请上报
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class NewQualificationAction extends BaseAction {

	private String addTypeNum; // 资质资格取得方式 001：申请 002：升级 003：增项
	private String levelName;// 级别名称
	private String corpName;// 企业名称
	private String[] certIds;// 服务事项ids
	private String check;
	private List<CertifiedService> certifieds;// 服务事项list
	private String message;// 提示信息
	private String typeNum;// 判断表示服
	private String corpCode;// 企业组织机构代码

	/**
	 * 跳转申请选择页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String newApplication() throws Exception {
		return "newApplicationPage";
	}

	/**
	 * 新申请和增项资质服务事项查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService() throws Exception {
		INewQualificationService newQualificationService = new NewQualificationServiceImpl();

		if (check.equals("1")) {
			levelName = "国务院住房城乡建设主管部门许可";
			typeNum = "1";
		}
		if (check.equals("2")) {
			levelName = "省住房城乡建设主管部门许可";
			typeNum = "2";
		}
		if (check.equals("3")) {
			levelName = "市(地)、省直管县、农垦、森工住房城乡建设主管部门许可";
			typeNum = "3";
		}

		corpName = ((Login) this.get("login")).getUserName();
		corpCode = ((Login) this.get("login")).getCorpCode();

		// 新办
		if (addTypeNum.equals("001")) {
			certifieds = newQualificationService.queryCertifiedService(check,
					corpCode);
		}
		// 增项
		if (addTypeNum.equals("003")) {
			String corpid = ((Login) this.get("login")).getUserId();
			certifieds = newQualificationService.queryCertifiedService(check,
					corpid, addTypeNum);
		}

		return "certifiedServicePage";
	}

	/**
	 * 资质服务事项提交
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
