package com.tj.jst.outside.businessReport.qualitychange.model;




public class TB_QUALITY_CHANGE {
	private String	QUALITY_CHANGE_ID;
	private String	CORPID;
	
	private String	CORPNAME;
	private String 	corpCode;
	private String	LICENSENUM;
	private String	ADDRESS;
	private String	REGPRIN ;
	private String	ECONOMICNUM;
	private String  ECONOMICNAME;
	private String	LEGALMAN ;
	private String	IDCARDTYPENUM;
	private String	LEGALMANIDCARD;
	
	private String	CHANGE_CORPNAME;
	private String	CHANGE_LICENSENUM;
	private String	CHANGE_ADDRESS;
	private String	CHANGE_REGPRIN ;
	private String	CHANGE_ECONOMICNUM;
	private String  CHANGE_ECONOMICNAME;
	private String	CHANGE_LEGALMAN ;
	private String	CHANGE_IDCARDTYPENUM;
	private String	CHANGE_LEGALMANIDCARD;
	
	private String	CREATE_TIME;
	private String	UPDATE_TIME;

	private String	STAFF_COUNTRY;
	private String	STAFF_PROVINCE;
	private String	STAFF_CITY;
	private String	APPROVAL_COUNTRY;
	private String	APPROVAL_PROVINCE;
	private String	APPROVAL_CITY;
	private String  APPROVALTIME_COUNTRY;
	private String  APPROVALTIME_PROVINCE;
	private String  APPROVALTIME_CITY;
	
	private String	LEVELSET;
	private String	BZ;
	
	//1：申请、3：国家不通过、4：国家通过、6：省级不通过、7：省级通过、9：地市不通过、10：地市通过
	private String	STATE;
	private String  SPARE1;
	
	private String  LEVELNAME;//辅助属性
	private String  ACCEPT_DEPARTMENT;//辅助属性
	private String  ACCEPT_STATE;//辅助属性
	
	private String  SPARENAME;
	private String  CHANGE_SPARE1;
	private String  CHANGE_SPARENAME;
	
	private String  IS_CODE_MERGE;// 是否四码合一：0否 1是
	
	public String getOLD_CORPCODE() {
		return OLD_CORPCODE;
	}
	public void setOLD_CORPCODE(String oLD_CORPCODE) {
		OLD_CORPCODE = oLD_CORPCODE;
	}
	public String getNEW_CORPCODE() {
		return NEW_CORPCODE;
	}
	public void setNEW_CORPCODE(String nEW_CORPCODE) {
		NEW_CORPCODE = nEW_CORPCODE;
	}
	private String  OLD_CORPCODE;// 旧组织机构代码
	private String  NEW_CORPCODE;// 四码合一后组织机构代码

	public String getQUALITY_CHANGE_ID() {
		return QUALITY_CHANGE_ID;
	}
	public void setQUALITY_CHANGE_ID(String qUALITY_CHANGE_ID) {
		QUALITY_CHANGE_ID = qUALITY_CHANGE_ID;
	}
	public String getCORPID() {
		return CORPID;
	}
	public void setCORPID(String cORPID) {
		CORPID = cORPID;
	}
	public String getCORPNAME() {
		return CORPNAME;
	}
	public void setCORPNAME(String cORPNAME) {
		CORPNAME = cORPNAME;
	}
	public String getLICENSENUM() {
		return LICENSENUM;
	}
	public void setLICENSENUM(String lICENSENUM) {
		LICENSENUM = lICENSENUM;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getECONOMICNUM() {
		return ECONOMICNUM;
	}
	public void setECONOMICNUM(String eCONOMICNUM) {
		ECONOMICNUM = eCONOMICNUM;
	}
	public String getLEGALMAN() {
		return LEGALMAN;
	}
	public void setLEGALMAN(String lEGALMAN) {
		LEGALMAN = lEGALMAN;
	}
	public String getIDCARDTYPENUM() {
		return IDCARDTYPENUM;
	}
	public void setIDCARDTYPENUM(String iDCARDTYPENUM) {
		IDCARDTYPENUM = iDCARDTYPENUM;
	}
	public String getLEGALMANIDCARD() {
		return LEGALMANIDCARD;
	}
	public void setLEGALMANIDCARD(String lEGALMANIDCARD) {
		LEGALMANIDCARD = lEGALMANIDCARD;
	}
	public String getCHANGE_CORPNAME() {
		return CHANGE_CORPNAME;
	}
	public void setCHANGE_CORPNAME(String cHANGE_CORPNAME) {
		CHANGE_CORPNAME = cHANGE_CORPNAME;
	}
	public String getCHANGE_LICENSENUM() {
		return CHANGE_LICENSENUM;
	}
	public void setCHANGE_LICENSENUM(String cHANGE_LICENSENUM) {
		CHANGE_LICENSENUM = cHANGE_LICENSENUM;
	}
	public String getCHANGE_ADDRESS() {
		return CHANGE_ADDRESS;
	}
	public void setCHANGE_ADDRESS(String cHANGE_ADDRESS) {
		CHANGE_ADDRESS = cHANGE_ADDRESS;
	}

	public String getCHANGE_ECONOMICNUM() {
		return CHANGE_ECONOMICNUM;
	}
	public void setCHANGE_ECONOMICNUM(String cHANGE_ECONOMICNUM) {
		CHANGE_ECONOMICNUM = cHANGE_ECONOMICNUM;
	}
	public String getCHANGE_LEGALMAN() {
		return CHANGE_LEGALMAN;
	}
	public void setCHANGE_LEGALMAN(String cHANGE_LEGALMAN) {
		CHANGE_LEGALMAN = cHANGE_LEGALMAN;
	}
	public String getCHANGE_IDCARDTYPENUM() {
		return CHANGE_IDCARDTYPENUM;
	}
	public void setCHANGE_IDCARDTYPENUM(String cHANGE_IDCARDTYPENUM) {
		CHANGE_IDCARDTYPENUM = cHANGE_IDCARDTYPENUM;
	}
	public String getCHANGE_LEGALMANIDCARD() {
		return CHANGE_LEGALMANIDCARD;
	}
	public void setCHANGE_LEGALMANIDCARD(String cHANGE_LEGALMANIDCARD) {
		CHANGE_LEGALMANIDCARD = cHANGE_LEGALMANIDCARD;
	}

	public String getREGPRIN() {
		return REGPRIN;
	}
	public void setREGPRIN(String rEGPRIN) {
		REGPRIN = rEGPRIN;
	}
	public String getCHANGE_REGPRIN() {
		return CHANGE_REGPRIN;
	}
	public void setCHANGE_REGPRIN(String cHANGE_REGPRIN) {
		CHANGE_REGPRIN = cHANGE_REGPRIN;
	}
	public String getSTAFF_COUNTRY() {
		return STAFF_COUNTRY;
	}
	public void setSTAFF_COUNTRY(String sTAFF_COUNTRY) {
		STAFF_COUNTRY = sTAFF_COUNTRY;
	}
	public String getSTAFF_PROVINCE() {
		return STAFF_PROVINCE;
	}
	public void setSTAFF_PROVINCE(String sTAFF_PROVINCE) {
		STAFF_PROVINCE = sTAFF_PROVINCE;
	}
	public String getSTAFF_CITY() {
		return STAFF_CITY;
	}
	public void setSTAFF_CITY(String sTAFF_CITY) {
		STAFF_CITY = sTAFF_CITY;
	}
	public String getAPPROVAL_COUNTRY() {
		return APPROVAL_COUNTRY;
	}
	public void setAPPROVAL_COUNTRY(String aPPROVAL_COUNTRY) {
		APPROVAL_COUNTRY = aPPROVAL_COUNTRY;
	}
	public String getAPPROVAL_PROVINCE() {
		return APPROVAL_PROVINCE;
	}
	public void setAPPROVAL_PROVINCE(String aPPROVAL_PROVINCE) {
		APPROVAL_PROVINCE = aPPROVAL_PROVINCE;
	}
	public String getAPPROVAL_CITY() {
		return APPROVAL_CITY;
	}
	public void setAPPROVAL_CITY(String aPPROVAL_CITY) {
		APPROVAL_CITY = aPPROVAL_CITY;
	}
	public String getLEVELSET() {
		return LEVELSET;
	}
	public void setLEVELSET(String lEVELSET) {
		LEVELSET = lEVELSET;
	}
	public String getBZ() {
		return BZ;
	}
	public void setBZ(String bZ) {
		BZ = bZ;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getECONOMICNAME() {
		return ECONOMICNAME;
	}
	public void setECONOMICNAME(String eCONOMICNAME) {
		ECONOMICNAME = eCONOMICNAME;
	}
	public String getCHANGE_ECONOMICNAME() {
		return CHANGE_ECONOMICNAME;
	}
	public void setCHANGE_ECONOMICNAME(String cHANGE_ECONOMICNAME) {
		CHANGE_ECONOMICNAME = cHANGE_ECONOMICNAME;
	}
	public String getSPARE1() {
		return SPARE1;
	}
	public void setSPARE1(String sPARE1) {
		SPARE1 = sPARE1;
	}
	public String getLEVELNAME() {
		return LEVELNAME;
	}
	public void setLEVELNAME(String lEVELNAME) {
		LEVELNAME = lEVELNAME;
	}
	public String getAPPROVALTIME_COUNTRY() {
		return APPROVALTIME_COUNTRY;
	}
	public void setAPPROVALTIME_COUNTRY(String aPPROVALTIME_COUNTRY) {
		APPROVALTIME_COUNTRY = aPPROVALTIME_COUNTRY;
	}
	public String getAPPROVALTIME_PROVINCE() {
		return APPROVALTIME_PROVINCE;
	}
	public void setAPPROVALTIME_PROVINCE(String aPPROVALTIME_PROVINCE) {
		APPROVALTIME_PROVINCE = aPPROVALTIME_PROVINCE;
	}
	public String getAPPROVALTIME_CITY() {
		return APPROVALTIME_CITY;
	}
	public void setAPPROVALTIME_CITY(String aPPROVALTIME_CITY) {
		APPROVALTIME_CITY = aPPROVALTIME_CITY;
	}
	public void setCREATE_TIME(String cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
	public void setUPDATE_TIME(String uPDATE_TIME) {
		UPDATE_TIME = uPDATE_TIME;
	}
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}
	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}
	public String getACCEPT_DEPARTMENT() {
		return ACCEPT_DEPARTMENT;
	}
	public void setACCEPT_DEPARTMENT(String aCCEPT_DEPARTMENT) {
		ACCEPT_DEPARTMENT = aCCEPT_DEPARTMENT;
	}
	public String getACCEPT_STATE() {
		return ACCEPT_STATE;
	}
	public void setACCEPT_STATE(String aCCEPT_STATE) {
		ACCEPT_STATE = aCCEPT_STATE;
	}
	public String getSPARENAME() {
		return SPARENAME;
	}
	public void setSPARENAME(String sPARENAME) {
		SPARENAME = sPARENAME;
	}
	public String getCHANGE_SPARE1() {
		return CHANGE_SPARE1;
	}
	public void setCHANGE_SPARE1(String cHANGE_SPARE1) {
		CHANGE_SPARE1 = cHANGE_SPARE1;
	}
	public String getCHANGE_SPARENAME() {
		return CHANGE_SPARENAME;
	}
	public void setCHANGE_SPARENAME(String cHANGE_SPARENAME) {
		CHANGE_SPARENAME = cHANGE_SPARENAME;
	}
	public String getIS_CODE_MERGE() {
		return IS_CODE_MERGE;
	}
	public void setIS_CODE_MERGE(String iS_CODE_MERGE) {
		IS_CODE_MERGE = iS_CODE_MERGE;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}


}
