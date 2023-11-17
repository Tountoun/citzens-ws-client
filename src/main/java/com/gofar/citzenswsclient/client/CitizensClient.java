package com.gofar.citzenswsclient.client;

import com.gofar.citzenswsclient.ws.GetCitizenInfoRequest;
import com.gofar.citzenswsclient.ws.GetCitizenInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Slf4j
public class CitizensClient extends WebServiceGatewaySupport {
    @Value("${webservice.uri}")
    private String uri;

    public GetCitizenInfoResponse getCitizenInfoResponse(String cin) {
        log.info("Sending soap request with cin {} to the server", cin);
        GetCitizenInfoResponse response = new GetCitizenInfoResponse();
        GetCitizenInfoRequest request = new GetCitizenInfoRequest();
        request.setCni(cin);
        try {
            response = (GetCitizenInfoResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(uri, request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return response;
    }

}
