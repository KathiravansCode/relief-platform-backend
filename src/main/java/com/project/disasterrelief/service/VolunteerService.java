package com.project.disasterrelief.service;

import com.project.disasterrelief.model.Volunteer;

import java.util.List;

public interface VolunteerService {
    Volunteer createVolunteer(Volunteer volunteer);
    Volunteer updateVolunteer(Long id, Volunteer volunteerDetails);
    void deleteVolunteer(Long id);
    Volunteer getVolunteerById(Long id);
    List<Volunteer> getAllVolunteers();
}
