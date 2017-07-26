package com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.dao.FloorSeparateQualificationDaoImpl;
import com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.dao.IFloorSeparateQualificationDao;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��������֤������
 * 
 * @author Administrator
 *
 */
public class FloorSeparateQualificationServiceImpl implements IFloorSeparateQualificationService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��������
	 */
	@Override
	public NewQualification queryPerchInfo(String id) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryPerchInfo(id);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.perchApprovalSuccess(id, op , name);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String perchApprovalFailed(String id, String op , String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.perchApprovalFailed(id, op , name);
	}

	/**
	 * �������� 2016-4-5�޸�
	 */
	@Override
	public void batchApplythrough(String[] ids ,String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		List<NewQualification> list = dao.queryQualification(ids);
		
		dao.batchApplythrough(list,name);
		
		
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).setFloorOp("ͨ��");
//			this.perchApprovalSuccess(list.get(i).getNewQualId(), list.get(i)
//					.getFloorOp(),name);
//		}
	}

	/**
	 * ��ѯְ����Ա
	 */
	@Override
	public int queryCountTitle(String userId) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountTitle(userId);
	}

	/**
	 * ��ѯ����ʦ
	 */
	@Override
	public int queryCountConstructor(String userName) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountConstructor(userName);
	}

	/**
	 * ��ѯ��λ��Ա
	 */
	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountPositions(corpName);
	}

	/**
	 * ��ѯ������Ա
	 */
	@Override
	public int queryCountSkilledworker(String userId) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountSkilledworker(userId);
	}

	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCretTypes();
	}

	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCretLevels();
	}

	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCretSequences();
	}

	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.querySpecialtyTypes(cretSequenceId);
	}

	@Override
	public List<DictionaryClass> queryCretGrades() {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCretGrades();
	}

	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryAddTypeNums();
	}

	@Override
	public CorpInfo queryCorpInfo(String corpCode) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCorpInfo(corpCode);
	}

}
