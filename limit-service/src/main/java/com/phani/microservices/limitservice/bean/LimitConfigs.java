package com.phani.microservices.limitservice.bean;

public class LimitConfigs {
	private int maximum;
	private int minimum;
	protected LimitConfigs() {}
	public LimitConfigs(int maximum, int minimum){
		super();
		this.maximum=maximum;
		this.minimum=minimum;
	}
	public int getMaximum() {return maximum;}
	public int getMinimum() {return minimum;}
}
