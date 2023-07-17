package com.springtutorial.learningspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springtutorial.learningspring.business.service.GuestService;

@Controller
@RequestMapping("/guests")
public class GuestController {
    
    private final GuestService guestService;
    
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model) {
        model.addAttribute("guests", this.guestService.getGuests());
        return "guestres";
    }
}
