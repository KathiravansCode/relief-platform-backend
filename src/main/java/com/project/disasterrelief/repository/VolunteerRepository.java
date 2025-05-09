package com.project.disasterrelief.repository;

import com.project.disasterrelief.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByUsername(String username);
    Optional<Volunteer> findByEmail(String email);
}
