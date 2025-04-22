package com.project.disasterrelief.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

    @PreAuthorize("hasAuthority('ROLE_VICTIM')")
    @GetMapping("/victim")
    public ResponseEntity<?> victimDashboard() {
        return ResponseEntity.ok("Welcome Victim");
    }

    @PreAuthorize("hasAuthority('ROLE_VOLUNTEER')")
    @GetMapping("/volunteer")
    public ResponseEntity<?> volunteerDashboard() {
        return ResponseEntity.ok("Welcome Volunteer");
    }

    @PreAuthorize("hasAuthority('ROLE_NGO')")
    @GetMapping("/ngo")
    public ResponseEntity<?> ngoDashboard() {
        return ResponseEntity.ok("Welcome NGO");
    }

    @PreAuthorize("hasAuthority('ROLE_OFFICIAL')")
    @GetMapping("/official")
    public ResponseEntity<?> officialDashboard() {
        return ResponseEntity.ok("Welcome Official");
    }
}

