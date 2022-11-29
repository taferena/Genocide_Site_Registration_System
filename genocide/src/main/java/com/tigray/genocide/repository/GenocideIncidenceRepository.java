package com.tigray.genocide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigray.genocide.model.GenocideIncidence;
 
public interface GenocideIncidenceRepository extends JpaRepository<GenocideIncidence, Integer> {
 
}