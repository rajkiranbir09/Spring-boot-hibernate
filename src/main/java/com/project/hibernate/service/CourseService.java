package com.project.hibernate.service;


import java.util.ArrayList;
import java.util.List;

import com.project.hibernate.entity.Course;
import com.project.hibernate.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;




@Service
public class CourseService {
    //
    @Autowired
    CourseRepository courseRepository;

    public boolean isPersisted(Course course) {
        Course fCourse= courseRepository.findByCourseId(course.getCourseId());
        if(course == null) {
            return false;
        }
        return true;

    }

    public Course getCourse(Course course) {
        return courseRepository.findByCourseId(course.getCourseId());
    }

    public Course insert(Course course) {
        return courseRepository.save(course);

    }

    public Course update(Course course) {

        if(!isPersisted(course)) {
            return null;
        }
        return courseRepository.save(course);

    }

    public Course delete(Course course) {

        if (!isPersisted(course)) {
            return null;
        }
        courseRepository.delete(course);
        return course;

    }

    public List<Course> listAll() {
        return courseRepository.findAll();

    }



    // @Override
    // public Model getTableObject() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public List listAllModel() {
    // CourseDao courseDao = new CourseDao();
    // ArrayList<Course> courseList = courseDao.listAll();
    // return courseList;
    // }
    //
    // @Override
    // public Model getModel(Model model) {
    // CourseDao courseDao = new CourseDao();
    // Course course = courseDao.getCourse((Course) model);
    // return course;
    // }

}