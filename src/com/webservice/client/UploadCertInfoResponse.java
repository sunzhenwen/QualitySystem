
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
 *         &lt;element name="UploadCertInfoResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "uploadCertInfoResult",
    "strErrMsg"
})
@XmlRootElement(name = "UploadCertInfoResponse")
public class UploadCertInfoResponse {

    @XmlElement(name = "UploadCertInfoResult")
    protected int uploadCertInfoResult;
    protected String strErrMsg;

    /**
     * ��ȡuploadCertInfoResult���Ե�ֵ��
     * 
     */
    public int getUploadCertInfoResult() {
        return uploadCertInfoResult;
    }

    /**
     * ����uploadCertInfoResult���Ե�ֵ��
     * 
     */
    public void setUploadCertInfoResult(int value) {
        this.uploadCertInfoResult = value;
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
