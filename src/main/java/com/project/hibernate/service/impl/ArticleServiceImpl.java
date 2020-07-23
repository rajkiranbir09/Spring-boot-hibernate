package com.project.hibernate.service.impl;

import java.util.List;

import com.project.hibernate.dao.IArticleDAO;
import com.project.hibernate.entity.Article;
import com.project.hibernate.service.IArticleService;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }
    @Override
    public List<Article> getAllArticles(){
        return articleDAO.getAllArticles();
    }

    @Override
    public List<Article> getAll5Articles() {
        return articleDAO.getAll5Articles();
    }

    @Override
    public void addArticle(Article article){
//        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
//            return false;
//        } else {
            articleDAO.addArticle(article);
//            return true;
//        }
    }
    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }
    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }

    // ADD FOR HIBERNATE SEARCH
//    FullTextEntityManager fullTextEntityManager
////            = Search.getFullTextEntityManager(entityManager);
////fullTextEntityManager.createIndexer().startAndWait();

//    FullTextEntityManager fullTextEntityManager
//            = Search.getFullTextEntityManager(entityManager);
//
//    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
//            .buildQueryBuilder()
//            .forEntity(Article.class)
//            .get();
//
//
//    // create lucene query via hibernate query dsl
//    Query query = queryBuilder
//            .keyword()
//            .onField("title")
//            .matching("New article title")
//            .createQuery();
//
//    // wrap lucene query into hibernate query
//    FullTextQuery jpaQuery
//            = fullTextEntityManager.createFullTextQuery(query, Article.class);
//    // execute the query
//    List<Article> results = jpaQuery.getResultList();
}