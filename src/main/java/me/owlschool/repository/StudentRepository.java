package me.owlschool.repository;

import me.owlschool.model.Parent;
import me.owlschool.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    @RestResource(path = "findByName")
    @Query("select p from Student p where CONCAT(p.person.firstName, p.person.lastName) like %?1%")
    Page<Student> findByName(@Param("name") String firstName, Pageable page);
}
