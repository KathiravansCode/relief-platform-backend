package com.project.disasterrelief.controller;

import com.project.disasterrelief.model.Victim;
import com.project.disasterrelief.service.VictimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/victims")
public class VictimController {

    @Autowired
    private VictimService victimService;

    @PostMapping
    public ResponseEntity<Victim> createVictim(@RequestBody Victim victim) {
        return ResponseEntity.ok(victimService.createVictim(victim));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Victim> getVictim(@PathVariable Long id) {
        return ResponseEntity.ok(victimService.getVictimById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Victim> updateVictim(@PathVariable Long id, @RequestBody Victim victim) {
        return ResponseEntity.ok(victimService.updateVictim(id, victim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVictim(@PathVariable Long id) {
        victimService.deleteVictim(id);
        return ResponseEntity.noContent().build();
    }
}
