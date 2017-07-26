package com.tj.jst.outside.businessReport.qualitychange.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业申请资质信息状况分页
 * @author DarkFlameMaster
 *
 */
public class QualityChangePageCondition extends Condition{

	// 组织机构代码证ID
	private String CORPNAME;
	private String START_TIME;
	private String END_TIME;
	private String departmentID;
	private String checkType;		
	private String SQL_STATE;
	// 组织机构代码证
//	private String CorpCode;
//	// 资质状况Id
//	private String newQualId;
//	// 资质资格类型
//	private String CertTypeNum;
//	// 资质序列名称
//	private String CretSequence;
//	// 资质等级
//	private String CretLevel;
	
	public QualityChangePageCondition(String checkType,String departmentID)
	{
		//国家审批权
		
		System.out.println("checkType"+checkType);
		
		if(checkType.equals("0"))
		{
			SQL_STATE="4";
		}
		//省级审批权
		if(checkType.equals("1"))
		{
			SQL_STATE="4";
		}	
		//地市审批权
		if(checkType.equals("2"))
		{
			SQL_STATE="3";
			this.departmentID=departmentID;
		}
		if(checkType.equals("3"))
		{
			SQL_STATE="3";
			this.departmentID=departmentID;
		}
		
		
	//	else
	//	{
	//		SQL_STATE="2";
	//	}

		
		
	}
	
	
	/**
	 * 查询语句
	 */
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		//System.out.println("SQL_STATE:"+SQL_STATE);
		if(SQL_STATE.equals("1"))
		{
			sb.append(" and bz=2 "); 
			sb.append(" and state=1 ");
		}
		if(SQL_STATE.equals("2"))
		{
			sb.append(" and bz=5 "); 
			sb.append(" and state in('1','4') ");
		}		
		if(SQL_STATE.equals("3")){
			sb.append(" and bz=8 "); 
			sb.append(" and state in('1','4','7') ");
			sb.append(" and spare1='" + departmentID + "' ");
		}
		//既有国家又有省级审批权
		if(SQL_STATE.equals("4")){
			sb.append(" and bz in('2','5') "); 
			sb.append(" and state in('1','4') ");
			sb.append(" and concat(levelset,state)!=',1,4' ");
		}
		
		if(CORPNAME!= null && !"".equals(CORPNAME)){
			sb.append(" and CORPNAME like '%"+CORPNAME.trim()+"%'"); 
		}
		if(START_TIME!= null && !"".equals(START_TIME)){
			sb.append(" and CREATE_TIME >= to_date('"+START_TIME+"','yyyy-MM-dd HH24:mi:ss')"); 
		}
		if(END_TIME != null && !"".equals(END_TIME)){
			sb.append(" and CREATE_TIME <= to_date('"+END_TIME+"','yyyy-MM-dd HH24:mi:ss')");
		}
		
		String sql = "select "
				+ " QUALITY_CHANGE_ID,CORPID, "
				+ " CORPNAME,LICENSENUM,ADDRESS,REGPRIN,ECONOMICNUM,ECONOMICNAME,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ " CHANGE_CORPNAME,CHANGE_LICENSENUM,CHANGE_ADDRESS,CHANGE_REGPRIN,CHANGE_ECONOMICNUM,CHANGE_ECONOMICNAME,CHANGE_LEGALMAN,CHANGE_IDCARDTYPENUM,CHANGE_LEGALMANIDCARD,"
				+ " to_char(CREATE_TIME,'yyyy-MM-dd HH24:mi:ss') CREATE_TIME, "
				+ " to_char(UPDATE_TIME,'yyyy-MM-dd HH24:mi:ss') UPDATE_TIME,"
				+ " STAFF_COUNTRY,STAFF_PROVINCE,STAFF_CITY,APPROVAL_COUNTRY,APPROVAL_PROVINCE,APPROVAL_CITY,"
				+ " to_char(APPROVALTIME_COUNTRY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_COUNTRY,"
				+ " to_char(APPROVALTIME_PROVINCE,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_PROVINCE,"
				+ " to_char(APPROVALTIME_CITY,'yyyy-MM-dd HH24:mi:ss') APPROVALTIME_CITY,"
				+ " LEVELSET,BZ,STATE,SPARE1"
				+ " from TB_QUALITY_CHANGE "
				+ "" + sb.toString();
		return sql;
	}
	
	/**
	 * 查询数量
	 */
	public String getCountSql() {
		// TODO Auto-generated method stub//设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if(SQL_STATE.equals("1"))
		{
			sb.append(" and bz=2 "); 
			sb.append(" and state=1 ");
		}
		if(SQL_STATE.equals("2"))
		{
			sb.append(" and bz=5 "); 
			sb.append(" and state in('1','4') ");
		}		
		if(SQL_STATE.equals("3")){
			sb.append(" and bz=8 "); 
			sb.append(" and state in('1','4','7') ");
			sb.append(" and spare1='" + departmentID + "' ");
		}
		//既有国家又有省级审批权
		if(SQL_STATE.equals("4")){
			sb.append(" and bz in('2','5') "); 
			sb.append(" and state in('1','4') ");
			sb.append(" and concat(levelset,state)!=',1,4' ");
		}

		if(CORPNAME!= null && !"".equals(CORPNAME)){
			sb.append(" and corpName like '%"+CORPNAME.trim()+"%'"); 
		}
		if(START_TIME!= null && !"".equals(START_TIME)){
			sb.append(" and CREATE_TIME >= to_date('"+START_TIME+"','yyyy-MM-dd HH24:mi:ss')"); 
		}
		if(END_TIME != null && !"".equals(END_TIME)){
			sb.append(" and CREATE_TIME <= to_date('"+END_TIME+"','yyyy-MM-dd HH24:mi:ss')");
		}
		String sqlCount = " select count(*) from TB_QUALITY_CHANGE "
				+ sb.toString();
		return sqlCount;
	}


	public String getCORPNAME() {
		return CORPNAME;
	}

	public void setCORPNAME(String cORPNAME) {
		CORPNAME = cORPNAME;
	}

	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}


	public String getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}





	public String getSQL_STATE() {
		return SQL_STATE;
	}


	public void setSQL_STATE(String sQL_STATE) {
		SQL_STATE = sQL_STATE;
	}


	public String getCheckType() {
		return checkType;
	}


	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}


	
	
	
}
