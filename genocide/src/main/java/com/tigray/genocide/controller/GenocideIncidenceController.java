package com.tigray.genocide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tigray.genocide.model.GenocideIncidence;
import com.tigray.genocide.repository.GenocideIncidenceRepository;

@RestController
public class GenocideIncidenceController {

    @Autowired
    private GenocideIncidenceRepository genocideIncidenceRepository;

    @GetMapping(path = "/getAllGenocideIncidents", produces = "application/json")
    public List<GenocideIncidence> getAllGenocideSites() {
        return genocideIncidenceRepository.findAll();
    }

    @GetMapping(path = "/getGenocideIncidentById/{id}", produces = "application/json")
    public GenocideIncidence getGenocideIncidentById(@PathVariable Integer id) {
        return genocideIncidenceRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/addGenocideIncidence", consumes = "application/json", produces = "application/json")
    public GenocideIncidence addGenocideSite(@RequestBody GenocideIncidence genocideIncidences) {
        return genocideIncidenceRepository.save(genocideIncidences);
    }

    @PutMapping(path = "/editGenocideIncidence", consumes = "application/json", produces = "application/json")
    public GenocideIncidence editGenocideSite(@RequestBody GenocideIncidence modifiedIncident) {
        GenocideIncidence originalIncident = genocideIncidenceRepository.findById(modifiedIncident.getId()).orElse(null);
        originalIncident.setIncidentDate(modifiedIncident.getIncidentDate());
        originalIncident.setNumVictims(modifiedIncident.getNumVictims());
        originalIncident.setEvidenceId(modifiedIncident.getEvidenceId());
        originalIncident.setCommittedBy(modifiedIncident.getCommittedBy());
        return genocideIncidenceRepository.save(originalIncident);
    }

    @DeleteMapping(path = "/deleteGenocideIncidentById/{id}", produces = "application/json")
    public Integer deleteGenocideSite(@PathVariable Integer id) {
        genocideIncidenceRepository.deleteById(id);
        return id;
    }

}