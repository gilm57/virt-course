package com.assoc.hypers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInput {


    private String fullName;
    private String email;
    private String phoneNumber;

    private List<OrderCourseQuantity> orderCourseQuantityList;
}
