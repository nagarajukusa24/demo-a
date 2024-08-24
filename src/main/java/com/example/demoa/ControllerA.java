package com.example.demoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerA {

    private final RestTemplate restTemplate;

    public ControllerA(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/a")
    public String callMicroserviceB(@RequestParam String message) {
        String microserviceBUrl = "http://localhost:8081/api/b";
        String response = restTemplate.getForObject(microserviceBUrl + "?message=" + message, String.class);
        return "Response from Microservice B: " + response;
    }
}
