package org.workspace7.cloudnative.demos.service2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private Service3Client service3;


    @Autowired
    private Service4Client service4;


    @GetMapping("/service2")
    public String hello() {
        return buildResponse(service3.hello(), service4.hello(),service4.longhello());
    }

    String buildResponse(String... responses) {

        HelloResponse helloResponse = new HelloResponse();

        for (String response : responses) {
            helloResponse.getResponses().add(response);
        }

        String response = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response = objectMapper.writeValueAsString(helloResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }
}
