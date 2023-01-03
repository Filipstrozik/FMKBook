package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    public Agent updateAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public Agent findAgentById(Integer id) {
        return agentRepository.findAgentById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteAgent(Integer id){
        agentRepository.deleteAgentById(id);
    }
}
