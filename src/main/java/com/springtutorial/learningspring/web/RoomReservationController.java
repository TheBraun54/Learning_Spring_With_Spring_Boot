package com.springtutorial.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springtutorial.learningspring.business.dto.RoomReservation;
import com.springtutorial.learningspring.business.service.ReservationService;
import com.springtutorial.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    } 

    @GetMapping
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> reservationList = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", reservationList);
        return "roomres";
    }
}
