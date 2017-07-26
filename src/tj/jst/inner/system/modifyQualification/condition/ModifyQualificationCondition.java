package com.tj.jst.inner.system.modifyQualification.condition;

import java.sql.Date;
import com.tj.jst.base.page.Condition;

/**
 * ��ҵ�ѻ����ʴ��
 * @author Administrator
 *
 */
public class ModifyQualificationCondition extends Condition {
	
	private String corpCode ;
	private String corpName ;

	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem("creatDate desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1  ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sql = "select * from TBQUALIFICATIONAPPLY "+sb.toString();
		System.out.println("��������sql = "+sql);
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		this.setOrderByItem("creatDate desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1  ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		String sqlCount="select count(*) from TBQUALIFICATIONAPPLY "+sb.toString();
		System.out.println("��������sqlCount = "+sqlCount);
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}


}
