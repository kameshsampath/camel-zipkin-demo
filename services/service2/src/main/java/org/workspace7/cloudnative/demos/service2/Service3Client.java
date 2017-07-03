package org.workspace7.cloudnative.demos.service2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kameshs
 */
@FeignClient(name = "service3", url = "localhost:9093")
public interface Service3Client {
    @RequestMapping(method = RequestMethod.GET, value = "/service3")
    String hello();
}
