package com.tj.jst.outside.businessReport.newQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;


/**
 * ���������ϱ�
 * @author Administrator
 *
 */
public interface INewQualificationService {
	
	/**
	 * ���������ʷ��������ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpCode);
	
	/**
	 * �����������ʷ��������ѯҳ��
	 * @author �ɽ
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check,String corpid,String addTypeNum);
	
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String check);
}
