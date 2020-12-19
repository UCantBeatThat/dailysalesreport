package com.project.organicstores.dailysalesreport.model;

import java.time.LocalDate;

public class Edible extends Product {
	
	private LocalDate dateOfManufacture;
	private LocalDate dateOfExpiry;
	private String foodType;
	
	public Edible() {
		super();
	}

	public Edible(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			LocalDate dateOfManufacture, LocalDate dateOfExpiry, String foodType) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase);
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.foodType = foodType;
	}

	public Edible(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			double lineTotal, LocalDate dateOfManufacture, LocalDate dateOfExpiry, String foodType) {
		super(itemCode, itemName, unitPrice, quantity, dateOfPurchase, lineTotal);
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.foodType = foodType;
	}

	public Edible(int itemCode, String itemName, int quantity) {
		super(itemCode, itemName, quantity);
	}

	public Edible(int itemCode, String itemName, double unitPrice, int quantity, double lineTotal) {
		super(itemCode, itemName, unitPrice, quantity, lineTotal);
	}

	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	

}
