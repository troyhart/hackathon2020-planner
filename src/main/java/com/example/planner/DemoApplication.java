package com.example.planner;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(path = "/")
public class DemoApplication {

	@Value("${planSets.uri}")
	private String planSetUri;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping()
	public String ping() {
		return "pong -> " + planSetUri;
	}

	@GetMapping(path = "/{planName}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<String> getMethodName(@PathVariable("planName") String planName) {

		RestTemplate restTemplate = new RestTemplate();
		List list = restTemplate.getForObject(planSetUri+"/plan-sets/"+planName, List.class);
		return list;
	}
}
