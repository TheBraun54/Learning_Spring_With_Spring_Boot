package com.springtutorial.learningspring.business.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springtutorial.learningspring.data.entity.Guest;
import com.springtutorial.learningspring.data.repository.GuestRepository;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guest->{guestList.add(guest);});
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest g1, Guest g2) {
                if (g1.getLastName().equals(g2.getLastName())) {
                    return g1.getFirstName().compareTo(g2.getFirstName());
                } else {
                    return g1.getLastName().compareTo(g2.getLastName());
                }
            }
        });
        return guestList;
    }

    public void addGuest(Guest guest) {
        if (guest == null) {
            throw new RuntimeException(
                "Guest was null"
            );
        }
        this.guestRepository.save(guest);
    }
}
