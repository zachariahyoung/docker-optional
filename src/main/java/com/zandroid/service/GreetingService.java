package com.zandroid.service;

import com.zandroid.Greeting;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting getMessage(String name){
        Assert.notNull(name, "Username must not be null");
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
