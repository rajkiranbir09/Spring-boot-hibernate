package com.project.hibernate.dao;


import com.project.hibernate.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class MessageDAO {

    @PersistenceContext
    EntityManager em;

    // CREATE MESSAGE
    public void create(Message entity){
        // merge or persist
        em.merge(entity);
    }
    // get all Message
    public List<Message> findAll() {
        // create native query
        return em.createNativeQuery("SELECT * FROM message",Message.class).getResultList();
    }

    // DELETE ALL MESSAGES
    public int deleteAllMessages(){
        return em.createNativeQuery("DELETE FROM message").executeUpdate();
    }

    // delete by userid
    public int delete(String userId) {

        List<Message> allMessages = findAll();
        for(Message item : allMessages){
            if(item.getMessageId().equals(userId)){
                em.remove(item);
                return 1;
            }
        }
        return 0;

    }


}
