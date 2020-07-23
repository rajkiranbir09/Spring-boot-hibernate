package com.project.hibernate.controller;


import com.project.hibernate.entity.Room;
import com.project.hibernate.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> findAll () {

        List<Room> rooms = roomService.findAll();

        if (rooms.isEmpty())
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public ResponseEntity<Room> findById (@PathVariable("id") int id) {

        Room room = roomService.findById(id);

        if (room == null)
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms_by_category/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> findByCategory (@PathVariable("category") String category) {

        List<Room> rooms = roomService.findByCategory(category);

        if (rooms.isEmpty())
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms_by_maxprice/{price}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> findByMaxprice (@PathVariable("price") int price) {

        List<Room> rooms = roomService.findByMaxPrice(price);

        if (rooms.isEmpty())
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms_by_option/{option_name}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> findByOption (@PathVariable("option_name") String optionName) {

        List<Room> rooms = roomService.findByOption(optionName);

        if (rooms.isEmpty())
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/available_rooms/{startdate}/{enddate}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> availableRooms (@PathVariable("startdate") String startDate,
                                                      @PathVariable("enddate") String endDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Room> availableRooms;
        Date start;
        Date end;

        try {
            start = dateFormat.parse(startDate);
            end = dateFormat.parse(endDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);
        }

        availableRooms = roomService.findAvailableRooms(start, end);

        if (availableRooms.isEmpty())
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Room>>(availableRooms, HttpStatus.OK);

    }
}