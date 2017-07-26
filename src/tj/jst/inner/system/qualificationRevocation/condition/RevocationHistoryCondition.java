package com.tj.jst.inner.system.qualificationRevocation.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class RevocationHistoryCondition extends Condition {
	
	private String corpCode ;
	private String corpName ;
	// 部门Id
	private String deptId;
	
	
	public RevocationHistoryCondition() {}
	
	public RevocationHistoryCondition(String deptId) {
		this.deptId = deptId;
	}



	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem("REVOCATIONDATE desc");
		StringBuffer sb=new StringBuffer();
		//查询当前可用单位；
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
		System.out.println("打回历史sql = "+sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		this.setOrderByItem("REVOCATIONDATE desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer();
		//查询当前可用单位；
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
		System.out.println("打回历史sqlCount = "+sqlCount);
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
