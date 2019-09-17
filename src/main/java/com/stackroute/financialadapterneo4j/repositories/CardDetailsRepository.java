package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.CardDetails;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends Neo4jRepository<CardDetails ,String> {
}
