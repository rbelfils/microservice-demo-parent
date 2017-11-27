package api.fr.keyteo.microservices.create.repo;

import java.util.List;

import api.fr.keyteo.microservices.create.user.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = true)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	List<Customer> findByName(@Param("name") String name);

	List<Customer> findByNameAndFirstname(String name, String firstname);
}
