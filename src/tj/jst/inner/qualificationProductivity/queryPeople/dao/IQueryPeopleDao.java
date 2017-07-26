package com.tj.jst.inner.qualificationProductivity.queryPeople.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 大厅审批数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryPeopleDao {

	Constructor queryConstructor(String idCard);

	Positions queryPositions(String idCard);

	Skilledworker querySkilledworker(String idCard);

	Title queryTitle(String idCard);

	
}
