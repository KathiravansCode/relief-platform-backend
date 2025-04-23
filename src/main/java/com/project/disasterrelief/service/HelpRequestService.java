package com.project.disasterrelief.service;

import com.project.disasterrelief.model.HelpRequest;

import java.util.List;
import java.util.Optional;

public interface HelpRequestService {
    HelpRequest createHelpRequest(HelpRequest helpRequest);
    List<HelpRequest> getAllHelpRequests();

    HelpRequest updateHelpRequest(Long id, HelpRequest helpRequest);
    void deleteHelpRequest(Long id);
    HelpRequest getHelpRequestById(Long id);
    List<HelpRequest> getHelpRequestsByStatus(String status);
    List<HelpRequest> findByType(String type);

}
