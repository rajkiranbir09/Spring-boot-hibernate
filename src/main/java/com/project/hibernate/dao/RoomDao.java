package com.project.hibernate.dao;


import com.project.hibernate.entity.Room;
import com.project.hibernate.entity.RoomOption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;


public interface RoomDao extends CrudRepository<Room, Integer>{

    List<Room> findByRoomOptions (RoomOption option);

    @Query("SELECT r FROM Room r WHERE r.price <= :price")
    List<Room> findByMaxPrice (@Param("price") int maxPrice);

    List<Room> findByRoomCategory(String category);

    Room findById(int id);

}