package com.assoc.hypers.repository;

import com.assoc.hypers.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {
    Page<Course> findByCourseNameContainingIgnoreCaseOrCourseDescriptionContainingIgnoreCase(
            String key1, String key2, Pageable pageable
    );
}
