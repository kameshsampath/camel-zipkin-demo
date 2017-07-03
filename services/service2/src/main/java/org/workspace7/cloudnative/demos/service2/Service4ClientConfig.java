package org.workspace7.cloudnative.demos.service2;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kameshs
 */
@Configuration
public class Service4ClientConfig {

    @Bean
    public Request.Options options(){
        return new Request.Options(7000,20000);
    }
}
