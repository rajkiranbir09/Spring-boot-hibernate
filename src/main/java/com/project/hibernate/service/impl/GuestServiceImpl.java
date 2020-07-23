package com.project.hibernate.service.impl;

import com.project.hibernate.entity.Guest;
import com.project.hibernate.entity.Visit;
import com.project.hibernate.exception.GuestException;
import com.project.hibernate.repository.GuestRepository;
import com.project.hibernate.service.IGuestService;
import com.project.hibernate.utils.DateModification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@Service
public class GuestServiceImpl implements IGuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    @Transactional
    public List<Guest> getAll() {
        final List<Guest> employeeList = guestRepository.findAll();
        for (Guest employee: employeeList) {
//            Collections.sort(employee.getVisits() {
//                @Override
//                public int compare(Visit o1, Visit o2) {
//                    return o1.getDate().compareTo(o2.getDate());
//                }
//            });
        }
        return employeeList;
    }


    @Override
    public Date calculateWorkingTime(Date date, Guest employee) throws GuestException {
//        final List<Guest> list = guestRepository.findByNameAndSurnameAndPatronymic(
//                employee.getName();
//
//        );
//        Date additionalDate = DateModification.getBeginOfNextDay(date);
//        if (!list.isEmpty()) {
//            final List<Visit> visitList = list.get(0).getVisitsBetweenDates(date, additionalDate);
//            for (int i = 0; i < visitList.size(); i++) {
//                if (visitList.get(i).getStatus().equals(Boolean.FALSE) && i != 0) {
//                    date.setTime(date.getTime() + visitList.get(i).getDate().getTime() - visitList.get(i - 1).getDate().getTime());
//                }
//            }
//            return date;
//        } else throw new GuestException();
        return null;
    }



}
