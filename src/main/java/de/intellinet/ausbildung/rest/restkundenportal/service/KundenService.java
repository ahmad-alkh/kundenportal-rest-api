/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 06.05.2021
 */
// @Service
public class KundenService implements IKundenService {

    private static final Logger logger = LoggerFactory.getLogger(KundenService.class);

    private static final List<PersonDTO> data = new ArrayList<PersonDTO>();//
    static {

        PersonDTO p1 = new PersonDTO();
        p1.setUuid("1");
        p1.setName("Ahmad");
        p1.setVorname("Stein");
        data.add(p1);
        PersonDTO p2 = new PersonDTO();
        p2.setUuid("2");
        p2.setName("Meier");
        p2.setVorname("Stein");
        data.add(p2);
    }

    @PostConstruct
    public void init() {
        logger.debug("init kundenservice");
    }

    @Override
    public Response speicher(PersonDTO person) {
        String uuid = UUID.randomUUID().toString();
        person.setUuid(uuid);
        data.add(person);
        Response response = new Response();
        response.setUuid(uuid);
        return response;
    }

    @Override
    public PersonDTO getByUuId(String idPerson) {

        return Optional.of(data.stream()//
                .filter(d -> d.getUuid().equals(idPerson))//
                .findFirst())//
                .get()//
                .orElse(new PersonDTO());

    }

    // @Override
    // public PersonDTO getById(Long idPerson) {
    //
    // return Optional.of(data.stream()//
    // .filter(d -> d.getId().equals(idPerson))//
    // .findFirst())//
    // .get()//
    // .orElse(new PersonDTO());
    //
    // }

    @Override
    public void delete(String UuId) {
        Response response = new Response();
        response.setUuid(UuId);

        data.remove(getByUuId(UuId));

    }

    @Override
    public List<PersonDTO> findAll() {
        return data;
    }

    @Override
    public PersonDTO updata(String uuid, PersonDTO person)

    {
        return null;
    }

    // public Person speicher(Person person) {
    // data.add(person);
    // return getById(person.getId());
    // }

}
