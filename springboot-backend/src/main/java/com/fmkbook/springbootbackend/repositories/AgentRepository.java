package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
