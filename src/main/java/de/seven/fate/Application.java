package de.seven.fate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by mtema on 02.09.2016.
 */
//@SpringBootApplication
@PropertySource(value = {"application.properties", "endpoints-cors.properties"})
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class Application {

    public static void main(String[] args) throws Exception {

        //ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ConfigurableEnvironment environment = new StandardServletEnvironment();
        environment.setActiveProfiles("dev");
        environment.setDefaultProfiles("dev");

        SpringApplication app = new SpringApplication(Application.class);
        app.setEnvironment(environment);
        app.run(args);
    }
}
