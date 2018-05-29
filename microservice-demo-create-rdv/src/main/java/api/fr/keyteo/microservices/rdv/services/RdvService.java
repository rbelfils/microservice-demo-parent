package api.fr.keyteo.microservices.rdv.services;

import java.util.Date;

import api.fr.keyteo.microservices.rdv.entities.Customer;
import api.fr.keyteo.microservices.rdv.entities.Rdv;
import api.fr.keyteo.microservices.rdv.repo.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RdvService {

	private RdvRepository rdvRepository;

	private KafkaTemplate<String, Customer> kafkaTemplate;

	@Autowired
	private RdvService(RdvRepository orderRepository, KafkaTemplate<String, Customer> kafkaTemplate) {
		super();
		this.rdvRepository = orderRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public Rdv createRdv(Rdv rdv) {

		Rdv result = rdvRepository.save(rdv);
		fireOrderCreatedEvent(rdv);
		return result;
	}

	/**
	 * Envoie l'event à kafka producer
	 * @param rdv
	 */
	private void fireOrderCreatedEvent(Rdv rdv) {
		kafkaTemplate.send("customer", rdv.getRdvId() + "created", rdv.getCustomer());
	}

}
