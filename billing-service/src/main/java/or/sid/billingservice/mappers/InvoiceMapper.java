package or.sid.billingservice.mappers;

import or.sid.billingservice.dtos.InvoiceRequestDTO;
import or.sid.billingservice.dtos.InvoiceResponseDTO;
import or.sid.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice InvoiceRequesDtoToInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO InvoiceToInvoiceResponse(Invoice invoice);
}
