package com.ensa.msinvoice;

import com.ensa.msinvoice.dao.InvoiceRepository;
import com.ensa.msinvoice.entities.Invoice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

            invoiceRepository.deleteAll(); //vider les categories a chaque demarrage
            invoiceRepository.save(new Invoice("1","lk124skjs1",  LocalDate.of(2020,2,24),null,null));
            invoiceRepository.save(new Invoice("2","bdbdbdg55g",LocalDate.of(2021,2,24),null, null));
            invoiceRepository.save(new Invoice("3","clk124skjs",LocalDate.of(2025,2,24),null,null));
            invoiceRepository.save(new Invoice("3","clk124skjs", LocalDate.of(2030,2,24),null,null));




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
