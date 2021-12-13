/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import de.intellinet.ausbildung.rest.restkundenportal.model.AdresseDTO;
import de.intellinet.ausbildung.rest.restkundenportal.model.PersonDTO;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 31.05.2021
 */
class MappingUtilsTest {

    @Test
    void adresseTest() {

        Adresse adresse = getAdresse();

        AdresseDTO adresseDTO = new AdresseDTO();
        // AdresseDTO mappAdersse = MappingUtils.mappAdersse(adresse, adresseDTO);

        // assertThat(mappAdersse.getHausnummer(), is("11"));

    }

    private Adresse getAdresse() {
        Adresse adresse = new Adresse();
        adresse.setHausnummer("11");
        adresse.setLand("De");
        adresse.setOrt("Frechen");
        adresse.setPlz("50226");
        adresse.setStrasse("Norddamer Str.");
        return adresse;
    }

    @Test
    void kontaktTest() {

        Kontakt kontakt = getKontakt();
        //
        // KontaktDTO mappKontakt = MappingUtils.mappKontakt(kontakt, new KontaktDTO());

        // assertThat(mappKontakt.getEmail(), is("frechen@net.de"));
    }

    private Kontakt getKontakt() {
        Kontakt kontakt = new Kontakt();
        kontakt.setEmail("frechen@net.de");
        kontakt.setMobil("01555464454");
        kontakt.setTelefon("001215444");
        return kontakt;
    }

    @Test
    void personTest() {

        PersonDTO mappePersonDTO = MappingUtils.mappePersonDTO(getperson());

        assertThat(mappePersonDTO.getName(), is("Müler"));
        assertThat(mappePersonDTO.getKontakt().getEmail(), is("frechen@net.de"));
        assertThat(mappePersonDTO.getAdresse().getHausnummer(), is("11"));
    }

    private Person getperson() {
        Person person = new Person();
        person.setName("Müler");
        person.setVorname("Emma");
        person.setStaatsangehoerigkeit("DE");

        // person.setAdresse(getAdresse());
        // person.getAdresse().setHausnummer("11");;
        person.setKontakt(getKontakt());
        // person.getKontakt().setEmail("frechen@net.de");

        return person;

    }

}
