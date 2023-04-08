package com.assoc.hypers.repository;

import com.assoc.hypers.entity.Cart;
import com.assoc.hypers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);
}
