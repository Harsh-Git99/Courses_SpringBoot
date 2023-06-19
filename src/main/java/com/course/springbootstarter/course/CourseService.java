package com.course.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	
	public List<Course> getAllCourses(int id){
		
		List<Course> courses = new ArrayList<>();
		
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(int id ) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		  return courseRepository.findById(id).get();	
	}
	

	public void addCourse(Course course) {
		
		courseRepository.save(course);
	}
	
	public void addCourses(List<Course> list) {
		courseRepository.saveAll(list);
	}

	
	public void updateCourse( Course course) {
		
		 courseRepository.save(course);
		
	
	}

	public void deleteCourses(int id) {
		courseRepository.deleteById(id);
		
	}

	public void deleteAllCourse() {
		courseRepository.deleteAll();
	}
	
	
}
