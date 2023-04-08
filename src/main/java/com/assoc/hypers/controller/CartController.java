package com.assoc.hypers.controller;

import com.assoc.hypers.entity.Cart;
import com.assoc.hypers.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping({"/addToCart/{courseId}"})
    public Cart addToCart(@PathVariable("courseId") Integer courseId){
        return cartService.addToCart(courseId);
    }
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping({"/getCartDetails"})
    public List<Cart> getCartDetails(){
        return cartService.getCartDetails();
    }
    @PreAuthorize("hasRole('STUDENT')")
    @DeleteMapping({"/deleteCartItem/{cartId}"})
    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId){
        cartService.deleteCartItem(cartId);
    }

}
