package com.ensa.msinvoice.dao;

import com.ensa.msinvoice.entities.Client;
import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends MongoRepository<Client,String> {
}
