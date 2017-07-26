package com.tj.jst.inner.qualificationProductivity.floorapproval.action;

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
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.qualitychange.util.Tools;

/**
 * 大厅审批方法类
 * 
 * @author DarkFlameMaster
 *
 */
public class FloorApprovalAction extends BaseAction {

	private FloorApproval floor;// Model类
	private String id;// 查询主键
	private String op;// 审批意见
	private String message;// 返回信息
	private NewQualification newQualification;// 项目Model嘞
	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// 资质序列(字典表：TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	// 资质级别(字典表：TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	// 申请类型(字典表：TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// 职称人员总数
	private int countTitle;
	// 注册建造师总数
	private int countConstructor;
	// 技术工人总数
	private int countSkilledworker;
	// 岗位人员
	private int countPositions;

	private String acceptDate;
	
	private String[] ids ;
	
	private String certNames ;
	
	private String corpName ;
	
	private List<NewQualification> newQualifications ; 
	
	private List<FloorApproval> floors ;
	
	private FloorApprovalCondition condition = new FloorApprovalCondition();

	public void setCondition(FloorApprovalCondition condition) {
		this.condition = condition;
	}

	public FloorApprovalCondition getCondition() {
		FloorApprovalCondition sessionCondition = (FloorApprovalCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		this.queryDictionaryClass();
		return "queryPage";
	}

	/**
	 * 审批页面
	 * 
	 * @return
	 */
	public String queryInfoPage() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		newQualification = service.queryInfo(id);
		// 查询职称人员总数
		countTitle = service.queryCountTitle(newQualification.getCorpId());
		// 注册建造师总数
		countConstructor = service.queryCountConstructor(newQualification
				.getCorpName());
		// 查询技术工人总数
		countSkilledworker = service.queryCountSkilledworker(newQualification
				.getCorpId());
		// 岗位人员
		countPositions = service.queryCountPositions(newQualification
				.getCorpName());
		return "queryInfoPage";
	}

	public String queryPerchInfo() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		newQualification = service.querPerchInfo(id);
		return "queryPerchInfo";
	}

	/**
	 * 受理通过页面
	 * 
	 * @return
	 */
	public String successPage() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		newQualification = service.queryInfo(id);
		acceptDate = Tools.getCurrentDate();
		return "successPage";
	}

	public String perchSuccess() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalSuccess(id, op, login.getName());
		return "query";
	}

	/**
	 * 受理不通过页面
	 * 
	 * @return
	 */
	public String failPage() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		newQualification = service.queryInfo(id);
		acceptDate = Tools.getCurrentDate();
		return "failPage";
	}

	public String perchFail() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalFailed(id, op, login.getName());
		return "query";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		if( null != floors && floors.size() > 0 ){
			
			for( int i=0; i<floors.size(); i++ ){
				floors.get(i).setMes1(floor.getMes1());
				floors.get(i).setMes2(floor.getMes2());
				floors.get(i).setMes3(floor.getMes3());
				floors.get(i).setMes4(floor.getMes4());
				floors.get(i).setMes5(floor.getMes5());
				floors.get(i).setMes6(floor.getMes6());
				floors.get(i).setMes7(floor.getMes7());
				floors.get(i).setMes9(floor.getMes9());
				floors.get(i).setMes10(floor.getMes10());
				floors.get(i).setMes11(floor.getMes11());
				floors.get(i).setMes12(floor.getMes12());
				floors.get(i).setMes13(floor.getMes13());
				floors.get(i).setMes14(floor.getMes14());
				floors.get(i).setApprovalOpinion(floor.getApprovalOpinion());
				
				IFloorApprovalService service = new FloorApprovalServiceImpl();
				Login login = (Login) this.get("login");
				ZJXTDao zjxtDao = new ZJXTDaoImpl();
				ZJT_ZJXT_INS zjt_zjxt_ins = new ZJT_ZJXT_INS();
				zjt_zjxt_ins.setINSID(floors.get(i).getNewQualId());
				zjt_zjxt_ins.setAPPPERSONNAME(floors.get(i).getCorpName());
				zjt_zjxt_ins.setPROCESSNAME(floors.get(i).getCertName()); 
				zjt_zjxt_ins.setRECEVIEDTIME(Tools.getCurrentDate());
				// zjt_zjxt_ins.setSTARTTIME(Tools.getCurrentDate());
				// zjt_zjxt_ins.setCOMPLETETIME(Tools.getCurrentDate());
				// zjxtDao.queryCreateDate(floor.getNewQualId())
				zjt_zjxt_ins.setCREATETIME(Tools.getCurrentDate());
				zjt_zjxt_ins.setINSSTATE("待审核");
				floors.get(i).setApprovalPerson(login.getName());// 审批人员
				floors.get(i).setAppDept(login.getDepartment());// 审批部门
				floors.get(i).setApprovalDate(new Date(new java.util.Date().getTime()));// 审批时间
				message = service.approvalSuccess(floors.get(i), login.getName());
				if (message.equals("添加成功 ！")) {
					message = service.changeType(floors.get(i).getNewQualId(), "1",
							login.getName(),floors.get(i).getApprovalOpinion());
					zjxtDao.insertZjxt_Ins(zjt_zjxt_ins);
				}
			}
			
		}else{
			
			IFloorApprovalService service = new FloorApprovalServiceImpl();
			Login login = (Login) this.get("login");
			ZJXTDao zjxtDao = new ZJXTDaoImpl();
			ZJT_ZJXT_INS zjt_zjxt_ins = new ZJT_ZJXT_INS();
			zjt_zjxt_ins.setINSID(floor.getNewQualId());
			zjt_zjxt_ins.setAPPPERSONNAME(floor.getCorpName());
			zjt_zjxt_ins.setPROCESSNAME(floor.getCertName()); 
			zjt_zjxt_ins.setRECEVIEDTIME(Tools.getCurrentDate());
			// zjt_zjxt_ins.setSTARTTIME(Tools.getCurrentDate());
			// zjt_zjxt_ins.setCOMPLETETIME(Tools.getCurrentDate());
			// zjxtDao.queryCreateDate(floor.getNewQualId())
			zjt_zjxt_ins.setCREATETIME(Tools.getCurrentDate());
			zjt_zjxt_ins.setINSSTATE("待审核");
			floor.setApprovalPerson(login.getName());// 审批人员
			floor.setAppDept(login.getDepartment());// 审批部门
			floor.setApprovalDate(new Date(new java.util.Date().getTime()));// 审批时间
			message = service.approvalSuccess(floor, login.getName());
			if (message.equals("添加成功 ！")) {
				message = service.changeType(floor.getNewQualId(), "1",
						login.getName(),floor.getApprovalOpinion());
				zjxtDao.insertZjxt_Ins(zjt_zjxt_ins);
			}
		}

		return "query";
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		Login login = (Login) this.get("login");
		ZJXTDao zjxtDao = new ZJXTDaoImpl();
		ZJT_ZJXT_INS zjt_zjxt_ins = new ZJT_ZJXT_INS();
		zjt_zjxt_ins.setINSID(floor.getNewQualId());
		zjt_zjxt_ins.setAPPPERSONNAME(floor.getCorpName());
		zjt_zjxt_ins.setPROCESSNAME(floor.getCertName());
		zjt_zjxt_ins.setRECEVIEDTIME(acceptDate);
		zjt_zjxt_ins.setSTARTTIME(acceptDate);
		zjt_zjxt_ins.setCOMPLETETIME(Tools.getCurrentDate());
		zjt_zjxt_ins.setCREATETIME(acceptDate);
		zjt_zjxt_ins.setINSSTATE("不予受理");
		zjt_zjxt_ins.setREJECTREASON(floor.getApprovalOpinion());
		floor.setApprovalPerson(login.getName());// 审批人员
		floor.setAppDept(login.getDepartment());// 审批部门
		floor.setApprovalDate(new Date(new java.util.Date().getTime()));// 审批时间
		message = service.approvalFailed(floor, login.getName());
		if (message.equals("添加成功 ！")) {
			message = service.changeType(floor.getNewQualId(), "b",
					login.getName(),floor.getApprovalOpinion());
			zjxtDao.insertZjxt_Ins_Oracle(zjt_zjxt_ins);
		}
		return "query";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass() {
		IFloorApprovalService certifiedService = new FloorApprovalServiceImpl();
		// 资质类型(字典表：TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		// 资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		// 资质序列(字典表：TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		// 资质级别(字典表：TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		// 申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}
	
	/**
	 * 批量审批
	 */
	public String batchApplythrough() {
		IFloorApprovalService service = new FloorApprovalServiceImpl();
		Login login = (Login) this.get("login");
		System.out.println("ids = " + Arrays.toString(ids));
		newQualifications = service.batchApplythrough(ids , login.getName());
		if(null==newQualifications){
			message = "请选择同一加企业进行批量审批！";
			currentPage = service.queryPage(condition);
			this.set(getActionName(), condition);
			this.queryDictionaryClass();
			return "queryPage" ;
		}
		corpName = newQualifications.get(0).getCorpName();
		return "successPage";
	}

	public FloorApproval getFloor() {
		return floor;
	}

	public void setFloor(FloorApproval floor) {
		this.floor = floor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
	}

	public List<DictionaryClass> getCretTypes() {
		return cretTypes;
	}

	public void setCretTypes(List<DictionaryClass> cretTypes) {
		this.cretTypes = cretTypes;
	}

	public List<DictionaryClass> getCretLevels() {
		return cretLevels;
	}

	public void setCretLevels(List<DictionaryClass> cretLevels) {
		this.cretLevels = cretLevels;
	}

	public List<DictionaryClass> getCretSequences() {
		return cretSequences;
	}

	public void setCretSequences(List<DictionaryClass> cretSequences) {
		this.cretSequences = cretSequences;
	}

	public List<DictionaryClass> getSpecialtyTypes() {
		return specialtyTypes;
	}

	public void setSpecialtyTypes(List<DictionaryClass> specialtyTypes) {
		this.specialtyTypes = specialtyTypes;
	}

	public List<DictionaryClass> getCretGrades() {
		return cretGrades;
	}

	public void setCretGrades(List<DictionaryClass> cretGrades) {
		this.cretGrades = cretGrades;
	}

	public List<DictionaryClass> getAddTypeNums() {
		return addTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		this.addTypeNums = addTypeNums;
	}

	public int getCountTitle() {
		return countTitle;
	}

	public void setCountTitle(int countTitle) {
		this.countTitle = countTitle;
	}

	public int getCountConstructor() {
		return countConstructor;
	}

	public void setCountConstructor(int countConstructor) {
		this.countConstructor = countConstructor;
	}

	public int getCountSkilledworker() {
		return countSkilledworker;
	}

	public void setCountSkilledworker(int countSkilledworker) {
		this.countSkilledworker = countSkilledworker;
	}

	public int getCountPositions() {
		return countPositions;
	}

	public void setCountPositions(int countPositions) {
		this.countPositions = countPositions;
	}

	public String getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getCertNames() {
		return certNames;
	}

	public void setCertNames(String certNames) {
		this.certNames = certNames;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public List<NewQualification> getNewQualifications() {
		return newQualifications;
	}

	public void setNewQualifications(List<NewQualification> newQualifications) {
		this.newQualifications = newQualifications;
	}

	public List<FloorApproval> getFloors() {
		return floors;
	}

	public void setFloors(List<FloorApproval> floors) {
		this.floors = floors;
	}


}
