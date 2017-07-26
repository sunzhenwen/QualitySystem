package com.tj.jst.inner.qualificationProductivity.writeOff.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ����ע��
 * @author Administrator
 *
 */
public class WriteOffCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	private String deptId;
	private String corpName;//��ҵ����
	private String licenseNum;//Ӫҵִ��ע���
	private String legalMan;//����������
	private String econmicNum;//��������
	private String certName;//������𼰵ȼ�
	private String certId;//֤����
	private String personalID;
//	
//	public WriteOffCondition()
//	{
//		
//	}
//	
//	public WriteOffCondition(String deptId,String personalID)
//	{
//		this.deptId = deptId;
//		this.personalID = personalID;
//	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" ORGANDATE desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb = null;
		//����ǹ������û�
		if(deptId.equals("230100"))
		{
			//��ѯ��ǰ���õ�λ��
			sb = new StringBuffer(" where APPROVALSTAFFID='"+personalID+"' and ISVALID=1 and WRITEOFFTYPE=1 ");
		}else if( personalID.equals("400105") || personalID.equals("400202") || personalID.equals("400223") || personalID.equals("400204") )
		{
			//��ѯ��ǰ���õ�λ��
			sb = new StringBuffer(" where APPROVALDEPT in ('20','0','3','17','18','19') and ISVALID=1 and WRITEOFFTYPE=1 ");
		}else if(deptId.equals("3") || personalID.equals("400000") || personalID.equals("400007") || personalID.equals("400060") || personalID.equals("400061") || personalID.equals("400104") || personalID.equals("401102") || personalID.equals("401142") || personalID.equals("401148") ) {
			sb = new StringBuffer(" where APPROVALDEPT='"+deptId+"' and ISVALID=1 and WRITEOFFTYPE=4 ");
		}else
		{
			sb = new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and ISVALID=1 and WRITEOFFTYPE=1 ");
		}

		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '%"+licenseNum.trim()+"%'"); 
		}
		if(legalMan!= null && !"".equals(legalMan)){
			sb.append(" and legalMan like '%"+legalMan.trim()+"%'"); 
		}
		if(econmicNum != null && !"".equals(econmicNum)){
			sb.append(" and ECONOMICNUM = '"+econmicNum+"'");
		}
		if(certId != null && !"".equals(certId)){
			sb.append(" and certId like '%"+certId.trim()+"%'");
		}
		if(certName != null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and WRITEOFFAPPDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and WRITEOFFAPPDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		String sql = "select * from v_TBCORPCERTINFO "+sb.toString();
		System.out.println(sql);
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		StringBuffer sb = null;
		//����ǹ������û�
		if(deptId.equals("230100"))
		{
			//��ѯ��ǰ���õ�λ��
			sb = new StringBuffer(" where APPROVALSTAFFID='"+personalID+"' and ISVALID=1 and WRITEOFFTYPE=1 ");
		}else if( personalID.equals("400105") || personalID.equals("400202") || personalID.equals("400223") || personalID.equals("400204") )
		{
			//��ѯ��ǰ���õ�λ��
			sb = new StringBuffer(" where APPROVALDEPT in ('20','0','3','17','18','19') and ISVALID=1 and WRITEOFFTYPE=1 ");
		}else if(deptId.equals("3") || personalID.equals("400000") || personalID.equals("400007") || personalID.equals("400060") || personalID.equals("400061") || personalID.equals("400104") || personalID.equals("401102") || personalID.equals("401142") || personalID.equals("401148") ) {
			sb = new StringBuffer(" where APPROVALDEPT='"+deptId+"' and ISVALID=1 and WRITEOFFTYPE=4 ");
		}else
		{
			sb = new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and ISVALID=1 and WRITEOFFTYPE=1 ");
		}
		
		
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(licenseNum!= null && !"".equals(licenseNum)){
			sb.append(" and licenseNum like '%"+licenseNum.trim()+"%'"); 
		}
		if(legalMan!= null && !"".equals(legalMan)){
			sb.append(" and legalMan like '%"+legalMan.trim()+"%'"); 
		}
		if(econmicNum != null && !"".equals(econmicNum)){
			sb.append(" and ECONOMICNUM = '"+econmicNum+"'");
		}
		if(certId != null && !"".equals(certId)){
			sb.append(" and certId like '%"+certId.trim()+"%'");
		}
		if(certName != null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and WRITEOFFAPPDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and WRITEOFFAPPDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		String sqlCount="select count(*) from v_TBCORPCERTINFO "+sb.toString();
		System.out.println(sqlCount);
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}

	public String getEconmicNum() {
		return econmicNum;
	}

	public void setEconmicNum(String econmicNum) {
		this.econmicNum = econmicNum;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
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

}
