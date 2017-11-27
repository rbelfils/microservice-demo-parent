package api.fr.keyteo.microservices.create.user;

import javax.annotation.PostConstruct;

import api.fr.keyteo.microservices.create.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTestDataGenerator {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerTestDataGenerator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void generateTestData() {
        List<Customer> listCustomer = customerRepository.findByNameAndFirstname("Wolff", "Eberhard");
        if (listCustomer.size()==0) {
            Customer c = new Customer();
            c.setName( "Wolff");
            c.setFirstname("Eberhard");
            c.setEmail("eberhard.wolff@gmail.com");
            customerRepository.save(c);
        }

      listCustomer = customerRepository.findByNameAndFirstname("Johnson", "Rod");
        if (listCustomer.size()==0) {
            Customer c = new Customer();
            c.setName("Rod");
            c.setFirstname("Johnson");
            c.setEmail("rod@somewhere.com");
            customerRepository.save(c);
        }


    }

}
