package com.example.demo1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
	
	@Id @GeneratedValue
	private long ID;
	private String type;
	private double basicFee;
	private double unitRate;
	private float rangeFrom;
	private float rangeTo;
	
	public Price() {}
	
	public Price(String type, double basicFee, double unitRate, float rangeFrom, float rangeTo) {
		super();
		this.type = type;
		this.basicFee = basicFee;
		this.unitRate = unitRate;
		this.rangeFrom = rangeFrom;
		this.rangeTo = rangeTo;
	}

	
	public String getType() {
		return this.type;
	}
	
//	public void setType(String type) {
//		this.type = type;
//	}
	
	public double getBasicFee() {
		return this.basicFee;
	}
//	
//	public void setBasicFee(double basicFee) {
//		this.basicFee = basicFee;
//	}
	
	public double getUnitRate() {
		return this.unitRate;
	}
	
//	public void setUnitRate(double unitRate) {
//		this.unitRate = unitRate;
//	}
	
	public float getRangeFrom() {
		return this.rangeFrom;
	}
	
//	public void setRangeFrom(float rangeFrom) {
//		this.rangeFrom = rangeFrom;
//	}
	
	public float getRangeTo() {
		return this.rangeTo;
	}
	
//	public void setRangeTo(float rangeTo) {
//		this.rangeTo = rangeTo;
//	}
}
