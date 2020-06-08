package com.kappa.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/welcome")
public class WelcomeController {

    @Value("${environment}")
    private String env;

    @GetMapping("")
    public ResponseEntity<Object> method1() {

        Map<String, String> map = new HashMap<>();
        map.put("Key1", "value1 "+env);
        map.put("Key2", "value2");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/bye")
    public ResponseEntity<Object> method2() {

        Map<String, String> map = new HashMap<>();
        map.put("greetings", "goodbye "+env);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
