
package com.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCorpName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCorpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCertID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCorpXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strUserName",
    "strPwd",
    "strCorpName",
    "strCorpCode",
    "strCertID",
    "strCorpXml"
})
@XmlRootElement(name = "UpdateOldShiGongModifyInfo2")
public class UpdateOldShiGongModifyInfo2 {

    protected String strUserName;
    protected String strPwd;
    protected String strCorpName;
    protected String strCorpCode;
    protected String strCertID;
    protected String strCorpXml;

    /**
     * ��ȡstrUserName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserName() {
        return strUserName;
    }

    /**
     * ����strUserName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserName(String value) {
        this.strUserName = value;
    }

    /**
     * ��ȡstrPwd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrPwd() {
        return strPwd;
    }

    /**
     * ����strPwd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrPwd(String value) {
        this.strPwd = value;
    }

    /**
     * ��ȡstrCorpName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCorpName() {
        return strCorpName;
    }

    /**
     * ����strCorpName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCorpName(String value) {
        this.strCorpName = value;
    }

    /**
     * ��ȡstrCorpCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCorpCode() {
        return strCorpCode;
    }

    /**
     * ����strCorpCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCorpCode(String value) {
        this.strCorpCode = value;
    }

    /**
     * ��ȡstrCertID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCertID() {
        return strCertID;
    }

    /**
     * ����strCertID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCertID(String value) {
        this.strCertID = value;
    }

    /**
     * ��ȡstrCorpXml���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCorpXml() {
        return strCorpXml;
    }

    /**
     * ����strCorpXml���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCorpXml(String value) {
        this.strCorpXml = value;
    }

}
