package de.seven.fate.schedules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    @Bean
    public CheckDatabaseSchedule getCheckDatabaseSchedule(){

        return new CheckDatabaseSchedule();
    }
}
