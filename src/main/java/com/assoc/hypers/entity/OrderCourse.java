package com.assoc.hypers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
public class OrderCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private String orderFullName;
    private String orderEmail;
    private String orderPhoneNumber;
    private String orderStatus;
    private Double orderAmount;

    @OneToOne
    private Course course;

    @OneToOne
    private User user;

    public OrderCourse() {
    }


    public OrderCourse(String orderFullName, String orderEmail, String orderPhoneNumber, String orderStatus, Double orderAmount, Course course, User user) {
        this.orderFullName = orderFullName;
        this.orderEmail = orderEmail;
        this.orderPhoneNumber = orderPhoneNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.course = course;
        this.user = user;
    }


    public String getOrderFullName() {
        return orderFullName;
    }

    public void setOrderFullName(String orderFullName) {
        this.orderFullName = orderFullName;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public String getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(String orderPhoneNumber) {
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
