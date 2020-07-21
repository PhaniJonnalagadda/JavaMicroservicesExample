package com.phani.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.*;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long>{

	ExchangeValue findByFromCurAndToCur(String fromCur,String toCur);
}
 	