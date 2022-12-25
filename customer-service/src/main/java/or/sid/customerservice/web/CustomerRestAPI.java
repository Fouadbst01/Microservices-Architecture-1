package or.sid.customerservice.web;

import lombok.AllArgsConstructor;
import or.sid.customerservice.dtos.CustomerRequestDTO;
import or.sid.customerservice.dtos.CustomerResponseDTO;
import or.sid.customerservice.exceptions.CustomerNotFoundException;
import or.sid.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerRestAPI {
    private CustomerService customerService;
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable  String id) throws CustomerNotFoundException {
        return  customerService.getCustomer(id);
    }

    @PostMapping
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }

    @GetMapping
    public List<CustomerResponseDTO> listCustomer(){
        return  customerService.listCustomer();
    }

    @PutMapping
    public CustomerResponseDTO UpdateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.update(customerRequestDTO);
    }
}
