package com.project.hibernate.service;


import com.project.hibernate.entity.File;

import java.util.List;



public interface FileService {
    File findById(String id);

    List<File> findAll();

    File save(File file);

    void delete(String id);

    public List<File> save(List<File> file);

}