package com.tj.jst.inner.system.modifyQualification.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.inner.system.modifyQualification.dao.IModifyQualificationDao;
import com.tj.jst.inner.system.modifyQualification.dao.ModifyQualificationDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


public class ModifyQualificationServiceImpl implements IModifyQualificationService {

	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryCity(provinceId);
	}

	//证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryIdCardType();
	}

	//企业登记注册类型
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryEconomicNum();
	}

	//注册资本币种
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryPrincipalUnit();
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryArea(cityId);
	}

	//查询黑龙江省所有市
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryHLJCitys();
	}

	/**
	 * 企业申请信息列表
	 */
	@Override
	public Page queryPage(ModifyQualificationCondition condition) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryPage(condition);
	}
	
	/**
	 * 跳转修改页面
	 */
	@Override
	public NewQualification modifyApplication(String newQualId) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.modifyApplication(newQualId);
	}
	
	/**
	 * 企业资质申请信息修改操作
	 */
	@Override
	public String modify(NewQualification newQualification) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.modify(newQualification);
	}
	
}
