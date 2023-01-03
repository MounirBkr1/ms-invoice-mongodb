package com.ensa.msinvoice.Exception;

public class ResourceNotFoundInvoiceException extends InvoiceException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundInvoiceException(String msg) {
        super(msg);
    }
}
