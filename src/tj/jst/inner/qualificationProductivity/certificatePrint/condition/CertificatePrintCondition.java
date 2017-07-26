package com.tj.jst.inner.qualificationProductivity.certificatePrint.condition;

import com.tj.jst.base.page.Condition;

/**
 * ֤���ӡ
 * @author hhc
 *
 */
public class CertificatePrintCondition extends Condition {

	private String corpName;//��ҵ����
	private String licenseNum;//Ӫҵִ��ע���
	private String legalMan;//����������
	private String econmicNum;//��������
	//private String certName;//������𼰵ȼ�
	private String certId;//֤����
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" certid desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where cretgrade=2 ");

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
//		if(certName != null && !"".equals(certName)){
//			sb.append(" and certName like '%"+certName.trim()+"%'");
//		}
		String sql = "select distinct CorpCode,CorpName,LicenseNum,RegPrin,CertId,LegalMan,EconmicName,UpdateType from v_TBCORPCERTINFO "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		StringBuffer sb = new StringBuffer(" select distinct CorpCode,CorpName,LicenseNum,RegPrin,CertId,LegalMan,EconmicName,UpdateType from v_TBCORPCERTINFO where cretgrade=2 ");
		
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
//		if(certName != null && !"".equals(certName)){
//			sb.append(" and certName like '%"+certName.trim()+"%'");
//		}
		String sqlCount=" select count(*) from ("+sb.toString()+")";
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

//	public String getCertName() {
//		return certName;
//	}
//
//	public void setCertName(String certName) {
//		this.certName = certName;
//	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

}
