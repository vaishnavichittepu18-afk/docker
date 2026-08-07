package com.beinginfinity.loadbalancer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LoadBalancerService {

    private final List<String> servers = List.of(
            "http://backend1:7070",
            "http://backend2:7070",
            "http://backend3:7070",
            "http://backend4:7070",
            "http://backend6:7070"
    );

    private int currentIndex = 0;
    private final Random random = new Random();

    public synchronized String getRoundRobinServer() {
        String server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }

    public String getRandomServer() {
        return servers.get(random.nextInt(servers.size()));
    }
}