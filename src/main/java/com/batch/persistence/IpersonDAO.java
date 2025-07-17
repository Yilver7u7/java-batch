package com.batch.persistence;

import com.batch.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IpersonDAO extends CrudRepository<Person, Long> {
}
