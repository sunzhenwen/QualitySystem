package com.tj.jst.inner.qualificationProductivity.countryApproval.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������������
 * @author Administrator
 *
 */
public class CountryApprovalCondition extends Condition {

	//��ʼʱ��
		private String startDate;
		//����ʱ��
		private String endDate;
		//��ҵ����
		private String corpName;
		//��������(�ֵ����TBAPTITUDEKINDDIC)
		private String cretType;
		//���ʵȼ�(�ֵ����TBCERTTITLELEVELDIC)
		private String cretLevel;
		//��������(�ֵ����TBTRADETYPEDIC)
		private String cretSequence;
		//����רҵ���(�ֵ����TBTRADETYPEBOUNDDIC)
		private String specialtyType;
		//���ʼ���(�ֵ����TBCRETGRADEDIC)
		private String cretGrade;
		//��������
		private String addTypeNum;
		//����Id
		private String deptId;
//		
//		public CountryApprovalCondition()
//		{
//			
//		}
//		
//		public CountryApprovalCondition(String deptId)
//		{
//			this.deptId = deptId;
//		}
		
		//��ѯ���
		@Override
		public String getInitialSql() {
			//��������
			this.setOrderByItem(" FLOORDATE asc ");
			//��ѯ��ǰ���õ�λ��
			StringBuffer sb=new StringBuffer(" where rtrim(APPROVALDEPT)='"+deptId+"' and rtrim(cretGrade)=1 ");
			
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(corpName!= null && !"".equals(corpName)){
				sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
			}
			if(cretType != null && !"".equals(cretType)){
				sb.append(" and cretType = '"+cretType+"'");
			}
			if(cretLevel != null && !"".equals(cretLevel)){
				sb.append(" and cretLevel = '"+cretLevel+"'");
			}
			if(cretSequence != null && !"".equals(cretSequence)){
				sb.append(" and cretSequence = '"+cretSequence+"'");
			}
			if(specialtyType != null && !"".equals(specialtyType)){
				sb.append(" and specialtyType = '"+specialtyType+"'");
			}
			if(cretGrade != null && !"".equals(cretGrade)){
				sb.append(" and cretGrade = '"+cretGrade+"'");
			}
			if(addTypeNum != null && !"".equals(addTypeNum)){
				sb.append(" and addTypeNum = '"+addTypeNum+"'");
			}
			sb.append("and (QUALIFTYPE='1' or QUALIFTYPE='3' or QUALIFTYPE='4') ");
			String sql = "select * from V_QUALIFICATIONAPPLY "+sb.toString();
			return sql;
		}

		//��ѯ����
		@Override
		public String getCountSql() {
			//��ѯ��ǰ���õ�λ��
			StringBuffer sb=new StringBuffer(" where rtrim(APPROVALDEPT)='"+deptId+"' and rtrim(cretGrade)=1 ");
			
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(corpName!= null && !"".equals(corpName)){
				sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
			}
			if(cretType != null && !"".equals(cretType)){
				sb.append(" and cretType = '"+cretType+"'");
			}
			if(cretLevel != null && !"".equals(cretLevel)){
				sb.append(" and cretLevel = '"+cretLevel+"'");
			}
			if(cretSequence != null && !"".equals(cretSequence)){
				sb.append(" and cretSequence = '"+cretSequence+"'");
			}
			if(specialtyType != null && !"".equals(specialtyType)){
				sb.append(" and specialtyType = '"+specialtyType+"'");
			}
			if(cretGrade != null && !"".equals(cretGrade)){
				sb.append(" and cretGrade = '"+cretGrade+"'");
			}
			if(addTypeNum != null && !"".equals(addTypeNum)){
				sb.append(" and addTypeNum = '"+addTypeNum+"'");
			}
			sb.append("and (QUALIFTYPE='1' or QUALIFTYPE='3' or QUALIFTYPE='4') ");
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

		public String getCretType() {
			return cretType;
		}

		public void setCretType(String cretType) {
			this.cretType = cretType;
		}

		public String getCretLevel() {
			return cretLevel;
		}

		public void setCretLevel(String cretLevel) {
			this.cretLevel = cretLevel;
		}

		public String getCretSequence() {
			return cretSequence;
		}

		public void setCretSequence(String cretSequence) {
			this.cretSequence = cretSequence;
		}

		public String getSpecialtyType() {
			return specialtyType;
		}

		public void setSpecialtyType(String specialtyType) {
			this.specialtyType = specialtyType;
		}

		public String getCretGrade() {
			return cretGrade;
		}

		public void setCretGrade(String cretGrade) {
			this.cretGrade = cretGrade;
		}

		public String getAddTypeNum() {
			return addTypeNum;
		}

		public void setAddTypeNum(String addTypeNum) {
			this.addTypeNum = addTypeNum;
		}

		public String getDeptId() {
			return deptId;
		}

		public void setDeptId(String deptId) {
			this.deptId = deptId;
		}

}