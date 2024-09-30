
package com.example.consumingwebservice.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gemi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gemi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="adi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="hizmeteBaslamaYili" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gemi", propOrder = {
    "id",
    "adi",
    "tipi",
    "hizmeteBaslamaYili"
})
public class Gemi {

    protected long id;
    @XmlElement(required = true)
    protected String adi;
    @XmlElement(required = true)
    protected String tipi;
    protected int hizmeteBaslamaYili;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the adi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdi() {
        return adi;
    }

    /**
     * Sets the value of the adi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdi(String value) {
        this.adi = value;
    }

    /**
     * Gets the value of the tipi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipi() {
        return tipi;
    }

    /**
     * Sets the value of the tipi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipi(String value) {
        this.tipi = value;
    }

    /**
     * Gets the value of the hizmeteBaslamaYili property.
     * 
     */
    public int getHizmeteBaslamaYili() {
        return hizmeteBaslamaYili;
    }

    /**
     * Sets the value of the hizmeteBaslamaYili property.
     * 
     */
    public void setHizmeteBaslamaYili(int value) {
        this.hizmeteBaslamaYili = value;
    }

}
