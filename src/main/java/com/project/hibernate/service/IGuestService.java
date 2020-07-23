package com.project.hibernate.service;

import com.project.hibernate.entity.Guest;
import com.project.hibernate.exception.GuestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public interface IGuestService {
    // GET ALL LIST OF GUEST
    List<Guest> getAll();

    // GET ALL LIST OF GUEST BY CUSTOM SEARCH QUERY
    Date calculateWorkingTime(Date date, Guest employee) throws GuestException;
}

