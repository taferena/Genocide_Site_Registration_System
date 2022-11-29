package com.tigray.genocide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigray.genocide.model.GenocideDocument;

public interface GenocideDocumentRepository extends JpaRepository<GenocideDocument, Integer> {

}