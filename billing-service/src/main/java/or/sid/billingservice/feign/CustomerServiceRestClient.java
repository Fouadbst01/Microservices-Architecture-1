package or.sid.billingservice.feign;

import or.sid.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {
    @GetMapping(path = "/customer/{id}")
    Customer customerById(@PathVariable String id);
    @GetMapping(path = "/customer")
    List<Customer> customers();

}
