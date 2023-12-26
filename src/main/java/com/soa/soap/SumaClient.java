/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.SumaRequest;
import com.soa.dto.SumaResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class SumaClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SumaClient.class);

    public SumaResponse execute() {

        SumaRequest request = new SumaRequest();
        
        request.getNumero().add(10.4);
        request.getNumero().add(28.6);
        request.getNumero().add(12.1);
        
        log.info("Executing WS");

        SumaResponse response = (SumaResponse) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/suma", request, 
                new SoapActionCallback("http://soa.com/SumaRequest"));

        return response;
    }

}