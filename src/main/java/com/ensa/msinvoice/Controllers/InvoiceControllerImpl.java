package com.ensa.msinvoice.Controllers;

import com.ensa.msinvoice.Services.InvoiceService;
import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api/v1/")
public class InvoiceControllerImpl implements InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceControllerImpl(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices =  invoiceService.getAllInvoices();


        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }



    @GetMapping("/invoice/{id}")
    @Override
    public ResponseEntity<Invoice> findById(@PathVariable("id") String id) {
        Invoice invoiceFinded= invoiceService.findById(id).get();
        return ResponseEntity.ok(invoiceFinded);
    }



    @PostMapping("/addInvoice")
    @Override
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice) {
        Invoice invoiceToAdd=invoiceService.addInvoice(invoice);
         return ResponseEntity.ok(invoiceToAdd);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public  ResponseEntity<String> deleteInvoiceById(@PathVariable("id") String id) {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") String id,@RequestBody Invoice invoice) {
        Invoice invoiceToUpdate = invoiceService.updateInvoice(id, invoice);
        return ResponseEntity.ok(invoiceToUpdate);
    }




    @GetMapping("/findByDateFactureBetween")
    public ResponseEntity<Page<Invoice>> findByDateFactureBetween(@RequestParam String startDate, @RequestParam String endDate, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //transform dtring to LocalDate
        LocalDate localDateStart = LocalDate.parse(startDate, formatter);
        LocalDate localDateEnd = LocalDate.parse(endDate, formatter);

        return ResponseEntity.ok(invoiceService.findByDateFactureBetween(localDateStart,localDateEnd,page,size));
    }


}
