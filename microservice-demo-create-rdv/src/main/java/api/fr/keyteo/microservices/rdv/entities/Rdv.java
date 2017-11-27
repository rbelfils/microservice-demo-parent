package api.fr.keyteo.microservices.rdv.entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rdv extends ResourceSupport {

    @Id
    @GeneratedValue
    private Long rdvId;

    private Date rdvDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Long getRdvId() {
        return rdvId;
    }

    public void setRdvId(Long rdvId) {
        this.rdvId = rdvId;
    }

    public Date getRdvDate() {
        return rdvDate;
    }

    public void setRdvDate(Date rdvDate) {
        this.rdvDate = rdvDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
