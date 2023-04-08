package com.assoc.hypers.repository;

import com.assoc.hypers.entity.OrderCourse;
import com.assoc.hypers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderCourse, Integer> {
    public List<OrderCourse> findByUser(User user);
}
