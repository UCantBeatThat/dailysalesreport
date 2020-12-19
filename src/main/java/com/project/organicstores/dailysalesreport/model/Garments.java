package com.project.organicstores.dailysalesreport.model;

import java.time.LocalDate;

public class Garments extends Product {
	
	private int size;
	private String material;
	
	public Garments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Garments(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			int size, String material) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase);
		this.size = size;
		this.material = material;
	}
	
	public Garments(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			double lineTotal, int size, String material) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase, lineTotal);
		this.size = size;
		this.material = material;
	}

	public Garments(int itemCode, String itemName, int quantity) {
		super(itemCode, itemName, quantity);
	}

	public Garments(int itemCode, String itemName, double unitPrice, int quantity, double lineTotal) {
		super(itemCode, itemName, unitPrice, quantity, lineTotal);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
