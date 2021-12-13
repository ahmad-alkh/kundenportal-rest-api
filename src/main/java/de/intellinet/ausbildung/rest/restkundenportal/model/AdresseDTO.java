/**
 * 
 */

package de.intellinet.ausbildung.rest.restkundenportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 04.05.2021
 */
@JsonInclude(Include.NON_NULL)
public class AdresseDTO {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String land;

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
}
