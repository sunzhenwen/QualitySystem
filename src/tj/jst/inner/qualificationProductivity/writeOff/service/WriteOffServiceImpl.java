package com.tj.jst.inner.qualificationProductivity.writeOff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.writeOff.dao.IWriteOffDao;
import com.tj.jst.inner.qualificationProductivity.writeOff.dao.WriteOffDaoImpl;

/**
 * ��ҵ����ע��
 * @author Administrator
 *
 */
public class WriteOffServiceImpl implements IWriteOffService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IWriteOffDao dao = new WriteOffDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * ��ת����ҳ���ѯ
	 */
	public CertificatePrint approvalPage(String corpCertId)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		return dao.approvalPage(corpCertId);
	}
	
	/**
	 * ����ͨ��
	 */
	public void applythrough(CertificatePrint certificatePrint,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.applythrough(certificatePrint,personalId,personalName);
	}
	
	/**
	 * ��������ͨ��
	 */
	@Override
	public void floorApplythrough(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.floorApplythrough(certificatePrint,personalID,personalName);
		
	}

	/**
	 * �����˻�
	 */
	public void applyBack(CertificatePrint certificatePrint,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.applyBack(certificatePrint,personalId,personalName);
	}
	
	/**
	 * ���������˻�
	 */
	@Override
	public void floorApplyBack(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.floorApplyBack(certificatePrint,personalID,personalName);
		
	}

	/**
	 * ��������
	 * @return
	 */
	public void baseBatchWriteOff(String[] ids,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseBatchWriteOff(list,personalId,personalName);
	}
	
	/**
	 * ������������
	 */
	@Override
	public void floorBaseBatchWriteOff(String[] ids, String personalId,
			String personalName) {
		// TODO Auto-generated method stub
		IWriteOffDao dao = new WriteOffDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.floorBaseBatchWriteOff(list,personalId,personalName);
	}

	
	/**
	 * �����˻�
	 * @return
	 */
	public void batchWriteOffReturn(String[] ids,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseWriteOffReturn(list,personalId,personalName);
	}
	
	@Override
	public List<DictionaryClass> queryEconmicNums() {
		IWriteOffDao dao = new WriteOffDaoImpl();
		return dao.queryEconmicNums();
	}


	

	
}
