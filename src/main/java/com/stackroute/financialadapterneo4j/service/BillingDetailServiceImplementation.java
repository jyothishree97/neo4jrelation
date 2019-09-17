package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.BillingDetails;
import com.stackroute.financialadapterneo4j.repositories.BillingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingDetailServiceImplementation implements BillingDetailService {

    @Autowired
    BillingDetailsRepository billingDetailsRepository;

    @Override
    public BillingDetails billingDetailNode(BillingDetails billingDetails) {
        return billingDetailsRepository.save(billingDetails);
    }
}
