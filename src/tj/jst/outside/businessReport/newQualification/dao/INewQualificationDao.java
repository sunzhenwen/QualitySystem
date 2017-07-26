package com.tj.jst.outside.businessReport.newQualification.dao;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


/**
 * ���������ϱ�
 * @author Administrator
 *
 */
public interface INewQualificationDao {
	
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

	public Boolean getBasicInfo(NewQualification newQualification, String corpId);
	
}
