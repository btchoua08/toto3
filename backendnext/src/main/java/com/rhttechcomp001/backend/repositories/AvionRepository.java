package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.domain.entities.Avion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvionRepository extends CrudRepository<Avion, Integer> , PagingAndSortingRepository<Avion,Integer> {
}
