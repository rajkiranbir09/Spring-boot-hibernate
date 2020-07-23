package com.project.hibernate.dto;

import java.util.Date;

public class PhotoDTO {
    private long photo_id;

    private String photo_name;

    private String photo_description;

    private long photo_likes;

    private long photo_views;

    private Date upload_data;

    private UserDTO userDTO;

    private String category;

    private String photo_file;
}
