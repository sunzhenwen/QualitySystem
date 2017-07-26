package com.tj.jst.outside.businessReport.newQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.dao.INewQualificationDao;
import com.tj.jst.outside.businessReport.newQualification.dao.NewQualificationDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


/**
 * ���������ϱ�
 * @author Administrator
 *
 */
public class NewQualificationServiceImpl implements INewQualificationService {

	/**
	 * ���������ʷ��������ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpCode)
	{
		INewQualificationDao newQualificationDao = new NewQualificationDaoImpl();
		return newQualificationDao.queryCertifiedService(check,corpCode);
	}
	
	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(Login login,String[] certIds,String addTypeNum,String check)
	{
		
		Boolean isEmpty = false ;
		INewQualificationDao newQualificationDao = new NewQualificationDaoImpl();
		List<NewQualification> list = newQualificationDao.queryCertifieds(certIds);
		
		for(int i=0;i<list.size();i++)
		{
			isEmpty = newQualificationDao.getBasicInfo(list.get(i),login.getUserId());
			//list.get(i).setCorpId(login.getUserId());//����
			//list.get(i).setCorpName(login.getUserName());//��ҵ����
			//list.get(i).setCorpCode(login.getCorpCode());//��֯��������
			list.get(i).setProvinceNum(login.getProvincenum());//ʡ
			list.get(i).setProvinceName(login.getProvinceName());//ʡ����
			list.get(i).setCityNum(login.getCitynum());//��
			list.get(i).setCityName(login.getCityName());//������
			list.get(i).setCountyNum(login.getCountynum());//��
			list.get(i).setCountyName(login.getCountyName());//������
			//list.get(i).setAddress(login.getAddress());//Ӫҵ��ַ
			
			if(check.equals("3")){
				list.get(i).setQualifType("1");//������
				list.get(i).setApprovalDeptName(login.getSpareName());
			}else{
				list.get(i).setQualifType("a");//������
			}
			
			list.get(i).setAddTypeNum(addTypeNum);//�����ʸ�ȡ�÷�ʽ
			//list.get(i).setEconomicNum(login.getEconomicNum());//��ҵ�Ǽ�ע������
			//list.get(i).setLicenseNum(login.getLicenseNum());//����Ӫҵִ�պ�
			//list.get(i).setLegalMan(login.getLegalMan());			//��������������
			list.get(i).setIdCardTypeNum(login.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			//list.get(i).setLegalManIdCard(login.getLegalManIdCard());//����������֤������
			list.get(i).setLegaLManDuty(login.getLegaLManDuty());	//����������ְ��
			//list.get(i).setLegaManProtitle(login.getLegaManProtitle());//����������ְ��
			//list.get(i).setRegPrin(login.getRegPrin());//ע���ʱ�
			//list.get(i).setAssets(login.getAssets());				//���ʲ�
			list.get(i).setMachinery(login.getMachinery());;		//��е�豸 
			list.get(i).setSpare1(login.getSpare1());
		}
		if (isEmpty) {
			return "���Ļ�����Ϣ��д�����ƻ���ȷ����˶Բ��޸���ҵ������Ϣ��������";
		} else {
			return newQualificationDao.submitCertifiedService(list);
		}
		
	}

	@Override
	public List<CertifiedService> queryCertifiedService(String check,String corpid, String addTypeNum) {
		// TODO �Զ����ɵķ������
		INewQualificationDao newQualificationDao = new NewQualificationDaoImpl();
		return newQualificationDao.queryCertifiedService(check, corpid, addTypeNum);
	}
}
