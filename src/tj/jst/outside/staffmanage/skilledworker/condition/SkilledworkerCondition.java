package com.tj.jst.outside.staffmanage.skilledworker.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������Ա��ҳ������
 * @author DarkFlameMaster
 *
 */
public class SkilledworkerCondition extends Condition {

	//��Ա����
	private String personName;
	//���֤����
	private String identityCard;
	//������Ա����
	private String skilledTypeNum;
	//������Ա����
	private String skilledLevelNum;
	//��֯��������֤ID
	private String UserId;
	//
	private String corpCode;
	//
	private String corpId;

	/**
	 * ��ѯ���
	 */
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(identityCard != null && !"".equals(identityCard)){
			sb.append(" and identityCard like '"+identityCard.trim()+"%'");
		}
		if(skilledLevelNum!= null && !"".equals(skilledLevelNum)){
			sb.append(" and SKILLEDLEVELNUM = '"+Integer.parseInt(skilledLevelNum.trim())+"'"); 
		}
		if(skilledTypeNum!= null && !"".equals(skilledTypeNum)){
			sb.append(" and SKILLEDTYPENUM = '"+Integer.parseInt(skilledTypeNum.trim())+"'");
		}
		
		String sql = "select * from V_SKILLEDWORKER"+sb.toString();
		return sql;
	}

	/**
	 * ��ѯ����
	 */
	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personname like '"+personName.trim()+"%'"); 
		}
		if(identityCard != null && !"".equals(identityCard)){
			sb.append(" and identityCard like '"+identityCard.trim()+"%'");
		}
		if(skilledLevelNum!= null && !"".equals(skilledLevelNum)){
			sb.append(" and SKILLEDLEVELNUM = '"+Integer.parseInt(skilledLevelNum.trim())+"'"); 
		}
		if(skilledTypeNum!= null && !"".equals(skilledTypeNum)){
			sb.append(" and SKILLEDTYPENUM = '"+Integer.parseInt(skilledTypeNum.trim())+"'");
		}
		
		String sqlCount = "select count(*) from V_SKILLEDWORKER"+sb.toString();
		System.out.println(sqlCount);
		return sqlCount;
	}

	public String getpersonName() {
		return personName;
	}

	public void setName(String personName) {
		this.personName = personName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getSkilledTypeNum() {
		return skilledTypeNum;
	}

	public void setSkilledTypeNum(String skilledTypeNum) {
		this.skilledTypeNum = skilledTypeNum;
	}

	public String getSkilledLevelNum() {
		return skilledLevelNum;
	}

	public void setSkilledLevelNum(String skilledLevelNum) {
		this.skilledLevelNum = skilledLevelNum;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	
	
}
