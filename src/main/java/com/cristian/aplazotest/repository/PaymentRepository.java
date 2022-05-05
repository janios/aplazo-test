package com.cristian.aplazotest.repository;

import com.cristian.aplazotest.models.entities.Payment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

  List<Payment> findAll();
}
