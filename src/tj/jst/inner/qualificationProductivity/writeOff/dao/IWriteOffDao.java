package com.tj.jst.inner.qualificationProductivity.writeOff.dao;

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
public interface IWriteOffDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<CertificatePrint> queryCertinfo(String[] ids);
	public void applythrough(CertificatePrint certificatePrint,String personalId,String personalName);
	public void applyBack(CertificatePrint certificatePrint,String personalId,String personalName);

	public void baseBatchWriteOff(List<CertificatePrint> list,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
	public CertificatePrint approvalPage(String corpCertId);
	public void baseWriteOffReturn(List<CertificatePrint> list,String personalId,String personalName);
	public void floorApplythrough(CertificatePrint certificatePrint, String personalID, String personalName);
	public void floorApplyBack(CertificatePrint certificatePrint,
			String personalID, String personalName);
	public void floorBaseBatchWriteOff(List<CertificatePrint> list,
			String personalId, String personalName);
}
