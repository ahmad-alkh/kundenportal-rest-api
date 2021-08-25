
package de.intellinet.ausbildung.rest.restkundenportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;
import de.intellinet.ausbildung.rest.restkundenportal.service.IKundenService;
import de.intellinet.ausbildung.rest.restkundenportal.service.Response;
import io.swagger.v3.oas.annotations.Operation;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 04.05.2021
 */

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private IKundenService kundenService;

    @Operation
    @GetMapping({"", "/"})
    public ResponseEntity<List<PersonDTO>> getAllpersons() {
        return new ResponseEntity<List<PersonDTO>>(kundenService.findAll(), HttpStatus.OK);
    }

    @Operation
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable String id) {
        return new ResponseEntity<PersonDTO>(kundenService.getByUuId(id), HttpStatus.OK);
    }

    @Operation
    @PostMapping(path = "/", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> speicherPerson(@RequestBody PersonDTO person) {
        Response response = kundenService.speicher(person);
        // String uuide = response.getUuid();
        return new ResponseEntity<Response>(response, HttpStatus.OK);

    }

    @Operation
    @PutMapping(path = "/{uuid}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> updataPerson(@PathVariable(name = "uuid") String uuid,
            @RequestBody PersonDTO person) {

        PersonDTO updata = kundenService.updata(uuid, person);
        ResponseEntity<PersonDTO> responseEntity = new ResponseEntity<PersonDTO>(updata, HttpStatus.OK);
        return responseEntity;

    }

    @Operation
    @DeleteMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePerson(@PathVariable String uuid) {
        kundenService.delete(uuid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
