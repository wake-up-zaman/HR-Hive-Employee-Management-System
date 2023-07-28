package com.example.Spring_Security_3.repository;

import com.example.Spring_Security_3.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
