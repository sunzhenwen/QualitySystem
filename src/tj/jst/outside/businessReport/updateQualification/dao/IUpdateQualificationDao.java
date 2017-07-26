package com.tj.jst.outside.businessReport.updateQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ���ʸ����ϱ�
 * @author DarkFlameMaster
 *
 */
public interface IUpdateQualificationDao {
	
	/**
	 * ��ѯ���Ҽ�������
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check ,String corpId);
	/**
	 * ���ݴ����ids��ѯ���ʷ���������Ϣ
	 * @param certIds
	 * @return
	 */
	public List<NewQualification> queryCertifieds(String[] certIds);
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(List<NewQualification> list);

}
