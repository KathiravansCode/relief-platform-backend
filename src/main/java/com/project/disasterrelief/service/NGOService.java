package com.project.disasterrelief.service;

import com.project.disasterrelief.model.NGO;

import java.util.List;

public interface NGOService {
    NGO createNGO(NGO ngo);
    NGO getNGOById(Long id);
    List<NGO> getAllNGOs();
    NGO updateNGO(Long id, NGO ngo);
    void deleteNGO(Long id);
}
