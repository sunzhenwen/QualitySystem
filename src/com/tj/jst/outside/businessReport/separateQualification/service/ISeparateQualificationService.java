package com.tj.jst.outside.businessReport.separateQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public interface ISeparateQualificationService {

	List<SeparateQualification> queryCorpQualification(String queryCorp);

	List<SeparateQualification> queryEXCorpQualification(String[] relationIds);

	String submitCertified(List<SeparateQualification> separateQualification,
			String addTypeNum, Login login);
	
}
