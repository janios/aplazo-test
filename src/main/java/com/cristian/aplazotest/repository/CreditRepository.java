package com.cristian.aplazotest.repository;

import com.cristian.aplazotest.models.entities.Credit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Integer> {

  List<Credit> findAll();
}
