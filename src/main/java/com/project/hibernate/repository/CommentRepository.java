package com.project.hibernate.repository;



import com.project.hibernate.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    // find all the comment by post id
    List<Comment> findByPostId(int postId);
}