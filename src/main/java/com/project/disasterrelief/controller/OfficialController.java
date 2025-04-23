package com.project.disasterrelief.controller;

import com.project.disasterrelief.model.Official;
import com.project.disasterrelief.service.OfficialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officials")
@CrossOrigin(origins = "*")
public class OfficialController {

    private final OfficialService officialService;

    public OfficialController(OfficialService officialService) {
        this.officialService = officialService;
    }

    @PostMapping
    public ResponseEntity<Official> createOfficial(@RequestBody Official official) {
        return ResponseEntity.ok(officialService.createOfficial(official));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Official> getOfficialById(@PathVariable Long id) {
        return ResponseEntity.ok(officialService.getOfficialById(id));
    }

    @GetMapping
    public ResponseEntity<List<Official>> getAllOfficials() {
        return ResponseEntity.ok(officialService.getAllOfficials());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Official> updateOfficial(@PathVariable Long id, @RequestBody Official official) {
        return ResponseEntity.ok(officialService.updateOfficial(id, official));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOfficial(@PathVariable Long id) {
        officialService.deleteOfficial(id);
        return ResponseEntity.ok("Official deleted successfully!");
    }
}
