package de.seven.fate.schedules;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class CheckDatabaseSchedule {

    private static final Logger LOGGER = Logger.getLogger(CheckDatabaseSchedule.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void check() {

        LOGGER.info("Running database check");
    }

}
