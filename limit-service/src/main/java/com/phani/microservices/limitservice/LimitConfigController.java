package com.phani.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phani.microservices.limitservice.bean.LimitConfigs;

@RestController
public class LimitConfigController {

	@Autowired
	private LimitConfigurations limitConfigs;
	@GetMapping("/limit")
	public LimitConfigs retrieveLimitConfig(){
		return new LimitConfigs(limitConfigs.getMaximum(), limitConfigs.getMinimum());
	}
}
