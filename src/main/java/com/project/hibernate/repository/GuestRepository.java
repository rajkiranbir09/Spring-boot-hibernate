package com.project.hibernate.repository;



import com.project.hibernate.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



// Guest Repository
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    // GET LIST OF GUEST
    List<Guest> findAll();
    // FIND GUEST BY CUSTOM QUERY
//    List<Guest> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}