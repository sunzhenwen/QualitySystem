package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
public interface IQualificationRevocationService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
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

	/**
	 * ��ת���ҳ��
	 * @param corpId
	 * @return
	 */
	public QualificationRevocation revocationPage(String relationId);

	/**
	 * ���ʴ�ز���
	 * @return
	 */
	public String revocation(QualificationRevocation qualificationRevocation);
	
}
