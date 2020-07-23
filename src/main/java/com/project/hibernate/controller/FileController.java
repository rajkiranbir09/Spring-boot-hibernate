package com.project.hibernate.controller;



import com.project.hibernate.entity.File;
import com.project.hibernate.exception.ResourceNotFoundException;
import com.project.hibernate.repository.FileRepository;
import com.project.hibernate.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

    @GetMapping
    @ApiOperation(value = "Find all Files metadata",notes = "Displays all the Files in the DB")

    List<File>  findAllFile(){
        return fileService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ApiOperation(value = "Find File By Id",notes = "Displays the File for the ID provided from the DB")

    File  findFileById(@PathVariable("id") String id){
        File file = fileService.findById(id);
        if(file == null){
            throw new ResourceNotFoundException("File Not Found");
        }
        else{
            return file;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Create new File",notes = "Displays the File created ")

    File create(@RequestBody File file){
        return fileService.save(file);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Update the file",notes = "Displays the File Updated ")

    List<File> create(@RequestBody List<File> file){
        return fileService.save(file);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )

    List<File> update(@RequestBody File[] file){

        for (File f:  file) {
            fileService.save(f);
        }
        return Arrays.asList(file) ;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete File",notes = "Removes the File identified by fileId ")

    void update(@PathVariable("id") String  id){
        fileService.delete(id);
    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<Long> serveInstance(@RequestParam("file") MultipartFile file) {
//        //deleteOldFile();
//        File dataSet = null;
//        try {
//            dataSet = new File(file.getBytes(),new Date(),file.getOriginalFilename());
//            fileRepository.save(dataSet);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(dataSet.getId(), HttpStatus.OK);
//
//    }

//    @PutMapping("/update/{id}")
//    public void updateEntityById(@PathVariable Long id, @RequestParam("description") String description) {
//        File dataSet = fileRepository.findOne(id);
//        dataSet.setDescription(description);
//        fileRepository.save(dataSet);
//    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteEntityById(@PathVariable("id") int id) {
//        fileRepository.delete(id);
//    }

}