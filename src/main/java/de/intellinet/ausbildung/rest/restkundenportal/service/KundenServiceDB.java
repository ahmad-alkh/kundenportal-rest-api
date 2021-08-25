/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.PersonRepository;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Person;

/**
 * 
 * @author ahmalk
 *
 * @since 10.05.2021
 */
@Service
public class KundenServiceDB implements IKundenService {

    static final Logger logger = LoggerFactory.getLogger(KundenServiceDB.class);

    @Autowired
    PersonRepository repository;

    @Override
    public Response speicher(PersonDTO personDTO) {
        Response response = new Response();
        Person entity = MappingUtils.createNewPersonEntity(personDTO);
        String uuid = UUID.randomUUID().toString();
        entity.setUuid(uuid);
        repository.save(entity);
        personDTO.setUuid(uuid);
        response.setUuid(uuid);
        return response;
    }

    @Override
    public void delete(String uuid) {

        List<Person> findAll = repository.findAll();
        Optional<Person> finding = findAll.stream().filter(p -> p.getUuid().equals(uuid)).findFirst();

        if (finding.isPresent()) {
            repository.delete(finding.get());
        }
        // Optional<Person> findByUuid = repository.findByUuid(uuid);
        //
        // if (findByUuid.isPresent()) {
        // repository.delete(findByUuid.get());
        //
        // }

        return;
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> findAll = repository.findAll();
        List<PersonDTO> mappPersonen = mappPersonen(findAll);
        return mappPersonen;
    }

    @Override
    public PersonDTO getByUuId(String idPerson) {
        Optional<Person> findByUuid = repository.findByUuid(idPerson);

        return MappingUtils.mappePersonDTO(findByUuid.get());
    }

    @Override
    public PersonDTO updata(String uuid, PersonDTO person) {
        Optional<Person> findByUuid = repository.findByUuid(uuid);
        if (findByUuid.isPresent()) {

            delete(uuid);
            person.setUuid(uuid);
            speicher(person);

            return person;

        } else {
            return null;
        }

    }

    private List<PersonDTO> mappPersonen(List<Person> personen) {
        List<PersonDTO> personenDTO = new ArrayList<PersonDTO>();
        for (Person person : personen) {
            personenDTO.add(MappingUtils.mappePersonDTO(person));
        }

        return personenDTO;
    }

}
