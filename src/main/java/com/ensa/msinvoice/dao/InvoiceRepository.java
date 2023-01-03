package com.ensa.msinvoice.dao;

import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource
public interface InvoiceRepository extends MongoRepository<Invoice,String> {
//    @Query("{'FactureDate': {$gte: ?0, $lte:?1 }}")
//    List<Invoice> findByDateFactureBetween(LocalDate startDate, LocalDate endDate);

    Page<Invoice> findByDateFactureBetween(LocalDate startDate, LocalDate endDate, PageRequest of);

//    @Query("{'name': ?0}")
//    List<Invoice> findByName(String name, Sort sort);
//
//    @Query("{'name': ?0 , 'department': ?1}")
//    List<Invoice> findByReferenceAndReference(String name, String department);
}
