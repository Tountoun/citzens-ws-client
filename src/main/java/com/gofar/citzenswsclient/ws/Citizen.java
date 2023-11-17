//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.11.17 à 07:23:46 AM GMT 
//


package com.gofar.citzenswsclient.ws;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour citizen complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="citizen"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cni" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="motherName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fatherName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="job" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="birthDay" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="bloodGroup" type="{http://gofar.com/ws}bloodGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citizen", propOrder = {
    "cni",
    "firstName",
    "lastName",
    "motherName",
    "fatherName",
    "height",
    "job",
    "birthDay",
    "bloodGroup"
})
@XmlSeeAlso({BloodGroup.class})
public class Citizen {

    @XmlElement(required = true)
    protected String cni;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String motherName;
    @XmlElement(required = true)
    protected String fatherName;
    protected double height;
    @XmlElement(required = true)
    protected String job;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDay;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BloodGroup bloodGroup;

    /**
     * Obtient la valeur de la propriété cni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCni() {
        return cni;
    }

    /**
     * Définit la valeur de la propriété cni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCni(String value) {
        this.cni = value;
    }

    /**
     * Obtient la valeur de la propriété firstName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Définit la valeur de la propriété firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Obtient la valeur de la propriété lastName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Définit la valeur de la propriété lastName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Obtient la valeur de la propriété motherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * Définit la valeur de la propriété motherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotherName(String value) {
        this.motherName = value;
    }

    /**
     * Obtient la valeur de la propriété fatherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Définit la valeur de la propriété fatherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
    }

    /**
     * Obtient la valeur de la propriété height.
     * 
     */
    public double getHeight() {
        return height;
    }

    /**
     * Définit la valeur de la propriété height.
     * 
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Obtient la valeur de la propriété job.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJob() {
        return job;
    }

    /**
     * Définit la valeur de la propriété job.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJob(String value) {
        this.job = value;
    }

    /**
     * Obtient la valeur de la propriété birthDay.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDay() {
        return birthDay;
    }

    /**
     * Définit la valeur de la propriété birthDay.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDay(XMLGregorianCalendar value) {
        this.birthDay = value;
    }

    /**
     * Obtient la valeur de la propriété bloodGroup.
     * 
     * @return
     *     possible object is
     *     {@link BloodGroup }
     *     
     */
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    /**
     * Définit la valeur de la propriété bloodGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link BloodGroup }
     *     
     */
    public void setBloodGroup(BloodGroup value) {
        this.bloodGroup = value;
    }

}
