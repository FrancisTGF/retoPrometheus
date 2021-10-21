package com.nttdata.bootcamp.retopromethus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {
	private Counter  counter;

	public TestController(MeterRegistry registry) {
		
		
		this.counter = Counter.builder("invocaciones.hello").description("Invocaciones Totales").register(registry);
	}
	@GetMapping("/helloWorld")
	public String helloWorld() {
		counter.increment();
		return "hello World";
		
	}

}