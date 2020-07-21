package com.phani.microservices.currencyexchangeservice;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private ExchangeValueRepository repository;
	@Autowired
	private Environment env;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getXchangeValue(@PathVariable String from,@PathVariable String to ) {
		ExchangeValue exVal=repository.findByFromCurAndToCur(from,to);
		//ExchangeValue exVal= new ExchangeValue(1000L,from,to,BigDecimal.valueOf(75));
		exVal.setPortNo(Integer.parseInt(env.getProperty("local.server.port")));
		return exVal;
		
	}
}

