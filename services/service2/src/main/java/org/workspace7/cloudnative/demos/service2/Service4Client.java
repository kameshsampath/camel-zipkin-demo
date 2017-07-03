package org.workspace7.cloudnative.demos.service2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kameshs
 */
@FeignClient(name = "service4", url = "localhost:9094", configuration = Service4ClientConfig.class)
public interface Service4Client {
    @RequestMapping(method = RequestMethod.GET, value = "/service4")
    String hello();

    @RequestMapping(method = RequestMethod.GET, value = "/longhello")
    String longhello();
}
