package com.example.eurekaClientApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/firstService")
@RestController
public class HelloController {



    @GetMapping("/hello")
    public String getHelloWordObject() {
        return "Hello this is my First Service";
    }



}