package com.tj.jst.outside.businessReport.queryQualification.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业所拥有的资质信息分类
 * 
 * @author DarkFlameMaster
 *
 */
public class QualificationCondition extends Condition {

	// 资质资格类型
	private String CertTypeNum;
	// 资质资格等级
	private String TitleLevelNum;
	// 资质资格获取方式
	private String AddTypeNum;
	// 专业类别
	private String TradeBoundNum;
	// 组织机构代码证ID
	private String CorpId;
	// 组织机构代码证
	private String CorpCode;

	/**
	 * 查询语句
	 */
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
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
	 * 查询数量
	 */
	public String getCountSql() {
		// TODO Auto-generated method stub//设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
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
