
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
 *         &lt;element name="UploadSheJiCertInfoResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "uploadSheJiCertInfoResult",
    "strErrMsg"
})
@XmlRootElement(name = "UploadSheJiCertInfoResponse")
public class UploadSheJiCertInfoResponse {

    @XmlElement(name = "UploadSheJiCertInfoResult")
    protected int uploadSheJiCertInfoResult;
    protected String strErrMsg;

    /**
     * 获取uploadSheJiCertInfoResult属性的值。
     * 
     */
    public int getUploadSheJiCertInfoResult() {
        return uploadSheJiCertInfoResult;
    }

    /**
     * 设置uploadSheJiCertInfoResult属性的值。
     * 
     */
    public void setUploadSheJiCertInfoResult(int value) {
        this.uploadSheJiCertInfoResult = value;
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
