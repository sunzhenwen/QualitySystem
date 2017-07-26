package com.tj.jst.inner.qualificationProductivity.changearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.dao.ChangeAreaDaoImpl;
import com.tj.jst.inner.qualificationProductivity.changearea.dao.IChangeAreaDao;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 内网审批归属地变更审批服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeAreaServiceImpl implements IChangeAreaService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.approvalSuccess(change);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.approvalFailed(change);
	}

	/**
	 * 查询跨省市变更名称
	 */
	@Override
	public String queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * 审批通过更改证书编号
	 */
	@Override
	public String changeCertificateCode(ChangeArea change) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.changeCertificateCode(change);
	}

	/**
	 * 跳转审批页面
	 */
	@Override
	public ChangeArea queryById(String changeId) {
		// TODO Auto-generated method stub
		IChangeAreaDao dao = new ChangeAreaDaoImpl();
		return dao.queryById(changeId);
	}

	/**
	 * 更改企业归属地
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
