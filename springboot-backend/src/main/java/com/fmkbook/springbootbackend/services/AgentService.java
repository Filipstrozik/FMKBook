package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent addAgent(Agent agent){
        return this.agentRepository.save(agent);
    }

    public List<Agent> findAllAgents() {
        return this.agentRepository.findAll();
    }

}
