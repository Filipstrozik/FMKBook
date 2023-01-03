package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    void deleteAgentById(Integer id);

    Optional<Agent> findAgentById(Integer id);
}
