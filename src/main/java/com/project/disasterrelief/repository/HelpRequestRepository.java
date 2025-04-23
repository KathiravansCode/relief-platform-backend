package com.project.disasterrelief.repository;

import com.project.disasterrelief.model.HelpRequest;
import com.project.disasterrelief.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

    // Get all help requests by a specific user
    List<HelpRequest> findByUser(User user);

    // Get all help requests filtered by type (e.g., "Medical", "Food")
    List<HelpRequest> findByType(String type);

    // Get help requests by status (e.g., "PENDING", "IN_PROGRESS", "COMPLETED")
    List<HelpRequest> findByStatus(String status);

    // Get help requests that match both type and status
    List<HelpRequest> findByTypeAndStatus(String type, String status);

    // Get help requests by location (optional enhancement if you add location field)
    List<HelpRequest> findByLocationContainingIgnoreCase(String location);

    List<HelpRequest> findByCategory(String category);

    List<HelpRequest> findByStatusIgnoreCase(String status);
}
