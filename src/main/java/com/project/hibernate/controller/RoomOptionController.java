package com.project.hibernate.controller;


import com.project.hibernate.entity.RoomOption;
import com.project.hibernate.service.RoomOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RequestMapping("/v1/api")
@RestController
public class RoomOptionController {

    @Autowired
    private RoomOptionService roomOptionService;

    @RequestMapping(value = "/room_options", method = RequestMethod.GET)
    public ResponseEntity<List<RoomOption>> findAll () {

        List<RoomOption> roomOptions = roomOptionService.findAll();

        if (roomOptions.isEmpty())
            return new ResponseEntity<List<RoomOption>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<RoomOption>>(roomOptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/room_options/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoomOption> findById (@PathVariable("id") int id) {

        RoomOption option = roomOptionService.findById(id);

        if (option == null)
            return new ResponseEntity<RoomOption>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<RoomOption>(option, HttpStatus.OK);
    }
}