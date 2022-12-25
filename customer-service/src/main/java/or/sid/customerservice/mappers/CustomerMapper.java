package or.sid.customerservice.mappers;

import or.sid.customerservice.dtos.CustomerRequestDTO;
import or.sid.customerservice.dtos.CustomerResponseDTO;
import or.sid.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
