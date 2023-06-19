package com.course.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends CrudRepository<Course, Integer> { // <Entity class we are working with, Type of PrimaryKey>

	public List<Course> findByTopicId(Integer id);
}
