package me.owlschool.repository;

import me.owlschool.model.School;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {

}
