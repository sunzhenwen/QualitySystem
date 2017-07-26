package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������Ա
 * @author DarkFlameMaster
 *
 */
public class QuerySkilledworkerCondition extends Condition {

	private String corpId;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"'");
		
		
		String sql = "select * from V_SKILLEDWORKER "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer("where corpId='"+corpId+"'");
		
		
		String sqlCount="select count(*) from V_SKILLEDWORKER "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
