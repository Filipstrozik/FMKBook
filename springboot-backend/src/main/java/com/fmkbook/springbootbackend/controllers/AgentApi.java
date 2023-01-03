package com.fmkbook.springbootbackend.controllers;


import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentApi {
    private final AgentService agentService;

    @Autowired
    public AgentApi(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents () {
        List<Agent> agentList = this.agentService.findAllAgents();
        return new ResponseEntity<>(agentList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
        Agent newAgent = agentService.addAgent(agent);
        return new ResponseEntity<>(newAgent, HttpStatus.CREATED);
    }
}
