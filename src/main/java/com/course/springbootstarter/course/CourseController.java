package com.course.springbootstarter.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId) {
		return courseService.getAllCourses(topicId);
				
	}
	
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable int topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	//add multiples
	@PostMapping("/topics/{topicId}/courses/multi")
	public void addCourses(@RequestBody List<Course> list,@PathVariable int topicId ) {
		for(Course course : list) {
			course.setTopic(new Topic(topicId,"",""));
			courseService.addCourse(course);
		}
		//courseService.addCourses(list);
	}
	
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable int topicId ,@PathVariable int id ){
		
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.updateCourse(course);
		
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public String  deleteCourse(@PathVariable int id) {
		 courseService.deleteCourses(id);
		 return "Deleted";	
	}
	
	@DeleteMapping("/topics/{id}/courses/deleteAll")
	public String  deleteAllCourses() {
		 courseService.deleteAllCourse();
		 return "Deleted all the Courses";	
	}
}
