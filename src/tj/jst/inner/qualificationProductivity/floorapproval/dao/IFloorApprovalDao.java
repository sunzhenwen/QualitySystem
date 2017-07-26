package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * �����������ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IFloorApprovalDao {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public NewQualification queryInfo(String id);

	public NewQualification queryPerchInfo(String id);

	/**
	 * ����ͨ��
	 * 
	 * @param floor
	 * @return
	 */
	public String approvalSuccess(FloorApproval floor , String name);

	public String perchApprovalSuccess(String id , String op , String name);

	/**
	 * ������ͨ��
	 * 
	 * @param floor
	 * @return
	 */
	public String approvalFailed(FloorApproval floor , String name);

	public String perchApprovalFailed(String id , String op , String name);

	/**
	 * ������ɺ����״̬
	 * 
	 * @param approvalId
	 * @param approvalOpinion 
	 * @return
	 */
	public String changeType(String approvalId, String type , String name, String approvalOpinion);

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

	// ��ѯְ����Ա
	public int queryCountTitle(String userId);

	// ��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId);

	// ��ѯ��λ��Ա
	public int queryCountPositions(String corpName);

	// ��ѯ������������
	public int queryCountSkilledworker(String userId);

	// ����ids�������ύ�����ʷ�������
	public List<NewQualification> queryQualification(String[] ids);

}
