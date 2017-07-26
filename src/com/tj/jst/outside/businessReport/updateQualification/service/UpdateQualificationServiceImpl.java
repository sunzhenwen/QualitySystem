package com.tj.jst.outside.businessReport.updateQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.updateQualification.dao.IUpdateQualificationDao;
import com.tj.jst.outside.businessReport.updateQualification.dao.UpdateQualificationDaoImpl;

/**
 * ���������ϱ�
 * @author DarkFlameMaster
 *
 */
public class UpdateQualificationServiceImpl implements IUpdateQualificationService{

	/**
	 * ��ѯ���Ҽ�������
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CertifiedService> queryCertifiedService(String check , String corpId) {
		// TODO Auto-generated method stub
		IUpdateQualificationDao updateQualificationDao = new UpdateQualificationDaoImpl();
		return updateQualificationDao.queryCertifiedService(check,corpId);
	}

	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	@Override
	public String submitCertifiedService(Login login, String[] certIds,
			String addTypeNum,String check) {
		// TODO Auto-generated method stub
		IUpdateQualificationDao updateQualificationDao = new UpdateQualificationDaoImpl();
		List<NewQualification> list =updateQualificationDao.queryCertifieds(certIds);
		for(int i=0;i<list.size();i++)
		{
			list.get(i).setCorpId(login.getUserId());//����
			list.get(i).setCorpName(login.getUserName());//��ҵ����
			list.get(i).setCorpCode(login.getCorpCode());//��֯��������
			list.get(i).setProvinceNum(login.getProvincenum());//ʡ
			list.get(i).setProvinceName(login.getProvinceName());//ʡ����
			list.get(i).setCityNum(login.getCitynum());//��
			list.get(i).setCityName(login.getCityName());//������
			list.get(i).setCountyNum(login.getCountynum());//��
			list.get(i).setCountyName(login.getCountyName());//������
			list.get(i).setAddress(login.getAddress());//Ӫҵ��ַ
			list.get(i).setQualifType("a");//������
			list.get(i).setAddTypeNum(addTypeNum);//�����ʸ�ȡ�÷�ʽ
			list.get(i).setEconomicNum(login.getEconomicNum());//��ҵ�Ǽ�ע������
			list.get(i).setLicenseNum(login.getLicenseNum());//����Ӫҵִ�պ�
			list.get(i).setLegalMan(login.getLegalMan());			//��������������
			list.get(i).setIdCardTypeNum(login.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			list.get(i).setLegalManIdCard(login.getLegalManIdCard());//����������֤������
			list.get(i).setLegaLManDuty(login.getLegaLManDuty());	//����������ְ��
			list.get(i).setLegaManProtitle(login.getLegaManProtitle());//����������ְ��
			list.get(i).setRegPrin(login.getRegPrin());//ע���ʱ�
			list.get(i).setAssets(login.getAssets());				//���ʲ�
			list.get(i).setMachinery(login.getMachinery());;		//��е�豸 
			list.get(i).setSpare1(login.getSpare1());
		}
		return updateQualificationDao.submitCertifiedService(list);
	}

}
