/**
 * 
 */
package com.tj.jst.outside.businessReport.qualitychange.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;

/**
 * @author Administrator
 *
 */
public interface QualityChangeDao {
	/**
	 * 查询已拥有未过期的资质
	 * @author 李宝山
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryQualityList(String corpId);
	
	public String addQualityChange(TB_QUALITY_CHANGE qualityChange);
	

	public List<TB_QUALITY_CHANGE> queryQualityChange(String quality_change_id,String state);
	
	public String updateQualityChange(TB_QUALITY_CHANGE  qualityChange);
	
	public String updateQualityCertificate(TB_QUALITY_CHANGE qualityChange);
	public TB_QUALITY_CHANGE queryQualityChangeById(String quality_change_id);
	
	public DictionaryClass queryEconomicName(String code);
	public List<TB_QUALITY_CHANGE> selectQualityChange(String name);
	
	public Page corpQualityChangeQuery(Condition condition);
	public Page selectQualityChange(Condition condition);
	public Page queryQualityChange(Condition condition);
	public String updateCorpBasicInfoSpare(TB_QUALITY_CHANGE qualityChange);
	public String changeCorpCretInfoSpare(TB_QUALITY_CHANGE qualityChange);
	
	
	public String getCheckType(String userId);
	
	public String deleteQualityChangeById(String qualityChangeId);
	
	
}
