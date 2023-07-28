package com.example.Spring_Security_3.service;


import com.example.Spring_Security_3.entity.UserEntity;
import com.example.Spring_Security_3.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public List<UserEntity> saveAllUser(List<UserEntity> userEntities){
        return userRepository.saveAll(userEntities);
    }

    public UserEntity getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return  "User deleted successfully for "+id;
    }

    public UserEntity updatedUser(UserEntity userEntity){
        UserEntity user=userRepository.findById(userEntity.getId()).orElse(null);
        user.setUserName(userEntity.getUserName());
        user.setEmail(userEntity.getEmail());
        user.setProgram(userEntity.getProgram());
        user.setBatch(userEntity.getBatch());
        return userRepository.save(user);
    }

}
