package or.sid.customerservice.services;

import lombok.AllArgsConstructor;
import or.sid.customerservice.dtos.CustomerRequestDTO;
import or.sid.customerservice.dtos.CustomerResponseDTO;
import or.sid.customerservice.entities.Customer;
import or.sid.customerservice.exceptions.CustomerNotFoundException;
import or.sid.customerservice.mappers.CustomerMapper;
import or.sid.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        customer.setId(UUID.randomUUID().toString());
        Customer savedCustomer =  customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer updateedCustomer =  customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updateedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException(String.format("Customer with %S not found",id)));
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {
        List<Customer> listCustomers = customerRepository.findAll();
        return listCustomers.stream().map(c -> customerMapper.customerToCustomerResponseDTO(c)).collect(Collectors.toList());

    }
}
