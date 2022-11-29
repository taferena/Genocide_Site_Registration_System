package com.tigray.genocide.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "GENOCIDE_INCIDENCE")
public class GenocideIncidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numVictims;
    private Date incidentDate;
    private String committedBy;
    private int evidenceId;
}
