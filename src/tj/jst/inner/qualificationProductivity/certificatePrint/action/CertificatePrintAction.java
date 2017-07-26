package com.tj.jst.inner.qualificationProductivity.certificatePrint.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.base.util.xmlOuter.CxfClient;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.condition.CertificatePrintCondition;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.CertificatePrintServiceImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.service.ICertificatePrintService;
import com.tj.jst.login.model.Login;

/**
 * 证书打印
 * @author hhc
 *
 */
@SuppressWarnings("serial")
public class CertificatePrintAction extends BaseAction {
	
	private String corpName;
	private String corpCode;
	private String corpCertId;
	private CertificatePrint certificatePrint;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	private String PRINTNUMBER;
	private String FBPRINTNUMBER;
	private String printReason;
	private String uploadState;
	private String errorString;
	private Login login = new Login();
	private String updateType;
	
	
	private CertificatePrintCondition condition = new CertificatePrintCondition();
	
	public void setCondition(CertificatePrintCondition condition) {
		this.condition = condition;
	}

	public CertificatePrintCondition getCondition() {
		CertificatePrintCondition sessionCondition = (CertificatePrintCondition) get(getActionName());
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
		ICertificatePrintService service = new CertificatePrintServiceImpl();
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
		ICertificatePrintService service = new CertificatePrintServiceImpl();
//		try {
			//corpName = URLDecoder.decode(corpName,"utf8");
		certificatePrint = service.queryPrint(corpCode);
		certificatePrint.setUpdateType(certificatePrint.getUpdateType().trim());
		uploadState="0";//上传初始状态为0
//			int checkNum=0;	
//			if(certificatePrint.getUpdateType()==null || certificatePrint.getUpdateType().trim().length()==0)
//			{
//				certificatePrint.setUpdateType("1");
//			}
//			if(!certificatePrint.getUpdateType().equals("0"))
			
//	    } catch (UnsupportedEncodingException e) {
//	        throw new RuntimeException("编码转换错误，请联系管理员");
//	    } 
		return "uploadPrint";
	}
	
	public String uploadCertificate()
	{
		ICertificatePrintService service = new CertificatePrintServiceImpl();
		
			//corpName = URLDecoder.decode(corpName,"utf8");
			
			service.updateCertificateNumber(corpCertId, "QRCODE", UUID.randomUUID().toString().replace("-", ""));
			service.updateCertificateNumber(corpCertId, "FBQRCODE", UUID.randomUUID().toString().replace("-", ""));
			service.updateCertificateNumber(corpCertId, "PRINTNUMBER",PRINTNUMBER);
			service.updateCertificateNumber(corpCertId, "FBPRINTNUMBER",FBPRINTNUMBER);	
			//System.out.println("corpCode------:"+corpCode);
			certificatePrint = service.queryPrint(corpCode);
			
			certificatePrint.setUpdateType(certificatePrint.getUpdateType());
			SimpleDateFormat YY = new SimpleDateFormat("yyyy");		
			SimpleDateFormat MM = new SimpleDateFormat("MM");	
			SimpleDateFormat DD = new SimpleDateFormat("dd");	
			certificatePrint.setYear(YY.format(certificatePrint.getPrintDate()));
			certificatePrint.setMonth(MM.format(certificatePrint.getPrintDate()));
			certificatePrint.setDay(DD.format(certificatePrint.getPrintDate()));
			
			int checkNum=0;
			CxfClient certificateUpload=new CxfClient();
			List returnlist = new ArrayList();
			returnlist=certificateUpload.uploadData(certificatePrint.getCertId(),printReason,(String)this.get("name"));
			
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
			
		return "print";
	}
	
	
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		ICertificatePrintService certifiedService = new CertificatePrintServiceImpl();
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



	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getUpdateType() {
		return updateType;
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
