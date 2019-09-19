package com.stackroute.financialadapterneo4j;

import com.stackroute.financialadapterneo4j.service.ItemServiceImplementation;
import com.stackroute.financialadapterneo4j.service.PatternAnalysisService;
import com.stackroute.financialadapterneo4j.service.PatternAnalysisServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancialAdapterNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialAdapterNeo4jApplication.class, args);
	}
}
