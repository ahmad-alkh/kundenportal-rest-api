/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.intellinet.ausbildung.rest.restkundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 10.05.2021
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findByUuid(String uuid);

}
