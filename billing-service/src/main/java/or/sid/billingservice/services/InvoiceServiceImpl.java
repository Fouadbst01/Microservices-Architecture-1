package or.sid.billingservice.services;

import lombok.AllArgsConstructor;
import or.sid.billingservice.dtos.InvoiceRequestDTO;
import or.sid.billingservice.dtos.InvoiceResponseDTO;
import or.sid.billingservice.entities.Customer;
import or.sid.billingservice.entities.Invoice;
import or.sid.billingservice.exceptions.InvocieNotFundException;
import or.sid.billingservice.feign.CustomerServiceRestClient;
import or.sid.billingservice.mappers.InvoiceMapper;
import or.sid.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceMapper mapper;
    private InvoiceRepository invoiceRepository;
    private CustomerServiceRestClient customerServiceRestClient;
    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = mapper.InvoiceRequesDtoToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        return mapper.InvoiceToInvoiceResponse(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) throws InvocieNotFundException {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(()-> new InvocieNotFundException(String.format("invoice %s not found", id)));
        Customer customer = customerServiceRestClient.customerById(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return mapper.InvoiceToInvoiceResponse(invoice);
    }

    @Override
    public InvoiceResponseDTO updateInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = mapper.InvoiceRequesDtoToInvoice(invoiceRequestDTO);
        Invoice updetedInvoice = invoiceRepository.save(invoice);
        return mapper.InvoiceToInvoiceResponse(updetedInvoice);
    }

    @Override
    public List<InvoiceResponseDTO> listInvoice() {
        List<Invoice> invoices = invoiceRepository.findAll();

        return invoices.stream()
            .map(in-> mapper.InvoiceToInvoiceResponse(in)).collect(Collectors.toList());
    }
}
