package com.tj.jst.inner.qualificationProductivity.innerchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.dao.IInnerChangeAreaDao;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.dao.InnerChangeAreaDaoImpl;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ���������޸���ҵ�����ط��񷽷�
 * 
 * @author DarkFlameMaster
 *
 */
public class InnerChangeAreaServiceImpl implements IInnerChangeAreaService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ��ҵ��Ϣ
	 */
	@Override
	public Corp queryCorp(String corpCode) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryCorp(corpCode);
	}

	/**
	 * ������ҵ������
	 */
	@Override
	public String changeArea(String corpCode, String cityNum) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.changeArea(corpCode, cityNum);
	}

	/**
	 * ��¼������־
	 */
	@Override
	public String recordLog(InnerChangeArea info) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.recordLog(info);
	}

	/**
	 * ��־��ѯ
	 */
	@Override
	public Page queryInfoPage(Condition condition) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryInfoPage(condition);
	}

}
