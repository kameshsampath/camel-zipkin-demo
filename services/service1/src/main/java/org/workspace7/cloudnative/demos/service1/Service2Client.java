package org.workspace7.cloudnative.demos.service1;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kameshs
 */
@FeignClient(name = "service2", url = "localhost:9092", configuration = Service2ClientConfig.class)
public interface Service2Client {
    @RequestMapping(method = RequestMethod.GET, value = "/service2")
    String hello();
}
