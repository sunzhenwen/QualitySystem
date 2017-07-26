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
 * 大厅审批服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class FloorApprovalServiceImpl implements IFloorApprovalService {

	/**
	 * 分页类
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查看审批详细
	 */
	@Override
	public NewQualification queryInfo(String id) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryInfo(id);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.approvalSuccess(floor, name);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.approvalFailed(floor, name);
	}

	/**
	 * 完成更改状态
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
	 * 资质就位审批
	 */
	@Override
	public NewQualification querPerchInfo(String id) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.queryPerchInfo(id);
	}

	/**
	 * 资质就位审批通过
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		IFloorApprovalDao dao = new FloorApprovalDaoImpl();
		return dao.perchApprovalSuccess(id, op, name);
	}

	/**
	 * 资质就位审批不通过
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
