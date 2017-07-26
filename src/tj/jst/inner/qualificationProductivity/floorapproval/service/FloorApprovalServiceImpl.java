package com.tj.jst.inner.qualificationProductivity.floorapproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.FloorApprovalDaoImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.IFloorApprovalDao;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��������������
 * 
 * @author DarkFlameMaster
 *
 */
public class FloorApprovalServiceImpl implements IFloorApprovalService {

	/**
	 * ��ҳ��
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * �鿴������ϸ
	 */
	@Override
	public NewQualification queryInfo(String id) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryInfo(id);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.approvalSuccess(floor, name);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.approvalFailed(floor, name);
	}

	/**
	 * ��ɸ���״̬
	 */
	@Override
	public String changeType(String approvalId, String type, String name,String approvalOpinion) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.changeType(approvalId, type, name, approvalOpinion);
	}

	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCretTypes();
	}

	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCretLevels();
	}

	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCretSequences();
	}

	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.querySpecialtyTypes(cretSequenceId);
	}

	@Override
	public List<DictionaryClass> queryCretGrades() {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCretGrades();
	}

	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryAddTypeNums();
	}

	@Override
	public int queryCountTitle(String userId) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCountTitle(userId);
	}

	@Override
	public int queryCountConstructor(String userId) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCountConstructor(userId);
	}

	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCountPositions(corpName);
	}

	@Override
	public int queryCountSkilledworker(String userId) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryCountSkilledworker(userId);
	}

	/**
	 * ���ʾ�λ����
	 */
	@Override
	public NewQualification querPerchInfo(String id) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryPerchInfo(id);
	}

	/**
	 * ���ʾ�λ����ͨ��
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.perchApprovalSuccess(id, op, name);
	}

	/**
	 * ���ʾ�λ������ͨ��
	 */
	@Override
	public String perchApprovalFailed(String id, String op, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.perchApprovalFailed(id, op, name);
	}

	@Override
	public List<NewQualification> batchApplythrough(String[] ids, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		List<NewQualification> list = dao.queryQualification(ids);
		return list ;
	}

}
