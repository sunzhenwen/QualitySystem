package com.tj.jst.inner.foreign.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;
import com.tj.jst.inner.foreign.service.CertifiedForeignCorpServiceImpl;
import com.tj.jst.inner.foreign.service.ICertifiedForeignCorpService;

/**
 * 经过认证的外商企业
 * @author DarkFlameMaster
 *
 */
@SuppressWarnings("serial")
public class CertifiedForeignCorpAction extends BaseAction {

	//企业名称
	private String corpName;
	//企业
	private CertifiedForeignCorp corp;
	//返回提示信息
	private String message;
	
	/**
	 * 外商企业修改页面
	 * @return
	 */
	public String modifyForeignCorpPage(){
		ICertifiedForeignCorpService foreignCorpService = new CertifiedForeignCorpServiceImpl();
		String corpId = (String)this.get("corpId");
		corp = foreignCorpService.queryCorp(corpId);
		return "certifiedForeignCorpModify";
	}
	
	/**
	 * 外商企业修改
	 * @return
	 */
	public String modifyForeignCorp()
	{
		ICertifiedForeignCorpService foreignCorpService = new CertifiedForeignCorpServiceImpl();
		message = foreignCorpService.modifyCorp(corp);
		return "goBusiness";
	}
	
	/**
	 * 返回业务办理页面
	 * @return
	 */
	public String goBusiness()
	{
		return "goBusiness";
	}


	public String getCorpName() {
		return corpName;
	}


	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}


	public CertifiedForeignCorp getCorp() {
		return corp;
	}


	public void setCorp(CertifiedForeignCorp corp) {
		this.corp = corp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
