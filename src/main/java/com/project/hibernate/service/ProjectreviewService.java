package com.project.hibernate.service;


import com.project.hibernate.entity.ProjectReview;

import java.util.Date;
import java.util.List;

public interface ProjectreviewService {

    void deleteProjectreview(ProjectReview pr);

    void saveProjectreview (ProjectReview book);

    ProjectReview findBookById(Long id);


    List<ProjectReview> findByEditionAndCopies();



    List<ProjectReview> findByReleaseDateNot(Date date);

    List<ProjectReview> findByReleaseDateBefore(Date date);

}