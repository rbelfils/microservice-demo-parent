package api.fr.keyteo.microservices.rdv.repo;

import api.fr.keyteo.microservices.rdv.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByName(@Param("name") String name);

}
