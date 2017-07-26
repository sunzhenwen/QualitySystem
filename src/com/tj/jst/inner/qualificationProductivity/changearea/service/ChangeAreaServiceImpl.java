package com.tj.jst.inner.qualificationProductivity.changearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.dao.ChangeAreaDaoImpl;
import com.tj.jst.inner.qualificationProductivity.changearea.dao.IChangeAreaDao;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * �������������ر������������
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeAreaServiceImpl implements IChangeAreaService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.approvalSuccess(change);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.approvalFailed(change);
	}

	/**
	 * ��ѯ��ʡ�б������
	 */
	@Override
	public String queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ����ͨ������֤����
	 */
	@Override
	public String changeCertificateCode(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.changeCertificateCode(change);
	}

	/**
	 * ��ת����ҳ��
	 */
	@Override
	public ChangeArea queryById(String changeId) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryById(changeId);
	}

	/**
	 * ������ҵ������
	 */
	@Override
	public Corp queryCorp(String corpName) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryCorp(corpName);
	}

	@Override
	public String changeCorpArea(Corp corp , String cityNum) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.changeCorpArea(corp,cityNum);
	}

}
