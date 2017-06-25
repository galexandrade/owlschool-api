package me.owlschool.repository;

import me.owlschool.model.Parent;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {
}
