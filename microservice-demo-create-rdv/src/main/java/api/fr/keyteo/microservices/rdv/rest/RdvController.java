package api.fr.keyteo.microservices.rdv.rest;

import api.fr.keyteo.microservices.rdv.entities.Rdv;
import api.fr.keyteo.microservices.rdv.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    @Autowired  private RdvService rdvService;

    @RequestMapping(path = "",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Rdv> createRdv(@RequestBody Rdv resource) {
        Rdv rdv = rdvService.createRdv(resource);
        //Lien HATEOAS
        rdv.add(linkTo(methodOn(RdvController.class).createRdv(resource)).withSelfRel());
        return new ResponseEntity<Rdv>(rdv, HttpStatus.OK);
    }
}
