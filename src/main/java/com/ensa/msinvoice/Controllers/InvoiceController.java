package com.ensa.msinvoice.Controllers;

import com.ensa.msinvoice.entities.Invoice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




public interface InvoiceController {

    public List<Invoice> getAllInvoices();
    public Optional<Invoice> findById(@PathVariable String id);
    public void addInvoice(Invoice invoice);

    public void deleteInvoiceById(String id);
    public void updateInvoice(@PathVariable String id,@RequestBody Invoice invoice);
}


