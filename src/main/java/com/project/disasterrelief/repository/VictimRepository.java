package com.project.disasterrelief.repository;

import com.project.disasterrelief.model.Victim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimRepository extends JpaRepository<Victim, Long> {
}
