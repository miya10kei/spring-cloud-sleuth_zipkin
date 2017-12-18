package com.example.microservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@SpringBootApplication
@RestController
public class Service3Application {

	public static void main(String[] args) {
		SpringApplication.run(Service3Application.class, args);
	}

	@GetMapping("/time")
	@ResponseBody
	public String time() throws InterruptedException {
        Thread.sleep(new Random().nextInt(5) * 1000);
		return LocalTime.now().toString();
	}

	@GetMapping("/date")
    @ResponseBody
	public String date() throws InterruptedException {
        Thread.sleep(new Random().nextInt(5) * 1000);
        return LocalDate.now().toString();
    }
}
