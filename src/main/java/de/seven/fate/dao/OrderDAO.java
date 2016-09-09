package de.seven.fate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //CRUD#s method

    @PostConstruct
    private void init(){
        System.out.println(this);
    }
}
