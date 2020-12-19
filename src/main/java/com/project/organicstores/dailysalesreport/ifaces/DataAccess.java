package com.project.organicstores.dailysalesreport.ifaces;

import java.time.LocalDate;
import java.util.List;

public interface DataAccess<T>{
	
	public boolean add(T t, int key);
	
	public String findLastKey(int key);
	
	public List<T> findAll(int key);
	
	public List<T> findByDate(int key, LocalDate date);
	
	public List<T> findTopProductsByMonth(int key, int month);
	
}
