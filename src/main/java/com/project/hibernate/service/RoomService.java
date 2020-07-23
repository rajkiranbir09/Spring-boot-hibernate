package com.project.hibernate.service;


import com.project.hibernate.dao.BookingDao;
import com.project.hibernate.dao.RoomDao;
import com.project.hibernate.dao.RoomOptionDao;
import com.project.hibernate.entity.Booking;
import com.project.hibernate.entity.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private RoomOptionDao roomOptionDao;

    // list all room in the company
    public List<Room> findAll () {
        return (List<Room>) roomDao.findAll();
    }

    // get room by id
    public Room findById (int id) {
        return roomDao.findById(id);
    }

    // find room by category
    public List<Room> findByCategory (String category) {
        return roomDao.findByRoomCategory(category);
    }

    // find room by max price
    public List<Room> findByMaxPrice (int price) {
        return roomDao.findByMaxPrice(price);
    }

    // find room by option: option name -> find option by name -> find roomn by option
    public List<Room> findByOption (String optionName) {
        return roomDao.findByRoomOptions(roomOptionDao.findByName(optionName));
    }

    // find available room in date
    public List<Room> findAvailableRooms (Date startDate) {

        List<Booking> bookings = bookingDao.findByDate(startDate);

        logger.info("Bookings: " + bookings.size());

        return findAvailableRoomsByBookings(bookings);
    }

    public List<Room> findAvailableRooms (Date startDate, Date endDate) {

        List<Booking> bookings = bookingDao.findByDatePeriod (startDate, endDate);

        logger.info("Bookings: " + bookings.size());

        return findAvailableRoomsByBookings(bookings);
    }


    // find avaible room by bookings
    private List<Room> findAvailableRoomsByBookings (List<Booking> bookings) {

        List<Room> rooms = (List<Room>) roomDao.findAll();

        if (bookings.isEmpty())
            return rooms;

        for (Booking booking : bookings) {
            rooms.remove(booking.getRoom());
        }

        logger.info("Rooms available: " + rooms.size());

        return rooms;
    }

}