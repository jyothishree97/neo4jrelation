package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.CardDetails;

import java.util.List;

public interface CardDetailService {

    CardDetails cardDetailNode(CardDetails cardDetails);

    List<CardDetails> findCardDetails(String transaction_holder_name);
}
