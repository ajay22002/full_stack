package com.gift.ajay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gift.ajay.Model.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, String> {
   
}