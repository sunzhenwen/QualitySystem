package com.tj.jst.outside.businessReport.newQualification.service;

import java.util.List;

import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.dao.INewQualificationDao;
import com.tj.jst.outside.businessReport.newQualification.dao.NewQualificationDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;


/**
 * 资质申请上报
 * @author Administrator
 *
 */
public class NewQualificationServiceImpl implements INewQualificationService {

	/**
	 * 新申请资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check , String corpCode)
	{
		INewQualificationDao newQualificationDao = new NewQualificationDaoImpl();
		return newQualificationDao.queryCertifiedService(check,corpCode);
	}
	
	/**
	 * 资质服务事项提交
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
			//list.get(i).setCorpId(login.getUserId());//主键
			//list.get(i).setCorpName(login.getUserName());//企业名称
			//list.get(i).setCorpCode(login.getCorpCode());//组织机构代码
			list.get(i).setProvinceNum(login.getProvincenum());//省
			list.get(i).setProvinceName(login.getProvinceName());//省名称
			list.get(i).setCityNum(login.getCitynum());//市
			list.get(i).setCityName(login.getCityName());//市名称
			list.get(i).setCountyNum(login.getCountynum());//区
			list.get(i).setCountyName(login.getCountyName());//区名称
			//list.get(i).setAddress(login.getAddress());//营业地址
			
			if(check.equals("3")){
				list.get(i).setQualifType("1");//已申请
				list.get(i).setApprovalDeptName(login.getSpareName());
			}else{
				list.get(i).setQualifType("a");//已申请
			}
			
			list.get(i).setAddTypeNum(addTypeNum);//资质资格取得方式
			//list.get(i).setEconomicNum(login.getEconomicNum());//企业登记注册类型
			//list.get(i).setLicenseNum(login.getLicenseNum());//工商营业执照号
			//list.get(i).setLegalMan(login.getLegalMan());			//法定代表人姓名
			list.get(i).setIdCardTypeNum(login.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			//list.get(i).setLegalManIdCard(login.getLegalManIdCard());//法定代表人证件号码
			list.get(i).setLegaLManDuty(login.getLegaLManDuty());	//法定代表人职务
			//list.get(i).setLegaManProtitle(login.getLegaManProtitle());//法定代表人职称
			//list.get(i).setRegPrin(login.getRegPrin());//注册资本
			//list.get(i).setAssets(login.getAssets());				//净资产
			list.get(i).setMachinery(login.getMachinery());;		//机械设备 
			list.get(i).setSpare1(login.getSpare1());
		}
		if (isEmpty) {
			return "您的基本信息填写不完善或不正确，请核对并修改企业基本信息后再申请";
		} else {
			return newQualificationDao.submitCertifiedService(list);
		}
		
	}

	@Override
	public List<CertifiedService> queryCertifiedService(String check,String corpid, String addTypeNum) {
		// TODO 自动生成的方法存根
		INewQualificationDao newQualificationDao = new NewQualificationDaoImpl();
		return newQualificationDao.queryCertifiedService(check, corpid, addTypeNum);
	}
}
