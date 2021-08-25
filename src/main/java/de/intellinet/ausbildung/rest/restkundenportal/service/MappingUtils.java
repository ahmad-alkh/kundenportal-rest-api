/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import de.intellinet.ausbildung.rest.restkundenportal.model.AdresseDTO;
import de.intellinet.ausbildung.rest.restkundenportal.model.KontaktDTO;
import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Person;
import de.intellinet.rest.restkundenportal.enums.AdresseTyp;

/**
 * 
 * @author ahmalk
 *
 * @since 11.05.2021
 */
public class MappingUtils {

    public static Person createNewPersonEntity(PersonDTO person) {
        Person personOut = new Person();
        mappPersonDtoIntoEntity(person, personOut);

        personOut.setAnlagedatum(LocalDateTime.now());

        return personOut;

    }

    public static PersonDTO mappePersonDTO(Person person) {
        PersonDTO personOut1 = new PersonDTO();

        BeanUtils.copyProperties(person, personOut1);

        List<Adresse> adressen = person.getAdressen();

        personOut1.setVorAdresse(mappeAdresseAusList(adressen, AdresseTyp.VORADRESSE));
        personOut1.setAdresse(mappeAdresseAusList(adressen, AdresseTyp.ADRESSE));

        personOut1.setKontakt(mapperAdress(person.getKontakt()));
        // Optional<Adresse> adresse = getAdresse(adressen, AdresseTyp.ADRESSE);//
        // if (adresse.isPresent()) {
        // personOut1.setAdresse(mappAdresse(adresse.get()));
        // }
        // adresse.ifPresent(a -> personOut1.setAdresse(mappAdresse(a)));

        return personOut1;
    }

    private static KontaktDTO mapperAdress(Kontakt kontakt) {
        KontaktDTO kontaktDTO = new KontaktDTO();
        BeanUtils.copyProperties(kontakt, kontaktDTO);
        return kontaktDTO;
    }

    private static AdresseDTO mappeAdresseAusList(List<Adresse> adressen, AdresseTyp adresseTyp) {
        Optional<Adresse> adresse = getAdresse(adressen, adresseTyp);//
        if (!adresse.isPresent()) {
            return null;
        }
        return mappAdresse(adresse.get());
    }

    private static Optional<Adresse> getAdresse(List<Adresse> adressen, AdresseTyp adresseTyp) {
        if (CollectionUtils.isEmpty(adressen)) {
            return Optional.empty();
        }
        return adressen.stream()//
                .filter(a -> a.getAdresseTyp().equals(adresseTyp))//
                .findFirst();//

    }

    public static Adresse mappeAdresse(AdresseDTO adresse) {

        Adresse adresseOut = new Adresse();

        BeanUtils.copyProperties(adresse, adresseOut);

        return adresseOut;
    }

    private static AdresseDTO mappAdresse(Adresse adresse) {
        if (Objects.isNull(adresse)) {
            return null;
        }
        AdresseDTO adresseDTO = new AdresseDTO();

        BeanUtils.copyProperties(adresse, adresseDTO);

        return adresseDTO;
    }

    public static Kontakt mappeKontakt(KontaktDTO kontakt) {

        Kontakt kontaktOut = new Kontakt();

        kontaktOut.setEmail(kontakt.getEmail());

        kontaktOut.setMobil(kontakt.getMobil());

        kontaktOut.setTelefon(kontakt.getTelefon());

        return kontaktOut;
    }

    public static void mappPersonDtoIntoEntity(PersonDTO source, Person target) {
        List<Adresse> adressen = new ArrayList<Adresse>();

        BeanUtils.copyProperties(source, target);

        target.setAenderungsdatum(LocalDateTime.now());

        if (Objects.nonNull(source.getAdresse())) {
            Adresse mappeAdresse = mappeAdresse(source.getAdresse());
            mappeAdresse.setAdresseTyp(AdresseTyp.ADRESSE);
            mappeAdresse.setPerson(target);
            adressen.add(mappeAdresse);
        }

        if (Objects.nonNull(source.getVorAdresse())) {
            Adresse mappeAdresse = mappeAdresse(source.getVorAdresse());
            mappeAdresse.setAdresseTyp(AdresseTyp.VORADRESSE);
            mappeAdresse.setPerson(target);
            adressen.add(mappeAdresse);
        }

        target.setAdressen(adressen);

        if (Objects.nonNull(source.getKontakt())) {

            Kontakt mappeKontakt = mappeKontakt(source.getKontakt());
            mappeKontakt.setPerson(target);
            target.setKontakt(mappeKontakt);
        }

    }

}
