package com.cristian.aplazotest.repository;

import com.cristian.aplazotest.models.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    List<Payment> findAll();

}
