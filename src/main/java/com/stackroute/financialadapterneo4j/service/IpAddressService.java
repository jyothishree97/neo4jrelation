package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.IPAddress;

public interface IpAddressService {

    IPAddress createNewIpAddressNode(IPAddress ipAddress);
}
