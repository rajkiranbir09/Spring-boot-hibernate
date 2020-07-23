package com.project.hibernate.service;




import com.project.hibernate.entity.User;

import java.util.List;

public interface UserService {

    void save(User author);

    void delete(User author);

    void delete(Long id);

    User findUser(Long id);

    Iterable<User> findAuthors();

    List<Object[]> findAuthorBookStartingWith();

}