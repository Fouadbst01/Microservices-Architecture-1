package or.sid.billingservice.web;

import lombok.AllArgsConstructor;
import or.sid.billingservice.dtos.InvoiceRequestDTO;
import or.sid.billingservice.dtos.InvoiceResponseDTO;
import or.sid.billingservice.exceptions.InvocieNotFundException;
import or.sid.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/invoices")
@AllArgsConstructor
public class InvoiceRestAPI {
    private InvoiceService invoiceService;

    @GetMapping("/{id}")
    public InvoiceResponseDTO getINvoice(@PathVariable  String id) throws InvocieNotFundException {
        return  invoiceService.getInvoice(id);
    }

    @PostMapping
    public InvoiceResponseDTO addInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return  invoiceService.saveInvoice(invoiceRequestDTO);
    }

    @GetMapping
    public List<InvoiceResponseDTO> invoiceResponseDTOList(){
        return invoiceService.listInvoice();
    }

    @PutMapping
    public InvoiceResponseDTO updateInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.updateInvoice(invoiceRequestDTO);
    }
}
