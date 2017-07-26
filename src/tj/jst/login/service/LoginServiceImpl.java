package com.tj.jst.login.service;

import java.util.List;

import com.tj.jst.login.dao.ILoginDao;
import com.tj.jst.login.dao.LoginDaoImpl;
import com.tj.jst.login.model.Login;

public class LoginServiceImpl implements ILoginService {
	
	@Override
	public Login query(String results) {
		ILoginDao loginDao = new LoginDaoImpl();
		return loginDao.query(results);
	}

	public List<String> getRole(String Ukey, String RoleSyetemID)
	{
		ILoginDao loginDao = new LoginDaoImpl();
		return loginDao.getRole(Ukey,RoleSyetemID);
	}

	/**
	 * ������ҵ���Ʋ�ѯ��ҵ����
	 * @param corpName
	 * @return
	 */
	@Override
	public String queryCorpByName(String corpName) {
		// TODO Auto-generated method stub
		ILoginDao loginDao = new LoginDaoImpl();
		return loginDao.queryCorpByName(corpName);
	}

	/**
	 * �������Ʋ�ѯ����
	 * @param corpName
	 * @return
	 */
	@Override
	public String queryDeptByName(String corpName) {
		// TODO Auto-generated method stub
		ILoginDao loginDao = new LoginDaoImpl();
		return loginDao.queryDeptByName(corpName);
	}
}
