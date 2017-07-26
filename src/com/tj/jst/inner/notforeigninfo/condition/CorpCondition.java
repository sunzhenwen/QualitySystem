package com.tj.jst.inner.notforeigninfo.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业信息分页工具
 * @author DarkFlameMaster
 *
 */
public class CorpCondition extends Condition {

	private String corpId;				//企业Id
	private String corpName;			//企业名称
	private String corpCode;			//企业组织机构代码证
	private String licenseNum;			//企业工商营业执照
	
	/**
	 * 查询语句
	 */
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
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
	 * 查询条数语句
	 */
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
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
