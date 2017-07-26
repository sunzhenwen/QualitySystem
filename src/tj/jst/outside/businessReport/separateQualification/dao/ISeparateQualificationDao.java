package com.tj.jst.outside.businessReport.separateQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;

/**
 * 资质就位上报
 * @author DarkFlameMaster
 *
 */
public interface ISeparateQualificationDao {

	List<SeparateQualification> queryCorpQualification(String queryCorp);

	List<SeparateQualification> queryEXCorpQualification(String[] relationIds);

	List<NewQualification> queryCertifieds(
			List<SeparateQualification> separateQualification);

	String submitCertified(List<NewQualification> list,List<SeparateQualification> separateQualification);
	
}
