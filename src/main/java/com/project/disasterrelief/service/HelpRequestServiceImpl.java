package com.project.disasterrelief.service;

import com.project.disasterrelief.exception.BadRequestException;
import com.project.disasterrelief.exception.ResourceNotFoundException;
import com.project.disasterrelief.model.HelpRequest;
import com.project.disasterrelief.repository.HelpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {

    @Autowired
    private HelpRequestRepository helpRequestRepository;

    public HelpRequest createHelpRequest(HelpRequest helpRequest) {
        if (helpRequest.getCategory() == null || helpRequest.getDescription() == null) {
            throw new BadRequestException("Category and Description must not be null.");
        }
        return helpRequestRepository.save(helpRequest);
    }

    public List<HelpRequest> getAllHelpRequests() {
        return helpRequestRepository.findAll();
    }

    public HelpRequest getHelpRequestById(Long id) {
        return helpRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HelpRequest not found with ID: " + id));
    }

    public HelpRequest updateHelpRequest(Long id, HelpRequest updatedHelpRequest) {
        HelpRequest existing = getHelpRequestById(id);
        existing.setCategory(updatedHelpRequest.getCategory());
        existing.setDescription(updatedHelpRequest.getDescription());
        existing.setStatus(updatedHelpRequest.getStatus());
        existing.setLocation(updatedHelpRequest.getLocation());
        return helpRequestRepository.save(existing);
    }

    public void deleteHelpRequest(Long id) {
        HelpRequest existing = getHelpRequestById(id);
        helpRequestRepository.delete(existing);
    }

    public List<HelpRequest> getHelpRequestsByStatus(String status) {
        return helpRequestRepository.findByStatusIgnoreCase(status);
    }


    @Override
    public List<HelpRequest> findByType(String type) {
        return helpRequestRepository.findByCategory(type); // or findByRequestType(type) if that's the actual field
    }



}


//private HelpRequestResponseDTO convertToDTO(HelpRequest helpRequest) {
//    HelpRequestResponseDTO dto = new HelpRequestResponseDTO();
//
//    dto.setId(helpRequest.getId());
//    dto.setTitle(helpRequest.getTitle());
//    dto.setDescription(helpRequest.getDescription());
//    dto.setCreatedAt(helpRequest.getCreatedAt());
//    dto.setStatus(helpRequest.getStatus());
//    dto.setType(helpRequest.getType());
//    dto.setCategory(helpRequest.getCategory());
//    dto.setLocation(helpRequest.getLocation());
//
//    HelpRequestResponseDTO.UserDTO userDTO = new HelpRequestResponseDTO.UserDTO();
//    userDTO.setId(helpRequest.getUser().getId());
//    userDTO.setUsername(helpRequest.getUser().getUsername());
//    userDTO.setEmail(helpRequest.getUser().getEmail());
//    userDTO.setRole(helpRequest.getUser().getRole());
//
//    dto.setUser(userDTO);
//    return dto;
//}
