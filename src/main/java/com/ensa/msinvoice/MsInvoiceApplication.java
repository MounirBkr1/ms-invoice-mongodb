package com.ensa.msinvoice;

import com.ensa.msinvoice.dao.InvoiceRepository;
import com.ensa.msinvoice.entities.Invoice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@OpenAPIDefinition(info=@Info(title="InvoiceAPI",version="1.0",description="description of my open api"))
public class MsInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsInvoiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(InvoiceRepository invoiceRepository) {
        return args -> {
            invoiceRepository.deleteAll(); //vider les categories a chaque demarrage
            invoiceRepository.save(new Invoice("1","lk124skjs","12-16-1920"));
            invoiceRepository.save(new Invoice("2","bdbdbd","12-16-1989"));
            invoiceRepository.save(new Invoice("3","clk124skjs","12-16-1989"));

        };
    }







}
