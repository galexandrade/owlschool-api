package me.owlschool.repository;

import me.owlschool.model.Matter;
import me.owlschool.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
public interface MatterRerpository extends PagingAndSortingRepository<Matter, Long> {
    @RestResource(path = "getTeachedMatters")
    @Query("select m from Matter m where m.teachers IS NOT EMPTY")
    List<Matter> getTeachedMatters(Pageable page);
}
