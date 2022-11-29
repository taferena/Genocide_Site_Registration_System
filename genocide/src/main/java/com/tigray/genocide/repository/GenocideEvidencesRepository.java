package com.tigray.genocide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigray.genocide.model.GenocideEvidences;

public interface GenocideEvidencesRepository extends JpaRepository<GenocideEvidences, Integer> {

}