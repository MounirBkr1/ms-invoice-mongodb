package com.ensa.msinvoice.Services;

import com.ensa.msinvoice.Exception.IdAlreadyExistInvoiceException;
import com.ensa.msinvoice.Exception.InvoiceException;
import com.ensa.msinvoice.Exception.ResourceNotFoundInvoiceException;
import com.ensa.msinvoice.dao.InvoiceRepository;
import com.ensa.msinvoice.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class InvoiceServiceImpl implements InvoiceService{


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private InvoiceRepository invoiceRepository;


    //add invoice
    @Override
    public Invoice addInvoice(Invoice invoice) {
        Optional<Invoice> invoiceToAdd=invoiceRepository.findById(invoice.getId());
        if(!invoiceToAdd.isEmpty()) throw new IdAlreadyExistInvoiceException("Invoice id already exist!");


        invoice.setReference(invoice.getReference() +"-Ref");
             return  invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(String id) {
        Optional<Invoice> findedInvoice = invoiceRepository.findById(id);

        if (findedInvoice.isEmpty()) throw new ResourceNotFoundInvoiceException("Not found Tutorial with id = " + id);
        return findedInvoice;
    }

    @Override
    public Invoice updateInvoice(String id, Invoice invoice) {
        Invoice selectedInvoice=invoiceRepository.findById(id).get();

        if(selectedInvoice !=null && selectedInvoice.getReference() != null ){
            selectedInvoice.setId(invoice.getId());
            selectedInvoice.setReference(invoice.getReference());
            selectedInvoice.setDateFacture(invoice.getDateFacture());
            invoiceRepository.save(selectedInvoice);
        } else{
            throw new InvoiceException("Invoive:" + invoice + "with id:"+id+"is not modified!!!!");
        }

        return selectedInvoice;
    }

    @Override
    public void deleteInvoiceById(String id) {
        invoiceRepository.deleteById(id);
    }



    @Override
    public Page<Invoice> findByDateFactureBetween(LocalDate startDate, LocalDate endDate, int page, int size) {
        return invoiceRepository.findByDateFactureBetween(startDate, endDate, PageRequest.of(page, size));
    }

    @Override
    public List<Invoice> getProductByDesignation(String reference) {
        List<Invoice> products = invoiceRepository.findProductByDesignation(reference);
        if(products.isEmpty() ){
            throw new EntityNotFoundException("cannot find any product with the designation" + " " + reference);
        }
        return products;
    }

//    @Override
//    public List<Invoice> findByName(String name) {
//        return invoiceRepository.findByName(name, Sort.unsorted());
//    }
//
//    @Override
//    public List<Invoice> findByNameAndReference(String name, String reference) {
//        return invoiceRepository.findByReferenceAndReference(name,reference);
//    }
}
