package io.microserivces.app.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.microserivces.app.domain.ConversionValue;

//after implementing zuul api gateway change @FeignClient(name = "currency-exchange-service") to below
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//after implementing zuul api gateway change @GetMapping("/v1/api/exchange-service/{from}/{to}") to below
	@GetMapping("/currency-exchange-service/v1/api/exchange-service/{from}/{to}")
	public ConversionValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
