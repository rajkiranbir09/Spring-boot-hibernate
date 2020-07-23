package com.project.hibernate.repository;



import com.project.hibernate.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long>{

    @Query("select c from Contact c where c.firstName like :x")
    public Page<Contact> searchContact(@Param("x") String mc, Pageable pageable);

    // find one by id
    Contact findByContactId(Integer id);
}
