package com.springtutorial.learningspring.data.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.springtutorial.learningspring.data.entity.Room;
@EnableJpaRepositories
public interface RoomRepository extends CrudRepository<Room, Long>{
    
}
