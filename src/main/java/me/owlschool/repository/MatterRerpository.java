package me.owlschool.repository;

import me.owlschool.model.Matter;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
public interface MatterRerpository extends PagingAndSortingRepository<Matter, Long> {
}
