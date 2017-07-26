
package com.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogoutCertInfo2Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "logoutCertInfo2Result",
    "strErrMsg"
})
@XmlRootElement(name = "LogoutCertInfo2Response")
public class LogoutCertInfo2Response {

    @XmlElement(name = "LogoutCertInfo2Result")
    protected boolean logoutCertInfo2Result;
    protected String strErrMsg;

    /**
     * 获取logoutCertInfo2Result属性的值。
     * 
     */
    public boolean isLogoutCertInfo2Result() {
        return logoutCertInfo2Result;
    }

    /**
     * 设置logoutCertInfo2Result属性的值。
     * 
     */
    public void setLogoutCertInfo2Result(boolean value) {
        this.logoutCertInfo2Result = value;
    }

    /**
     * 获取strErrMsg属性的值。
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
     * 设置strErrMsg属性的值。
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
