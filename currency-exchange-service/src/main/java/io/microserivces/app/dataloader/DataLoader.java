package io.microserivces.app.dataloader;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import io.microserivces.app.domain.ExchangeValue;
import io.microserivces.app.repo.ExchangeValueRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ExchangeValueRepo exchangeValueRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		ExchangeValue ev1 = new ExchangeValue("NZD", "INR", BigDecimal.valueOf(46), 0);
		ExchangeValue ev2 = new ExchangeValue("AUD", "INR", BigDecimal.valueOf(50), 0);
		ExchangeValue ev3 = new ExchangeValue("GBP", "INR", BigDecimal.valueOf(90), 0);

		exchangeValueRepo.save(ev1);
		exchangeValueRepo.save(ev2);
		exchangeValueRepo.save(ev3);

		System.out.println("Data loaded");

	}

}
