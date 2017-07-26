package com.tj.jst.inner.qualificationProductivity.queryCorp.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.IQueryCorpService;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.QueryCorpServiceImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;

/**
 * 查询所有资质信息
 * @author DarkFlameMaster
 *
 */
public class QueryCretAction extends BaseAction{
	
	private List<CertifiedService> certifieds;	//服务事项list
	private String[] certIds;					//服务事项ids
	private String provinceNum ;
	private String cityNum ;
	private List<CertifiedService> certifieds1;	//服务事项list
	private List<CertifiedService> certifieds2;	//服务事项list
	private List<CertifiedService> certifieds3;	//服务事项list
	

	/**
	 * 资质信息全部列表
	 * @return
	 * @throws Exception
	 */
	public String getCretInfo()throws Exception{
		IQueryCorpService corpService = new QueryCorpServiceImpl();
		certifieds1 = corpService.queryGradeCertifiedService("1");  //国家资质
		certifieds2 = corpService.queryGradeCertifiedService("2");  //省资质
		certifieds3 = corpService.queryGradeCertifiedService("3");  //市资质
		this.getProvinceNum();
		this.getCityNum();
		System.out.println("cityNumcityNumcityNumcityNum"+getProvinceNum()+"cityNumcityNumcityNumcityNum"+getCityNum());
		return "certifiedServicePage";
	}

	public List<CertifiedService> getCertifieds() {
		return certifieds;
	}

	public void setCertifieds(List<CertifiedService> certifieds) {
		this.certifieds = certifieds;
	}

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<CertifiedService> getCertifieds1() {
		return certifieds1;
	}

	public void setCertifieds1(List<CertifiedService> certifieds1) {
		this.certifieds1 = certifieds1;
	}

	public List<CertifiedService> getCertifieds2() {
		return certifieds2;
	}

	public void setCertifieds2(List<CertifiedService> certifieds2) {
		this.certifieds2 = certifieds2;
	}

	public List<CertifiedService> getCertifieds3() {
		return certifieds3;
	}

	public void setCertifieds3(List<CertifiedService> certifieds3) {
		this.certifieds3 = certifieds3;
	}
	
	
	
}
