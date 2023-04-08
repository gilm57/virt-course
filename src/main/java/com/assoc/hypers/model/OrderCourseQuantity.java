package com.assoc.hypers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCourseQuantity {

    private Integer courseId;
    private Integer quantity;
}
