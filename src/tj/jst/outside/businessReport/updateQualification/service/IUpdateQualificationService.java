package com.tj.jst.outside.businessReport.updateQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;

/**
 * 资质升级上报
 * @author DarkFlameMaster
 *
 */
public interface IUpdateQualificationService {

	/**
	 * 查询资质
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	/**
	 * 资质服务事项提交
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String check);
}
