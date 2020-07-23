package com.project.hibernate.service.impl;



import com.project.hibernate.entity.Balance;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.impl.BalanceRepository;
import com.project.hibernate.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    @Qualifier("balanceRepository")
    private BalanceRepository balanceRepository;

    @Override
    public Balance findBalance(User user) {
        return balanceRepository.findOneByUser(user);
    }

    @Override
    public void saveBalance(Balance balance) {
        balanceRepository.save(balance);
    }
}