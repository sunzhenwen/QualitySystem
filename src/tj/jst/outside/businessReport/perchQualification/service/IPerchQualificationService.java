package com.tj.jst.outside.businessReport.perchQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public interface IPerchQualificationService {

	/**
	 * ��λ���ʷ��������ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String typeNum);
}
