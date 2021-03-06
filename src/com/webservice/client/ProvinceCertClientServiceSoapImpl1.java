
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.webservice.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.16
 * 2016-06-06T10:39:20.825+08:00
 * Generated source version: 2.7.16
 * 
 */

@javax.jws.WebService(
                      serviceName = "ProvinceCertClientService",
                      portName = "ProvinceCertClientServiceSoap12",
                      targetNamespace = "http://tempuri.org/",
                      wsdlLocation = "http://210.12.219.69/CertificateService/ProvinceCertClientService.asmx?wsdl",
                      endpointInterface = "com.webservice.client.ProvinceCertClientServiceSoap")
                      
public class ProvinceCertClientServiceSoapImpl1 implements ProvinceCertClientServiceSoap {

    private static final Logger LOG = Logger.getLogger(ProvinceCertClientServiceSoapImpl1.class.getName());

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#readOldShiGongCertInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  readOldShiGongCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void readOldShiGongCertInfo(java.lang.String strUserName,java.lang.String strPwd,javax.xml.ws.Holder<java.lang.String> readOldShiGongCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation readOldShiGongCertInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        try {
            java.lang.String readOldShiGongCertInfoResultValue = "";
            readOldShiGongCertInfoResult.value = readOldShiGongCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#logoutCertInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertTypeNum ,)java.lang.String  strCertID ,)java.lang.String  strLogOutMark ,)java.lang.Boolean  logoutCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void logoutCertInfo(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertTypeNum,java.lang.String strCertID,java.lang.String strLogOutMark,javax.xml.ws.Holder<java.lang.Boolean> logoutCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation logoutCertInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertTypeNum);
        System.out.println(strCertID);
        System.out.println(strLogOutMark);
        try {
            java.lang.Boolean logoutCertInfoResultValue = null;
            logoutCertInfoResult.value = logoutCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#updateOldShiGongModifyInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertNum ,)java.lang.String  strCertID ,)java.lang.String  strCorpXml ,)java.lang.Boolean  updateOldShiGongModifyInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void updateOldShiGongModifyInfo(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertNum,java.lang.String strCertID,java.lang.String strCorpXml,javax.xml.ws.Holder<java.lang.Boolean> updateOldShiGongModifyInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation updateOldShiGongModifyInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertNum);
        System.out.println(strCertID);
        System.out.println(strCorpXml);
        try {
            java.lang.Boolean updateOldShiGongModifyInfoResultValue = null;
            updateOldShiGongModifyInfoResult.value = updateOldShiGongModifyInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#testOldShiGongCertSlbIsExists(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCorpName ,)java.lang.String  strCertID ,)java.lang.Integer  testOldShiGongCertSlbIsExistsResult ,)java.lang.String  strErrMsg )*
     */
    public void testOldShiGongCertSlbIsExists(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCorpName,java.lang.String strCertID,javax.xml.ws.Holder<java.lang.Integer> testOldShiGongCertSlbIsExistsResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation testOldShiGongCertSlbIsExists");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCorpName);
        System.out.println(strCertID);
        try {
            java.lang.Integer testOldShiGongCertSlbIsExistsResultValue = null;
            testOldShiGongCertSlbIsExistsResult.value = testOldShiGongCertSlbIsExistsResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#helloWorld(*
     */
    public java.lang.String helloWorld() { 
        LOG.info("Executing operation helloWorld");
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#uploadCertInfoNotPrint(java.lang.String  strCertTypeNum ,)java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertXml ,)java.lang.Integer  uploadCertInfoNotPrintResult ,)java.lang.String  strErrMsg )*
     */
    public void uploadCertInfoNotPrint(java.lang.String strCertTypeNum,java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertXml,javax.xml.ws.Holder<java.lang.Integer> uploadCertInfoNotPrintResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation uploadCertInfoNotPrint");
        System.out.println(strCertTypeNum);
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertXml);
        try {
            java.lang.Integer uploadCertInfoNotPrintResultValue = null;
            uploadCertInfoNotPrintResult.value = uploadCertInfoNotPrintResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#uploadOldShiGongCertInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertXml ,)java.lang.Integer  uploadOldShiGongCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void uploadOldShiGongCertInfo(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertXml,javax.xml.ws.Holder<java.lang.Integer> uploadOldShiGongCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation uploadOldShiGongCertInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertXml);
        try {
            java.lang.Integer uploadOldShiGongCertInfoResultValue = null;
            uploadOldShiGongCertInfoResult.value = uploadOldShiGongCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#readOldShiGongCertInfoDetails(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertNum ,)java.lang.String  readOldShiGongCertInfoDetailsResult ,)java.lang.String  strErrMsg )*
     */
    public void readOldShiGongCertInfoDetails(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertNum,javax.xml.ws.Holder<java.lang.String> readOldShiGongCertInfoDetailsResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation readOldShiGongCertInfoDetails");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertNum);
        try {
            java.lang.String readOldShiGongCertInfoDetailsResultValue = "";
            readOldShiGongCertInfoDetailsResult.value = readOldShiGongCertInfoDetailsResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#uploadJSCertAddressInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCorpXml ,)java.lang.Integer  uploadJSCertAddressInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void uploadJSCertAddressInfo(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCorpXml,javax.xml.ws.Holder<java.lang.Integer> uploadJSCertAddressInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation uploadJSCertAddressInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCorpXml);
        try {
            java.lang.Integer uploadJSCertAddressInfoResultValue = null;
            uploadJSCertAddressInfoResult.value = uploadJSCertAddressInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#logoutOldShiGongCertInfo(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertNum ,)java.lang.String  strLogOutMark ,)java.lang.Boolean  logoutOldShiGongCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void logoutOldShiGongCertInfo(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertNum,java.lang.String strLogOutMark,javax.xml.ws.Holder<java.lang.Boolean> logoutOldShiGongCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation logoutOldShiGongCertInfo");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertNum);
        System.out.println(strLogOutMark);
        try {
            java.lang.Boolean logoutOldShiGongCertInfoResultValue = null;
            logoutOldShiGongCertInfoResult.value = logoutOldShiGongCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#updateOldShiGongModifyInfo2(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCorpName ,)java.lang.String  strCorpCode ,)java.lang.String  strCertID ,)java.lang.String  strCorpXml ,)java.lang.Boolean  updateOldShiGongModifyInfo2Result ,)java.lang.String  strErrMsg )*
     */
    public void updateOldShiGongModifyInfo2(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCorpName,java.lang.String strCorpCode,java.lang.String strCertID,java.lang.String strCorpXml,javax.xml.ws.Holder<java.lang.Boolean> updateOldShiGongModifyInfo2Result,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation updateOldShiGongModifyInfo2");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCorpName);
        System.out.println(strCorpCode);
        System.out.println(strCertID);
        System.out.println(strCorpXml);
        try {
            java.lang.Boolean updateOldShiGongModifyInfo2ResultValue = null;
            updateOldShiGongModifyInfo2Result.value = updateOldShiGongModifyInfo2ResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#logoutCertInfo2(java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertTypeNum ,)java.lang.String  strCorpName ,)java.lang.String  strCertID ,)java.lang.String  strLogOutMark ,)java.lang.Boolean  logoutCertInfo2Result ,)java.lang.String  strErrMsg )*
     */
    public void logoutCertInfo2(java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertTypeNum,java.lang.String strCorpName,java.lang.String strCertID,java.lang.String strLogOutMark,javax.xml.ws.Holder<java.lang.Boolean> logoutCertInfo2Result,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation logoutCertInfo2");
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertTypeNum);
        System.out.println(strCorpName);
        System.out.println(strCertID);
        System.out.println(strLogOutMark);
        try {
            java.lang.Boolean logoutCertInfo2ResultValue = null;
            logoutCertInfo2Result.value = logoutCertInfo2ResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#uploadCertInfo(java.lang.String  strCertTypeNum ,)java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertXml ,)java.lang.Integer  uploadCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void uploadCertInfo(java.lang.String strCertTypeNum,java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertXml,javax.xml.ws.Holder<java.lang.Integer> uploadCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation uploadCertInfo");
        System.out.println(strCertTypeNum);
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertXml);
        try {
            java.lang.Integer uploadCertInfoResultValue = null;
            uploadCertInfoResult.value = uploadCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.webservice.client.ProvinceCertClientServiceSoap#uploadSheJiCertInfo(java.lang.String  strCertTypeNum ,)java.lang.String  strUserName ,)java.lang.String  strPwd ,)java.lang.String  strCertXml ,)java.lang.Integer  uploadSheJiCertInfoResult ,)java.lang.String  strErrMsg )*
     */
    public void uploadSheJiCertInfo(java.lang.String strCertTypeNum,java.lang.String strUserName,java.lang.String strPwd,java.lang.String strCertXml,javax.xml.ws.Holder<java.lang.Integer> uploadSheJiCertInfoResult,javax.xml.ws.Holder<java.lang.String> strErrMsg) { 
        LOG.info("Executing operation uploadSheJiCertInfo");
        System.out.println(strCertTypeNum);
        System.out.println(strUserName);
        System.out.println(strPwd);
        System.out.println(strCertXml);
        try {
            java.lang.Integer uploadSheJiCertInfoResultValue = null;
            uploadSheJiCertInfoResult.value = uploadSheJiCertInfoResultValue;
            java.lang.String strErrMsgValue = "";
            strErrMsg.value = strErrMsgValue;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
