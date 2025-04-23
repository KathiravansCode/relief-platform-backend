package com.project.disasterrelief.service;

import com.project.disasterrelief.model.Official;

import java.util.List;

public interface OfficialService {
    Official createOfficial(Official official);
    Official getOfficialById(Long id);
    List<Official> getAllOfficials();
    Official updateOfficial(Long id, Official official);
    void deleteOfficial(Long id);
}
