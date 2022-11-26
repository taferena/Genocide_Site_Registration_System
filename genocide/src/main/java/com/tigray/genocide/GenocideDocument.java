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
public class GenocideDocument {
    @Id
    private int id;
    private String docName;
    private Date updateDate;
    private String updatedBy;
}
