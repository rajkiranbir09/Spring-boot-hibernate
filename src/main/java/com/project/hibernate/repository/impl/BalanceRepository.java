package com.project.hibernate.repository.impl;



import com.project.hibernate.entity.Balance;
import com.project.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("balanceRepository")
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    public Balance findOneByUser(User user);
}