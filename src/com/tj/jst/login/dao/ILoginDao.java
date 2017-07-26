package com.tj.jst.login.dao;

import java.util.List;

import com.tj.jst.login.model.Login;


public interface ILoginDao {
	
	public Login query(String results);
	
	public List<String> getRole(String Ukey, String RoleSyetemID);

	/**
	 * 根据企业名称查询企业锁号
	 * @param corpName
	 * @return
	 */
	public String queryCorpByName(String corpName);

	/**
	 * 根据名称查询部门
	 * @param corpName
	 * @return
	 */
	public String queryDeptByName(String corpName);
}
