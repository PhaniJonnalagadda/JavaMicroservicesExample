package com.phani.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class ExchangeValue {

	@Id
	private Long id;
	@Column(name="Currency_From")
	private String fromCur;
	@Column(name="Currency_To")
	private String toCur;
	@Column(name="conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name="PORT")
	private Integer portNo;
	
	public ExchangeValue() {
			
	}
	public ExchangeValue(Long id, String from, String to, BigDecimal value) {
		super();
		this.id = id;
		this.fromCur = from;
		this.toCur = to;
		this.conversionMultiple = value;
	}
	
	public Integer getPortNo() {
		return portNo;
	}
	public void setPortNo(Integer no) {
		this.portNo = no;
	}
	public Long getId() {
		return id;
	}
	public String getFromVal() {
		return fromCur;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public String getToVal() {
		return toCur;
	}
}

