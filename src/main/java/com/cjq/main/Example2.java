package com.cjq.main;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RestController
public class Example2 {
    @RequestMapping("/t")
    String home() {
        return "Hello World2!";
    }
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example2.class, args);
//    }
}