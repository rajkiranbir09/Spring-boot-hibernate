package com.project.hibernate.controller;


import java.util.List;

import javax.validation.Valid;

import com.project.hibernate.entity.Category;
import com.project.hibernate.service.CategoryService;
import com.project.hibernate.service.elasticsearch.CategoryESService;
import org.elasticsearch.search.aggregations.metrics.percentiles.hdr.InternalHDRPercentiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/v1/api/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService categoryService;

//    @Autowired
//    private CategoryESService categoryESService;

    // Get All Notes
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
//        categoryService = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
        List<Category> categories = null;
        try {
            categories = categoryService.listAll();
        }catch (Exception e){
            return new ResponseEntity<List<Category>>(categories, HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    // get all category with elastic search database base
//    @GetMapping
//    public Iterable<Category> getAllCategoryES() {
//        return categoryESService.findAll();
//    }

    // Create a new Note

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
//        categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
        return categoryService.insert(category);
    }

    // INSERT A NEW CATEGORY WITH ELASTICSEARCH

//    @PostMapping(value = "/insertes")
//    public void insertCategory(@RequestBody Category c){
//        categoryESService.addCategory(c);
//    }
    // Get a Single Note

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer categoryId) {
        Category fcategory= new Category();
//        categoryService = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
        fcategory.setCategoryId(categoryId);

        fcategory = categoryService.getCategory(fcategory);
        if (fcategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(fcategory);
    }

    // Update a Note

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Integer categoryId,
                                                   @Valid @RequestBody Category category) {
//        categoryService = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
        Category updatedCourse = categoryService.update(category);
        if (updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCourse);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Integer categoryId) {
//        categoryService = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
        Category category = new Category();
        category.setCategoryId(categoryId);
        Category deletedCategory = categoryService.delete(category);

        if (deletedCategory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    // DELETE CATEGORY WITH ELASTICSEARCH DATABASE
//    @RequestMapping(value = "/delete/student/{id}", method = RequestMethod.GET)
//    public void deleteStudent(@PathVariable int id){
//        studentService.deleteStudent(id);
//    }

}