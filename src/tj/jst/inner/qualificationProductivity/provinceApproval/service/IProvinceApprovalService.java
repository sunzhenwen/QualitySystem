package com.tj.jst.inner.qualificationProductivity.provinceApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ʡ����������
 * 
 * @author Administrator
 *
 */
public interface IProvinceApprovalService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ��ת����ҳ��(�����������)
	 * 
	 * @return
	 */
	public NewQualification queryApproval(String newQualId);

	/**
	 * ����ͨ��(�����������)
	 * 
	 * @return
	 */
	public void applyThrough(NewQualification newQualification);

	/**
	 * �����˻�(�����������)
	 * 
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification);

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification);

	/**
	 * ����ͨ��(��������������������)
	 * 
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification);

	/**
	 * �����˻�(�������������˻�)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification);

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void batchApplythrough(String[] ids, String approvalStaff,
			String approvalStaffId);

	// ��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification);

	// ��ѯְ����Ա
	public int queryCountTitle(String userId);

	// ��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userName);

	// ��ѯ��λ��Ա
	public int queryCountPositions(String corpName);

	// ��ѯ������������
	public int queryCountSkilledworker(String userId);

	// ��������(�ֵ��TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCretTypes();

	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();

	// ��������(�ֵ��TBTRADETYPEDIC)
	public List<DictionaryClass> queryCretSequences();

	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId);

	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades();

	// ��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();

	// ��ѯע�Ὠ��ʦlist
	public Page queryConstructor(Condition constructocondition);

	// ��������list
	public Page querySkilledworker(Condition constructocondition);

	// ְ����Ա
	public Page queryTitle(Condition constructocondition);

	// ��λ��Ա
	public Page queryPositions(Condition constructocondition);

	// ��λ��Ա��Ŀ
	public List queryPositionsNum(String corpName);

	/**
	 * ��ѯ�ظ��ļ���������Ŀ
	 * 
	 * @param corpName
	 * @return
	 */
	public String querySkillworkerNum(String corpName);

	/**
	 * ��ѯ�ظ���ְ����Ա��Ŀ
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryTitleNum(String corpName);

	/**
	 * ��ѯ�ظ��ĸ�λ��Ա��Ŀ
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryPosNum(String corpName);

	/**
	 * �ظ���Ա���
	 * 
	 * @param condition
	 * @return
	 */
	public Page skillworkerNum(Condition condition);

	/**
	 * �ظ�ְ����Ա���
	 * 
	 * @param condition
	 * @return
	 */
	public Page titleNum(Condition condition);

	/**
	 * �ظ���λ��Ա���
	 * 
	 * @param condition
	 * @return
	 */
	public Page posNum(Condition condition);

}
