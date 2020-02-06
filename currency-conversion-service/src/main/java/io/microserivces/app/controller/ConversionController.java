package io.microserivces.app.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.microserivces.app.domain.ConversionValue;
import io.microserivces.app.feignproxy.CurrencyExchangeServiceProxy;

@RestController
@RequestMapping("/v1/api/conversion-service")
public class ConversionController {

	private static final Logger log = LoggerFactory.getLogger(ConversionController.class);

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "hi hello";
	}

	@GetMapping("/{from}/{to}/{quantity}")
	public ResponseEntity<?> getConversionValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		ConversionValue res = proxy.getExchangeValue(from, to);

		ConversionValue cnv = new ConversionValue(Long.valueOf(1000), from, to, res.getConversionMultiple(), quantity,
				quantity.multiply(res.getConversionMultiple()), res.getPort());

		log.info("currency conversion - > {} ", cnv);

		return new ResponseEntity<ConversionValue>(cnv, HttpStatus.ACCEPTED);
	}
}
