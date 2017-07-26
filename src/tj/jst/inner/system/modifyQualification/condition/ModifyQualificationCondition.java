package com.tj.jst.inner.system.modifyQualification.condition;

import java.sql.Date;
import com.tj.jst.base.page.Condition;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class ModifyQualificationCondition extends Condition {
	
	private String corpCode ;
	private String corpName ;

	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem("creatDate desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1  ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sql = "select * from TBQUALIFICATIONAPPLY "+sb.toString();
		System.out.println("资质申请sql = "+sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		this.setOrderByItem("creatDate desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1  ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sqlCount="select count(*) from TBQUALIFICATIONAPPLY "+sb.toString();
		System.out.println("资质申请sqlCount = "+sqlCount);
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


}
