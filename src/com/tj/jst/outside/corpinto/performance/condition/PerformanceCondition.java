package com.tj.jst.outside.corpinto.performance.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public class PerformanceCondition extends Condition {

	//��ҵid
	private String corpId;
	//��Ŀ����
	private String proName;
	//��Ŀ����
	private String proType;
	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;	
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
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
