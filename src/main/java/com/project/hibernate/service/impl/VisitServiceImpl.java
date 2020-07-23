package com.project.hibernate.service.impl;

import com.project.hibernate.repository.VisitRepository;
import com.project.hibernate.service.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitServiceImpl implements IVisitService {

    @Autowired
    private VisitRepository visitRepository;
}
