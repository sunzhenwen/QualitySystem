package com.tj.jst.inner.qualificationProductivity.queryPeople.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.FloorApprovalDaoImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.IFloorApprovalDao;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.queryPeople.dao.IQueryPeopleDao;
import com.tj.jst.inner.qualificationProductivity.queryPeople.dao.QueryPeopleDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 大厅审批服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPeopleServiceImpl implements IQueryPeopleService {

	@Override
	public Constructor queryConstructor(String idCard) {
		// TODO Auto-generated method stub
		IQueryPeopleDao dao = new QueryPeopleDaoImpl();
		return dao.queryConstructor( idCard );
	}

	@Override
	public Positions queryPositions(String idCard) {
		// TODO Auto-generated method stub
		IQueryPeopleDao dao = new QueryPeopleDaoImpl();
		return dao.queryPositions( idCard );
	}

	@Override
	public Skilledworker querySkilledworker(String idCard) {
		// TODO Auto-generated method stub
		IQueryPeopleDao dao = new QueryPeopleDaoImpl();
		return dao.querySkilledworker( idCard );
	}

	@Override
	public Title queryTitle(String idCard) {
		// TODO Auto-generated method stub
		IQueryPeopleDao dao = new QueryPeopleDaoImpl();
		return dao.queryTitle( idCard );
	}

	
}
