package com.tj.jst.outside.businessReport.perchQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.perchQualification.service.IPerchQualificationService;
import com.tj.jst.outside.businessReport.perchQualification.service.PerchQualificationServiceImpl;

/**
 * 资质就位上报
 * @author DarkFlameMaster
 *
 */
public class PerchQualificationAction extends BaseAction{
	
	private String addTypeNum;  				//资质资格取得方式   007:就位
	private String levelName;					//级别名称
	private String corpName;					//企业名称
	private String[] certIds;					//服务事项ids
	private String check;						//事项选择check
	private String corpId;						//通过CorpId获取公司资质信息
	private List<CertifiedService> certifieds;	//服务事项list
	private String message;						//提示信息
	private String typeNum;						//判断资质等级
	
	/**
	 * 跳转资质就位页面
	 * @return
	 * @throws Exception
	 */
	public String perchApplication()throws Exception{
		return "perchApplicationPage";
	}
	
	/**
	 * 资质就位服务事项页面
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService()throws Exception{
		IPerchQualificationService perchQualification = new PerchQualificationServiceImpl();
		if(check.equals("1"))
		{
			levelName = "国务院住房城乡建设主管部门许可";
			typeNum = "1";
		}
		if(check.equals("2"))
		{
			levelName = "省住房城乡建设主管部门许可";
			typeNum = "2";
		}
		if(check.equals("3"))
		{
			levelName = "市(地)、省直管县、农垦、森工住房城乡建设主管部门许可";
			typeNum = "3";
		}
		corpName = ((Login)this.get("login")).getUserName();
		corpId = ((Login)this.get("login")).getUserId();
		certifieds = perchQualification.queryCertifiedService(check,corpId);
		return "certifiedServicePage";
	}
	
	/**
	 * 资质服务事项提交
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
