package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 资质服务事项维护
 * @author Administrator
 *
 */
public interface IQualificationRevocationService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCretTypes();
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
	//资质序列(字典表：TBTRADETYPEDIC)
	public List<DictionaryClass> queryCretSequences();
	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId);
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades();
	public List<Department> getDepartment();

	/**
	 * 跳转打回页面
	 * @param corpId
	 * @return
	 */
	public QualificationRevocation revocationPage(String relationId);

	/**
	 * 资质打回操作
	 * @return
	 */
	public String revocation(QualificationRevocation qualificationRevocation);
	
}
