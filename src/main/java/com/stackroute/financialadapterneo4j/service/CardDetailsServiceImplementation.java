package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.repositories.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardDetailsServiceImplementation implements CardDetailService {

    @Autowired
    CardDetailsRepository cardDetailsRepository;

    @Override
    public CardDetails cardDetailNode(CardDetails cardDetails) {
            return cardDetailsRepository.save(cardDetails);
    }
}
