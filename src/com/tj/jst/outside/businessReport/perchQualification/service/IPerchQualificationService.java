package com.tj.jst.outside.businessReport.perchQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;

/**
 * 资质就位上报
 * @author DarkFlameMaster
 *
 */
public interface IPerchQualificationService {

	/**
	 * 就位资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	
	/**
	 * 资质服务事项提交
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String typeNum);
}
