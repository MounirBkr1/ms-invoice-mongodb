package com.ensa.msinvoice;

import com.ensa.msinvoice.dao.InvoiceRepository;
import com.ensa.msinvoice.entities.Customer;
import com.ensa.msinvoice.entities.Invoice;

import com.ensa.msinvoice.entities.Product;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@OpenAPIDefinition(info=@Info(title="InvoiceAPI",version="1.0",description="description of my open api"))
public class MsInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsInvoiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(InvoiceRepository invoiceRepository) {
        return args -> {
            LocalDate startDate=LocalDate.of(2020,2,24);
            LocalDate endDate=LocalDate.of(2025,2,24);


            Customer c1= new Customer("1","mounir","bkr","mr@gmail","rue zohour","casablanca");
            Customer c2= new Customer("2","monsif","bkr","mr@gmail","rue zohour","casablanca");
            Customer c3= new Customer("3","maha","bkr","mr@gmail","rue zohour","casablanca");

            Product p1= new Product("1","hp",1452.22,1254,"",LocalDate.of(2020,2,24),"description");
            Product p2= new Product("2","samsung",1452.22,1254,"",LocalDate.of(2020,2,24),"description");
            Product p3= new Product("3","apple",1452.22,1254,"",LocalDate.of(2020,2,24),"description");


            List<Product> lp1 = new ArrayList<>();
            lp1.add(p1);
            lp1.add(p2);

            List<Product> lp2 = new ArrayList<>();
            lp2.add(p2);
            lp2.add(p3);
            List<Product> lp3 = new ArrayList<>();
            lp3.add(p3);
            lp3.add(p2);
            lp3.add(p3);

            invoiceRepository.deleteAll(); //vider les categories a chaque demarrage
            invoiceRepository.save(new Invoice("1","1425-Ref",LocalDate.of(2021,2,24),154,2511,c1, lp1));
            invoiceRepository.save(new Invoice("2","14256-Ref",LocalDate.of(2025,2,24),14,2500,c2,lp2));
            invoiceRepository.save(new Invoice("3","1425-Ref", LocalDate.of(2030,2,24),14,1526,c3,lp3));




            Page<Invoice> invoicesBetween = invoiceRepository.findByDateFactureBetween(startDate,endDate, PageRequest.of(3, 5));


            System.out.println(invoicesBetween);

            invoicesBetween.forEach((i)->{
                System.out.println("hi mounir");
                System.out.println(i.getId());
                System.out.println(i.getReference());
                System.out.println(i.getDateFacture());
            });
        };
    }







}
