package com.stackroute.financialadapterneo4j.controller;

import com.stackroute.financialadapterneo4j.domain.*;
import com.stackroute.financialadapterneo4j.repositories.BillingDetailsRepository;
import com.stackroute.financialadapterneo4j.repositories.IpAddressRepository;
import com.stackroute.financialadapterneo4j.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PatternAnalysisController {

    private PatternAnalysisService patternAnalysisService;
    private ItemService itemService;
    private CardDetailService cardDetailService;
    private BillingDetailService billingDetailService;


    @Autowired
    public PatternAnalysisController(PatternAnalysisService patternAnalysisService,ItemService itemService, CardDetailService cardDetailService,BillingDetailService billingDetailService){
        this.patternAnalysisService=patternAnalysisService;
        this.itemService=itemService;
        this.cardDetailService=cardDetailService;
        this.billingDetailService=billingDetailService;
    }

    @GetMapping("item")
    public ResponseEntity<Iterable<Item>>  getByNo_Of_Items (String no_of_items){
        System.out.println(no_of_items);
        System.out.println("inside controller method*******");
        Iterable<Item> items = patternAnalysisService.findByno_of_items(no_of_items);
        System.out.println(items);
        return new ResponseEntity<>(patternAnalysisService.findByno_of_items(no_of_items),HttpStatus.OK);
    }

    @GetMapping("transactions/{transaction_holder_name}")
    public ResponseEntity<List<TransactionDetails>>  getTransactions(@PathVariable ("transaction_holder_name") String transaction_holder_name){
        List<TransactionDetails> transactionDetails = patternAnalysisService.findTransactions(transaction_holder_name);
        System.out.println(transactionDetails);
        return new ResponseEntity<>(patternAnalysisService.findTransactions(transaction_holder_name),HttpStatus.OK);
    }

    @GetMapping("transaction/{transaction_holder_name}")
    public ResponseEntity<Iterable<IPAddress>>  getByName(@PathVariable("transaction_holder_name") String transaction_holder_name) {

        Iterable<IPAddress> transactionDetails=patternAnalysisService.findByName(transaction_holder_name);
        System.out.println(transactionDetails);
        return new ResponseEntity<>(patternAnalysisService.findByName(transaction_holder_name),HttpStatus.OK);
    }

    @GetMapping("carddetails")
    public ResponseEntity<Iterable<CardDetails>> getCardDetails(String card_no){
        Iterable<CardDetails> cardDetails=patternAnalysisService.findCardDetails();
        System.out.println(cardDetails);
        return new ResponseEntity<>(patternAnalysisService.findCardDetails(),HttpStatus.OK);
    }

    @Autowired
    IpAddressRepository repository;
    BillingDetailsRepository billingDetailsRepository;


    @PostMapping("transactions")
    public ResponseEntity<TransactionDetails> saveTransactions(@RequestBody TransactionDetails transactionDetails)
    {
        System.out.println(transactionDetails);
        TransactionDetails obj=patternAnalysisService.saveTransaction(transactionDetails);
        System.out.println(obj);
        return new ResponseEntity<TransactionDetails>(obj,HttpStatus.OK);
    }

    @PostMapping("Ipaddress")
    public ResponseEntity<IPAddress> saveIpAddress(@RequestBody IPAddress ipAddress){
        System.out.println(ipAddress);
        repository.createNode(ipAddress.getId(), ipAddress.getIpv4(), ipAddress.getIpv6());
        return new ResponseEntity<IPAddress>(new IPAddress(),HttpStatus.OK);
    }

    @PostMapping("item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        System.out.println(item);
        itemService.itemNode(item);
        return new ResponseEntity<Item>(new Item(), HttpStatus.OK);
    }

    @PostMapping("card")
    public ResponseEntity<CardDetails> saveCardDetails(@RequestBody CardDetails cardDetails){
        System.out.println(cardDetails);
        cardDetailService.cardDetailNode(cardDetails);
        return new ResponseEntity<CardDetails>(cardDetailService.cardDetailNode(cardDetails),HttpStatus.OK);

    }

    @PostMapping("billing")
    public ResponseEntity<BillingDetails> saveBillingDetails(@RequestBody BillingDetails billingDetails){
        System.out.println(billingDetails);
        billingDetailService.billingDetailNode(billingDetails);
        return new ResponseEntity<BillingDetails>(new BillingDetails(),HttpStatus.OK);

    }
}
