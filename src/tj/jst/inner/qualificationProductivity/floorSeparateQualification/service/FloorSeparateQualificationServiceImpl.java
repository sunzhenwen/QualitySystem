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
 * 大厅受理换证服务类
 * 
 * @author Administrator
 *
 */
public class FloorSeparateQualificationServiceImpl implements IFloorSeparateQualificationService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 资质审批
	 */
	@Override
	public NewQualification queryPerchInfo(String id) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryPerchInfo(id);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.perchApprovalSuccess(id, op , name);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String perchApprovalFailed(String id, String op , String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.perchApprovalFailed(id, op , name);
	}

	/**
	 * 批量审批 2016-4-5修改
	 */
	@Override
	public void batchApplythrough(String[] ids ,String name) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		List<NewQualification> list = dao.queryQualification(ids);
		
		dao.batchApplythrough(list,name);
		
		
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).setFloorOp("通过");
//			this.perchApprovalSuccess(list.get(i).getNewQualId(), list.get(i)
//					.getFloorOp(),name);
//		}
	}

	/**
	 * 查询职称人员
	 */
	@Override
	public int queryCountTitle(String userId) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountTitle(userId);
	}

	/**
	 * 查询建造师
	 */
	@Override
	public int queryCountConstructor(String userName) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountConstructor(userName);
	}

	/**
	 * 查询岗位人员
	 */
	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		IFloorSeparateQualificationDao dao = new FloorSeparateQualificationDaoImpl();
		return dao.queryCountPositions(corpName);
	}

	/**
	 * 查询技术人员
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
