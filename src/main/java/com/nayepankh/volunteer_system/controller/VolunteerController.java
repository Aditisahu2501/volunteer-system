package com.nayepankh.volunteer_system.controller;

import com.nayepankh.volunteer_system.model.Volunteer;
import com.nayepankh.volunteer_system.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    // Home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Show registration form
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "register";
    }

    // Handle form submission
    @PostMapping("/register")
    public String submitForm(@ModelAttribute Volunteer volunteer) {
        volunteerService.saveVolunteer(volunteer);
        return "redirect:/success";
    }

    // Success page
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}