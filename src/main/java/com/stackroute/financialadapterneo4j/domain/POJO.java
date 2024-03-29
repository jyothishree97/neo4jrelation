package com.stackroute.financialadapterneo4j.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class POJO {
    private String actor;
    private String verb;
    ObjectTypes object;
    private double distance;
    private double timeStamp;
    private String message;
}
