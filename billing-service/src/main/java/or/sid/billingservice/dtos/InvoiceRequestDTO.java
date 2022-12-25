package or.sid.billingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import or.sid.billingservice.entities.Customer;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data @AllArgsConstructor
public class InvoiceRequestDTO {
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customerID;
}
