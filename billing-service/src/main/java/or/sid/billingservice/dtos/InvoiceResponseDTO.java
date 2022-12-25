package or.sid.billingservice.dtos;

import lombok.Data;
import or.sid.billingservice.entities.Customer;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;
}
