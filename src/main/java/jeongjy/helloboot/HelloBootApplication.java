package jeongjy.helloboot;

import jeongjy.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HelloBootApplication {
    private final JdbcTemplate jdbcTemplate;

    public HelloBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(30) primary key, count int)");
    }

    public static void main(String[] args) {

        SpringApplication.run(HelloBootApplication.class, args);
    }
}
