package com.springtutorial.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springtutorial.learningspring.business.dto.RoomReservation;
import com.springtutorial.learningspring.business.service.GuestService;
import com.springtutorial.learningspring.business.service.ReservationService;
import com.springtutorial.learningspring.data.entity.Guest;
import com.springtutorial.learningspring.data.entity.Room;
import com.springtutorial.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final GuestService guestService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }

    @GetMapping(path="/reservations")
    public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping(path="/guests") 
    public List<Guest> getGuests() {
        return this.guestService.getGuests();
    }

    @PostMapping(path="/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.guestService.addGuest(guest);
    }

    @GetMapping(path="/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getRooms();
    }
}

