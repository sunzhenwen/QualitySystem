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
 * ʡ����������
 * 
 * @author Administrator
 *
 */
public class ProvinceApprovalServiceImpl implements IProvinceApprovalService {

	/**
	 * ��ѯ
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
	 * ��ת����ҳ���ѯ (�����������)
	 */
	public NewQualification queryApproval(String newQualId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryApproval(newQualId);
	}

	/**
	 * ����ͨ��(�����������)
	 * 
	 * @return
	 */
	public void applyThrough(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		// ��ѯ֤�����Ƿ��Ѿ�����
		String certId = qualificationsApprovalDao.queryCertId(newQualification);
		// ���δ����
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
			// ����Ѵ���
			qualificationsApprovalDao.applyThrough(newQualification, certId);
		}

		//����״̬����ʡ��
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "��׼");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//�������ʱ��		
		
	}

	/**
	 * �����˻�(�����������)
	 * 
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.applyThroughBack(newQualification);
		
		//����״̬����ʡ��
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "������׼");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//�������ʱ��
		zjxtDao.updateRejectReason(newQualification.getNewQualId(), newQualification.getUltimateOpinion());
				
	}

	/**
	 * ����ͨ��(��������������������)
	 * 
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		// ��ѯ֤�����Ƿ��Ѿ�����
		String certId = qualificationsApprovalDao.queryCertId(newQualification);

		// ���δ����
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
		
		//����״̬����ʡ��
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "��׼");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//�������ʱ��	
		
	}

	/**
	 * �����˻�(�������������˻�)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.applyUltimateThroughBack(newQualification);
		
		//����״̬����ʡ��
		ZJXTDao zjxtDao=new ZJXTDaoImpl();
		zjxtDao.updateInsState(newQualification.getNewQualId(), "������׼");
		zjxtDao.updateCompleteTime(newQualification.getNewQualId(), Tools.getCurrentDate());//�������ʱ��
		zjxtDao.updateRejectReason(newQualification.getNewQualId(), newQualification.getUltimateOpinion());
		
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		qualificationsApprovalDao.pushApply(newQualification);
	}

	// ��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}

	// ��ѯְ����Ա
	public int queryCountTitle(String userId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}

	// ��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userName) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userName);
	}

	// ��ѯ��λ��Ա
	public int queryCountPositions(String corpName) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}

	// ��ѯ������������
	public int queryCountSkilledworker(String userId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}

	// ��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	// ��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}

	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}

	// ��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums() {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}

	// ��ѯ��������list
	public Page querySkilledworker(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao
				.querySkilledworker(constructocondition);
	}

	// ��ѯע�Ὠ��ʦlist
	public Page queryConstructor(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryConstructor(constructocondition);
	}

	// ְ����Ա
	public Page queryTitle(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryTitle(constructocondition);
	}

	// ��λ��Ա
	public Page queryPositions(Condition constructocondition) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPositions(constructocondition);
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void batchApplythrough(String[] ids, String approvalStaff,
			String approvalStaffId) {
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao
				.queryQualification(ids);

		for (int i = 0; i < list.size(); i++) {
			// �ж��Ƿ�Ϊ������������
			if (!list.get(i).getTwoApprovalDept().trim().equals("0")) {
				// �ж��Ƿ񾭹�����
				if (list.get(i).getTwoApprovalStaffId() == null) {
					// ���δ���������������������ͳ���
					this.pushApply(list.get(i));
				} else {
					list.get(i).setApprovalStaff(approvalStaff);
					list.get(i).setApprovalStaffId(approvalStaffId);
					list.get(i).setUltimateOpinion("����ͨ��");
					// ��������ռ�����
					this.applyUltimateThrough(list.get(i));
				}
			} else {
				list.get(i).setApprovalStaff(approvalStaff);
				list.get(i).setApprovalStaffId(approvalStaffId);
				list.get(i).setUltimateOpinion("����ͨ��");
				this.applyThrough(list.get(i));
			}
		}

	}

	/**
	 * ��Ϊ��Ա��Ŀ
	 */
	@Override
	public List queryPositionsNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPositionsNum(corpName);
	}

	/**
	 * ��ѯ�ظ��ļ�����Ա��Ŀ
	 */
	@Override
	public String querySkillworkerNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.querySkillworkerNum(corpName);
	}

	/**
	 * ��ѯ�ظ���ְ����Ա��Ŀ
	 */
	@Override
	public String queryTitleNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryTitleNum(corpName);
	}

	/**
	 * ��ѯ�ظ��ĸ�λ��Ա��Ŀ
	 */
	@Override
	public String queryPosNum(String corpName) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.queryPosNum(corpName);
	}

	/**
	 * �ظ�������Ա���
	 */
	@Override
	public Page skillworkerNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.skillworkerNum(condition);
	}

	/**
	 * �ظ�ְ����Ա���
	 */
	@Override
	public Page titleNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.titleNum(condition);
	}

	/**
	 * �ظ���λ��Ա���
	 */
	@Override
	public Page posNum(Condition condition) {
		// TODO Auto-generated method stub
		IProvinceApprovalDao qualificationsApprovalDao = new ProvinceApprovalDaoImpl();
		return qualificationsApprovalDao.posNum(condition);
	}

}
