package com.stackroute.financialadapterneo4j.repositories;

import com.stackroute.financialadapterneo4j.domain.IPAddress;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpAddressRepository extends Neo4jRepository<IPAddress, String> {

    @Query("CREATE (i: Ip_address) SET i.id = {id}, i.ipv4 = {ipv4}, i.ipv6 = {ipv6}")
    IPAddress createNode(String id, String ipv4, String ipv6);
}
