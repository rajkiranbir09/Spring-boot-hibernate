package com.project.hibernate.controller;


import com.project.hibernate.entity.Upload;
import com.project.hibernate.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/upload")
public class UploadRestController {

    @Autowired
    UploadRepository uploadRepository;

    // save new upload
    @PostMapping("/save")
    public void save(@RequestBody Upload upload){
        uploadRepository.save(upload);
    }

    // Find all
    @GetMapping("/getall")
    public List<Upload> get(){
        return (List<Upload>)uploadRepository.findAll();
    }
}