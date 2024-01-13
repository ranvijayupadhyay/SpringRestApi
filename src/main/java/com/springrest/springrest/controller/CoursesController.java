package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.response.CourseResponse;
import com.springrest.springrest.response.GenericResponse;
import com.springrest.springrest.services.CourseService;

@RestController
public class CoursesController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to our Cources";
	}
	
	
	//For getting all the courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getCourses();
	}
	
	
	@GetMapping("/courses/{courseId}/data")
	public Object getCourse(@PathVariable String courseId) {
		Course course = null;
		CourseResponse courseResponse = new CourseResponse();
		boolean error = false;
		try {
			course = courseService.getCourse(Long.parseLong(courseId));
			course.getTitle();
		} catch (Exception e) {
			error = true;
		}
		if (course != null) {
			if (!error) {
				courseResponse.setId(course.getId());
				courseResponse.setDescription(course.getDescription());
				courseResponse.setTitle(course.getTitle());
			}
			else
				return new GenericResponse("No Course Found", HttpStatus.OK);
		}
		return courseResponse;
	}
	
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourses(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public GenericResponse deleteCourse(@PathVariable String courseId) {
		try {
			courseService.deleteCourse(Long.parseLong(courseId));
			return new GenericResponse("Course Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new GenericResponse();
		}
	}
	
}
