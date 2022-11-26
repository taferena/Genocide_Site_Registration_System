package com.tigray.genocide;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenocideEvidences{
    @Id
    private String id;
    private String evidenceType;
    private Date evidenceDate;
    private String evidenceLink;
    private String evidenceDocumentId;
    private String evidenceBy;
}