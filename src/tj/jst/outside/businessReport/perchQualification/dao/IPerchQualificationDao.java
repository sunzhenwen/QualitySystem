package com.tj.jst.outside.businessReport.perchQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;

/**
 * 资质就位上报
 * @author DarkFlameMaster
 *
 */
public interface IPerchQualificationDao {

	/**
	 * 就位资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	
	/**
	 * 根据传入的ids查询资质服务事项信息
	 * @param certIds
	 * @return
	 */
	public List<PerchQualification> queryCertifieds(String[] certIds);
	
	/**
	 * 资质服务事项提交
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(List<PerchQualification> list);

	/**
	 * 将数据直接从基本信息表里取出并赋值
	 * @param perchQualification
	 * @param corpId 
	 * @return 
	 */
	public Boolean getBasicInfo(PerchQualification perchQualification, String corpId);
}
