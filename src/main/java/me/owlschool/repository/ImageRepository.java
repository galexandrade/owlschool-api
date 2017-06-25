package me.owlschool.repository;

import me.owlschool.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@RepositoryRestResource(exported = false)
public interface ImageRepository extends CrudRepository<Image, Long> {
}
