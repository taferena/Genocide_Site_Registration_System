package com.tigray.genocide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenocideController{

@Autowired    
private GenocideRepository genocideRepository;

@GetMapping(path = "/getAllGenocideIncidents", produces = "application/json")
public List<GenocideIncidence> getAllGenocideSites (){
    return genocideRepository.findAll();
}

@GetMapping(path = "/getGenocideIncidentById/{id}", produces = "application/json")
public GenocideIncidence getGenocideIncidentById (@PathVariable String id){
    System.out.println("xxxxxxxxxxxxxxx "+id+" xxxxxxxxxxxxxxx");

    GenocideIncidence incidence = genocideRepository.findById(id).orElse(null);
    System.out.println("xxxxxxxxxxxxxxx "+ incidence+" xxxxxxxxxxxxxxx");
    return genocideRepository.findById(id).orElse(null);
}

@PostMapping(path = "/addGenocideIncidence",consumes = "application/json", produces = "application/json")
public GenocideIncidence addGenocideSite(@RequestBody GenocideIncidence genocideIncidences){
    genocideRepository.save(genocideIncidences);
    return genocideIncidences;
}

@PutMapping(path = "/editGenocideIncidence",consumes = "application/json", produces = "application/json")
public GenocideIncidence editGenocideSite(@RequestBody GenocideIncidence modifiedIncident){
    GenocideIncidence originalIncident = genocideRepository.findById(modifiedIncident.getId()).orElse(null);
    originalIncident.setIncidentDate(modifiedIncident.getIncidentDate());
    originalIncident.setNumVictims(modifiedIncident.getNumVictims());
    originalIncident.setEvidenceId(modifiedIncident.getEvidenceId());
    originalIncident.setCommitedBy(modifiedIncident.getCommitedBy());
    genocideRepository.save(originalIncident);
    return  originalIncident;
}

@DeleteMapping(path = "/deleteGenocideIncidentById/{id}", produces = "application/json")
public String deleteGenocideSite(@PathVariable String id){
    genocideRepository.deleteById(id);
    return id;
}

}