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

import com.tigray.genocide.model.GenocideEvidences;
import com.tigray.genocide.repository.GenocideEvidencesRepository;

@RestController
public class GenocideEvidencesController {

    @Autowired
    private GenocideEvidencesRepository genocideEvidencesRepository;

    @GetMapping(path = "/getAllGenocideEvidences", produces = "application/json")
    public List<GenocideEvidences> getAllGenocideEvidence() {
        return genocideEvidencesRepository.findAll();
    }

    @GetMapping(path = "/getGenocideEvidenceById/{id}", produces = "application/json")
    public GenocideEvidences getGenocideEvidenceById(@PathVariable Integer id) {
        return genocideEvidencesRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/addGenocideEvidence", consumes = "application/json", produces = "application/json")
    public GenocideEvidences addGenocideEvidence(@RequestBody GenocideEvidences genocideEvidences) {
        return genocideEvidencesRepository.save(genocideEvidences);
    }

    @PutMapping(path = "/editGenocideEvidence", consumes = "application/json", produces = "application/json")
    public GenocideEvidences editGenocideEvidence(@RequestBody GenocideEvidences modifiedEvidences) {
        GenocideEvidences originalEvidence = genocideEvidencesRepository.findById(modifiedEvidences.getId())
                .orElse(null);
        originalEvidence.setEvidenceType(modifiedEvidences.getEvidenceType());
        originalEvidence.setEvidenceDate(modifiedEvidences.getEvidenceDate());
        originalEvidence.setEvidenceLink(modifiedEvidences.getEvidenceLink());
        originalEvidence.setEvidenceDocumentId(modifiedEvidences.getEvidenceDocumentId());
        originalEvidence.setEvidenceBy(modifiedEvidences.getEvidenceBy());

        return genocideEvidencesRepository.save(originalEvidence);
    }

    @DeleteMapping(path = "/deleteGenocideEvidenceById/{id}", produces = "application/json")
    public Integer deleteGenocideEvidence(@PathVariable Integer id) {
        genocideEvidencesRepository.deleteById(id);
        return id;
    }

}