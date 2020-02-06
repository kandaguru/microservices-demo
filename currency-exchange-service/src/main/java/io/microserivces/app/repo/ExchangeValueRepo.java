package io.microserivces.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.microserivces.app.domain.ExchangeValue;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {
	public ExchangeValue findByFromAndTo(String from,String to);
	
}
