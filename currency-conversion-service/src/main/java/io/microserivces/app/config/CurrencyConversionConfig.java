package io.microserivces.app.config;

import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

public class CurrencyConversionConfig {

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
