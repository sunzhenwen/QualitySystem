package com.tj.jst.outside.businessReport.updateQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.updateQualification.service.IUpdateQualificationService;
import com.tj.jst.outside.businessReport.updateQualification.service.UpdateQualificationServiceImpl;

public class UpdateQualificationAction extends BaseAction {

	private String addTypeNum;   //资质获得方式 ： 002 资质升级
	private String levelName;//级别名称
	private String corpName;//企业名称
	private String corpId;  //企业ID
	private String[] certIds;//服务事项ids
	private String check;
	private List<CertifiedService> certifieds;//服务事项list
	private String message;//提示信息
	
	
	/**
	 * 跳转申请选择页面
	 * @return
	 * @throws Exception
	 */
	public String updateApplication()throws Exception{
		return "updateApplicationPage";
    }
	
	/**
	 * 跳转资质服务事项选择页面
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService()throws Exception{
		
		IUpdateQualificationService updateQualificationService = new UpdateQualificationServiceImpl();
		if(check.equals("1"))
		{
			levelName = "国务院住房城乡建设主管部门许可";
			check = "1";
		}
		if(check.equals("2"))
		{
			levelName = "省住房城乡建设主管部门许可";
			check = "2";
		}
		if(check.equals("3"))
		{
			levelName = "市(地)、省直管县、农垦、森工住房城乡建设主管部门许可";
			check = "3";
		}
		corpName = ((Login)this.get("login")).getUserName();
		corpId = ((Login)this.get("login")).getUserId();
		certifieds = updateQualificationService.queryCertifiedService(check,corpId);
		return "certifiedServicePage";
	}
	
	/**
	 * 资质服务事项提交
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
