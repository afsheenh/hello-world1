package com.example.demo.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.CustomerTrip;

@Configuration
public class AppConfig {
	
	@Bean
	public CustomerTrip firstTrip() {
		return new CustomerTrip(1010,"karapakkam","madipakkam",new BigDecimal(230),LocalDate.of(2019, Month.AUGUST, 29));
	}

	@Bean
	public CustomerTrip secondTrip() {
		return new CustomerTrip(1010,"madipakkam","guindy",new BigDecimal(430),LocalDate.of(2019, Month.AUGUST, 29));
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(dataSource());
	}
	

}
