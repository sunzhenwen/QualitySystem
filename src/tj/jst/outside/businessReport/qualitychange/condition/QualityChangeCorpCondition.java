package com.tj.jst.outside.businessReport.qualitychange.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ����������Ϣ״����ҳ
 * @author DarkFlameMaster
 *
 */
public class QualityChangeCorpCondition extends Condition{

	// ��֯��������֤ID
	private String CorpId;
	// ��֯��������֤
//	private String CorpCode;
//	// ����״��Id
//	private String newQualId;
//	// �����ʸ�����
//	private String CertTypeNum;
//	// ������������
//	private String CretSequence;
//	// ���ʵȼ�
//	private String CretLevel;

	
	/**
	 * ��ѯ���
	 */
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where corpId='" + CorpId + "' ");
//		if (CretLevel != null && !"".equals(CretLevel)) {
//			sb.append(" and CretLevel like '"
//					+ Integer.parseInt(CretLevel.trim()) + "%'");
//		}
		String sql = "select "
				+ " QUALITY_CHANGE_ID,CORPID, "
				+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
				+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
				+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
				+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
				+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
				+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
				+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
				+ " LEVELSET,BZ,STATE,SPARE1"
				+ " from TB_QUALITY_CHANGE "
				+ "" + sb.toString();
		return sql;
	}
	
	/**
	 * ��ѯ����
	 */
	public String getCountSql() {
		// TODO Auto-generated method stub//��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where corpId='" + CorpId + "' ");
//		if (CretLevel != null && !"".equals(CretLevel)) {
//			sb.append(" and CretLevel like '"
//					+ Integer.parseInt(CretLevel.trim()) + "%'");
//		}
		String sqlCount = "select count(*) from TB_QUALITY_CHANGE"
				+ sb.toString();
		System.out.println(sqlCount);
		return sqlCount;
	}

	public String getCorpId() {
		return CorpId;
	}

	public void setCorpId(String corpId) {
		CorpId = corpId;
	}


	
	
	
}
