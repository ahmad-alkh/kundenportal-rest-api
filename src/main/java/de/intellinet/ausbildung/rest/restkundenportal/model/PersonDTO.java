/**
 * 
 */

package de.intellinet.ausbildung.rest.restkundenportal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 * @author ahmalk
 *
 * @since 04.05.2021
 */
public class PersonDTO {

    private String uuid;
    private String vorname;
    private String name;
    private String geburtsort;
    private String geburtsname;
    private String staatsangehoerigkeit;
    private LocalDate geburtsdatum;
    private LocalDateTime anlagedatum;
    private KontaktDTO kontakt;
    private AdresseDTO adresse;
    private AdresseDTO VorAdresse;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String id) {
        this.uuid = id;
    }

    public AdresseDTO getVorAdresse() {
        return VorAdresse;
    }

    public void setVorAdresse(AdresseDTO vorAdresse) {
        VorAdresse = vorAdresse;
    }

    public KontaktDTO getKontakt() {
        return kontakt;
    }

    public void setKontakt(KontaktDTO kontakt) {
        this.kontakt = kontakt;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }

    private LocalDateTime aenderungsdatum;

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
