package com.tj.jst.inner.qualificationProductivity.cityApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������������
 * @author Administrator
 *
 */
public interface ICityApprovalService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public NewQualification queryapproval(String newQualId);
	/**
	 * ����ͨ��
	 * @return
	 */
	public void applythrough(NewQualification newQualification);
	/**
	 * �����˻�
	 * @return
	 */
	public void applyBack(NewQualification newQualification);

	//��ѯְ����Ա
	public int queryCountTitle(String userId);
	//��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId);
	//��ѯ��λ��Ա
	public int queryCountPositions(String corpName);
	//��ѯ������������
	public int queryCountSkilledworker(String userId);
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
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();
	//��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification);
	/**
	 * ��������
	 * @return
	 */
	public void batchApplythrough(String[] ids,String approvalStaff,String approvalStaffId);
}
