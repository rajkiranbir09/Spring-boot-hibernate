package com.project.hibernate.repository;


import com.project.hibernate.entity.Relationship;
import com.project.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    // frome the native query
    @Query(nativeQuery = true)
    List findByIdIs(@Param("id") Long id);

    // Plain query method
    @Lock(LockModeType.READ)
    List<User> getFollowed(@Param("id") Long id);

    List<User> getFollower(@Param("id") Long id);

    int getPostsCount(@Param("id") Long id);

    Relationship isFollowingId(@Param("id") Long id, @Param("profileid") Long profileId);

    List<HashMap<Long,String>> findUserByNameLike(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    void removeRelationship(@Param("id") Long id,@Param("profileid") Long profileId);
}