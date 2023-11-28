package com.isuruk.dev.app;

import com.isuruk.dev.app.beans.ColorPrinter;
import com.isuruk.dev.app.beans.impl.BlueInkImpl;
import com.isuruk.dev.app.beans.impl.ColorPrinterImpl;
import com.isuruk.dev.app.beans.impl.GreenInkImpl;
import com.isuruk.dev.app.beans.impl.RedInkImpl;
import com.isuruk.dev.app.config.PizzaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class QuickstartJava17Springboot3Application {

	@Autowired
	private ColorPrinter colorPrinter;

	@Autowired
	private PizzaConfig pizzaConfig;

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(QuickstartJava17Springboot3Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			log.info("Datasource : {}",dataSource.toString());
			jdbcTemplate.execute("SELECT 1");
		};
	}

}
