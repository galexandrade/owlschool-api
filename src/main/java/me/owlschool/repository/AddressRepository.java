package me.owlschool.repository;

import me.owlschool.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AddressRepository extends CrudRepository<Address, Long> {
}
