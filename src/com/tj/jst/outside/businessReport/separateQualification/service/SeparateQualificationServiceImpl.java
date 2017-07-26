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
 * 资质就位上报
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
			list.get(i).setCorpId(login.getUserId());//主键
			list.get(i).setCorpName(login.getUserName());//企业名称
			list.get(i).setCorpCode(login.getCorpCode());//组织机构代码
			list.get(i).setProvinceNum(login.getProvincenum());//省
			list.get(i).setProvinceName(login.getProvinceName());//省名称
			list.get(i).setCityNum(login.getCitynum());//市
			list.get(i).setCityName(login.getCityName());//市名称
			list.get(i).setCountyNum(login.getCountynum());//区
			list.get(i).setCountyName(login.getCountyName());//区名称
			list.get(i).setAddress(login.getAddress());//营业地址
			list.get(i).setQualifType("a");//已申请
			list.get(i).setAddTypeNum(addTypeNum);//资质资格取得方式
			list.get(i).setEconomicNum(login.getEconomicNum());//企业登记注册类型
			list.get(i).setLicenseNum(login.getLicenseNum());//工商营业执照号
			list.get(i).setLegalMan(login.getLegalMan());			//法定代表人姓名
			list.get(i).setIdCardTypeNum(login.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			list.get(i).setLegalManIdCard(login.getLegalManIdCard());//法定代表人证件号码
			list.get(i).setLegaLManDuty(login.getLegaLManDuty());	//法定代表人职务
			list.get(i).setLegaManProtitle(login.getLegaManProtitle());//法定代表人职称
			list.get(i).setRegPrin(login.getRegPrin());//注册资本
			list.get(i).setAssets(login.getAssets());				//净资产
			list.get(i).setMachinery(login.getMachinery());;		//机械设备 
			list.get(i).setSpare1(login.getSpare1());
		}
		return dao.submitCertified(list,separateQualification);
	}
	
}
