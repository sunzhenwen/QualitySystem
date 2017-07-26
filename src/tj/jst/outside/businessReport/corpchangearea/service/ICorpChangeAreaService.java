package com.tj.jst.outside.businessReport.corpchangearea.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

/**
 * 企业跨地市变更接口类
 * 
 * @author DarkFlameMaster
 *
 */
public interface ICorpChangeAreaService {

	/**
	 * 查询企业信息
	 * 
	 * @param corpName
	 * @return
	 */
	public CertifiedCorp queryPage(String corpName);

	/**
	 * 提交归属地变更申请信息
	 * 
	 * @param change
	 * @return
	 */
	public String approvalUpdate(ChangeArea change,int mark);

	/**
	 * 查询省
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryProvince();

	/**
	 * 查询市
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<DictionaryClass> queryCity(String provinceId);

	/**
	 * 查询是否需要厅局审批
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryMark(String corpName);
}
