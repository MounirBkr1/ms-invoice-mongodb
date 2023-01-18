package com.ensa.msinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToMany;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private String id;
    private String designation;
    private Double price;


    private String description;

    //private String photo;
    private long depositQuantity;
    @DateTimeFormat(style = "dd-MM-yyyy")
    private LocalDate expiryDate;;

    @OneToMany
    private Invoice invoice;
}