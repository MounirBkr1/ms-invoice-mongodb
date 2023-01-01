package com.ensa.msinvoice.dao;

import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceRepository extends MongoRepository<Invoice,String> {
}
