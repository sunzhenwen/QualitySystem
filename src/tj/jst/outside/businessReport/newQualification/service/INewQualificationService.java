package com.tj.jst.outside.businessReport.newQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;


/**
 * 资质申请上报
 * @author Administrator
 *
 */
public interface INewQualificationService {
	
	/**
	 * 新申请资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpCode);
	
	/**
	 * 增项申请资质服务事项查询页面
	 * @author 李宝山
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check,String corpid,String addTypeNum);
	
	
	/**
	 * 资质服务事项提交
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String check);
}
