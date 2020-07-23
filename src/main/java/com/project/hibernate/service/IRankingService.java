package com.project.hibernate.service;



import com.project.hibernate.entity.User;

import java.util.Map;

public interface IRankingService {

    int getRankingFor(String subject, String skill);

    void addRanking(String subject, String observer, String skill, int ranking);

    void updateRanking(String subject, String observer, String skill, int ranking);

    void removeRanking(String subject, String observer, String skill);

    Map<String, Integer> findRankingsFor(String subject);

    User findBestPersonFor(String expertise);
}