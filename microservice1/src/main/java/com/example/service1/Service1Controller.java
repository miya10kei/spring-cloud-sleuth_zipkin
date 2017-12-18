package com.example.service1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class Service1Controller {
    private RestTemplate restTemplate;
    private ObjectMapper mapper;

    public Service1Controller(final RestTemplate restTemplate, final ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable("id") final String id) {
        try {
            final ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8082/users/" + id, String.class);
            final String date = restTemplate.getForEntity("http://localhost:8083/date/", String.class).getBody();
            final String time = restTemplate.getForEntity("http://localhost:8083/time/", String.class).getBody();
            return "Hello "  + mapper.readTree(res.getBody()).get("name") + " @ " + date + " " + time;
        } catch (IOException | HttpClientErrorException e) {
            return "Hello World!";
        }
    }
}
