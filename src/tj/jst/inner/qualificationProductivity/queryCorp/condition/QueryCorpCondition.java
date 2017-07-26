package com.tj.jst.inner.qualificationProductivity.queryCorp.condition;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class QueryCorpCondition extends Condition {
	
	private String corpId;				//公司Id
	List<Corp> list;					//公司list
	private String[] certIds;  
	private String sqlWhere = " ";
	private String sqlWhere2 = " ";
	private String provinceNum ;
	private String cityNum ;
	
	public QueryCorpCondition(){
		
	}
	
	public QueryCorpCondition(List<Corp> list , String[] certIds) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.certIds = certIds;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(" where t.locknumber1 is not null and a.corpcertid is not null and a.certtypenum = '3' ");
		sqlWhere2 = ""; 
		if(cityNum!=null && !"".equals(cityNum)){
			sb.append(" and t.cityNum = '"+cityNum+"' ");
		}
		if(list != null)
		{
			sqlWhere2 = sqlWhere2 + " and " ;
			
			if(null!= cityNum && !"".equals(cityNum)){
				
				for(int i=0; i<list.size(); i++)
				{
					sqlWhere2  = sqlWhere2 +  " t.corpId = '" + list.get(i).getCorpId() + "' and t.provinceNum = '"+provinceNum+"'  and t.cityNum = '"+cityNum+"' or" ;
				}
			}else{
				for(int i=0; i<list.size(); i++)
				{
					sqlWhere2  = sqlWhere2 +  " t.corpId = '" + list.get(i).getCorpId() + "' or" ;
				}
				
			}
			
			if(sqlWhere.length() > 6)
			{
				sqlWhere2 = sqlWhere2.substring(1,sqlWhere2.length()-2); 
				System.out.println("sqlWhere2 = " + sqlWhere2);
				sb.append(sqlWhere2); 
			}
		}
		else{
			if(certIds != null)
			{
				sb.append(" and t.corpId is null ");
			}
		}
		
		String sql = "select distinct t.* from v_corpbasicinfo t "
				+ "left join tbcorpcertinfo a on t.corpcode = a.corpcode "+sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(" where t.locknumber1 is not null and a.corpcertid is not null and a.certtypenum = '3' ");
		sqlWhere = "";
		if(cityNum!=null && !"".equals(cityNum)){
			sb.append(" and t.cityNum = '"+cityNum+"' ");
		}
		if(list != null)
		{
			sqlWhere = sqlWhere + " and " ;
			if( cityNum != null && !"".equals(cityNum)){
				
				for(int i=0; i<list.size(); i++)
				{
					sqlWhere  = sqlWhere +  " t.corpId = '" + list.get(i).getCorpId() + "' and t.provinceNum = '"+provinceNum+"'  and t.cityNum = '"+cityNum+"' or" ;
				}
			}else{
				for(int i=0; i<list.size(); i++)
				{
					sqlWhere  = sqlWhere +  " t.corpId = '" + list.get(i).getCorpId() + "' or" ;
				}
				
			}
			if(sqlWhere.length() > 6)
			{
				sqlWhere = sqlWhere.substring(1,sqlWhere.length()-2); 
				System.out.println("sqlWhere = " + sqlWhere);
				sb.append(sqlWhere); 
			}
		}
		else
		{
			if(certIds != null)
			{
				sb.append(" and t.corpId is null ");
			}
		}
		String sqlCount="select count(*) from ( select distinct t.* from v_corpbasicinfo t left join tbcorpcertinfo a on t.corpcode = a.corpcode"+sb.toString() + ")";
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public List<Corp> getList() {
		return list;
	}

	public void setList(List<Corp> list) {
		this.list = list;
	}

	public String getSqlWhere() {
		return sqlWhere;
	}

	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}


}
