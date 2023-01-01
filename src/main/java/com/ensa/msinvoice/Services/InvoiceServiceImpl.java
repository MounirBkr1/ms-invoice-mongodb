package com.ensa.msinvoice.Services;

import com.ensa.msinvoice.dao.InvoiceRepository;
import com.ensa.msinvoice.entities.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvoiceServiceImpl implements InvoiceService{


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private InvoiceRepository invoiceRepository;


    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(String id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public void updateInvoice(String id, Invoice invoice) {
        invoiceRepository.findById(id);

        Invoice new_invoice = new Invoice();
        new_invoice.setId(invoice.getId());
        new_invoice.setReference(invoice.getReference());
        new_invoice.setDateFacture(invoice.getDateFacture());

        invoiceRepository.save(new_invoice);


    }

    @Override
    public void deleteInvoiceById(String id) {
        invoiceRepository.deleteById(id);

    }
}
