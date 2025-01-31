package com.phani.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="api-gateway-server-zuul")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public ConvertedValue getXchangeValue(@PathVariable String from,@PathVariable String to );

}
