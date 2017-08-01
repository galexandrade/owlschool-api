package me.owlschool.repository;

import me.owlschool.model.Matter;
import me.owlschool.model.Parent;
import me.owlschool.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
public interface StaffRepository extends PagingAndSortingRepository<Staff, Long> {
    @RestResource(path = "findTeacherByName")
    @Query("select s from Staff s where s.function = 'teacher' and s.person.firstName like %?1%")
    Page<Staff> findTeacherByName(@Param("name") String firstName, Pageable page);

    @RestResource(path = "findByFunction")
    Page<Staff> findByFunction(@Param("function") String function, Pageable page);

    @RestResource(path = "findTeacherByMatter")
    @Query("select s from Staff s INNER JOIN s.matters m where s.function = 'teacher' and m.id = ?1")
    Page<Staff> findTeacherByMatter(@Param("matterId") Long matterId, Pageable page);
}
