package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.CardDetails;
import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.TransactionDetails;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatternAnalysis extends Neo4jRepository<TransactionDetails,String> {

    //The below query is to check if the number of item is greater than 3 and its cost is greater than 10000
    @Query("Match(i:Item) where i.no_of_items>=3 AND i.item_price>=10000 return i")
    Collection<Item> findByno_of_items(@Param("no_of_items") String no_of_items);

    @Query("Match(i:Ip_address),(t:Transaction) where t.transaction_id=i.id and t.transaction_holder_name={transaction_holder_name} return t,i")
    List<TransactionDetails> findTransactions(@Param("transaction_holder_name") String transaction_holder_name);

    @Query("Match(c:CardDetails) return c")
    List<CardDetails> findCardDetails();

    @Query("Match(t:Transaction),(i:Ip_address),(item:Item) where t.amount=item.item_price and t.transaction_id=i.id and  t.transaction_holder_name={transaction_holder_name} return i.ipv4")
    Collection<IPAddress> fingByName(@Param("transaction_holder_name") String transaction_holder_name);
}
