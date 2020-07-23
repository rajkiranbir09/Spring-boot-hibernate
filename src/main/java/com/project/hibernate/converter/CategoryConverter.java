package com.project.hibernate.converter;


import com.project.hibernate.dto.CategoryDTO;
import com.project.hibernate.entity.Category;
import org.springframework.core.convert.converter.Converter;



public class CategoryConverter implements Converter<CategoryDTO, Category> {

    @Override
    public Category convert(CategoryDTO source) {
        Category target = new Category();
        target.setName(source.getName());
        // id
        target.setCategoryId(source.getCategoryId());
        return target;
    }



}