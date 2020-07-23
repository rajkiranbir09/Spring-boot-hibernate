package com.project.hibernate.repository;


import com.project.hibernate.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

//@Repository
@Transactional
@org.springframework.stereotype.Repository
//public interface FileRepository extends Repository<File,Integer> {
public interface FileRepository extends JpaRepository<File,Integer> {

    File findOne(String id);

    List<File> findAll();

    File save(File file);

    void delete(String id);

    List<File> save(List<File> file);
}