package com.project.hibernate.service;


import com.project.hibernate.entity.Post;

public interface PostService {


    Post getPost(Integer id);

    Post addPost(Post post);
}