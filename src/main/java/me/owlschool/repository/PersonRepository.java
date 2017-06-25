package me.owlschool.repository;

import me.owlschool.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@RepositoryRestResource(exported = false)
public interface PersonRepository extends CrudRepository <Person, Long> {
}
