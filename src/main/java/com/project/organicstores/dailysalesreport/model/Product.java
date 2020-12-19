package com.project.organicstores.dailysalesreport.model;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.project.organicstores.dailysalesreport.ifaces.ProductDetails;

public abstract class Product implements ProductDetails {

	private int itemCode;
	private String itemName;
	private double unitPrice;
	private int quantity;
	private LocalDate dateOfPurchase;
	private double lineTotal;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.dateOfPurchase = dateOfPurchase;
	}

	public Product(int itemCode, String itemName, double unitPrice, int quantity, LocalDate dateOfPurchase,
			double lineTotal) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.dateOfPurchase = dateOfPurchase;
		this.lineTotal = lineTotal;
	}

	public Product(int itemCode, String itemName, int quantity) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public Product(int itemCode, String itemName, double unitPrice, int quantity, double lineTotal) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getLineTotal() {
		return lineTotal;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	@Override
	public double calculateLineTotal(int quantity) {
		return this.getUnitPrice()*quantity;
	}

}
