package com.example.challenge;

import com.example.challenge.entity.Device;
import com.example.challenge.service.DeviceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class ChallengeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChallengeApplication.class, args);


	}

@Bean
	CommandLineRunner commandLineRunner (DeviceService deviceService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			List<Device> deviceList = mapper.readValue(new File("src/main/resources/devices.json"), new TypeReference<List<Device>>() {});

			deviceService.saveAll(deviceList);
		};
    }
}