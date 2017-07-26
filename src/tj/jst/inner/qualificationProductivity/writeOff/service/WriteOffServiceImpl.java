package com.tj.jst.inner.qualificationProductivity.writeOff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.writeOff.dao.IWriteOffDao;
import com.tj.jst.inner.qualificationProductivity.writeOff.dao.WriteOffDaoImpl;

/**
 * 企业资质注销
 * @author Administrator
 *
 */
public class WriteOffServiceImpl implements IWriteOffService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IWriteOffDao dao = new WriteOffDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * 跳转审批页面查询
	 */
	public CertificatePrint approvalPage(String corpCertId)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		return dao.approvalPage(corpCertId);
	}
	
	/**
	 * 审批通过
	 */
	public void applythrough(CertificatePrint certificatePrint,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.applythrough(certificatePrint,personalId,personalName);
	}
	
	/**
	 * 大厅审批通过
	 */
	@Override
	public void floorApplythrough(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.floorApplythrough(certificatePrint,personalID,personalName);
		
	}

	/**
	 * 申请退回
	 */
	public void applyBack(CertificatePrint certificatePrint,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.applyBack(certificatePrint,personalId,personalName);
	}
	
	/**
	 * 大厅申请退回
	 */
	@Override
	public void floorApplyBack(CertificatePrint certificatePrint,
			String personalID, String personalName) {
		// TODO Auto-generated method stub
		IWriteOffDao dao = new WriteOffDaoImpl();
		dao.floorApplyBack(certificatePrint,personalID,personalName);
		
	}

	/**
	 * 批量审批
	 * @return
	 */
	public void baseBatchWriteOff(String[] ids,String personalId,String personalName)
	{
		IWriteOffDao dao = new WriteOffDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseBatchWriteOff(list,personalId,personalName);
	}
	
	/**
	 * 大厅批量审批
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
	 * 批量退回
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
