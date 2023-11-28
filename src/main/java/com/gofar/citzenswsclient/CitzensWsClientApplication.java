package com.gofar.citzenswsclient;

import com.gofar.citzenswsclient.client.CitizensClient;
import com.gofar.citzenswsclient.ws.GetCitizenInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class CitzensWsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitzensWsClientApplication.class, args);
    }

}
