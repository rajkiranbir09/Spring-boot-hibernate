package com.project.hibernate.service.impl;


import com.project.hibernate.entity.Post;
import com.project.hibernate.repository.PostRepository;
import com.project.hibernate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
//public class PostServiceImpl implements PostService {
    public class PostServiceImpl{

//    @Autowired
//    private PostRepository postRepository;
//
//    public Post getPost( id) {
//        Post post = postRepository.findOne(id);
//        if (post != null) {
//            return new PostDao(post.getTitle(), post.getContent(), post.getCreationDate());
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Long addPost(NewPostDao newPostDao) {
//        Post post = new Post();
//        post.setContent(newPostDao.getContent());
//        post.setTitle(newPostDao.getTitle());
//        post.setCreationDate((newPostDao.getCreationDate() != null)
//                ? newPostDao.getCreationDate() : new Date());
//        return postRepository.save(post).getId();
//    }
}