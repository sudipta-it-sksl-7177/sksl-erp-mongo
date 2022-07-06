package org.sksl.skslmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SkslMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkslMongoApplication.class, args);
    }

}
