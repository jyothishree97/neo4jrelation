package com.stackroute.financialadapterneo4j.service;


import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;
import com.stackroute.financialadapterneo4j.repositories.PatternAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.neo4j.driver.v1.Config.build;

@Service
public class PatternAnalysisServiceImplementation implements PatternAnalysisService {
    private PatternAnalysis patternAnalysis;

    @Autowired
    public PatternAnalysisServiceImplementation(PatternAnalysis patternAnalysis) {
        this.patternAnalysis = patternAnalysis;
    }

    @Override
    public Collection<Item> findByno_of_items(String no_of_items) {
        System.out.println("inside service method********" + patternAnalysis.findByno_of_items(no_of_items));
        return patternAnalysis.findByno_of_items(no_of_items);
    }

    @Override
    public Collection<IPAddress> findByName(String transaction_holder_name){
         Collection<IPAddress> ipAddress=patternAnalysis.fingByName(transaction_holder_name);
         return ipAddress;
    }

    @Override
    public List<TransactionDetails> findTransactions(String transaction_holder_name){
        List<TransactionDetails> details=patternAnalysis.findTransactions(transaction_holder_name);
        return patternAnalysis.findTransactions(transaction_holder_name);
        }

    @Override
    public List<CardDetails> findCardDetails() {
        return patternAnalysis.findCardDetails();
    }

    @Override
    public TransactionDetails saveTransaction(TransactionDetails transactionDetails) {
      return patternAnalysis.save(transactionDetails);
    }
}
