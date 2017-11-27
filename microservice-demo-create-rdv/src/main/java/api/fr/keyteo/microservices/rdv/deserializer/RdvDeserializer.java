package api.fr.keyteo.microservices.rdv.deserializer;
import api.fr.keyteo.microservices.rdv.entities.Rdv;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 *
 */
public class RdvDeserializer extends JsonDeserializer<Rdv> {

    public RdvDeserializer() {
        super(Rdv.class);
    }
}
