package me.owlschool.repository;

import me.owlschool.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
}
