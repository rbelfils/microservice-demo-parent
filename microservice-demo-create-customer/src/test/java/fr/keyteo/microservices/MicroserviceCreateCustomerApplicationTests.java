package fr.keyteo.microservices;

import api.fr.keyteo.microservices.create.MicroserviceCreateUserApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroserviceCreateUserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MicroserviceCreateCustomerApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

}
