package com.tj.jst.inner.qualificationProductivity.queryPeople.action;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.dao.ZJXTDao;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.dao.ZJXTDaoImpl;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.model.ZJT_ZJXT_INS;
import com.tj.jst.inner.qualificationProductivity.floorapproval.condition.FloorApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.FloorApprovalServiceImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.IFloorApprovalService;
import com.tj.jst.inner.qualificationProductivity.queryPeople.dao.IQueryPeopleDao;
import com.tj.jst.inner.qualificationProductivity.queryPeople.service.IQueryPeopleService;
import com.tj.jst.inner.qualificationProductivity.queryPeople.service.QueryPeopleServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.qualitychange.util.Tools;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 大厅审批方法类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPeopleAction extends BaseAction {

	private String idCard ;
	private String message ;
	
	// 注册建造师
	private Constructor constructor;
	//岗位人员
	private Positions positions;
	// 注册技术工种
	private Skilledworker skilledworker;
	//职称人员
	private Title title;
	
	public String queryIDCard(){
		return "queryIDCard";
	}
	
	public String queryPeopleID(){
		
		IQueryPeopleService service = new QueryPeopleServiceImpl();
		
		constructor = service.queryConstructor(idCard);
		positions = service.queryPositions(idCard);
		skilledworker = service.querySkilledworker(idCard);
		title = service.queryTitle(idCard);
		
		if( constructor.getIdCard()== null && positions.getCardId()==null && skilledworker.getIdentityCard()==null && title.getIdCard()==null  ) {
			
			message = "查无此人！" ;
			return "queryIDCard" ;
			
		} else {
			
			return "queryPeople";
			
		}
		
	}
	
	public String goBack(){
		return "query" ;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Constructor getConstructor() {
		return constructor;
	}

	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}

	public Positions getPositions() {
		return positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

	public Skilledworker getSkilledworker() {
		return skilledworker;
	}

	public void setSkilledworker(Skilledworker skilledworker) {
		this.skilledworker = skilledworker;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	

}
