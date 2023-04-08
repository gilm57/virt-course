package com.assoc.hypers.controller;

import com.assoc.hypers.entity.OrderCourse;
import com.assoc.hypers.model.OrderInput;
import com.assoc.hypers.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping({"/placeOrder/{isSingleCourseCheckout}"})
    public String placeOrder(@PathVariable("isSingleCourseCheckout") boolean isSingleCourseCheckout,
                            @RequestBody OrderInput orderInput) {
        orderService.placeOrder(orderInput, isSingleCourseCheckout);
        return "Order has been submitted!";
    }
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping({"/getOrderDetails"})
    public List<OrderCourse> getOrderDetails(){
        return orderService.getOrderDetails();
    }
    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping({"/getAllOrderDetails"})
    public List<OrderCourse> getAllOrderDetails(){
        return orderService.getAllOrderDetails();

    }
    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping({"/markOrderAsDelivered/{orderId}"})
    public String markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId){
        orderService.markOrderAsDelivered(orderId);

        return "Order has been delivered";

    }

}
