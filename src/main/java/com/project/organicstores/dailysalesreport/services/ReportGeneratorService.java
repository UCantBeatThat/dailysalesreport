package com.project.organicstores.dailysalesreport.services;

import java.io.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.organicstores.dailysalesreport.model.Product;

public class ReportGeneratorService {
	
	private Connection connection;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	public ReportGeneratorService(Connection connection) {
		super();
		this.connection = connection;
	}

	public void generateReportByDate(int key, LocalDate date) {
		
		ProductService productService = new ProductService(connection);
		
		List<Product> productList = productService.findByDate(key, date);
		
		double grandTotal = 0.0;
		int totalQuantity = 0;
		
		if(key == 1) {
			System.out.println("Edible Items report for " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear());
		}
		else if(key == 2) {
			System.out.println("Garment Items report for " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear());
		}
		else if(key == 3) {
			System.out.println("Electronic Items report for " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear());
		}
		
		String reportString = "";
		String dashLine = "--------------------------------------------------------------------------\n";
		
		reportString += dashLine;
		reportString += "Sl. No.\tItem Name\t\tUnit Price\tQuantity\tAmount\t\n";
		reportString += dashLine;
		
		for(Product eachProduct : productList) {
			grandTotal += eachProduct.getLineTotal();
			totalQuantity += eachProduct.getQuantity();
			reportString += (eachProduct.getItemCode() + "\t" + eachProduct.getItemName() + "\t\t" 
					+ eachProduct.getUnitPrice() + "\t\t" + eachProduct.getQuantity() + "\t\t" + eachProduct.getLineTotal() + "\n");
		}
		
		reportString += dashLine;
		reportString += "Total\t\t\t\t\t\t" + totalQuantity + "\t\t" + grandTotal + "\n";
		reportString += dashLine;
		
		File file = new File("reports/reportByDate.txt");
		
		if(!writeToTextFile(reportString, file)) {
			log.error(file.toString() + ": Report file could not be generated");
		}
		
		System.out.println(reportString);
	}
	
	public void generateReportForTopSellingItems(int key, int month) {
		
		ProductService productService = new ProductService(connection);
		
		List<Product> productList = productService.findTopProductsByMonth(key, month);
		
		final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		int totalQuantity = 0;
		
		if(key == 1) {
			System.out.println("Top Selling Edible Items for " + monthNames[month-1] + " 2020");
		}
		else if(key == 2) {
			System.out.println("Top Selling Garment Items for " + monthNames[month-1] + " 2020");
		}
		else if(key == 3) {
			System.out.println("Top Selling Electronic Items for " + monthNames[month-1] + " 2020");
		}
		
		String reportString = "";
		String dashLine = "---------------------------------------------------\n"; 
		
		reportString += dashLine;
		reportString += "Sl. No.\tItem Name\t\tQuantity\n";
		reportString += dashLine;
		
		for(Product eachProduct : productList) {
			totalQuantity += eachProduct.getQuantity();
			reportString += (eachProduct.getItemCode() + "\t" + eachProduct.getItemName() + "\t\t" 
					+ eachProduct.getQuantity() + "\n");
		}
		
		reportString += dashLine;
		reportString += "Total\t\t\t\t" + totalQuantity + "\n";
		reportString += dashLine;
		
		File file = new File("reports/topThreeProducts.txt");
		
		if(!writeToTextFile(reportString, file)) {
			log.error(file.toString() + ": Report file could not be generated");
		}
		
		System.out.println(reportString);
	}
	
	public boolean writeToTextFile(String report, File file) {
		boolean result = false;
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))){
			writer.println(report);
			result = true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	} 
}
