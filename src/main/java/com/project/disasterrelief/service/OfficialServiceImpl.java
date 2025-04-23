package com.project.disasterrelief.service.impl;

import com.project.disasterrelief.exception.ResourceNotFoundException;
import com.project.disasterrelief.model.Official;
import com.project.disasterrelief.repository.OfficialRepository;
import com.project.disasterrelief.service.OfficialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficialServiceImpl implements OfficialService {

    private final OfficialRepository officialRepository;

    public OfficialServiceImpl(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
    }

    @Override
    public Official createOfficial(Official official) {
        return officialRepository.save(official);
    }

    @Override
    public Official getOfficialById(Long id) {
        return officialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Official not found with ID: " + id));
    }

    @Override
    public List<Official> getAllOfficials() {
        return officialRepository.findAll();
    }

    @Override
    public Official updateOfficial(Long id, Official updatedOfficial) {
        Official official = getOfficialById(id);
        official.setDepartment(updatedOfficial.getDepartment());
        return officialRepository.save(official);
    }

    @Override
    public void deleteOfficial(Long id) {
        Official official = getOfficialById(id);
        officialRepository.delete(official);
    }
}
