package com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.condition;

import com.tj.jst.base.page.Condition;

/**
 * 终审人员历史审批记录
 * @author DarkFlameMaster
 *
 */
public class QueryApplicationHistoryCondition extends Condition{

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//企业名称
	private String corpName;
	//申请类型
	private String addTypeNum;
	//初审审批结果
	private String oneResults;
	//终审审批结果
	private String ultimateresults;
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	private String cretLevel;
	//终审审批人员ID
	private String approvalStaffId;
	// 审批层级判断
	private String level;
	// 部门Id
	private String deptId;
//	
//	public QueryApplicationHistoryCondition(){
//		
//	}
//	
//	public QueryApplicationHistoryCondition(String approvalStaffId , String deptId ){
//		this.approvalStaffId = approvalStaffId;
//		this.deptId = deptId;
//	}
	
	
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		//设置排序
		this.setOrderByItem("CREATDATE desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where (APPROVALSTAFFID='"+approvalStaffId+"' "
				+ "or TWOAPPROVALSTAFFID='"+approvalStaffId+"' or (rtrim(SPARE1)='"+deptId+"' "
				+ " and CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc','bfdca30b-967a-4104-8b4b-91615dff947e'," 
								+"'cf7fa175-7b73-4f89-ae18-882519a2d0e0','dc53db6d-7b9c-4ef5-8593-7bce1965d98d'," 
								+"'ead0cb20-5a76-4120-bdff-bba66e81b4ba','841a088c-8687-435f-b3bd-ba262d04a176',"
								+"'80e8e0a6-d48e-47e5-bbf8-da44843e8185','d25fb2d1-abf5-4d98-b12e-a5d63ff63e6b',"
								+"'a7300268-1cab-4cce-850e-dfdbd0beebad','1959dbef-443f-4cd7-92e7-ee0ccafa330c',"
								+"'4587c1a1-3c26-4505-89af-baef1990510f','61ed166d-cc34-4ed4-946e-1d8cb2e815e0')))");
		
		if(level!= null && !"".equals(level)){
			if(level.equals("1")){
				sb.append(" and (TWOAPPROVALSTAFFID is null)");
			}
			else if(level.equals("2")){
				sb.append(" and (TWOAPPROVALSTAFFID is not null)");
			}
		}
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(cretLevel != null && !"".equals(cretLevel)){
			sb.append(" and cretLevel = '"+cretLevel+"'");
		}
		if(addTypeNum != null && !"".equals(addTypeNum)){
			sb.append(" and addTypeNum = '"+addTypeNum+"'");
		}
		if(ultimateresults != null && !"".equals(ultimateresults)){
			if(ultimateresults.equals("5")){
				sb.append(" and (qualiftype = '5' or qualiftype = '9')");
			}else if(ultimateresults.equals("6")){
				sb.append(" and (qualiftype = '6' or qualiftype = '10' or qualiftype = '8')");
			}
		}
		String sql = "select * from V_QUALIFICATIONAPPLY "+sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(" where (APPROVALSTAFFID='"+approvalStaffId+"' "
				+ "or TWOAPPROVALSTAFFID='"+approvalStaffId+"' or (rtrim(SPARE1)='"+deptId+"' "
				+ " and CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc','bfdca30b-967a-4104-8b4b-91615dff947e'," 
								+"'cf7fa175-7b73-4f89-ae18-882519a2d0e0','dc53db6d-7b9c-4ef5-8593-7bce1965d98d'," 
								+"'ead0cb20-5a76-4120-bdff-bba66e81b4ba','841a088c-8687-435f-b3bd-ba262d04a176',"
								+"'80e8e0a6-d48e-47e5-bbf8-da44843e8185','d25fb2d1-abf5-4d98-b12e-a5d63ff63e6b',"
								+"'a7300268-1cab-4cce-850e-dfdbd0beebad','1959dbef-443f-4cd7-92e7-ee0ccafa330c',"
								+"'4587c1a1-3c26-4505-89af-baef1990510f','61ed166d-cc34-4ed4-946e-1d8cb2e815e0')))");
		if(level!= null && !"".equals(level)){
			if(level.equals("1")){
				sb.append(" and (TWOAPPROVALSTAFFID is null)");
			}
			else if(level.equals("2")){
				sb.append(" and (TWOAPPROVALSTAFFID is not null)");
			}
		}
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(cretLevel != null && !"".equals(cretLevel)){
			sb.append(" and cretLevel = '"+cretLevel+"'");
		}
		if(addTypeNum != null && !"".equals(addTypeNum)){
			sb.append(" and addTypeNum = '"+addTypeNum+"'");
		}
		if(ultimateresults != null && !"".equals(ultimateresults)){
			if(ultimateresults.equals("5")){
				sb.append(" and (qualiftype = '5' or qualiftype = '9')");
			}else if(ultimateresults.equals("6")){
				sb.append(" and (qualiftype = '6' or qualiftype = '10' or qualiftype = '8')");
			}
		}
		String sqlCount="select count(*) from V_QUALIFICATIONAPPLY "+sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
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

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getAddTypeNum() {
		return addTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}


	public String getCretLevel() {
		return cretLevel;
	}

	public void setCretLevel(String cretLevel) {
		this.cretLevel = cretLevel;
	}

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public String getOneResults() {
		return oneResults;
	}

	public void setOneResults(String oneResults) {
		this.oneResults = oneResults;
	}

	public String getUltimateresults() {
		return ultimateresults;
	}

	public void setUltimateresults(String ultimateresults) {
		this.ultimateresults = ultimateresults;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	
	
}
