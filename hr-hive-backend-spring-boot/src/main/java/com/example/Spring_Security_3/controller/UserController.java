package com.example.Spring_Security_3.controller;

import com.example.Spring_Security_3.entity.UserEntity;
import com.example.Spring_Security_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }
    @PostMapping("/addAllUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserEntity> addAllUser(@RequestBody  List<UserEntity> userEntities){
        return userService.saveAllUser(userEntities);
    }

    @GetMapping("/findUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public UserEntity findUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/GetAllUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserEntity> findAllUser() {
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public UserEntity updateUser(@RequestBody UserEntity userEntity){
        return userService.updatedUser(userEntity);
    }

    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String DeleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
