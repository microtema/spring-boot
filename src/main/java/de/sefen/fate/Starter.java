package de.sefen.fate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtema on 02.09.2016.
 */
@RestController
@EnableAutoConfiguration
public class Starter {

    @RequestMapping("/")
    public String home() {
        return "Hello Spring boot!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter.class, args);
    }
}
