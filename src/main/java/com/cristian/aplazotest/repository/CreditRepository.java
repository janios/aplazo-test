package com.cristian.aplazotest.repository;

import com.cristian.aplazotest.models.entities.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Integer> {

    List<Credit> findAll();

}
