package com.project.hibernate.dao;



import com.project.hibernate.entity.Order;
import com.project.hibernate.entity.enums.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Integer>{

    List<Order> findAllByOrderByPkAsc();

    List<Order> findAllByOrderByPkDesc();

    List<Order> findByOrderStatusOrderByDeliveryDateDesc(OrderStatus orderStatus);
}