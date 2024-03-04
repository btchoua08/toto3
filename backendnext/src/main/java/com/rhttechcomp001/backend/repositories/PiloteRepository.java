package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.domain.entities.Pilote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PiloteRepository extends CrudRepository<Pilote,Integer> , PagingAndSortingRepository<Pilote,Integer> {
}
