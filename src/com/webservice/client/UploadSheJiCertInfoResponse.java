
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
     * ��ȡuploadSheJiCertInfoResult���Ե�ֵ��
     * 
     */
    public int getUploadSheJiCertInfoResult() {
        return uploadSheJiCertInfoResult;
    }

    /**
     * ����uploadSheJiCertInfoResult���Ե�ֵ��
     * 
     */
    public void setUploadSheJiCertInfoResult(int value) {
        this.uploadSheJiCertInfoResult = value;
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
