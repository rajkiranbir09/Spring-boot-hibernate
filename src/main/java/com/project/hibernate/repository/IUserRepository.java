package com.project.hibernate.repository;

import com.project.hibernate.entity.User;
import org.omg.CORBA.INTERNAL;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends CrudRepository<User, Long> {
//    @Cacheable(value = "findByUserName")
    User findByUserName(String username);
    // find by id
    User findByUserId(int id);

    // find all user
    List<User> findAll();

//    @Query(value = "SELECT a, COUNT(a) AS cnt FROM user AS a GROUP BY a ORDER BY cnt")
//    List<Object[]> findUserProjectreviewStartingWith();

    User findByEmail(String email);

    //Same function of above but with HQL
    @Query("select u from User u where u.email = ?1")
    User findByEmailQuery(String email);

    // find user by name
    @Query(nativeQuery = true,value = "SELECT * from user where username like '%?1%'")
    Iterable<User> search(String username);

    // left join with roles table
    @Query("select u from User u left join fetch u.roles r where u.username=:username")
    public Optional<User> findByUsernameJoin(@Param("username") String username);
}