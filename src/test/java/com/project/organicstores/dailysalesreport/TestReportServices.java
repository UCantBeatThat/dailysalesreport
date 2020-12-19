package com.project.organicstores.dailysalesreport;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.project.organicstores.dailysalesreport.ifaces.Constants;
import com.project.organicstores.dailysalesreport.model.Garments;
import com.project.organicstores.dailysalesreport.model.Product;
import com.project.organicstores.dailysalesreport.services.ProductService;
import com.project.organicstores.dailysalesreport.services.ReportGeneratorService;
import com.project.organicstores.dailysalesreport.utils.ConnectionUtils;

class TestReportServices {
	
	private Connection connection = ConnectionUtils.getConnectionFromPool();
	
	private ProductService productService = new ProductService(connection);
	
	private ReportGeneratorService reportService = new ReportGeneratorService(connection);
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	private LocalDate dateOfPurchase = LocalDate.now();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		log.info("Starting " + testInfo.getDisplayName());
	}

	@AfterEach
	void tearDown(TestInfo testinfo) throws Exception {
		log.info(testinfo.getDisplayName() + " finished.");
	}

	@Test
	@DisplayName(value="Check if method adds an entry in the table")
	void testAdd() {
		
		LocalDate dateOfPurchase = LocalDate.now();
		
		Product shirt = new Garments(1001, "Polo T-Shirt", 299.99, 10, dateOfPurchase, 32, Constants.DRESS_MATERIAL_GENTS);
		
		assertTrue(productService.add(shirt, 2));
	}
	
	@Test
	@DisplayName(value="Check if method raises an exception on duplicate entry")
	void testAddCheckForException() {
		
		Product shirt = new Garments(1001, "Polo T-Shirt", 299.99, 10, dateOfPurchase, 32, Constants.DRESS_MATERIAL_GENTS);
		
		assertThrows(SQLException.class, 
				() -> productService.add(shirt, 2));
	}

	@Test
	@DisplayName(value = "Check if method displays entries added")
	void testFindAllNotNull() {
		assertNotNull(productService.findAll(2));
	}
	
	@Test
	@DisplayName(value = "Check if method raises an exception")
	void testFindAllForException() {
		assertThrows(SQLException.class, 
				() -> productService.findAll(2));
	}

	@Test
	@DisplayName(value = "Check if method raises IO exception")
	void testFindByDateForIOException() {
		assertThrows(IOException.class, 
				() -> reportService.generateReportByDate(2, dateOfPurchase));
	}
	
	@Test
	@DisplayName(value = "Check if method raises SQL exception")
	void testFindByDateForSQLException() {
		assertThrows(SQLException.class, 
				() -> reportService.generateReportByDate(10, dateOfPurchase));
	}

	@Test
	@DisplayName(value = "Check if method raises IO exception")
	void testFindTopProductsByMonthForIOException() {
		assertThrows(IOException.class,
				() -> reportService.generateReportForTopSellingItems(2, 11));
	}
	
	@Test
	@DisplayName(value = "Check if method raises SQL exception")
	void testFindTopProductsByMonthForSQLException() {
		assertThrows(IOException.class,
				() -> reportService.generateReportForTopSellingItems(2, 11));
	}

}
