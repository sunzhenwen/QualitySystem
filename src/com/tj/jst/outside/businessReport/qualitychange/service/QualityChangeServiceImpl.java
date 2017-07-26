/**
 * 
 */
package com.tj.jst.outside.businessReport.qualitychange.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.qualitychange.dao.QualityChangeDao;
import com.tj.jst.outside.businessReport.qualitychange.dao.QualityChangeDaoImpl;
import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;

/**
 * @author Administrator
 *
 */
public class QualityChangeServiceImpl implements QualityChangeService{

	@Override
	public List<CertifiedService> queryQualityList(String corpId) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.queryQualityList(corpId);
	}

	@Override
	public String addQualityChange(TB_QUALITY_CHANGE qualityChange) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.addQualityChange(qualityChange);
	}

	@Override
	public List<TB_QUALITY_CHANGE> queryQualityChange(String quality_change_id,
			String state) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.queryQualityChange(quality_change_id, state);
	}

	@Override
	public String updateQualityChange(TB_QUALITY_CHANGE  qualityChange) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.updateQualityChange(qualityChange);
	}

	@Override
	public String updateQualityCertificate(TB_QUALITY_CHANGE qualityChange) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		
		return qualityChangeDao.updateQualityCertificate(qualityChange);
	}

	@Override
	public TB_QUALITY_CHANGE queryQualityChangeById(String quality_change_id) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.queryQualityChangeById(quality_change_id);
	}

	@Override
	public DictionaryClass queryEconomicName(String code) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.queryEconomicName(code);
	}

	@Override
	public List<TB_QUALITY_CHANGE> selectQualityChange(String name) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.selectQualityChange(name);
	}

	@Override
	public Page corpQualityChangeQuery(Condition condition) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.corpQualityChangeQuery(condition);
	}

	@Override
	public Page selectQualityChange(Condition condition) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.selectQualityChange(condition);
	}

	@Override
	public Page queryQualityChange(Condition condition) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.queryQualityChange(condition);
	}

	@Override
	public String updateCorpBasicInfoSpare(TB_QUALITY_CHANGE qualityChange) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.updateCorpBasicInfoSpare(qualityChange);
	}

	@Override
	public String changeCorpCretInfoSpare(TB_QUALITY_CHANGE qualityChange) {
		// TODO Auto-generated method stub
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.changeCorpCretInfoSpare(qualityChange);
	}

	@Override
	public String getCheckType(String userId){
		// TODO Auto-generated method stub
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.getCheckType(userId);
	}

	@Override
	public String deleteQualityChangeById(String qualityChangeId) {
		// TODO 自动生成的方法存根
		QualityChangeDao qualityChangeDao=new QualityChangeDaoImpl();
		return qualityChangeDao.deleteQualityChangeById(qualityChangeId);
	}
	
	
	
}
