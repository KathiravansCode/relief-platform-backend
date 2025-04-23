package com.project.disasterrelief.controller;

import com.project.disasterrelief.service.HelpRequestService;
import com.project.disasterrelief.model.HelpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpRequest")
public class HelpRequestController {

    @Autowired
    private HelpRequestService helpRequestService;

    // Post new HelpRequest
    @PostMapping
    public ResponseEntity<HelpRequest> createHelpRequest(@RequestBody HelpRequest helpRequest) {
        HelpRequest createdRequest = helpRequestService.createHelpRequest(helpRequest);
        return ResponseEntity.status(201).body(createdRequest);
    }

    // Get all HelpRequests
    @GetMapping
    public ResponseEntity<List<HelpRequest>> getAllHelpRequests() {
        List<HelpRequest> helpRequests = helpRequestService.getAllHelpRequests();
        return ResponseEntity.ok(helpRequests);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HelpRequest> getHelpRequestById(@PathVariable Long id) {
        HelpRequest helpRequest = helpRequestService.getHelpRequestById(id);
        return ResponseEntity.ok(helpRequest);
    }



    // Update existing help request
    @PutMapping("/{id}")
    public ResponseEntity<HelpRequest> updateHelpRequest(@PathVariable Long id, @RequestBody HelpRequest updatedHelpRequest) {
        HelpRequest updated = helpRequestService.updateHelpRequest(id, updatedHelpRequest);
        return ResponseEntity.ok(updated);
    }

    // Delete a help request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHelpRequest(@PathVariable Long id) {
        helpRequestService.deleteHelpRequest(id);
        return ResponseEntity.noContent().build();
    }


    // Other API endpoints...
}

