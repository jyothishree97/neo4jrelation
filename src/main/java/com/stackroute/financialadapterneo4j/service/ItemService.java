package com.stackroute.financialadapterneo4j.service;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.Location;
public interface ItemService {
    Item saveItem(Item item);
    public Location getLocation(String host);
    public boolean compareLocations(Location currentTransactionLocation, Location previousTransactionLocation);
    public long calculateDateDifference(String currentTransactionTimeStamp, String oldTransactionTimeStamp);
    public double distance(double latitude1, double longitude1, double latitude2, double longitude2, String unit);
}