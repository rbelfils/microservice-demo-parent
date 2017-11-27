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
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(path = "ping",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> ping() {

        return new ResponseEntity<Rdv>(HttpStatus.OK);
    }
}
