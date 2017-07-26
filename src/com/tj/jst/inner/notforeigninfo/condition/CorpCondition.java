package com.tj.jst.inner.notforeigninfo.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ��Ϣ��ҳ����
 * @author DarkFlameMaster
 *
 */
public class CorpCondition extends Condition {

	private String corpId;				//��ҵId
	private String corpName;			//��ҵ����
	private String corpCode;			//��ҵ��֯��������֤
	private String licenseNum;			//��ҵ����Ӫҵִ��
	
	/**
	 * ��ѯ���
	 */
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 and locknumber1 is not null ");
//		if(corpId!= null && !"".equals(corpId)){
//			if(corpId.length() > 4){
//				sb.append(" and SPARE1 like '"+corpId.trim()+"%'"); 
//			}else{
//				sb.append(" and 1=1"); 
//			}
//		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode != null && !"".equals(corpCode)){
			sb.append(" and corpCode like '"+corpCode.trim()+"%'");
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '"+licenseNum.trim()+"%'"); 
		}
		String sql = "select * from v_corpbasicinfo "+sb.toString();
		return sql;
	}
	
	/**
	 * ��ѯ�������
	 */
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer("  where 1=1 and locknumber1 is not null  ");
//		if(corpId!= null && !"".equals(corpId)){
//			if(corpId.length() > 4){
//				sb.append(" and SPARE1 like '"+corpId.trim()+"%'"); 
//			}else{
//				sb.append(" and 1=1"); 
//			}
//		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode != null && !"".equals(corpCode)){
			sb.append(" and corpCode like '"+corpCode.trim()+"%'");
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '"+licenseNum.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_corpbasicinfo "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	
	
	
}
