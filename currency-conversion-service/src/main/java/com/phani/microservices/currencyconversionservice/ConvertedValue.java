package com.phani.microservices.currencyconversionservice;

import java.math.BigDecimal;
public class ConvertedValue {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int portNo;
	private BigDecimal quantity;
	private BigDecimal calculatedAmt;
	
	
	public ConvertedValue() {}
	public ConvertedValue(Long id,	 String from,	 String to,	 BigDecimal conversionMultiple,	 BigDecimal quantity,
			BigDecimal calculatedAmt,	 int port) {
		this.from = from;
		this.to=to;
		this.conversionMultiple = conversionMultiple;
		this.quantity =quantity;
		this.calculatedAmt=calculatedAmt;
		this.id=id;
		this.portNo=port;
	}
	public String getTo() {return to;}
	public void setTo( String to) {this.to = to;}
	public String getFrom() {return from;}
	public void setFrom(String from) {this.from = from;}
	
	public BigDecimal getConversionMultiple() {return conversionMultiple;}
	public void setConversionMultiple(BigDecimal conversionMultiple) {this.conversionMultiple = conversionMultiple;}
	public BigDecimal getQuantity() {return quantity;}
	public void setQuantity(BigDecimal quantity) {this.quantity = quantity;}
	public BigDecimal getCalculatedAmt() {return calculatedAmt;}
	public void setCalculatedAmt(BigDecimal calculatedAmt) {this.calculatedAmt = this.conversionMultiple.multiply(this.quantity);}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public int getPortNo() {return portNo;}
	public void setPortNo(int port) {this.portNo = port;}
	
}
