package com.ensa.msinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection="Invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//si on met ToString annotation ça genere une boucle infinie
public class Invoice {

    @Id
    private String id;
    private String reference;

//    String pattern = "MM-dd-yyyy";
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private String dateFacture;



}
