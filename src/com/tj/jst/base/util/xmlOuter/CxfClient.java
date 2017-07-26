package com.tj.jst.base.util.xmlOuter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.jdom.JDOMException;

import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;
import com.webservice.client.ProvinceCertClientServiceSoap;

public class CxfClient {
	

	
	public List uploadData(String certid,String strLogOutMark,String prinStaff)
	{
		List returnlist = new ArrayList();
		GenerateXml gx = new GenerateXml();  
        try {
        	//获取资质证书信息
        	List<CorpCert> list = gx.BuildXMLDoc(certid);
        	if(list.size()!=0)
        	{
        		//查询变更表信息
        		TB_QUALITY_CHANGE tqc = gx.queryQualityChange(list.get(0).getCorpId());
        		//打印证书
    			returnlist = this.printDoc(list,gx,certid,tqc);
        	}
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        return returnlist;
	}
	
	public String getNowDate() {
        Date date = null;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fDate = simpleDateFormat.format(c.getTime());
        return fDate;
    }
	
	/**
	 * 打证
	 * @param list
	 */
	public List printDoc(List<CorpCert> list,GenerateXml gx,String certid,TB_QUALITY_CHANGE tqc )
	{
		String isGengMing = "";
		String oldCorpName = "";
		String oldCorpCode = "";
		//判断是否存在变更信息
		if(!"".equals(tqc.getCORPID()) && tqc.getCORPID() != null)
		{
			//判断企业名称是否变更过
			if(tqc.getCORPNAME().equals(tqc.getCHANGE_CORPNAME()))
			{
				//企业名称变更过
				isGengMing = "0";
				oldCorpName = tqc.getCORPNAME();
				oldCorpCode = tqc.getCorpCode();
			}else
			{
				//企业名称未变更过
				isGengMing = "1";
				oldCorpName = tqc.getCORPNAME();
				oldCorpCode = tqc.getCorpCode();
			}
		}else
		{
			//未存在变更信息
			isGengMing = "0";
		}
		
		//接口上传返回值
		int checkNum;
		//返回的错误信息
		String errorString = "";
		List returnlist = new ArrayList();
		
		Holder<java.lang.Integer> uploadCertInfoResult = new Holder<java.lang.Integer>();
		Holder<java.lang.String> strErrMsg = new Holder<java.lang.String>();
		String address = "http://210.12.219.69/CertificateService/ProvinceCertClientService.asmx"; //此处最好用系统参数
		//String address = "http://219.232.244.147/TestCertificateService/ProvinceCertClientService.asmx"; //测试接口
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(address);
		bean.setServiceClass(ProvinceCertClientServiceSoap.class);
		ProvinceCertClientServiceSoap ws = (ProvinceCertClientServiceSoap) bean.create();
		String listXml="";
		String xml = "<?xml version=\"1.0\" encoding=\"gb2312\"?>"
				+ "<root certtypenum=\"7\">"
				+ "<certbasicinfo certid=\""+list.get(0).getCertid()+"\" deptgrade=\""+list.get(0).getDeptgrade()+"\">"
				+ "<corpname ShowName=\"企业名称\">"+list.get(0).getCorpname()+"</corpname>"
				+ "<corpcode ShowName=\"组织机构代码\">"+list.get(0).getCorpcode()+"</corpcode>"
				+ "<licensenum ShowName=\"营业执照注册号\">"+list.get(0).getLicensenum()+"</licensenum>"
				+ "<provincename ShowName=\"所在省份\">"+list.get(0).getProvincename()+"</provincename>"
				+ "<cityname ShowName=\"所在城市\">"+list.get(0).getCityname()+"</cityname>"
				+ "<adminareaname ShowName=\"所在区县\">"+list.get(0).getAdminareaname()+"</adminareaname>"
				+ "<economicpropertyname ShowName=\"经济性质\">"+list.get(0).getEconomicpropertyname()+"</economicpropertyname>"
				+ "<officephone ShowName=\"联系电话\">"+list.get(0).getOfficephone()+"</officephone>"
				+ "<postalcode ShowName=\"邮政编码\">无数据</postalcode>"
				+ "<address ShowName=\"详细地址\">"+list.get(0).getAddress()+"</address>"
				+ "<regprin ShowName=\"注册资金（万元）\">"+list.get(0).getRegprin()+"</regprin>"
				+ "<principalunitname ShowName=\"注册资金单位编号\">"+list.get(0).getPrincipalunitname()+"</principalunitname>"
				+ "<legalman ShowName=\"法定代表人\">"+list.get(0).getLegalman()+"</legalman>"
				+ "<organdate ShowName=\"发证日期\">"+list.get(0).getOrgandate()+"</organdate>"
				+ "<organname ShowName=\"发证机关\">"+list.get(0).getOrganname()+"</organname>"
				+ "<enddate ShowName=\"有效期\">"+list.get(0).getEnddate()+"</enddate>"
				+ "<printnumber ShowName=\"正本流水号\">"+list.get(0).getPrintnumber()+"</printnumber>"
				+ "<printdate ShowName=\"正本打印时间\">"+this.getNowDate()+"</printdate>"
				+ "<fbprintnumber ShowName=\"副本流水号\">"+list.get(0).getFbprintnumber()+"</fbprintnumber>"
				+ "<fbprintdate ShowName=\"副本打印时间\">"+this.getNowDate()+"</fbprintdate>"
				+ "<qrcode ShowName=\"证书正本二维码标识符\">"+list.get(0).getQrcode()+"</qrcode>"
				+ "<fbqrcode ShowName=\"证书副本二维码标识符\">"+list.get(0).getFbqrcode()+"</fbqrcode>"
				+ "<mark ShowName=\"备注\">"+list.get(0).getMark()+"</mark>"
				
				
				

				
				+ "<isgengming ShowName=\"本次操作是否为企业更名 如果是：传1 否则传空或0\">"+isGengMing+"</isgengming>"
				+ "<isxishou ShowName=\"本次操作是否为吸收合并重组 如果是：传1 否则传空或0\">0</isxishou>"
				+ "<oldcorpname ShowName=\"企业更名时，原企业名称\">"+oldCorpName+"</oldcorpname>"
				+ "<oldcorpcode ShowName=\"企业更名时，原企业组织机构代码\">"+oldCorpCode+"</oldcorpcode>"
				+ "<xishoucorpname ShowName=\"吸收合并重组时，原企业名称\"></xishoucorpname>"
				+ "<xishoucorpcode ShowName=\"吸收合并重组时，原企业组织机构代码\"></xishoucorpcode>"
				+ "<xishoucertid ShowName=\"吸收合并重组时，原企业证书编号\"></xishoucertid>"
				
				
				
				+ "<aptitudebound>";
		
		for(int i=0;i<list.size();i++)
		{
			if("公路交通工程交通安全设施".equals(list.get(i).getTradetypeboundname()))
			{
				listXml=listXml+"<Item tradetypename=\""+list.get(i).getTradetypename()+"\" tradetypeboundname=\""+list.get(i).getTradetypeboundname()+"\" gradename=\""+list.get(i).getGradename()+"\" tradetypeboundchildmark=\"交通安全设施\" ismaster=\"\" notedate=\""+list.get(i).getNotedate()+"\" />";
			}else
			{
				listXml=listXml+"<Item tradetypename=\""+list.get(i).getTradetypename()+"\" tradetypeboundname=\""+list.get(i).getTradetypeboundname()+"\" gradename=\""+list.get(i).getGradename()+"\" tradetypeboundchildmark=\"\" ismaster=\"\" notedate=\""+list.get(i).getNotedate()+"\" />";
			}
			
		}

		
		xml=xml+listXml+ "</aptitudebound>"+ "</certbasicinfo>" + "</root>";
		ws.uploadCertInfo("7", "230000", "ki3iPNiuXrNXER2Y", xml, uploadCertInfoResult, strErrMsg);
		
		//接收接口返回标识
		checkNum = uploadCertInfoResult.value;
		if(checkNum==1)
		{
			//如果上传成功更改打印标识
			gx.updateDate(certid);
			//记录打证成功日志
			gx.successLog(certid,xml,strErrMsg.value,"2","打证",list.get(0).getCorpname());
		}
		if(checkNum!=1)
		{
			//如果上传不成功记录日志
			gx.recordLog(certid,xml,strErrMsg.value,list.get(0).getUpdateType(),"打证",list.get(0).getCorpname());
			errorString = "打证:"+strErrMsg.value;
		}
		System.out.println("打证返回= "+checkNum);
		System.out.println("打证= "+errorString);
        returnlist.add(checkNum);
        returnlist.add(errorString);
		return returnlist;
	}
	
	/**
	 * 注销
	 * @param list
	 * @param gx
	 * @param certid
	 * @param strLogOutMark
	 * @return
	 */
	public boolean cancellation(List<CorpCert> list,GenerateXml gx,String certid,String strLogOutMark,String prinStaff)
	{
		boolean logout = false;
		Holder<java.lang.Boolean> booleanUploadCertInfoResult = new Holder<java.lang.Boolean>();
		Holder<java.lang.String> strErrMsg = new Holder<java.lang.String>();
		String address = "http://210.12.219.69/CertificateService/ProvinceCertClientService.asmx"; //注销接口
		//String address = "http://219.232.244.147/TestCertificateService/ProvinceCertClientService.asmx"; //测试接口
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress(address);
		bean.setServiceClass(ProvinceCertClientServiceSoap.class);
		ProvinceCertClientServiceSoap ws = (ProvinceCertClientServiceSoap) bean.create();
		//上传注销证书数据
		ws.logoutCertInfo("230000","ki3iPNiuXrNXER2Y","7", certid, strLogOutMark,booleanUploadCertInfoResult, strErrMsg);
		logout = booleanUploadCertInfoResult.value;
		System.out.println("注销证书返回值= "+logout);
		System.out.println("注销证书返回消息= "+strErrMsg.value);
		if(logout)
		{
			//记录资质证注销记录
			gx.cancelLog(certid, strLogOutMark, prinStaff);
		}

		return logout;
	}
	
	public static void main(String[] args) {  
		CxfClient cxfClient = new CxfClient();
		cxfClient.uploadData("D223004539","测试数据","韩虎成");
	}  
}
