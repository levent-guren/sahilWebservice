
package com.example.consumingwebservice.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="gemi" type="{http://tr.gov.sg/ws/gemi}gemi"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gemi"
})
@XmlRootElement(name = "getGemiResponse")
public class GetGemiResponse {

    @XmlElement(required = true)
    protected Gemi gemi;

    /**
     * Gets the value of the gemi property.
     * 
     * @return
     *     possible object is
     *     {@link Gemi }
     *     
     */
    public Gemi getGemi() {
        return gemi;
    }

    /**
     * Sets the value of the gemi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gemi }
     *     
     */
    public void setGemi(Gemi value) {
        this.gemi = value;
    }

}
