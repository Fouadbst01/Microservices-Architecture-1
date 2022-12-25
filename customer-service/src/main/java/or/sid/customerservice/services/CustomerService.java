package or.sid.customerservice.services;

import or.sid.customerservice.dtos.CustomerRequestDTO;
import or.sid.customerservice.dtos.CustomerResponseDTO;
import or.sid.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;


public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id) throws CustomerNotFoundException;
    List<CustomerResponseDTO> listCustomer();
}
