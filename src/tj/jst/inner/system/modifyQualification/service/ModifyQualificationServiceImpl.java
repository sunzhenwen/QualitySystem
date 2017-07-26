package com.tj.jst.inner.system.modifyQualification.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.inner.system.modifyQualification.dao.IModifyQualificationDao;
import com.tj.jst.inner.system.modifyQualification.dao.ModifyQualificationDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


public class ModifyQualificationServiceImpl implements IModifyQualificationService {

	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryCity(provinceId);
	}

	//֤������
	@Override
	public List<DictionaryClass> queryIdCardType() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryIdCardType();
	}

	//��ҵ�Ǽ�ע������
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryEconomicNum();
	}

	//ע���ʱ�����
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryPrincipalUnit();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryArea(cityId);
	}

	//��ѯ������ʡ������
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryHLJCitys();
	}

	/**
	 * ��ҵ������Ϣ�б�
	 */
	@Override
	public Page queryPage(ModifyQualificationCondition condition) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.queryPage(condition);
	}
	
	/**
	 * ��ת�޸�ҳ��
	 */
	@Override
	public NewQualification modifyApplication(String newQualId) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.modifyApplication(newQualId);
	}
	
	/**
	 * ��ҵ����������Ϣ�޸Ĳ���
	 */
	@Override
	public String modify(NewQualification newQualification) {
		// TODO Auto-generated method stub
		IModifyQualificationDao dao = new ModifyQualificationDaoImpl();
		return dao.modify(newQualification);
	}
	
}
