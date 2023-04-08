package com.assoc.hypers.service;

import com.assoc.hypers.auth.JwtRequestFilter;
import com.assoc.hypers.entity.Cart;
import com.assoc.hypers.entity.Course;
import com.assoc.hypers.entity.User;
import com.assoc.hypers.repository.CartRepository;
import com.assoc.hypers.repository.CourseRepository;
import com.assoc.hypers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Course addNewCourse(Course course) {
        return courseRepository.save(course);
    }


    public Page<Course> getCourseList(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber,3);

        if (searchKey.equals("")){
            return courseRepository.findAll(pageable);
        }else {
            return courseRepository.findByCourseNameContainingIgnoreCaseOrCourseDescriptionContainingIgnoreCase(
                    searchKey,searchKey,pageable
            );
        }
    }

    public Course getCourseById(Integer courseId) {
        return courseRepository.findById(courseId).get();
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
    public void deleteCourse(Integer courseId){
         courseRepository.deleteById(courseId);
    }


    public List<Course> getCourseDetails(boolean isSingleCourseCheckout, Integer courseId) {
        if (isSingleCourseCheckout && courseId !=0){
            //Checkout single course only

            List<Course> courseList = new ArrayList<>();
            Course course = courseRepository.findById(courseId).get();
            courseList.add(course);
            return courseList;
        }else {
            //checkout the entire cart
            String userName = JwtRequestFilter.CURRENT_USER;
            User user = userRepository.findById(userName).get();
            List<Cart> cartList = cartRepository.findByUser(user);
            return cartList.stream().map(x -> x.getCourse()).collect(Collectors.toList());
        }
    }
}
