package com.hai.xsmb.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Locale;

@SpringBootApplication(scanBasePackages = "com.hai.xsmb")
@EnableJpaRepositories(basePackages = "com.hai.xsmb.core.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = "com.hai.xsmb.core.entity")
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new WebApplication().configure(new SpringApplicationBuilder(WebApplication.class)).run(args);
    }
}
