package com.example.hostname;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class HostnameController {

    @GetMapping("/")
    public String home() throws Exception {
        return "Served by : " + InetAddress.getLocalHost().getHostName();
    }
}
