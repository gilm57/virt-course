package com.assoc.hypers.service;

import com.assoc.hypers.auth.JwtRequestFilter;
import com.assoc.hypers.entity.Cart;
import com.assoc.hypers.entity.Course;
import com.assoc.hypers.entity.OrderCourse;
import com.assoc.hypers.entity.User;
import com.assoc.hypers.model.OrderCourseQuantity;
import com.assoc.hypers.model.OrderInput;
import com.assoc.hypers.repository.CartRepository;
import com.assoc.hypers.repository.CourseRepository;
import com.assoc.hypers.repository.OrderRepository;
import com.assoc.hypers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartRepository cartRepository;
    private static final String ORDER_PLACED = "Placed";
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<OrderCourse> getAllOrderDetails(){
        List<OrderCourse> orderCourses = new ArrayList<>();
        orderRepository.findAll().forEach(
                x->orderCourses.add(x)
        );
        return orderCourses;
    }

    public List<OrderCourse> getOrderDetails(){
        String currentUser = JwtRequestFilter.CURRENT_USER;
        User user = userRepository.findById(currentUser).get();
        return orderRepository.findByUser(user);

    }

    public void placeOrder(OrderInput orderInput, boolean isSingleCourseCheckout) {
        List<OrderCourseQuantity> orderCourseQuantityList = orderInput.getOrderCourseQuantityList();

        for (OrderCourseQuantity OCQ : orderCourseQuantityList){
            Course course = courseRepository.findById(OCQ.getCourseId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user =userRepository.findById(currentUser).get();

            OrderCourse orderCourse = new OrderCourse(
                    orderInput.getFullName(),
                    orderInput.getEmail(),
                    orderInput.getPhoneNumber(),
                        ORDER_PLACED,
                                    course.getCoursePrice() * OCQ.getQuantity(),
                    course,user

            );
            //The Cart will be empty clicking placeOrder
            if (!isSingleCourseCheckout){
                List<Cart> carts = cartRepository.findByUser(user);
                carts.stream().forEach(x -> cartRepository.deleteById(x.getCartId()));

            }
            orderRepository.save(orderCourse);

        }
    }

    public void markOrderAsDelivered(Integer orderId){
       OrderCourse orderCourse= orderRepository.findById(orderId).get();

       if (orderCourse !=null){
           orderCourse.setOrderStatus("DELIVERED");
           orderRepository.save(orderCourse);
       }
    }
}
