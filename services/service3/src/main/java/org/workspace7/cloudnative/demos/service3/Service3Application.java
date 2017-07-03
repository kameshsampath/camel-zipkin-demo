package org.workspace7.cloudnative.demos.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kameshs
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Service3Application {

    public static void main(String[] args) {
        SpringApplication.run(Service3Application.class, args);
    }

}
