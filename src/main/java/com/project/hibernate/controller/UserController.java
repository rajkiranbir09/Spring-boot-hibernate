package com.project.hibernate.controller;


import com.project.hibernate.captcha.CaptchaVerifier;
import com.project.hibernate.dao.impl.UserDAOImpl;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
@AllArgsConstructor
public class UserController {

    private CaptchaVerifier verifier = new CaptchaVerifier();

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserDAOImpl userDAO;



    // find User by user name
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByUserName(@PathVariable("name") String name) {


        return userRepository.findByUserName(name);
    }

    // get all
    @GetMapping
    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

    // find user by email 1
    @GetMapping(value = "/email/{userEmail}")
    public List<User> findByEmail1(@PathVariable("userEmail") String email) {
        return userDAO.findByEmail1(email);
    }

//    @Autowired
//    private UserDao userDao;
//
//
//    @RequestMapping(value="/users")
//    public String user(Model model, HttpSession session) {
//
//        return "users";
//    }
//
//    /* Create a new User */
//    @RequestMapping(value="/createNewUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String createNewUser(@RequestParam String userName,@RequestParam String userMail) {
//        try {
//            User user = new User(userMail, userName);
//            userDao.create(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully created!";
//    }
//    /* Update a new User */
//    @RequestMapping(value="/updateTheUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String updateTheUser(@RequestParam int userId,@RequestParam String userName,@RequestParam String userMail) {
//        try {
//            User user = userDao.getById(userId);
//            user.setUsername(userMail);
//            user.setName(userName);
//            userDao.update(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully updated!";
//    }
//
//    /* Delete the User */
//    @RequestMapping(value="/deleteTheUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String getAllTasks(@RequestParam int userId) {
//        try {
//            User user = new User(userId);
//            userDao.delete(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully deleted!";
//    }
//
//    //Get All Users
//    @RequestMapping(value = "/getAllUserList")
//    @ResponseBody
//    public java.lang.Object getAllUserList() {
//
//        return userDao.getAllUserList();
//    }
//
//
//    /** ------
//     * Delete the user with the passed id.
//     */
//    @RequestMapping(value="/delete")
//    @ResponseBody
//    public String delete(long id) {
//        try {
//            User user = new User(id);
//            userDao.delete(user);
//        }
//        catch (Exception ex) {
//            return "Error deleting the user: " + ex.toString();
//        }
//        return "User succesfully deleted!";
//    }
//
//
//
//    /**
//     * Update the username and the name for the user indentified by the passed id.
//     */
//    @RequestMapping(value="/update")
//    @ResponseBody
//    public String updateName(long id, String username, String name) {
//        try {
//            User user = userDao.getById(id);
//            user.setUsername(username);
//            user.setName(name);
//            userDao.update(user);
//        }
//        catch (Exception ex) {
//            return "Error updating the user: " + ex.toString();
//        }
//        return "User succesfully updated!";
//    }
//


//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody final User user) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        password = bCryptPasswordEncoder.encode(password);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
//
//    @GetMapping("/employees")
//    public List<Employee> listEmployee() {
//        return employeeRepository.findAll();
//    }
//
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<?> getEmployee(@PathVariable(value = "id")  Long id) {
//        Employee employee = employeeRepository.findOne(id);
//
//        if(employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<?> updateEmployee(@PathVariable(value = "id")  Long id,
//                                            @Valid @RequestBody Employee updateData) {
//        Employee employee = employeeRepository.findOne(id);
//
//        if(employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        employee.setManagerId(updateData.getManagerId());
//        employee.setName(updateData.getName());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//
//        return ResponseEntity.ok(updatedEmployee);
//    }
//



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")final  int id) {
        User user = userRepository.findByUserId(id);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

    // validate user with captcha

    private boolean validateUser(User user, String captchaResponse) {

        if(!verifier.verifyCaptcha(captchaResponse)){

            return false;
        }
        return true;

    }
}
