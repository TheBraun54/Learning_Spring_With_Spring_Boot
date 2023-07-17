package com.springtutorial.learningspring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springtutorial.learningspring.data.entity.Guest;

@EnableJpaRepositories
public interface GuestRepository extends JpaRepository<Guest, Long>{
    
}
