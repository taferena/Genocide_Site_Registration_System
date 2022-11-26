package com.tigray.genocide;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

// @GetMapping("/{id}")
// public GenocideSite getUser(@PathVariable String id){
//     return  userRepository.findById(id).orElse(null);
// }

@PostMapping(path = "/addGenocideIncidence",consumes = "application/json", produces = "application/json")
public GenocideIncidence addGenocideSite(@RequestBody GenocideIncidence genocideIncidences){
    // genocideIncidences.setId("001");
    // genocideIncidences.setCommitedBy("Tafere");
    // genocideIncidences.setEvidenceId(01);
    // genocideIncidences.setIncidentDate(new Date());
    // genocideIncidences.setNumVictims(200);
    genocideRepository.save(genocideIncidences);
    return genocideIncidences;
}

// @PutMapping("/")
// public GenocideSite editUser(@RequestBody GenocideSite newUser){
//     GenocideSite oldUser = userRepository.findById(newUser.getId()).orElse(null);
//     oldUser.setName(newUser.getName());
//     oldUser.setEmail(newUser.getEmail());
//     oldUser.setPassword(newUser.getPassword());
//     return  oldUser;
// }

// @DeleteMapping("/{id}")
// public String deleteUser(@PathVariable String id){
//       userRepository.deleteById(id);
//     return id;
// }

}