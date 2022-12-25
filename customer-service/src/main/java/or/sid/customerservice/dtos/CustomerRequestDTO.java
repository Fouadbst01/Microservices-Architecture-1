package or.sid.customerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;
}
