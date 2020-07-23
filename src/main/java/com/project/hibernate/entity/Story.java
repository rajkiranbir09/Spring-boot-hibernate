package com.project.hibernate.entity;

import lombok.Data;

@Data
public class Story {

    private int id;

    private String title;

    private String description;

    private Integer storypoints;

    private Integer sprintId;

    private String status = "Not Started";

}
