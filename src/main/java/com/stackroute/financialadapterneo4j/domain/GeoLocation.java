package com.stackroute.financialadapterneo4j.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeoLocation {
    private Double latitude;
    private Double longitude;
}
