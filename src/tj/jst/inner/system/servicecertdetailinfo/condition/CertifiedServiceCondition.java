package com.tj.jst.inner.system.servicecertdetailinfo.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
public class CertifiedServiceCondition extends Condition {

	//��ʼʱ��
	private Date startDate;
	//����ʱ��
	private Date endDate;
	//������������
	private String certName;
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	private String cretType;
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private String cretLevel;
	//��������(�ֵ��TBTRADETYPEDIC)
	private String cretSequence;
	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	private String specialtyType;
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	private String cretGrade;
	//�Ƿ�����͵ȼ�
	private String lowestType;
	//�Ƿ������
	private String isUpgrade;
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem("CREATEDATE desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where type=0 ");
		
		if(isUpgrade!= null && !"".equals(isUpgrade)){
			sb.append(" and isUpgrade = '"+isUpgrade+"'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		if(certName!= null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'"); 
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
		if(lowestType != null && !"".equals(lowestType)){
			sb.append(" and lowestType = '"+lowestType+"'");
		}
		String sql = "select * from V_SERVICECERTDETAIL "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		this.setOrderByItem("CREATEDATE desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where type=0 ");
		
		if(isUpgrade!= null && !"".equals(isUpgrade)){
			sb.append(" and isUpgrade = '"+isUpgrade+"'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		if(certName!= null && !"".equals(certName)){
			sb.append(" and certName like '%"+certName.trim()+"%'"); 
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
		if(lowestType != null && !"".equals(lowestType)){
			sb.append(" and lowestType = '"+lowestType+"'");
		}
		
		String sqlCount="select count(*) from V_SERVICECERTDETAIL "+sb.toString();
		return sqlCount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
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

	public String getLowestType() {
		return lowestType;
	}

	public void setLowestType(String lowestType) {
		this.lowestType = lowestType;
	}

	public String getIsUpgrade() {
		return isUpgrade;
	}

	public void setIsUpgrade(String isUpgrade) {
		this.isUpgrade = isUpgrade;
	}

}
