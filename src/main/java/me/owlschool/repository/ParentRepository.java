package me.owlschool.repository;

import me.owlschool.model.Course;
import me.owlschool.model.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {
    @RestResource(path = "findByName")
    @Query("select p from Parent p where p.person.firstName like %?1%")
    Page<Parent> findByName(@Param("name") String firstName, Pageable page);
}
