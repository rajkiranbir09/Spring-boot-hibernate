package com.project.hibernate.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.project.hibernate.dao.IArticleDAO;
import com.project.hibernate.entity.Article;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ArticleDAOImpl implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;



    SessionFactory sessionFactory;

    Session session;

    Transaction transaction;


    @Override
    @Transactional(readOnly = true)
    public Article getArticleById(int articleId)  {
        return entityManager.find(Article.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    // GET TOP 5


    @Override
    @Transactional(readOnly = true)
    public List<Article> getAll5Articles() {
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY a.articleId DESC").setMaxResults(5).getResultList();
    }

    // HSQL - PAGINATION

    @Transactional(readOnly = true)
    public List<Article> getAllArticlesCustomPagination(Integer start, Integer maxResult) {
        Session session = sessionFactory.openSession();
        String hql = "FROM article";
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(maxResult);
        List<Article> emList = query.list();
        return emList;
    }

    // get all limit 10 using HQL
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles10() {
        Session session = sessionFactory.openSession();
        String hql = "FROM article as a order by a.created_at desc,a.title asc";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // SELECT ALL ARTICLE WITH THE SAME CREATED_DATE
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles10GroupByCreatedDate() {
        Session session = sessionFactory.openSession();
        String hql = "select count(a.title) from article a group by a.created_date";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // HQL - FIND ARTICLE BY CATEGORY - sql injection protection
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCategory() {
        Session session = sessionFactory.openSession();
        String hql = "from article a where a.category =:categoryName";
        Query query = session.createQuery(hql);
        query.setParameter("categoryName","Work");
        List<Article> emList = query.list();
        return emList;
    }


    // CRITERIA API
    // get all
    public List<Article> getAllArticlesByCriteria() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
//        Query query = session.createQuery(hql);
//        query.setParameter("categoryName","Work");
        List<Article> emList = criteria.list();
        return emList;
    }

    // restriction with criteria
    // get article on the current date - today

    public List<Article> getAllArticlesByCriteriaToday() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
//        Query query = session.createQuery(hql);
//        query.setParameter("categoryName","Work");
        // get today
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); //2016/11/16 12:08:43
        criteria.add(Restrictions.eq("created_at",dtf.format(now)));
        List<Article> emList = criteria.list();
        return emList;
    }


    // FIND ARTICLE WITH TITLE - SEARCH
    public List<Article> getAllArticlesByCriteriaSearchWithTitle() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.add(Restrictions.like("title","Working is the best thing"));

        List<Article> emList = criteria.list();
        return emList;
    }

    // FIND ARTICLE WITH CREATED AT BETWEEN A GIVEN DATE
//    criteria.add(Restrictions.between("salary", 4000,5000));


    // SEARCH ARTICLE WITH SPECIAL CUSTOM QUERY
    public List<Article> searchArticleCustomQuery(String title1,Date createdAt ) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); //2016/11/16 12:08:43
        Criterion createdat = Restrictions.eq("createdAt",createdAt);
        Criterion title = Restrictions.like("title", title1);
        LogicalExpression andExp = Restrictions.and(createdat, title); // AND
        criteria.add(andExp);
        List<Article> emList = criteria.list();
        return emList;
    }
    // SEARCH FOR ARTICLE WITH 2 CATEGORY (OR)
    public List<Article> searchArticleByCategories(String category1,String category2 ) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);

        Criterion category11 = Restrictions.eq("category",category1);
        Criterion category22 = Restrictions.like("category",category2);
        LogicalExpression andExp = Restrictions.and(category11, category22); // OR search
        criteria.add(andExp);
        List<Article> emList = criteria.list();
        return emList;
    }

    // Pagination - sort with Criteria API
    public List<Article> searchArticleByCustomSortAndPagination() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);


        criteria.setFirstResult(0);
        criteria.setMaxResults(50);
        // sort
        criteria.addOrder(Order.desc("created_at"));
        List<Article> emList = criteria.list();
        return emList;
    }





//    String hql = "UPDATE Employee E set E.firstName = :name WHERE id =
//:employee_id";
//    Query query = session.createQuery(hql);
//query.setParameter("name", "Shashi");
//query.setParameter("employee_id", 2);
//    int result = query.executeUpdate();
//System.out.println("Row affected: " + result);


    // SELECT QUERY WITH HQL
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCustomQuery() {
        Session session = sessionFactory.openSession();
        String hql = "select a.title,a.content,a.description,a.category from article as a";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // where clause
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCustomQueryWithWhere() {
        Session session = sessionFactory.openSession();
        String hql = "from article a where a.title ='Urgent'";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }



//    @Transactional(readOnly = false)
//    public void insertEmployee(Employee employee) {
//        Session session = sessionFactory.openSession();
//        session.save(employee);
//    }

    @Override
    @Transactional(readOnly = false)
    public void addArticle(Article article) {
//        entityManager.
        entityManager.merge(article);
//        entityManager.getTransaction().commit();
//        entityManager.close();

        // 2 nd way to save the object
        // Session session = this.sessionFactory.openSession();
//        Serializable userId = session.save(user);
//        session.flush();
        // 3rd way to save the object
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Serializable userId = session.save(user);
//        session.getTransaction().commit();
//        session.close();

        // 4th way to save object  persiste
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();
    }
    @Override
    public void updateArticle(Article article) {
//        Article artcl = getArticleById(article.getArticleId());
//        artcl.setTitle(article.getTitle());
//        artcl.setCategory(article.getCategory());
//        entityManager.flush();
    }
    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }
    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title)
                .setParameter(2, category).getResultList().size();
        return count > 0 ? true : false;
    }








}

//    @Override
//    public void update(User user) {
//        Session session = this.sessionFactory.openSession();
//        User persistentUser = (User) session.load(User.class, new
//                Integer(user.getId()));
//        Transaction tx = session.beginTransaction();
//        persistentUser.setFirstName(user.getFirstname());
//        persistentUser.setLastname(user.getLastname());
//        session.update(persistentUser);
//        tx.commit();
//    }

//    @Override
//    public void update(User user) {
//        Session session = this.sessionFactory.openSession();
//        Transaction tx1 = session.beginTransaction();
//        User persistentUser = (User) session.load(User.class, new
//                Integer(user.getId()));
//        tx1.commit();
//        Transaction tx2 = session.beginTransaction();
//        user.setEmail(persistentUser.getEmail());
//        user.setPassword(persistentUser.getPassword());
//        session.merge(user);
//        tx2.commit();
//    }