package com.project.hibernate.service;

import com.project.hibernate.entity.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    List<Article> getAll5Articles();
}