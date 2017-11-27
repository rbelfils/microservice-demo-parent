package api.fr.keyteo.microservices.rdv.repo;

import api.fr.keyteo.microservices.rdv.entities.Rdv;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RdvRepository extends PagingAndSortingRepository<Rdv, Long> {

}
