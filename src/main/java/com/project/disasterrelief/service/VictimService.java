package com.project.disasterrelief.service;

import com.project.disasterrelief.model.Victim;

public interface VictimService {
    Victim createVictim(Victim victim);
    Victim getVictimById(Long id);
    Victim updateVictim(Long id, Victim victim);
    void deleteVictim(Long id);
}
