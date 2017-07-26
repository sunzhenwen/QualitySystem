package com.tj.jst.outside.staffmanage.positions.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.page.Condition;

/**
 * ��λ��Ա��ҳ������
 * @author Administrator
 *
 */
public class PositionsCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String idCard;
	//��ҵ����
	private String corpName;
	//��λ����
	private String duty;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
			if (duty != null){
				duty = URLDecoder.decode(duty,"utf8");
			}
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    }   
		
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where FIsDeleted = 0 and FEntName='"+corpName+"' and fduty  in ('ʩ��Ա','����Ա','��ȫԱ','��׼Ա','����Ա','��еԱ','����Ա','����Ա')");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and FName like '"+personName.trim()+"%'"); 
		}
		if(duty!=null && !"".equals(duty)){
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and FCardID like '"+idCard.trim()+"%'");
		}
		String sql = "select row_number() over(order by FRegDate desc) as rownumber,fPersonID, FName, FCardID, FSex, FEntName, FDuty , FCertNumber FROM Position_Certificate"+sb.toString();
		System.out.println("sql= "+sql);
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
			if (duty != null){
				duty = URLDecoder.decode(duty,"utf8");
			}
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    }  
		
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where FIsDeleted = 0  and FEntName='"+corpName+"' and fduty  in ('ʩ��Ա','����Ա','��ȫԱ','��׼Ա','����Ա','��еԱ','����Ա','����Ա')  ");
		if(duty!=null && !"".equals(duty)){
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and FName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and FCardID like '"+idCard.trim()+"%'");
		}
		String sqlCount="select count(*) from Position_Certificate "+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

}
