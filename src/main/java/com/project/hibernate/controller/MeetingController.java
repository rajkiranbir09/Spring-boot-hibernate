package com.project.hibernate.controller;

import java.util.List;

import com.project.hibernate.dao.impl.MeetingDAOImpl;
import com.project.hibernate.entity.Article;
import com.project.hibernate.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/v1/api/meetings")
public class MeetingController {
    @Autowired
    private MeetingDAOImpl meetingDAO;



    @GetMapping
    public ResponseEntity<List<Meeting>> getAllMeeting() {
        List<Meeting> result = meetingDAO.getAllList();
        return new ResponseEntity<List<Meeting>>(result, HttpStatus.OK);
    }
}
