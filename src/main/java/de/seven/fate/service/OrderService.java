package de.seven.fate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OrderService {

    //value from *.properties
    @Value("${app.description}")
    private String description;

    //random value from *.properties
    @Value("${app.uuid}")
    private String uuid;

    @Value("${app.secret}")
    private String secret;

    //value from system property
    @Value("${user.name}")
    private String userName;

    //value from JNDI
    @Value("${java:comp/env}")
    private String mailServer;

    @PostConstruct
    private void init(){
        System.out.println(this);
    }
}
