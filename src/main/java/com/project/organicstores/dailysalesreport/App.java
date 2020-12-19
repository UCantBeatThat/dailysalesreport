package com.project.organicstores.dailysalesreport;

import java.sql.Connection;
import java.time.LocalDate;

import com.project.organicstores.dailysalesreport.ifaces.Constants;
import com.project.organicstores.dailysalesreport.model.Edible;
import com.project.organicstores.dailysalesreport.model.Electronics;
import com.project.organicstores.dailysalesreport.model.Garments;
import com.project.organicstores.dailysalesreport.model.Product;
import com.project.organicstores.dailysalesreport.services.ProductService;
import com.project.organicstores.dailysalesreport.services.ReportGeneratorService;
import com.project.organicstores.dailysalesreport.utils.ConnectionUtils;

public class App 
{
    public static void main( String[] args )
    {
    	Connection connection = ConnectionUtils.getConnectionFromPool();
    	
    	ProductService service = new ProductService(connection);
    	
    	ReportGeneratorService reportService = new ReportGeneratorService(connection);
    	
    	LocalDate dateOfPurchase = LocalDate.now();
    	
    	Product soanPapdi = new Edible(110, "Soan Papdi", 80.00, 5, dateOfPurchase, dateOfPurchase.minusDays(40), dateOfPurchase.plusDays(100), Constants.FOOD_TYPE_VEG);
    	
    	Product shirt = new Garments(101, "Polo T-Shirt", 299.99, 10, dateOfPurchase, 32, Constants.DRESS_MATERIAL_GENTS);
    	
    	Product pant = new Garments(102, "Levis Jeans", 789.20, 4, dateOfPurchase.plusDays(1), 36, Constants.DRESS_MATERIAL_UNISEX);
    	
    	Product mobilePhone = new Electronics(102, "Samsung Galaxy M30", 21899.99, 109090, dateOfPurchase, 6, 1, 240);
    	
    	service.add(soanPapdi, 1);
    	
    	service.add(shirt, 2);
    	
    	service.add(pant, 2);
    	
    	service.add(mobilePhone, 3);

//    	List<Product> productList = service.findAll(2);
    	
//    	System.out.println(gson.toJson(productList) + "\n\n");
    	
//    	productList = service.findAll(1);
    	
//    	System.out.println(gson.toJson(productList) + "\n\n");
    	
//    	productList = service.findAll(3);
    	
//    	System.out.println(gson.toJson(productList) + "\n\n");
    	
//    	productList = service.findByDate(2, dateOfPurchase.plusDays(1));
    	
//    	System.out.println(gson.toJson(productList) + "\n\n");
    	
//    	productList = service.findTopProductsByMonth(2, 10);
    	
//    	System.out.println(productList + "\n\n");
    	
    	reportService.generateReportByDate(1, dateOfPurchase);
    	
    	reportService.generateReportForTopSellingItems(2, 11);
    	
    	service.closeConnection();
    }
}
