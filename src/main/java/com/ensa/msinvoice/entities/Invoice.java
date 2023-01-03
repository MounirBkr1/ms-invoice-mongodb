package com.ensa.msinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;


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

    @DateTimeFormat(style = "dd-MM-yyyy")
    private LocalDate dateFacture;

    private Client client;

    private List<Product> products;

}
