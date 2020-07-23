package com.project.hibernate.service;


import com.project.hibernate.dao.MessageDAO;
import com.project.hibernate.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MessageService {

    @Autowired
    MessageDAO messageRepository;

    public Message create(Message message){
        messageRepository.create(message);
        return message;
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public int deleteAll(){
        return messageRepository.deleteAllMessages();
    }

    public int delete(String userId) {
        return messageRepository.delete(userId);

    }

}