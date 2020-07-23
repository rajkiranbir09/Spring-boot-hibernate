package com.project.hibernate.repository;



import com.project.hibernate.entity.Post;
import com.project.hibernate.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    // find post by user
    Post findByUser(User user);
    // find by body like
    List<Post> findByBodyIsLikeOrTitleIsLike(String term, String term2);

    //Find posts between today and 3 days ahead
    List<Post> findByCreateDateBetween(Date from, Date to);

    @Query("select p.createDate from Post p")
    List<Date> createDates();

    // Get the list of posts in reverse order.
    @Query("select p from Post p order by p.id desc")
    List<Post> postsInReverse();

}