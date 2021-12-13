/**
 * 
 */

package de.intellinet.ausbildung.rest.restkundenportal.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.intellinet.rest.restkundenportal.enums.AdresseTyp;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 04.05.2021
 */
@Entity
@Table(name = "kunde_adresse")
public class Adresse extends AbstractPersistable<Long> {

    @Column(length = 50)
    private String strasse;
    @Column(length = 10)
    private String hausnummer;
    @Column(length = 5)
    private String plz;
    @Column(length = 20)
    private String ort;
    @Enumerated(EnumType.STRING)
    private AdresseTyp adresseTyp;
    @Column(length = 2)
    private String land;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public AdresseTyp getAdresseTyp() {
        return adresseTyp;
    }

    public void setAdresseTyp(AdresseTyp adresseTyp) {
        this.adresseTyp = adresseTyp;
    }

}
