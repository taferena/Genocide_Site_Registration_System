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
public class GenocideIncidence {
    @Id
    private String id;
    private int numVictims;
    private Date incidentDate;
    private String commitedBy;
    private int evidenceId; 

}
