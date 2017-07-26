package com.tj.jst.inner.qualificationProductivity.twoQuery.condition;

import com.tj.jst.base.page.Condition;

/**
 * 
 * 初审人员历史审批记录查询
 * @author DarkFlameMaster
 *
 */
public class TwoQueryCondition extends Condition{

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
		//初审审批人员ID
		private String approvalStaffId;
		
//		public TwoQueryCondition(){
//			
//		}
//		
//		public TwoQueryCondition(String approvalStaffId){
//			this.approvalStaffId = approvalStaffId;
//		}
		
		
		@Override
		public String getInitialSql() {
			// TODO Auto-generated method stub
			//设置排序
			//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
			//查询当前可用单位；
			StringBuffer sb=new StringBuffer(" where TWOAPPROVALSTAFFID='"+approvalStaffId+"' ");
			
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
			if(oneResults != null && !"".equals(oneResults)){
				sb.append(" and ONERESULTS = '"+oneResults+"'");
			}
			if(ultimateresults != null && !"".equals(ultimateresults)){
				sb.append(" and ULTIMATERESULTS = '"+ultimateresults+"'");
			}
			if(addTypeNum != null && !"".equals(addTypeNum)){
				sb.append(" and addTypeNum = '"+addTypeNum+"'");
			}
			String sql = "select * from V_QUALIFICATIONAPPLY "+sb.toString();
			return sql;
		}
		@Override
		public String getCountSql() {
			// TODO Auto-generated method stub
			StringBuffer sb=new StringBuffer(" where TWOAPPROVALSTAFFID='"+approvalStaffId+"' ");
			
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
			if(oneResults != null && !"".equals(oneResults)){
				sb.append(" and ONERESULTS = '"+oneResults+"'");
			}
			if(ultimateresults != null && !"".equals(ultimateresults)){
				sb.append(" and ULTIMATERESULTS = '"+ultimateresults+"'");
			}
			if(addTypeNum != null && !"".equals(addTypeNum)){
				sb.append(" and addTypeNum = '"+addTypeNum+"'");
			}
			String sqlCount="select count(*) from V_QUALIFICATIONAPPLY "+sb.toString();
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

		
		
		
	
}
