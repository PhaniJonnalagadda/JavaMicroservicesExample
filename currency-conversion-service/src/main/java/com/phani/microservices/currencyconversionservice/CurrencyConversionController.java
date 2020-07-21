package com.phani.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy feignProxy;
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/value/{value}")
	public ConvertedValue convertedCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		ConvertedValue ConValue = feignProxy.getXchangeValue(from, to); 
		return new ConvertedValue(ConValue.getId(),from,to,ConValue.getConversionMultiple(),value,value.multiply(ConValue.getConversionMultiple()),ConValue.getPortNo());
	}

	
	@GetMapping("/currency-converter/from/{from}/to/{to}/value/{value}")
	public ConvertedValue convertedCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		//BigDecimal calcValue= BigDecimal.valueOf(value*75);
		Map<String,String>uriVars= new HashMap<>();
		uriVars.put("from", from);
		uriVars.put("to", to);
		ResponseEntity<ConvertedValue> entity =new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConvertedValue.class, uriVars);
		ConvertedValue ConValue = entity.getBody();
		return new ConvertedValue(ConValue.getId(),from,to,ConValue.getConversionMultiple(),value,value.multiply(ConValue.getConversionMultiple()),ConValue.getPortNo());
	}
}
