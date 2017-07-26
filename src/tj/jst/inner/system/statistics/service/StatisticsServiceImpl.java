package com.tj.jst.inner.system.statistics.service;

import com.tj.jst.inner.system.statistics.dao.IStatisticsDao;
import com.tj.jst.inner.system.statistics.dao.StatisticsDaoImpl;

public class StatisticsServiceImpl implements IStatisticsService {

	@Override
	public int countCorps() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countCorps();
	}

	@Override
	public int countSkillWorkers() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countSkillWorkers();
	}

	@Override
	public int countTitles() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countTitles();
	}

	@Override
	public int countCertificateCity() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countCertificateCity();
	}

	@Override
	public int countCertificateProvince() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countCertificateProvince();
	}
	
	@Override
	public int countCertificateCountry() {
		// TODO Auto-generated method stub
		IStatisticsDao dao = new StatisticsDaoImpl() ;
		return dao.countCertificateCountry();
	}
}
