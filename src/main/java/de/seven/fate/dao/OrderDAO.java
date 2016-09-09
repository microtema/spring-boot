package de.seven.fate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource primaryDataSource;

    @Autowired
    private DataSource secondaryDataSource;

    //CRUD#s method

    @PostConstruct
    private void init(){
        System.out.println(this);
    }
}
