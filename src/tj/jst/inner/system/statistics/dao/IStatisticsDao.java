package com.tj.jst.inner.system.statistics.dao;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface IStatisticsDao {

	int countCorps();

	int countSkillWorkers();

	int countTitles();

	int countCertificateCity();

	int countCertificateProvince();
	
	int countCertificateCountry() ;
	
	
	
}
