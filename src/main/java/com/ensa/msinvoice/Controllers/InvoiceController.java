package com.ensa.msinvoice.Controllers;

import com.ensa.msinvoice.entities.Invoice;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;




public interface InvoiceController {

    public ResponseEntity<List<Invoice>> getAllInvoices();
    public ResponseEntity<Invoice> findById(String id);
    public ResponseEntity<Invoice> addInvoice(Invoice invoice);

    public ResponseEntity<String> deleteInvoiceById(String id);
    public ResponseEntity<Invoice> updateInvoice( String id, Invoice invoice);

    public ResponseEntity<Page<Invoice>> findByDateFactureBetween(String startDate, String endDate, int page, int size);



}


