package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao courseDao;
	
//	private List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<Course>();
//		list.add(new Course(1, "New Article", "How to write descriptive article"));
//		list.add(new Course(2, "React Js", "Full Courses on React js"));
//	
	
	
	}
	
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c;
//	
		return courseDao.getReferenceById(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
//		for(Course c: list) {
//			if(c.getId()==course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				break;
//			}
//		}
		courseDao.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long courseId) {
//		list = list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		courseDao.deleteById(courseId);
	}

}
