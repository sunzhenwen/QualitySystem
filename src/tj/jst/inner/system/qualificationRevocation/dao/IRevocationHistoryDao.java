package com.tj.jst.inner.system.qualificationRevocation.dao;

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
public interface IRevocationHistoryDao {
	
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
	 * ���ʴ����ʷ
	 * @param historyCondition
	 * @return
	 */
	public Page pagedQueryHistory(RevocationHistoryCondition historyCondition);
	
	/**
	 * ���ʴ����ʷ��ϸ
	 * @param revocationId
	 * @return
	 */
	public QualificationRevocation revocationHistoryPage(String revocationId);
}
