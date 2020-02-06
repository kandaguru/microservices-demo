package io.microserivces.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microserivces.app.config.Configuration;
import io.microserivces.app.domain.LimitService;

@RestController
@RequestMapping("/v1/api/limit-service")
public class limitServiceController {

	@Autowired
	private Configuration configuration;

	@GetMapping({ "/", "" })
	public LimitService getLimitService() {
		return new LimitService(configuration.getMinimum(), configuration.getMaximum());
	}

}
