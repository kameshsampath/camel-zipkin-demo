package org.workspace7.cloudnative.demos.service1;

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
    Service2Client service2Client;

    @GetMapping("/service1")
    public String hello() {
        return String.format(service2Client.hello());
    }
}
