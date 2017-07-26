package com.tj.jst.outside.businessReport.queryQualification.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ��ӵ�е�������Ϣ����
 * 
 * @author DarkFlameMaster
 *
 */
public class QualificationCondition extends Condition {

	// �����ʸ�����
	private String CertTypeNum;
	// �����ʸ�ȼ�
	private String TitleLevelNum;
	// �����ʸ��ȡ��ʽ
	private String AddTypeNum;
	// רҵ���
	private String TradeBoundNum;
	// ��֯��������֤ID
	private String CorpId;
	// ��֯��������֤
	private String CorpCode;

	/**
	 * ��ѯ���
	 */
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where corpId='" + CorpId + "'  and (QUALIFTYPE = 5 or QUALIFTYPE = 9)");
		if (CertTypeNum != null && !"".equals(CertTypeNum)) {
			sb.append(" and CertTypeNum like '"
					+ Integer.parseInt(CertTypeNum.trim()) + "%'");
		}
		if (TitleLevelNum != null && !"".equals(TitleLevelNum)) {
			sb.append(" and TitleLevelNum like '"
					+ Integer.parseInt(TitleLevelNum.trim()) + "%'");
		}
		if (AddTypeNum != null && !"".equals(AddTypeNum)) {
			sb.append(" and AddTypeNum = '"
					+ Integer.parseInt(AddTypeNum.trim()) + "'");
		}
		if (TradeBoundNum != null && !"".equals(TradeBoundNum)) {
			sb.append(" and TradeBoundNum = '"
					+ Integer.parseInt(TradeBoundNum.trim()) + "'");
		}

		String sql = "select * from V_QUALIFICATION" + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	/**
	 * ��ѯ����
	 */
	public String getCountSql() {
		// TODO Auto-generated method stub//��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where corpId='" + CorpId + "'  and (QUALIFTYPE = 5 or QUALIFTYPE = 9)");
		if (CertTypeNum != null && !"".equals(CertTypeNum)) {
			sb.append(" and CertTypeNum like '"
					+ Integer.parseInt(CertTypeNum.trim()) + "%'");
		}
		if (TitleLevelNum != null && !"".equals(TitleLevelNum)) {
			sb.append(" and TitleLevelNum like '"
					+ Integer.parseInt(TitleLevelNum.trim()) + "%'");
		}
		if (AddTypeNum != null && !"".equals(AddTypeNum)) {
			sb.append(" and AddTypeNum = '"
					+ Integer.parseInt(AddTypeNum.trim()) + "'");
		}
		if (TradeBoundNum != null && !"".equals(TradeBoundNum)) {
			sb.append(" and TradeBoundNum = '"
					+ Integer.parseInt(TradeBoundNum.trim()) + "'");
		}

		String sqlCount = "select count(*) from V_QUALIFICATION"
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getCertTypeNum() {
		return CertTypeNum;
	}

	public void setCertTypeNum(String certTypeNum) {
		CertTypeNum = certTypeNum;
	}

	public String getTitleLevelNum() {
		return TitleLevelNum;
	}

	public void setTitleLevelNum(String titleLevelNum) {
		TitleLevelNum = titleLevelNum;
	}

	public String getAddTypeNum() {
		return AddTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		AddTypeNum = addTypeNum;
	}

	public String getTradeBoundNum() {
		return TradeBoundNum;
	}

	public void setTradeBoundNum(String tradeBoundNum) {
		TradeBoundNum = tradeBoundNum;
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

}
