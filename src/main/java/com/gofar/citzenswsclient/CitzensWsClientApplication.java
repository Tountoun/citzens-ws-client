package com.gofar.citzenswsclient;

import com.gofar.citzenswsclient.client.CitizensClient;
import com.gofar.citzenswsclient.ws.GetCitizenInfoResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CitzensWsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitzensWsClientApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CitizensClient client) {
        return args -> {
            GetCitizenInfoResponse response = client.getCitizenInfoResponse("150-100-401");
            System.out.println(response.getData().getFirstName());
        };
    }
}
