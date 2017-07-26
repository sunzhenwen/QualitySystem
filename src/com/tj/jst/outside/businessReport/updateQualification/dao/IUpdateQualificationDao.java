package com.tj.jst.outside.businessReport.updateQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 资质更新上报
 * @author DarkFlameMaster
 *
 */
public interface IUpdateQualificationDao {
	
	/**
	 * 查询国家级别资质
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check ,String corpId);
	/**
	 * 根据传入的ids查询资质服务事项信息
	 * @param certIds
	 * @return
	 */
	public List<NewQualification> queryCertifieds(String[] certIds);
	/**
	 * 资质服务事项提交
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(List<NewQualification> list);

}
