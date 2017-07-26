package com.tj.jst.outside.businessReport.queryQualificationInfo.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ����������Ϣ״����ҳ
 * @author DarkFlameMaster
 *
 */
public class QualificationInfoCondition extends Condition{

	// ��֯��������֤ID
	private String CorpId;
	// ��֯��������֤
	private String CorpCode;
	// ����״��Id
	private String newQualId;
	// �����ʸ�����
	private String CertTypeNum;
	// ������������
	private String CretSequence;
	// ���ʵȼ�
	private String CretLevel;
	
	public QualificationInfoCondition(){
		
	}
	
	public QualificationInfoCondition(String corpId){
		this.CorpId = corpId;
	}
	
	/**
	 * ��ѯ���
	 */
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where q.corpCode='" + CorpId + "' and (c.certtradestatusnum = '001' or c.certtradestatusnum is null)  ");
		if (CretLevel != null && !"".equals(CretLevel)) {
			sb.append(" and q.CretLevel like '"
					+ Integer.parseInt(CretLevel.trim()) + "%'");
		}
		String sql = "select q.* from V_QUALIFICATIONAPPLY q " +
				"left join TBCORPCERTDETAILINFO c on q.CORPID = c.corpid and q.SPECIALTYTYPE = c.tradeboundnum and q.CRETLEVEL = c.titlelevelnum and c.certid is not null " + sb.toString();
		return sql;
	}
	
	/**
	 * ��ѯ����
	 */
	public String getCountSql() {
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where q.corpCode='" + CorpId + "' and (c.certtradestatusnum = '001' or c.certtradestatusnum is null)  ");
		if (CretLevel != null && !"".equals(CretLevel)) {
			sb.append(" and q.CretLevel like '"
					+ Integer.parseInt(CretLevel.trim()) + "%'");
		}
		String sqlCount = "select count(*) from V_QUALIFICATIONAPPLY q " +
				"left join TBCORPCERTDETAILINFO c on q.CORPID = c.corpid and q.SPECIALTYTYPE = c.tradeboundnum and q.CRETLEVEL = c.titlelevelnum and c.certid is not null "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount );
		return sqlCount;
	}

	public String getCorpId() {
		return CorpId;
	}

	public void setCorpId(String corpId) {
		CorpId = corpId;
	}

	public String getCorpCode() {
		return CorpCode;
	}

	public void setCorpCode(String corpCode) {
		CorpCode = corpCode;
	}

	public String getNewQualId() {
		return newQualId;
	}

	public void setNewQualId(String newQualId) {
		this.newQualId = newQualId;
	}

	public String getCertTypeNum() {
		return CertTypeNum;
	}

	public void setCertTypeNum(String certTypeNum) {
		CertTypeNum = certTypeNum;
	}

	public String getCretSequence() {
		return CretSequence;
	}

	public void setCretSequence(String cretSequence) {
		CretSequence = cretSequence;
	}

	public String getCretLevel() {
		return CretLevel;
	}

	public void setCretLevel(String cretLevel) {
		CretLevel = cretLevel;
	}
	
	
	
}
