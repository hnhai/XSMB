package com.hai.xsmb.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.hai.xsmb")
@EnableJpaRepositories(basePackages = "com.hai.xsmb.core.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = "com.hai.xsmb.core.entity")
@EnableScheduling
public class SchdulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchdulerApplication.class, args);
    }
}
