package com.project.hibernate.dao;


import com.project.hibernate.entity.Booking;
import com.project.hibernate.entity.Room;
import com.project.hibernate.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

public interface BookingDao extends CrudRepository<Booking, Long> {

    // Find Meeting room booking by date
    // start date - end date
    @Query("SELECT b FROM Booking b WHERE :date BETWEEN b.startDate AND b.endDate")
    List<Booking> findByDate (@Param("date") Date date);

    List<Booking> findByUser (User user);

    List<Booking> findByRoom(Room room);

    @Query("SELECT b FROM Booking b WHERE b.endDate >= :startDate AND b.startDate <= :endDate")
    List<Booking> findByDatePeriod(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

}