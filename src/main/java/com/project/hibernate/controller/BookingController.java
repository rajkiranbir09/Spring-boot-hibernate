package com.project.hibernate.controller;


import com.project.hibernate.entity.Booking;
import com.project.hibernate.entity.Room;
import com.project.hibernate.entity.User;
import com.project.hibernate.service.BookingService;
import com.project.hibernate.service.RoomService;
import com.project.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class BookingRestController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;


    // find all bookings
    @RequestMapping(value = "/bookings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Booking>> findAll () {

        List<Booking> bookings = bookingService.findAll();

        if (bookings.isEmpty())
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    // find booking by id
    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Booking> findById (@PathVariable("id") long id) {

        Booking booking = bookingService.findById(id);

        if (booking == null)
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "/{user_id}/bookings", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> findByUser (@PathVariable("user_id") long id) {

        User user = userService.findById(id);

        if (user == null)
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);

        List<Booking> bookings = bookingService.findByUser(user);

        if (bookings.isEmpty())
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    @RequestMapping(value = "/bookings_by_room/{room_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> findByRoom (@PathVariable("room_id") int id) {

        Room room = roomService.findById(id);

        if (room == null)
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);

        List<Booking> bookings = bookingService.findByRoom(room);

        if (bookings.isEmpty())
            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);

    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public ResponseEntity<Booking> addBooking (@RequestBody Booking booking) {

        bookingService.save(booking);

        return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Booking> updateBooking (@PathVariable("id") long id, @RequestBody Booking booking) {

        Booking currentBooking = bookingService.findById(id);

        if (currentBooking == null)
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);

        bookingService.save(booking);

        return new ResponseEntity<Booking>(currentBooking, HttpStatus.NO_CONTENT);
    }

    @Transactional
    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBooking (@PathVariable("id") long id) {

        Booking booking = bookingService.findById(id);

        if (booking == null)
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        bookingService.delete(booking);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}