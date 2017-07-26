package com.tj.jst.inner.foreign.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;
import com.tj.jst.inner.foreign.service.CertifiedForeignCorpServiceImpl;
import com.tj.jst.inner.foreign.service.ICertifiedForeignCorpService;

/**
 * ������֤��������ҵ
 * @author DarkFlameMaster
 *
 */
@SuppressWarnings("serial")
public class CertifiedForeignCorpAction extends BaseAction {

	//��ҵ����
	private String corpName;
	//��ҵ
	private CertifiedForeignCorp corp;
	//������ʾ��Ϣ
	private String message;
	
	/**
	 * ������ҵ�޸�ҳ��
	 * @return
	 */
	public String modifyForeignCorpPage(){
		ICertifiedForeignCorpService foreignCorpService = new CertifiedForeignCorpServiceImpl();
		String corpId = (String)this.get("corpId");
		corp = foreignCorpService.queryCorp(corpId);
		return "certifiedForeignCorpModify";
	}
	
	/**
	 * ������ҵ�޸�
	 * @return
	 */
	public String modifyForeignCorp()
	{
		ICertifiedForeignCorpService foreignCorpService = new CertifiedForeignCorpServiceImpl();
		message = foreignCorpService.modifyCorp(corp);
		return "goBusiness";
	}
	
	/**
	 * ����ҵ�����ҳ��
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
