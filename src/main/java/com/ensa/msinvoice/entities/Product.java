package com.ensa.msinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    private long depositQuantity;
    private String photo;
    @DateTimeFormat(style = "dd-MM-yyyy")
    private LocalDate expiryDate;;
    private String description;

}