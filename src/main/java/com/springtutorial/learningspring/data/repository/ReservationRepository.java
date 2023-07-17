package com.springtutorial.learningspring.data.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springtutorial.learningspring.data.entity.Reservation;

@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
