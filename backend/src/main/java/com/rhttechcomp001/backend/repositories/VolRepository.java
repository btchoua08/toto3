package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.domain.entities.Vol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VolRepository extends CrudRepository<Vol,String> , PagingAndSortingRepository<Vol,String> {
}
