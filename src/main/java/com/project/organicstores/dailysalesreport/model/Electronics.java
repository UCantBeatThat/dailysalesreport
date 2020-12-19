package com.project.organicstores.dailysalesreport.model;

import java.time.LocalDate;

public class Electronics extends Product {
	
	private int size;
	private int warranty;
	private int wattage;
	
	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Electronics(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			int size, int warranty, int wattage) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase);
		this.size = size;
		this.warranty = warranty;
		this.wattage = wattage;
	}

	public Electronics(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			double lineTotal, int size, int warranty, int wattage) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase, lineTotal);
		this.size = size;
		this.warranty = warranty;
		this.wattage = wattage;
	}

	public Electronics(int itemCode, String itemName, int quantity) {
		super(itemCode, itemName, quantity);
	}

	public Electronics(int itemCode, String itemName, double unitPrice, int quantity, double lineTotal) {
		super(itemCode, itemName, unitPrice, quantity, lineTotal);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getWattage() {
		return wattage;
	}

	public void setWattage(int wattage) {
		this.wattage = wattage;
	}
}
