package com.stackroute.financialadapterneo4j.service;


import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;
import com.stackroute.financialadapterneo4j.repositories.PatternAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public Collection<TransactionDetails> findByno_of_items(String transaction_holder_name) {
        System.out.println("inside service method********" + patternAnalysis.findByno_of_items(transaction_holder_name));
        return patternAnalysis.findByno_of_items(transaction_holder_name);
    }

    @Override
    public Collection<IPAddress> findByName(String transaction_holder_name){
         Collection<IPAddress> ipAddress=patternAnalysis.findByName(transaction_holder_name);
         return ipAddress;
    }

    @Override
    public List<TransactionDetails> findTransactions(String transaction_holder_name){
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
