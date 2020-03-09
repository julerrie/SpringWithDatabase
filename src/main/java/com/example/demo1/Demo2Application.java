package com.example.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner priceCommandLineRunner(PriceRepository repository) {
		return (args) -> {
			repository.save(new Price("A",795.00,145.31,0,20));
			repository.save(new Price("B",1056.00,130.46,21,80));
			repository.save(new Price("C",1232.00,128.26,81,200));
			repository.save(new Price("D",1892.00,124.96,201,500));
			repository.save(new Price("E",6292.00,116.16,501,800));
			repository.save(new Price("F",12452.00,108.46,801,922337290));
		};
	}

}