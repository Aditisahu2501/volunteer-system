package com.nayepankh.volunteer_system.service;

import com.nayepankh.volunteer_system.model.Volunteer;
import com.nayepankh.volunteer_system.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public void saveVolunteer(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }
}