package com.performance.tune.controller;


import com.performance.tune.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class Home {
    @Autowired
    HomeService service;

    private static final String hello = "Hello...";

    @RequestMapping("/v1/hello")
    public String hello(){
        service.hello(hello);
        return hello;
    }

    @RequestMapping("/v1/hello/optional")
    public ResponseEntity<String> helloOptional(){
        service.optionalHello(Optional.ofNullable(hello));
        return  ResponseEntity.ok(hello);
    }

    @RequestMapping("/v1/hello/get")
    public ResponseEntity<List<Document>> getHello(){
        return ResponseEntity.ok(service.getHello());
    }
}
