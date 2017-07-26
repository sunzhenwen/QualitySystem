package com.tj.jst.inner.qualificationProductivity.provinceApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.CertifiedCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.dao.ZJXTDao;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.dao.ZJXTDaoImpl;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.dao.IProvinceApprovalDao;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.dao.ProvinceApprovalDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.qualitychange.util.Tools;

/**
 * 省级资质审批
 * 
 * @author Administrator
 *
 */
public class ProvinceApprovalServiceImpl implements IProvinceApprovalService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}

	/**
	 * 跳转审批页面查询 (无需二级审批)
	 */
	public NewQualification queryApproval(String newQualId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryApproval(newQualId);
	}

	/**
	 * 审批通过(无需二级审批)
	 * 
	 * @return
	 */
	public void applyThrough(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		// 查询证书编号是否已经存在
		String certId = qualificationsApprovalDao.queryCertId(newQualification);
		// 如果未存在
		if (certId.equals("")) {
			int serNum = CertifiedCode.querySerNum();
			if (serNum != -1) {
				String certifiedCode = CertifiedCode.getCertifiedCode(
						newQualification.getEconomicNum() + "",
						newQualification.getCretGrade(), serNum);
				qualificationsApprovalDao.applyThrough(newQualification,
						certifiedCode);
			}
		} else {
			// 如果已存在
			qualificationsApprovalDao.applyThrough(newQualification, certId);
		}

		//审批状态推送省厅
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "批准");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//更新完结时间		
		
	}

	/**
	 * 申请退回(无需二级审批)
	 * 
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.applyThroughBack(newQualification);
		
		//审批状态推送省厅
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "不予批准");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//更新完结时间
		zjxtDao.updateRejectReason(newQualification.getNewQualId(), newQualification.getUltimateOpinion());
				
	}

	/**
	 * 审批通过(经过二级审批进行终审)
	 * 
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		// 查询证书编号是否已经存在
		String certId = qualificationsApprovalDao.queryCertId(newQualification);

		// 如果未存在
		if (certId.equals("")) {
			int serNum = CertifiedCode.querySerNum();
			if (serNum != -1) {
				String certifiedCode = CertifiedCode.getCertifiedCode(
						newQualification.getEconomicNum() + "",
						newQualification.getCretGrade(), serNum);
				qualificationsApprovalDao.applyUltimateThrough(
						newQualification, certifiedCode);
			}
		} else {
			qualificationsApprovalDao.applyUltimateThrough(newQualification,
					certId);
		}
		
		//审批状态推送省厅
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "批准");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//更新完结时间	
		
	}

	/**
	 * 申请退回(经过初审终审退回)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.applyUltimateThroughBack(newQualification);
		
		//审批状态推送省厅
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "不予批准");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//更新完结时间
		zjxtDao.updateRejectReason(newQualification.getNewQualId(), newQualification.getUltimateOpinion());
		
	}

	/**
	 * 推送外审
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.pushApply(newQualification);
	}

	// 查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}

	// 查询职称人员
	public int queryCountTitle(String userId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}

	// 查询注册建造师
	public int queryCountConstructor(String userName) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userName);
	}

	// 查询岗位人员
	public int queryCountPositions(String corpName) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}

	// 查询技术工人总数
	public int queryCountSkilledworker(String userId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}

	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	// 资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}

	// 资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}

	// 申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}

	// 查询技术工人list
	public Page querySkilledworker(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao
				.querySkilledworker(constructocondition);
	}

	// 查询注册建造师list
	public Page queryConstructor(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryConstructor(constructocondition);
	}

	// 职称人员
	public Page queryTitle(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryTitle(constructocondition);
	}

	// 岗位人员
	public Page queryPositions(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPositions(constructocondition);
	}

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public void batchApplythrough(String[] ids, String approvalStaff,
			String approvalStaffId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao
				.queryQualification(ids);

		for (int i = 0; i < list.size(); i++) {
			// 判断是否为二级审批资质
			if (!list.get(i).getTwoApprovalDept().trim().equals("0")) {
				// 判断是否经过初审
				if (list.get(i).getTwoApprovalStaffId() == null) {
					// 如果未经过初级审批，进行推送初审
					this.pushApply(list.get(i));
				} else {
					list.get(i).setApprovalStaff(approvalStaff);
					list.get(i).setApprovalStaffId(approvalStaffId);
					list.get(i).setUltimateOpinion("审批通过");
					// 否则进行终极审批
					this.applyUltimateThrough(list.get(i));
				}
			} else {
				list.get(i).setApprovalStaff(approvalStaff);
				list.get(i).setApprovalStaffId(approvalStaffId);
				list.get(i).setUltimateOpinion("审批通过");
				this.applyThrough(list.get(i));
			}
		}

	}

	/**
	 * 敢为人员数目
	 */
	@Override
	public List queryPositionsNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPositionsNum(corpName);
	}

	/**
	 * 查询重复的技术人员数目
	 */
	@Override
	public String querySkillworkerNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.querySkillworkerNum(corpName);
	}

	/**
	 * 查询重复的职称人员数目
	 */
	@Override
	public String queryTitleNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryTitleNum(corpName);
	}

	/**
	 * 查询重复的岗位人员数目
	 */
	@Override
	public String queryPosNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPosNum(corpName);
	}

	/**
	 * 重复技术人员输出
	 */
	@Override
	public Page skillworkerNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.skillworkerNum(condition);
	}

	/**
	 * 重复职称人员输出
	 */
	@Override
	public Page titleNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.titleNum(condition);
	}

	/**
	 * 重复岗位人员输出
	 */
	@Override
	public Page posNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.posNum(condition);
	}

}
