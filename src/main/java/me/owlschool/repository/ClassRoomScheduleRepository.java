package me.owlschool.repository;

import me.owlschool.model.ClassRoomSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@RepositoryRestResource(exported = false)
public interface ClassRoomScheduleRepository extends CrudRepository<ClassRoomSchedule, Long> {
}
