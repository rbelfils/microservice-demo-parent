package api.fr.keyteo.microservices.create.services;

import api.fr.keyteo.microservices.create.repo.CustomerRepository;
import api.fr.keyteo.microservices.create.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public Customer createCustomer(Customer customer) {
        System.out.println("BEFORE" + customer.toString());
        Customer result = customerRepo.save(customer);
        System.out.println("AFTER" +customer.toString());
        return result;
    }
}
