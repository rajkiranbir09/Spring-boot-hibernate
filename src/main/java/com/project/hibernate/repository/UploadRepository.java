package com.project.hibernate.repository;


import com.project.hibernate.entity.Upload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UploadRepository extends CrudRepository<Upload,Integer> {
}