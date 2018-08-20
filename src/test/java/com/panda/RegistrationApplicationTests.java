package com.panda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackageClasses = {
        RegistrationApplicationTests.class,
})
public class RegistrationApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplicationTests.class, args);
    }
}
