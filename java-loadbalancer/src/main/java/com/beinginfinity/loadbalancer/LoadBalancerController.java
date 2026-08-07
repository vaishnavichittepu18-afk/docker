package com.beinginfinity.loadbalancer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancerController {

    private final LoadBalancerService service;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${algorithm:round-robin}")
    private String algorithm;

    public LoadBalancerController(LoadBalancerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {

        String server;

        if ("random".equalsIgnoreCase(algorithm)) {
            server = service.getRandomServer();
        } else {
            server = service.getRoundRobinServer();
        }

        return restTemplate.getForObject(server + "/", String.class);
    }
}