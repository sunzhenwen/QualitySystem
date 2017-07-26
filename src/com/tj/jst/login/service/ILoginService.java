package com.tj.jst.login.service;

import java.util.List;

import com.tj.jst.login.model.Login;



public interface ILoginService {
	
	public Login query(String results);
	
	public List<String> getRole(String Ukey, String RoleSyetemID);

	/**
	 * ������ҵ���Ʋ�ѯ��ҵ����
	 * @param corpName
	 * @return
	 */
	public String queryCorpByName(String corpName);

	/**
	 * �������Ʋ�ѯ����
	 * @param corpName
	 * @return
	 */
	public String queryDeptByName(String corpName);
}
