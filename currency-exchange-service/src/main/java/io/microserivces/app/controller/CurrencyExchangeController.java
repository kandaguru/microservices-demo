package io.microserivces.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microserivces.app.domain.ExchangeValue;
import io.microserivces.app.repo.ExchangeValueRepo;

@RestController
@RequestMapping("/v1/api/exchange-service")
public class CurrencyExchangeController {

	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepo exchangeValueRepo;

	@GetMapping("/{from}/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exv = exchangeValueRepo.findByFromAndTo(from, to);
		exv.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		log.info("currency exchange log - {}", exv);
		return exchangeValueRepo.save(exv);
	}

}
