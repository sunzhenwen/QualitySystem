
package com.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogoutOldShiGongCertInfoResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="strErrMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "logoutOldShiGongCertInfoResult",
    "strErrMsg"
})
@XmlRootElement(name = "LogoutOldShiGongCertInfoResponse")
public class LogoutOldShiGongCertInfoResponse {

    @XmlElement(name = "LogoutOldShiGongCertInfoResult")
    protected boolean logoutOldShiGongCertInfoResult;
    protected String strErrMsg;

    /**
     * ��ȡlogoutOldShiGongCertInfoResult���Ե�ֵ��
     * 
     */
    public boolean isLogoutOldShiGongCertInfoResult() {
        return logoutOldShiGongCertInfoResult;
    }

    /**
     * ����logoutOldShiGongCertInfoResult���Ե�ֵ��
     * 
     */
    public void setLogoutOldShiGongCertInfoResult(boolean value) {
        this.logoutOldShiGongCertInfoResult = value;
    }

    /**
     * ��ȡstrErrMsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrErrMsg() {
        return strErrMsg;
    }

    /**
     * ����strErrMsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrErrMsg(String value) {
        this.strErrMsg = value;
    }

}
