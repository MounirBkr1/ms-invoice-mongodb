package com.ensa.msinvoice.Services;

import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    public Invoice addInvoice(Invoice invoice);


    public List<Invoice> getAllInvoices();

    //get: client by id
    public Optional<Invoice> findById(String id);

    //put: update client
    public Invoice updateInvoice(String id, Invoice invoice);

    //delete client by id
     public void deleteInvoiceById(String id);

     //pagination

    Page<Invoice> findByDateFactureBetween(LocalDate startDate, LocalDate endDate, int page, int size);

//     public List<Invoice> findByName(String name);
//     public List<Invoice> findByNameAndReference(String name,String reference);
}
