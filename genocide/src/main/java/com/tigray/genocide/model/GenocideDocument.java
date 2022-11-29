package com.tigray.genocide.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="GENOCIDE_DOCUMENT")
@Data
public class GenocideDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String docName;
    private Date updatedDate;
    private String updatedBy;
}
