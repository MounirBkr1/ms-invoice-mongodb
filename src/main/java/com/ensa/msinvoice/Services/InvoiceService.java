package com.ensa.msinvoice.Services;

import com.ensa.msinvoice.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    public void saveInvoice(Invoice invoice);


    public List<Invoice> getAllInvoices();

    //get: client by id
    public Optional<Invoice> findById(String id);

    //put: update client
    public void updateInvoice(String id,Invoice invoice);

    //delete client by id
     public void deleteInvoiceById(String id);
}
