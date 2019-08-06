package com.boiler.entities;

public class TransferFunds {
	
	private Long originId;
	private Long destId;
	private Double amount;
	
	public Long getOriginId() {
		return originId;
	}
	public void setOriginId(Long originId) {
		this.originId = originId;
	}
	public Long getDestId() {
		return destId;
	}
	public void setDestId(Long destId) {
		this.destId = destId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
