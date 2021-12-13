
package de.intellinet.ausbildung.rest.restkundenportal.service;

import java.util.List;

import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;

public interface IKundenService {

    Response speicher(PersonDTO person);

    PersonDTO getByUuId(String id);

    List<PersonDTO> findAll();

    void delete(String id);

    PersonDTO updata(String uuid, PersonDTO person);

}
