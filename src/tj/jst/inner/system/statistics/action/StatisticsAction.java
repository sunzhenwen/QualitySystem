package com.tj.jst.inner.system.statistics.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.system.statistics.service.IStatisticsService;
import com.tj.jst.inner.system.statistics.service.StatisticsServiceImpl;


/**
 * 企业数量、证书数量、人员数量统计
 * @author Administrator
 *
 */
public class StatisticsAction extends BaseAction {
	
	private int countCorps ;
	private int countSkillWorkers ;
	private int countTitles;
	private int countCertificateCity ; //地市证书数量
	private int countCertificateProvince ; //省级证书数量
	private int countCertificateCountry ; //国家级证书数量 
	
	public String queryPage() {
		
		IStatisticsService service = new StatisticsServiceImpl() ;
		
		countCorps = service.countCorps() ;
		countSkillWorkers = service.countSkillWorkers() ;
		countTitles = service.countTitles() ;
		countCertificateCity = service.countCertificateCity() ;
		countCertificateProvince = service.countCertificateProvince() ;
		countCertificateCountry = service.countCertificateCountry();
		
		return "queryPage";
	}
	
	public int getCountCorps() {
		return countCorps;
	}
	public void setCountCorps(int countCorps) {
		this.countCorps = countCorps;
	}
	public int getCountSkillWorkers() {
		return countSkillWorkers;
	}
	public void setCountSkillWorkers(int countSkillWorkers) {
		this.countSkillWorkers = countSkillWorkers;
	}
	public int getCountTitles() {
		return countTitles;
	}
	public void setCountTitles(int countTitles) {
		this.countTitles = countTitles;
	}
	public int getCountCertificateCity() {
		return countCertificateCity;
	}
	public void setCountCertificateCity(int countCertificateCity) {
		this.countCertificateCity = countCertificateCity;
	}
	public int getCountCertificateProvince() {
		return countCertificateProvince;
	}
	public void setCountCertificateProvince(int countCertificateProvince) {
		this.countCertificateProvince = countCertificateProvince;
	}


	public int getCountCertificateCountry() {
		return countCertificateCountry;
	}


	public void setCountCertificateCountry(int countCertificateCountry) {
		this.countCertificateCountry = countCertificateCountry;
	}
	
}
