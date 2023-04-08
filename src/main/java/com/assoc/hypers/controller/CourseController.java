package com.assoc.hypers.controller;

import com.assoc.hypers.entity.Course;
import com.assoc.hypers.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping({"/addNewCourse"})
    public Course addNewCourse(@RequestBody Course course){
        return courseService.addNewCourse(course);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping({"/getCourseList"})
    public Page<Course> getCourseList(@RequestParam(defaultValue = "0") int pageNumber,
                                      @RequestParam(defaultValue = "") String searchKey){
        return courseService.getCourseList(pageNumber,searchKey);
    }
    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping({"/getCourseById/{courseId}"})
    public Course getCourseById(@PathVariable("courseId") Integer courseId){
        return courseService.getCourseById(courseId);
    }
    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping({"/updateCourse"})
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @PreAuthorize("hasRole('TEACHER')")
    @DeleteMapping({"/deleteCourse"})
    public void deleteCourse(@PathVariable("courseId") Integer courseId){
        courseService.deleteCourse(courseId);
    }
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping({"/getCourseDetails/{isSingleCourseCheckout}/{courseId}"})
    public List<Course> getCourseDetails(@PathVariable(name= "isSingleCourseCheckout") boolean isSingleCourseCheckout,
                                         @PathVariable(name = "courseId") Integer courseId){

        return courseService.getCourseDetails(isSingleCourseCheckout,courseId);
    }


}
