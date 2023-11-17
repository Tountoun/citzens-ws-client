package com.gofar.citzenswsclient.config;

import com.gofar.citzenswsclient.client.CitizensClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfig {

    @Value("${webservice.client.defaultUri}")
    private String defaultUri;

    @Bean(name = "marshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.gofar.citzenswsclient.ws");
        return marshaller;
    }

    @Bean
    public CitizensClient citizensClient(Jaxb2Marshaller marshaller) {
        CitizensClient client = new CitizensClient();
        client.setDefaultUri(defaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
