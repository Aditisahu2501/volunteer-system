package com.nayepankh.volunteer_system.controller;

import com.nayepankh.volunteer_system.service.AdminService;
import com.nayepankh.volunteer_system.service.VolunteerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VolunteerService volunteerService;

    // Show login page
    @GetMapping("/admin/login")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/admin/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session) {
        if (adminService.validateAdmin(username, password)) {
            session.setAttribute("admin", username);
            return "redirect:/admin/dashboard";
        }
        return "redirect:/admin/login?error=true";
    }

    // Dashboard
    @GetMapping("/admin/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }
        model.addAttribute("volunteers", volunteerService.getAllVolunteers());
        return "dashboard";
    }

    // Logout
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}