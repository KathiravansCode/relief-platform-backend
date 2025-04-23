package com.project.disasterrelief.service;

import com.project.disasterrelief.model.Victim;
import com.project.disasterrelief.repository.VictimRepository;
import com.project.disasterrelief.service.VictimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VictimServiceImpl implements VictimService {

    @Autowired
    private VictimRepository victimRepository;

    @Override
    public Victim createVictim(Victim victim) {
        return victimRepository.save(victim);
    }

    @Override
    public Victim getVictimById(Long id) {
        return victimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Victim not found with id: " + id));
    }

    @Override
    public Victim updateVictim(Long id, Victim updatedVictim) {
        Victim existingVictim = getVictimById(id);
        existingVictim.setAddress(updatedVictim.getAddress());
        existingVictim.setAdditionalDetails(updatedVictim.getAdditionalDetails());
        return victimRepository.save(existingVictim);
    }

    @Override
    public void deleteVictim(Long id) {
        victimRepository.deleteById(id);
    }
}
