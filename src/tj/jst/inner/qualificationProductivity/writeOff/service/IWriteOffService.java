package com.tj.jst.inner.qualificationProductivity.writeOff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ��ҵ����ע��
 * @author Administrator
 *
 */
public interface IWriteOffService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	
	/**
	 * ��������
	 * @return
	 */
	public void baseBatchWriteOff(String[] ids,String personalId,String personalName);
	public void floorBaseBatchWriteOff(String[] ids,String personalId,String personalName);
	public CertificatePrint approvalPage(String corpCertId);
	public void applythrough(CertificatePrint certificatePrint,String personalId,String personalName);
	public void applyBack(CertificatePrint certificatePrint,String personalId,String personalName);
	public void batchWriteOffReturn(String[] ids,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
	public void floorApplythrough(CertificatePrint certificatePrint, String personalID, String personalName);


	public void floorApplyBack(CertificatePrint certificatePrint,
			String personalID, String personalName);
}
