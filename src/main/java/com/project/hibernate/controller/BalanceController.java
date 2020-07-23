package com.project.hibernate.controller;


import com.project.hibernate.dao.UserDAO;
import com.project.hibernate.entity.Balance;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.IUserRepository;
import com.project.hibernate.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/balance")
@CrossOrigin
public class BalanceController {
//    @Autowired
//    @Qualifier("IUserRepository")
//    private IUserRepository userRepository;
//
//    @Autowired
//    private UploadMaterialsService uploadMaterialsService;

//    @Autowired
//    private BalanceService balanceService;


    // GET BALANCE BY USER
    @GetMapping(value = "/users/{userId}")
    public Balance getBalanceByUser(@PathVariable Integer userId){
//        User currentUser = userRepository.findById(userId);
        return null;
//        return balanceService.findBalance(currentUser);
    }

    // SAVE BALANCE BY USER





}
