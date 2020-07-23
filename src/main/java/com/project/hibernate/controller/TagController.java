package com.project.hibernate.controller;



import com.project.hibernate.entity.Post;
import com.project.hibernate.entity.Tag;
import com.project.hibernate.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/api/tags")
//@Api(tags="Vechiles")
public class TagController {

    @Autowired
    TagRepository tagRepositoryDao;

    // get all tags
    @GetMapping
    @ResponseBody
    public Iterable<Tag> getTagsJSON(){
        return tagRepositoryDao.findAll();
    }
    // create new tag
    @PostMapping
    public Tag createNewTag(@Valid @RequestBody Tag t){
        tagRepositoryDao.save(t);
        return t;
    }
    // get one tag by id
    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable("id") int id){
        return tagRepositoryDao.findById(id);

    }

    // get all post by tag id


}