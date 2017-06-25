package me.owlschool.repository;

import me.owlschool.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
