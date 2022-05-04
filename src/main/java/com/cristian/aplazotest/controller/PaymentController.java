package com.cristian.aplazotest.controller;

import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.entities.Credit;
import com.cristian.aplazotest.models.entities.Payment;
import com.cristian.aplazotest.service.CalculationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculate")
public class PaymentController {

  @Autowired private CalculationService calculationService;

  @PostMapping
  public ResponseEntity<List<ResponseDto>> create(@RequestBody RequestDto request) {
    return new ResponseEntity<>(calculationService.calulate(request), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Credit>> allPayments(){
    return new ResponseEntity<>(calculationService.getAllCredits(), HttpStatus.OK);
  }
}
