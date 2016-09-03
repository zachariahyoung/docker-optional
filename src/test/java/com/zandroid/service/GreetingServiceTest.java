package com.zandroid.service;

import com.zandroid.Greeting;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class GreetingServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private GreetingService target;

    @Before
    public void setup() {
        this.target = new GreetingService();
    }

    @Test
    public void getGreetingShouldReturnHello() throws Exception {

        // --- ARRANGE ---


        // --- ACT ---

        Optional<Greeting> hello = target.getMessage("hello");
        // --- ASSERT ---

        Optional<String> map = hello.map(Greeting::getContent);

        assertThat(map).isEqualTo(Optional.of("Hello, hello!"));
    }

    @Test
    public void getGreetingShouldReturnNull() throws Exception {

        // --- ARRANGE ---


        // --- ACT ---

        Optional<Greeting> hello = target.getMessage(null);
        // --- ASSERT ---

        Optional<String> map = hello.map(Greeting::getContent);

        assertThat(map).isEqualTo(Optional.empty());
    }

}