package com.project.hibernate.repository;


import com.project.hibernate.entity.Meetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MeetupRepository extends JpaRepository<Meetup, Long> {
}