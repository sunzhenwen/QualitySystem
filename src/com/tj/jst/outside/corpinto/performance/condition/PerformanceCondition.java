package com.tj.jst.outside.corpinto.performance.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public class PerformanceCondition extends Condition {

	//企业id
	private String corpId;
	//项目名称
	private String proName;
	//项目类型
	private String proType;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;	
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(proName!= null && !"".equals(proName)){
			sb.append(" and proName like '"+proName.trim()+"%'"); 
		}
		if(proType != null && !"".equals(proType)){
			sb.append(" and proType like '"+proType.trim()+"%'");
		}
		
		String sql = "select * from TBCORPPERFORMANCE "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(proName!= null && !"".equals(proName)){
			sb.append(" and proName like '"+proName.trim()+"%'"); 
		}
		if(proType != null && !"".equals(proType)){
			sb.append(" and proType like '"+proType.trim()+"%'");
		}
		
		String sqlCount="select count(*) from TBCORPPERFORMANCE "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
