package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.BillingDetails;
import org.springframework.stereotype.Service;

@Service
public interface BillingDetailService {

    BillingDetails billingDetailNode(BillingDetails billingDetails);
}
