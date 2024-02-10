package com.gift.ajay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.ajay.Model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,String>{
Optional<User>  findByEmail(String email);
}
