package com.project.hibernate.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CategoryDTO {

    private int categoryId;

    private String name;
}
