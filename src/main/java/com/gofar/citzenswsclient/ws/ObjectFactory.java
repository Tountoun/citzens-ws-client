//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.11.17 à 07:23:46 AM GMT 
//


package com.gofar.citzenswsclient.ws;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gofar.citzenswsclient.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gofar.citzenswsclient.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCitizenInfoRequest }
     * 
     */
    public GetCitizenInfoRequest createGetCitizenInfoRequest() {
        return new GetCitizenInfoRequest();
    }

    /**
     * Create an instance of {@link GetCitizenInfoResponse }
     * 
     */
    public GetCitizenInfoResponse createGetCitizenInfoResponse() {
        return new GetCitizenInfoResponse();
    }

    /**
     * Create an instance of {@link Citizen }
     * 
     */
    public Citizen createCitizen() {
        return new Citizen();
    }

}
