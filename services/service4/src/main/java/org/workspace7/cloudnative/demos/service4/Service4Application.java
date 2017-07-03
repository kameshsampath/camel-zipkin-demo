package org.workspace7.cloudnative.demos.service4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kameshs
 */
@SpringBootApplication
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Service4Application {
    public static void main(String[] args) {
        SpringApplication.run(Service4Application.class, args);
    }
}
