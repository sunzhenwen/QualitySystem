package com.tj.jst.outside.businessReport.separateQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.perchQualification.dao.IPerchQualificationDao;
import com.tj.jst.outside.businessReport.perchQualification.dao.PerchQualificationDaoImpl;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;
import com.tj.jst.outside.businessReport.separateQualification.dao.ISeparateQualificationDao;
import com.tj.jst.outside.businessReport.separateQualification.dao.SeparateQualificationDaoImpl;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;

/**
 * ���ʾ�λ�ϱ�
 * @author DarkFlameMaster
 *
 */
public class SeparateQualificationServiceImpl implements ISeparateQualificationService {

	@Override
	public List<SeparateQualification> queryCorpQualification(String queryCorp) {
		// TODO Auto-generated method stub
		ISeparateQualificationDao dao = new SeparateQualificationDaoImpl();
		return dao.queryCorpQualification(queryCorp);
	}

	@Override
	public List<SeparateQualification> queryEXCorpQualification(
			String[] relationIds) {
		// TODO Auto-generated method stub
		ISeparateQualificationDao dao = new SeparateQualificationDaoImpl();
		return dao.queryEXCorpQualification(relationIds);
	}

	@Override
	public String submitCertified(
			List<SeparateQualification> separateQualification,
			String addTypeNum, Login login) {
		// TODO Auto-generated method stub
		ISeparateQualificationDao dao = new SeparateQualificationDaoImpl();
		List<NewQualification> list =dao.queryCertifieds(separateQualification);
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
		return dao.submitCertified(list,separateQualification);
	}
	
}
