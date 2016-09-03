package com.zandroid.controller;

import com.zandroid.Greeting;
import com.zandroid.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity greeting(@RequestParam(value="name") String name) {

        return greetingService.getMessage(name)
                .map(a -> new ResponseEntity<Greeting>(a, HttpStatus.OK))
                .orElseThrow(IllegalArgumentException::new);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> notFound(IllegalArgumentException ex) {
        return new ResponseEntity<String>("Not Exist user", HttpStatus.NOT_FOUND);
    }

}
