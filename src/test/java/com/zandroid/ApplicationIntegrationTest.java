package com.zandroid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {

		ResponseEntity<Greeting> response = this.restTemplate.getForEntity("/greeting?name={username}", Greeting.class, "mickey");

		assertThat(response).isNotNull();
	}

}
