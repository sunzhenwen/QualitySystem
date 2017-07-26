package com.tj.jst.outside.businessReport.newQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


/**
 * 资质申请上报
 * @author Administrator
 *
 */
public interface INewQualificationDao {
	
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

	public Boolean getBasicInfo(NewQualification newQualification, String corpId);
	
}
