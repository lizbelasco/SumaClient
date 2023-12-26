package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.SumaResponse;
import com.soa.soap.SumaClient;

@SpringBootApplication
public class SumaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SumaClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(SumaClient client) {
        return args -> {
            SumaResponse response = client.execute();
            System.err.println(response.getSuma());
        };
    }

}
