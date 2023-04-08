package com.assoc.hypers.service;

import com.assoc.hypers.auth.JwtRequestFilter;
import com.assoc.hypers.entity.Cart;
import com.assoc.hypers.entity.Course;
import com.assoc.hypers.entity.User;
import com.assoc.hypers.repository.CartRepository;
import com.assoc.hypers.repository.CourseRepository;
import com.assoc.hypers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public void deleteCartItem(Integer cartId){
        cartRepository.deleteById(cartId);
    }
    public Cart addToCart(Integer courseId) {

       Course course = courseRepository.findById(courseId).get();
       String userName = JwtRequestFilter.CURRENT_USER;

       User user = null;
       if (userName !=null){
           user = userRepository.findById(userName).get();

       }
       //To avoid duplicate item in the cart
        List<Cart> cartList = cartRepository.findByUser(user);
        List<Cart> filteredList = cartList.stream().filter(x -> x.getCourse().getCourseId()== courseId).collect(Collectors.toList());
       if (filteredList.size() > 0){
           return null;
       }
       //
       if (course !=null && user !=null ){
           Cart cart = new Cart(course, user);
           return cartRepository.save(cart);
       }
       return null;
    }
    public List<Cart> getCartDetails(){
        String userName = JwtRequestFilter.CURRENT_USER;
        User user = userRepository.findById(userName).get();
        return cartRepository.findByUser(user);
    }
}
