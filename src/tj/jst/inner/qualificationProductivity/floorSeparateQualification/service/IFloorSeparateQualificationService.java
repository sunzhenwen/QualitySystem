package com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��������֤����
 * 
 * @author Administrator
 *
 */
public interface IFloorSeparateQualificationService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ������ϸ
	 * 
	 * @param id
	 * @return
	 */
	public NewQualification queryPerchInfo(String id);

	/**
	 * ����ͨ��
	 * 
	 * @param id
	 * @param op
	 * @return
	 */
	public String perchApprovalSuccess(String id, String op,String name);

	/**
	 * ������ͨ��
	 * 
	 * @param id
	 * @param op
	 * @return
	 */
	public String perchApprovalFailed(String id, String op,String name);

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void batchApplythrough(String[] ids , String name);

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

	/**
	 * ��ѯ��ҵ��Ϣ
	 * 
	 * @param corpCode
	 * @return
	 */
	public CorpInfo queryCorpInfo(String corpCode);
}
