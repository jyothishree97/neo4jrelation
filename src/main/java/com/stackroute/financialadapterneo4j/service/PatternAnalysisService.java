package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;

import java.util.Collection;
import java.util.List;

public interface PatternAnalysisService {
    Collection<TransactionDetails> findByno_of_items(String transaction_holder_name);

    Collection<IPAddress> findByName(String transaction_holder_name);

    TransactionDetails saveTransaction(TransactionDetails transactionDetails);

    List<TransactionDetails> findTransactions(String transaction_holder_name);

    List<CardDetails> findCardDetails();
}
