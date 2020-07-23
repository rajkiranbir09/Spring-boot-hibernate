package com.project.hibernate.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.hibernate.entity.Category;
import com.project.hibernate.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public boolean isPersisted(Category category) {
        Category fcategory= categoryRepository.findByCategoryId(category.getCategoryId());
        if(category == null) {
            return false;
        }
        return true;

    }

    public Category getCategory(Category category) {
        return categoryRepository.findByCategoryId(category.getCategoryId());
    }

    public Category insert(Category category) {
        return categoryRepository.save(category);

    }

    public Category update(Category category) {

        if(!isPersisted(category)) {
            return null;
        }
        return categoryRepository.save(category);

    }

    public Category delete(Category category) {

//		if (isPersisted(category)) {
//			return null;
//		}
        categoryRepository.delete(category);
        return category;

    }

    public List<Category> listAll() {
        return categoryRepository.findAll();

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