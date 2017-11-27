package api.fr.keyteo.microservices.rdv.config;

import api.fr.keyteo.microservices.rdv.entities.Customer;
import api.fr.keyteo.microservices.rdv.entities.Rdv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
class SpringRestDataConfig extends RepositoryRestConfigurerAdapter {

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.exposeIdsFor(Rdv.class, Customer.class);
			}
		};
	}

}
