package com.tj.jst.outside.businessReport.separateQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;
import com.tj.jst.outside.businessReport.separateQualification.service.ISeparateQualificationService;
import com.tj.jst.outside.businessReport.separateQualification.service.SeparateQualificationServiceImpl;

/**
 * 资质就位上报
 * @author DarkFlameMaster
 *
 */
public class SeparateQualificationAction extends BaseAction{
	
	private String addTypeNum;  				//资质资格取得方式   006:就位
	private String levelName;					//级别名称
	private String corpName;					//企业名称
	private String[] relationIds;				//服务事项ids
	private String check;						//事项选择check
	private String corpId;						//通过CorpId获取公司资质信息
	private List<SeparateQualification> separateQualification;	//服务事项list
	private String message;						//提示信息
	private String typeNum;						//判断资质等级
	private String queryCorp ;                  //企业名称或组织机构代码证号
	
	/**
	 * 跳转至被分立企业查询页面
	 * @return
	 */
	public String queryCorp() {
		return "queryCorp";
	}
	
	/**
	 * 查询被分立企业的所有资质
	 * @return
	 */
	public String queryCorpQualification() {
		
		ISeparateQualificationService service = new SeparateQualificationServiceImpl();
		separateQualification = service.queryCorpQualification(queryCorp) ;
		if(0 == separateQualification.size()) {
			message = "您输入的企业名称或组织机构代码证号不正确，请确认后重新查询" ;
			return "queryCorp";
		}else{
			corpName = separateQualification.get(0).getCorpName();
			return "queryCorpQualification" ;
		}
		
	}
	
	/**
	 * 处理资质上报
	 * @return
	 */
	public String submitCertified() {
		
		ISeparateQualificationService service = new SeparateQualificationServiceImpl();
		Login login = (Login)this.get("login");
		separateQualification = service.queryEXCorpQualification(relationIds);//从基础库的证书表里查询被分立企业的资质信息
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
