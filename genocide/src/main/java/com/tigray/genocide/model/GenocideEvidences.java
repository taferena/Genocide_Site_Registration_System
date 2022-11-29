package com.tigray.genocide.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GENOCIDE_EVIDENCES")
@Data
public class GenocideEvidences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String evidenceType;
    private Date evidenceDate;
    private String evidenceLink;
    private String evidenceDocumentId;
    private String evidenceBy;
}