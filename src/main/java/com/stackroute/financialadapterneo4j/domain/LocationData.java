package com.stackroute.financialadapterneo4j.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationData {
    private GeoLocation geo;
}
