package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.BillingDetails;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailsRepository extends Neo4jRepository<BillingDetails , String> {
//    @Query("CREATE (i:Billing) SET i.bill_id= {bill_id}, i.billing_address = {billing_address}")
//    BillingDetails billingDetailNode(String bill_id, String billing_address);
}
