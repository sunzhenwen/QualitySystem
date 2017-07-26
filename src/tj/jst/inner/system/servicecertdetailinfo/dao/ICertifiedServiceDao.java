package com.tj.jst.inner.system.servicecertdetailinfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
public interface ICertifiedServiceDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @param certifiedService
	 */
	public void addCertifiedService(CertifiedService certifiedService);
	
	/**
	 * ��ѯ����
	 * @param certifiedService
	 */
	public CertifiedService queryById(String certId);
	
	/**
	 * �޸�
	 * @param certifiedService
	 */
	public void modifyCertifiedService(CertifiedService certifiedService);
	
	/**
	 * ɾ��
	 */
	public void delectCertifiedService(String[] certIds);
	
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCretTypes();
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
	//��������(�ֵ��TBTRADETYPEDIC)
	public List<DictionaryClass> queryCretSequences();
	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId);
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades();
	
	public List<Department> getDepartment();
}
