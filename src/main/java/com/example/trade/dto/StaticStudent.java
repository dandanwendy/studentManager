package com.example.trade.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaticStudent {
    private int id;
    private String name;
    private int chinese;
    private int math;
    private int english;
    private double average;

}
