package com.tj.jst.inner.qualificationProductivity.certificatePrint.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.base.util.xmlOuter.CxfClient;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.condition.CityCertificatePrintCondition;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.CityCertificatePrintServiceImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.ICityCertificatePrintService;
import com.tj.jst.login.model.Login;

/**
 * 地市证书打印
 * @author hhc
 *
 */
@SuppressWarnings("serial")
public class CityCertificatePrintAction extends BaseAction {
	
	private String corpName;
	private String corpCode;
	private String corpCertId;
	private CertificatePrint certificatePrint;
	private String PRINTNUMBER;
	private String FBPRINTNUMBER;
	private String errorString;
	private String printReason;
	private String uploadState;
	private Login login = new Login();
	private String updateType;
	
	
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	
	private CityCertificatePrintCondition condition = new CityCertificatePrintCondition();
	
	public void setCondition(CityCertificatePrintCondition condition) {
		this.condition = condition;
	}

	public CityCertificatePrintCondition getCondition() {
		CityCertificatePrintCondition sessionCondition = (CityCertificatePrintCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		ICityCertificatePrintService service = new CityCertificatePrintServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}	
	
	/**
	 * 打印查询
	 * @return
	 */
	public String queryPrint()
	{
		ICityCertificatePrintService service = new CityCertificatePrintServiceImpl();
//		try {
			//corpName = URLDecoder.decode(corpName,"utf8");
			certificatePrint = service.queryPrint(corpCode.trim());
			certificatePrint.setUpdateType(certificatePrint.getUpdateType().trim());
			uploadState="0";//上传初始状态为0
			
			
//	    } catch (UnsupportedEncodingException e) {
//	        throw new RuntimeException("编码转换错误，请联系管理员");
//	    } 
		return "uploadPrint";
	}
	
	/**
	 * 证书信息上传
	 * @return
	 */
	public String uploadCertificate()
	{
		ICityCertificatePrintService service = new CityCertificatePrintServiceImpl();
	
			//corpName = URLDecoder.decode(corpName,"utf8");
			service.updateCertificateNumber(corpCertId, "QRCODE", UUID.randomUUID().toString().replace("-", ""));
			service.updateCertificateNumber(corpCertId, "FBQRCODE", UUID.randomUUID().toString().replace("-", ""));
			service.updateCertificateNumber(corpCertId, "PRINTNUMBER",PRINTNUMBER);
			service.updateCertificateNumber(corpCertId, "FBPRINTNUMBER",FBPRINTNUMBER);	
			certificatePrint = service.queryPrint(corpCode.trim());
			certificatePrint.setUpdateType(certificatePrint.getUpdateType());
			SimpleDateFormat YY = new SimpleDateFormat("yyyy");		
			SimpleDateFormat MM = new SimpleDateFormat("MM");	
			SimpleDateFormat DD = new SimpleDateFormat("dd");	
			certificatePrint.setYear(YY.format(certificatePrint.getPrintDate()));
			certificatePrint.setMonth(MM.format(certificatePrint.getPrintDate()));
			certificatePrint.setDay(DD.format(certificatePrint.getPrintDate()));
					
			int checkNum=0;
			CxfClient certificateUpload=new CxfClient();
			login = (Login)this.get("login");
			//System.out.println("用户名"+login.getName());
			List returnlist = new ArrayList();
			returnlist=certificateUpload.uploadData(certificatePrint.getCertId(),printReason,login.getName());
			//System.out.println("checkNum"+checkNum);
			checkNum=(int) returnlist.get(0);
			if(checkNum==1)
			{
				uploadState="1";//上传成功状态为1		
			}
			else
			{
				uploadState="2";//上传失败状态为2
				errorString=(String) returnlist.get(1);
				return "uploadPrint";
			}
			
//			if(certificatePrint.getUpdateType()==null || certificatePrint.getUpdateType().trim().length()==0)
		return "print";
	}
	
	
	
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		ICityCertificatePrintService certifiedService = new CityCertificatePrintServiceImpl();
		//企业登记注册类型(字典表：TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}

	public List<DictionaryClass> getEconmicNums() {
		return econmicNums;
	}

	public void setEconmicNums(List<DictionaryClass> econmicNums) {
		this.econmicNums = econmicNums;
	}

	public String getCorpCertId() {
		return corpCertId;
	}

	public void setCorpCertId(String corpCertId) {
		this.corpCertId = corpCertId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public CertificatePrint getCertificatePrint() {
		return certificatePrint;
	}

	public void setCertificatePrint(CertificatePrint certificatePrint) {
		this.certificatePrint = certificatePrint;
	}

	public String getPRINTNUMBER() {
		return PRINTNUMBER;
	}

	public void setPRINTNUMBER(String pRINTNUMBER) {
		PRINTNUMBER = pRINTNUMBER;
	}

	public String getFBPRINTNUMBER() {
		return FBPRINTNUMBER;
	}

	public void setFBPRINTNUMBER(String fBPRINTNUMBER) {
		FBPRINTNUMBER = fBPRINTNUMBER;
	}

	public String getPrintReason() {
		return printReason;
	}

	public void setPrintReason(String printReason) {
		this.printReason = printReason;
	}

	public String getUploadState() {
		return uploadState;
	}

	public void setUploadState(String uploadState) {
		this.uploadState = uploadState;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}



}
