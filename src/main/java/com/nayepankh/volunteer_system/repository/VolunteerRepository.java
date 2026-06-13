package com.nayepankh.volunteer_system.repository;
import com.nayepankh.volunteer_system.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}