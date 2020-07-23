package com.project.hibernate.service;


import com.project.hibernate.dao.BookingDao;
import com.project.hibernate.entity.Booking;
import com.project.hibernate.entity.Room;
import com.project.hibernate.entity.RoomOption;
import com.project.hibernate.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingDao bookingDao;

    // find all
    public List<Booking> findAll () {

        List<Booking> bookings = (List<Booking>) bookingDao.findAll();
        setCosts(bookings);
        return bookings;
    }

    // find by user
    public List<Booking> findByUser (User user) {

        List<Booking> bookings = bookingDao.findByUser(user);
        setCosts(bookings);
        return bookings;
    }

    public List<Booking> findByRoom (Room room) {
        return bookingDao.findByRoom(room);
    }

    public Booking findById (long id) {
        return bookingDao.findOne(id);
    }

    public void save (Booking booking) {

        logger.info("Save booking with id " + booking.getId());

        bookingDao.save(booking);
    }

    public void delete (Booking booking) {

        logger.info("Delete booking with id " + booking.getId());

        bookingDao.delete(booking);
    }


    void setCosts (List<Booking> bookings) {

        for (Booking booking : bookings) {

            Room room = booking.getRoom();
            int cost = room.getPrice();

            for (RoomOption option : room.getRoomOptions())
                cost += option.getPrice();

            int period = (int) ((booking.getEndDate().getTime() - booking.getStartDate().getTime())/(24*60*60*1000));

            cost *= period;
            booking.setCost(cost);
        }
    }
}