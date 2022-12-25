package or.sid.billingservice.services;

import or.sid.billingservice.dtos.InvoiceRequestDTO;
import or.sid.billingservice.dtos.InvoiceResponseDTO;
import or.sid.billingservice.entities.Invoice;
import or.sid.billingservice.exceptions.InvocieNotFundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String id) throws InvocieNotFundException;
    InvoiceResponseDTO updateInvoice(InvoiceRequestDTO invoiceRequestDTO);

    List<InvoiceResponseDTO> listInvoice();
}
