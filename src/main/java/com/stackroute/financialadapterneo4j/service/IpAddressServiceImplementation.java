package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.IPAddress;
import com.stackroute.financialadapterneo4j.repositories.IpAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpAddressServiceImplementation implements IpAddressService {

    @Autowired
    private IpAddressRepository ipAddressRepository;

    @Override
    public IPAddress createNewIpAddressNode(IPAddress ipAddress) {
        System.out.println(ipAddress);
        return ipAddress;
//        return ipAddressRepository.createNode(ipAddress.getId(), ipAddress.getIpv4(), ipAddress.getIpv6());
    }
}
