package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.Item;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends Neo4jRepository<Item,String> {

//    @Query("CREATE (it:Item) SET it.item_id = {item_id}, it.item_name={item_name}, it.item_price={item_price}, it.no_of_items = {no_of_items}, it.parent_id={parent_id")
//    Item itemNode(String item_id, String item_name, int item_price, int no_of_items, String parent_id);
}
