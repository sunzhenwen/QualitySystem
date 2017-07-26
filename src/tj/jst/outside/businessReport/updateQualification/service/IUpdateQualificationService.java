package com.tj.jst.outside.businessReport.updateQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;

/**
 * ���������ϱ�
 * @author DarkFlameMaster
 *
 */
public interface IUpdateQualificationService {

	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String check);
}
