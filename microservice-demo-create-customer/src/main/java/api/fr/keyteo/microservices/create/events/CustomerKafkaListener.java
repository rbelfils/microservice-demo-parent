package api.fr.keyteo.microservices.create.events;

import api.fr.keyteo.microservices.create.services.CustomerService;
import api.fr.keyteo.microservices.create.user.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class CustomerKafkaListener {

	private final Logger log = LoggerFactory.getLogger(CustomerKafkaListener.class);

	private CustomerService customerService;

	public CustomerKafkaListener(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@KafkaListener(topics = "customer")
	public void order(Customer customer, Acknowledgment acknowledgment) {
		log.info("Revceived customer " + customer.getCustomerId());
		customerService.createCustomer(customer);
		acknowledgment.acknowledge();
	}

}
