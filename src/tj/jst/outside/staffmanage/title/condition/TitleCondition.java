package com.tj.jst.outside.staffmanage.title.condition;

import com.tj.jst.base.page.Condition;

/**
 * ְ����Ա��ҳ������
 * @author Administrator
 *
 */
public class TitleCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String idCard;
	//��ҵid
	private String corpId;
	//ְ��
	private String titleName;
	//ְ��רҵ
	private String titleMajor;
	//ְ�Ƽ���
	private String titleLevel;
	//��ѧרҵ
	private String studyMajor;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(titleName!= null && !"".equals(titleName)){
			sb.append(" and titleName like '"+titleName.trim()+"%'"); 
		}
		if(titleMajor != null && !"".equals(titleMajor)){
			sb.append(" and titleMajor like '"+titleMajor.trim()+"%'");
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '"+titleLevel.trim()+"%'"); 
		}
		if(studyMajor != null && !"".equals(studyMajor)){
			sb.append(" and studyMajor like '"+studyMajor.trim()+"%'");
		}
		
		String sql = "select * from v_persontitleinfo "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(titleName!= null && !"".equals(titleName)){
			sb.append(" and titleName like '"+titleName.trim()+"%'"); 
		}
		if(titleMajor != null && !"".equals(titleMajor)){
			sb.append(" and titleMajor like '"+titleMajor.trim()+"%'");
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '"+titleLevel.trim()+"%'"); 
		}
		if(studyMajor != null && !"".equals(studyMajor)){
			sb.append(" and studyMajor like '"+studyMajor.trim()+"%'");
		}
		
		String sqlCount="select count(*) from v_persontitleinfo "+sb.toString();
		System.out.println(sqlCount);
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
	
	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleMajor() {
		return titleMajor;
	}

	public void setTitleMajor(String titleMajor) {
		this.titleMajor = titleMajor;
	}

	public String getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}

	public String getStudyMajor() {
		return studyMajor;
	}

	public void setStudyMajor(String studyMajor) {
		this.studyMajor = studyMajor;
	}

}
