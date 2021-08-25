/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 10.05.2021
 */
@Entity
@Table(name = "kunde_person")
public class Person extends AbstractPersistable<Long> {

    private String uuid;

    private String vorname;
    private String name;
    private String geburtsort;
    private String geburtsname;
    private String staatsangehoerigkeit;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private LocalDate geburtsdatum;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime anlagedatum;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime aenderungsdatum;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Adresse> adressen;

    @OneToOne(cascade = CascadeType.ALL, optional = true, mappedBy = "person")
    private Kontakt kontakt;

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Kontakt getKontakt() {
        return kontakt;
    }

    public List<Adresse> getAdressen() {
        return adressen;
    }

    public void setAdressen(List<Adresse> adressen) {
        this.adressen = adressen;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getGeburtsname() {
        return geburtsname;
    }

    public void setGeburtsname(String geburtsname) {
        this.geburtsname = geburtsname;
    }

    public String getStaatsangehoerigkeit() {
        return staatsangehoerigkeit;
    }

    public void setStaatsangehoerigkeit(String staatsangehoerigkeit) {
        this.staatsangehoerigkeit = staatsangehoerigkeit;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public LocalDateTime getAnlagedatum() {
        return anlagedatum;
    }

    public void setAnlagedatum(LocalDateTime anlagedatum) {
        this.anlagedatum = anlagedatum;
    }

    public LocalDateTime getAenderungsdatum() {
        return aenderungsdatum;
    }

    public void setAenderungsdatum(LocalDateTime aenderungsdatum) {
        this.aenderungsdatum = aenderungsdatum;
    }

}
