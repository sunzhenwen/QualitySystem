package com.tj.jst.inner.qualificationProductivity.provinceApproval.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.page.Condition;

/**
 * ע�Ὠ��ʦ��ҳ������
 * @author Administrator
 *
 */
public class QueryConstructorCondition extends Condition {

	//��ҵid
	private String corpName;
	
	public QueryConstructorCondition()
	{
		
	}
	
	public QueryConstructorCondition(String corpName)
	{
		this.corpName = corpName;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    } 
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpName='"+corpName+"' ");
		
		String sql = "select * from V_CONSTRUCTOR"+sb.toString();
		System.out.println("sql= "+sql);
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    } 
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpName='"+corpName+"' ");
		
		String sqlCount="select count(*) from V_CONSTRUCTOR "+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
