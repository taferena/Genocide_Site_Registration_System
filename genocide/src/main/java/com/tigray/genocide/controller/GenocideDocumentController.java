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

import com.tigray.genocide.model.GenocideDocument;
import com.tigray.genocide.repository.GenocideDocumentRepository;

@RestController
public class GenocideDocumentController {

    @Autowired
    private GenocideDocumentRepository genocideDocumentRepository;

    @GetMapping(path = "/getAllGenocideDocument", produces = "application/json")
    public List<GenocideDocument> getAllGenocideDocument() {
        return genocideDocumentRepository.findAll();
    }

    @GetMapping(path = "/getGenocideDocumentById/{id}", produces = "application/json")
    public GenocideDocument getGenocideDocumentById(@PathVariable Integer id) {
        return genocideDocumentRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/addGenocideDocument", consumes = "application/json", produces = "application/json")
    public GenocideDocument addGenocideDocument(@RequestBody GenocideDocument GenocideDocument) {
        return genocideDocumentRepository.save(GenocideDocument);
    }

    @PutMapping(path = "/editGenocideDocument", consumes = "application/json", produces = "application/json")
    public GenocideDocument editGenocideDocument(@RequestBody GenocideDocument modifiedDocuments) {
        GenocideDocument originalDocument = genocideDocumentRepository.findById(modifiedDocuments.getId())
                .orElse(null);
        originalDocument.setDocName(modifiedDocuments.getDocName());
        originalDocument.setUpdatedDate(modifiedDocuments.getUpdatedDate());
        originalDocument.setUpdatedBy(modifiedDocuments.getUpdatedBy());
        return genocideDocumentRepository.save(originalDocument);
    }

    @DeleteMapping(path = "/deleteGenocideDocumentById/{id}", produces = "application/json")
    public Integer deleteGenocideDocument(@PathVariable Integer id) {
        genocideDocumentRepository.deleteById(id);
        return id;
    }

}