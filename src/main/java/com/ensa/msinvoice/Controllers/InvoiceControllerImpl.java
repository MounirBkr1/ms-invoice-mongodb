package com.ensa.msinvoice.Controllers;

import com.ensa.msinvoice.Services.InvoiceService;
import com.ensa.msinvoice.entities.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api/v1")
public class InvoiceControllerImpl implements InvoiceController {



    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/invoice/{id}")
    @Override
    public Optional<Invoice> findById(String id) {
        return invoiceService.findById(id);
    }

    @PostMapping("/addInvoice")
    @Override
    public void addInvoice(Invoice invoice) {
         invoiceService.saveInvoice(invoice);

    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteInvoiceById(String id) {
        invoiceService.deleteInvoiceById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public void updateInvoice(String id,Invoice invoice) {
        invoiceService.updateInvoice(id,invoice);
    }

}
