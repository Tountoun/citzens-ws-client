//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.12.05 à 08:25:39 PM GMT 
//


package com.gofar.citzenswsclient.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bloodGroup.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="bloodGroup"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ARP"/&gt;
 *     &lt;enumeration value="BRP"/&gt;
 *     &lt;enumeration value="ORP"/&gt;
 *     &lt;enumeration value="ABRP"/&gt;
 *     &lt;enumeration value="ARN"/&gt;
 *     &lt;enumeration value="BRN"/&gt;
 *     &lt;enumeration value="ORN"/&gt;
 *     &lt;enumeration value="ABRN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "bloodGroup")
@XmlEnum
public enum BloodGroup {

    ARP,
    BRP,
    ORP,
    ABRP,
    ARN,
    BRN,
    ORN,
    ABRN;

    public String value() {
        return name();
    }

    public static BloodGroup fromValue(String v) {
        return valueOf(v);
    }

}
