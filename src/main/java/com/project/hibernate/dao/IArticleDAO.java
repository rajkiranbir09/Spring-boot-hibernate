package com.project.hibernate.dao;
import com.project.hibernate.entity.Article;


import java.util.List;

public interface IArticleDAO {

    List<Article> getAllArticles();

    List<Article> getAll5Articles();

    Article getArticleById(int articleId);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    boolean articleExists(String title, String category);
}