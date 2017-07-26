package com.tj.jst.outside.corpinto.foreign.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;
import com.tj.jst.outside.corpinto.foreign.service.ForeignCorpServiceImpl;
import com.tj.jst.outside.corpinto.foreign.service.IForeignCorpService;
/**
 * ����Ͷ����ҵ
 * @author Administrator
 *
 */
public class ForeignCorpAction extends BaseAction{
	
	//������ҵ��֯��������
	private String corpCode;
	//����Ͷ����ҵ
	private ForeignCorp foreignCorp;
	//���������
	private List<DictionaryClass> nations;
	//ע���ʱ�����
	private List<DictionaryClass> principalUnit;
	//����ID
	private String nationId;
	//����Ͷ��������
	private List<DictionaryClass> ivestors;
	//��ʾ��Ϣ
	private String message;
	//���ؽ��
	private String result;
	
	
	/**
	 * ��������ҵ���
	 * @return
	 */
	public String addForeignCorp(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		message = foreignCorpService.addForeignCorp(foreignCorp);
		return "addForeignCorp";
	}
	
	/**
	 * ������ҵ�޸�
	 * @return
	 */
	public String modifyforeginCorp()
	{
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		message = foreignCorpService.modifyForeignCorp(foreignCorp);
		return "modifyForeignCorp";
	}
	
	/**
	 * ��ת������ҵע������ͼҳ��
	 * @return
	 */
	public String foreignFlowChart()
	{
		return "foreignFlowChart";
	}
	
	/**
	 * ��ת��֯��������֤��ѯҳ��
	 * @return
	 */
	public String queryCorpNamePage()
	{
		return "queryCorpNamePage";
	}
	
	/**
	 * ��ת������½ҳ��
	 * @return
	 */
	public String queryOutLoginPage()
	{
		return "outLogin";
	}
	
	/**
	 * ��֯���������ѯ
	 * @return
	 */
	public String queryForeignCorpName(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		foreignCorp = foreignCorpService.queryCorpName(corpCode);
		String returnPage = "";
		
		//���ص�½ҳ��
		if(foreignCorp.getCheckType() == 0){
			returnPage = "outLogin";
		}
		//��ת�޸�ҳ��
		if(foreignCorp.getCheckType() == 1){
			//��ѯ���������
			nations = foreignCorpService.queryNation();
			this.queryDictionary();
			returnPage = "foreignCorpModify";
		}
		//��תע�����ҳ��
		if(foreignCorp.getCheckType() == 2){
			//��ѯ���������
			nations = foreignCorpService.queryNation();
			this.queryDictionary();
			returnPage = "foreignCorpAdd";
		}
		return returnPage;
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionary(){
		IForeignCorpService foreignCorpService = new ForeignCorpServiceImpl();
		//ע���ʱ�����
		principalUnit = foreignCorpService.queryPrincipalUnit();
		//����Ͷ������
		ivestors = foreignCorpService.queryIvestor();
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public ForeignCorp getForeignCorp() {
		return foreignCorp;
	}

	public void setForeignCorp(ForeignCorp foreignCorp) {
		this.foreignCorp = foreignCorp;
	}

	public List<DictionaryClass> getNations() {
		return nations;
	}

	public void setNations(List<DictionaryClass> nations) {
		this.nations = nations;
	}

	public List<DictionaryClass> getPrincipalUnit() {
		return principalUnit;
	}

	public void setPrincipalUnit(List<DictionaryClass> principalUnit) {
		this.principalUnit = principalUnit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}
	public List<DictionaryClass> getIvestors() {
		return ivestors;
	}

	public void setIvestors(List<DictionaryClass> ivestors) {
		this.ivestors = ivestors;
	}

	

}
