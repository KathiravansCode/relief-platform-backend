package com.project.disasterrelief.service;

import com.project.disasterrelief.exception.ResourceNotFoundException;
import com.project.disasterrelief.model.NGO;
import com.project.disasterrelief.repository.NGORepository;
import com.project.disasterrelief.service.NGOService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NGOServiceImpl implements NGOService {

    private final NGORepository ngoRepository;

    public NGOServiceImpl(NGORepository ngoRepository) {
        this.ngoRepository = ngoRepository;
    }

    @Override
    public NGO createNGO(NGO ngo) {
        return ngoRepository.save(ngo);
    }

    @Override
    public NGO getNGOById(Long id) {
        return ngoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NGO not found with ID: " + id));
    }

    @Override
    public List<NGO> getAllNGOs() {
        return ngoRepository.findAll();
    }

    @Override
    public NGO updateNGO(Long id, NGO updatedNGO) {
        NGO ngo = getNGOById(id);
        ngo.setName(updatedNGO.getName());
        ngo.setContact(updatedNGO.getContact());
        return ngoRepository.save(ngo);
    }

    @Override
    public void deleteNGO(Long id) {
        NGO ngo = getNGOById(id);
        ngoRepository.delete(ngo);
    }
}
