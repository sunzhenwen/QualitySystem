
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
 *         &lt;element name="UploadCertInfoNotPrintResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "uploadCertInfoNotPrintResult",
    "strErrMsg"
})
@XmlRootElement(name = "UploadCertInfoNotPrintResponse")
public class UploadCertInfoNotPrintResponse {

    @XmlElement(name = "UploadCertInfoNotPrintResult")
    protected int uploadCertInfoNotPrintResult;
    protected String strErrMsg;

    /**
     * 获取uploadCertInfoNotPrintResult属性的值。
     * 
     */
    public int getUploadCertInfoNotPrintResult() {
        return uploadCertInfoNotPrintResult;
    }

    /**
     * 设置uploadCertInfoNotPrintResult属性的值。
     * 
     */
    public void setUploadCertInfoNotPrintResult(int value) {
        this.uploadCertInfoNotPrintResult = value;
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
