package com.tj.jst.inner.system.qualificationRevocation.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ�ѻ����ʴ��
 * @author Administrator
 *
 */
public class RevocationHistoryCondition extends Condition {
	
	private String corpCode ;
	private String corpName ;
	// ����Id
	private String deptId;
	
	
	public RevocationHistoryCondition() {}
	
	public RevocationHistoryCondition(String deptId) {
		this.deptId = deptId;
	}



	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem("REVOCATIONDATE desc");
		StringBuffer sb=new StringBuffer();
		//��ѯ��ǰ���õ�λ��
		if (deptId.equals("20")) {
			sb=new StringBuffer(" where 1=1  ");
		} else {
			sb=new StringBuffer(" where approvaldept = '"+deptId+"'  ");
		}
		
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sql = "select * from tbqualificationrevocation_log "+sb.toString();
		System.out.println("�����ʷsql = "+sql);
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		this.setOrderByItem("REVOCATIONDATE desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer();
		//��ѯ��ǰ���õ�λ��
		if (deptId.equals("20")) {
			sb=new StringBuffer(" where 1=1  ");
		} else {
			sb=new StringBuffer(" where approvaldept = '"+deptId+"'  ");
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sqlCount="select count(*) from tbqualificationrevocation_log "+sb.toString();
		System.out.println("�����ʷsqlCount = "+sqlCount);
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


}
