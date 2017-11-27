package api.fr.keyteo.microservices.create.events;

import api.fr.keyteo.microservices.create.user.Customer;
import org.springframework.kafka.support.serializer.JsonDeserializer;


public class CustomerDeserializer extends JsonDeserializer<Customer> {

	public CustomerDeserializer() {
		super(Customer.class);
	}

}
