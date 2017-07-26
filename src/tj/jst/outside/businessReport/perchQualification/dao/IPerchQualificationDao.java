package com.tj.jst.outside.businessReport.perchQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public interface IPerchQualificationDao {

	/**
	 * ��λ���ʷ��������ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpId);
	
	/**
	 * ���ݴ����ids��ѯ���ʷ���������Ϣ
	 * @param certIds
	 * @return
	 */
	public List<PerchQualification> queryCertifieds(String[] certIds);
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(List<PerchQualification> list);

	/**
	 * ������ֱ�Ӵӻ�����Ϣ����ȡ������ֵ
	 * @param perchQualification
	 * @param corpId 
	 * @return 
	 */
	public Boolean getBasicInfo(PerchQualification perchQualification, String corpId);
}
