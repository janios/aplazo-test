package com.cristian.aplazotest.controller;

import com.cristian.aplazotest.models.dto.CreditDto;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.exception.AplazoException;
import com.cristian.aplazotest.service.PaymentService;
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
@RequestMapping("/api/v1")
public class PaymentController {

  @Autowired private PaymentService paymentService;

  @PostMapping("/calculate")
  public ResponseEntity<List<ResponseDto>> create(@RequestBody RequestDto request)
      throws AplazoException {
    return new ResponseEntity<>(paymentService.calulate(request), HttpStatus.CREATED);
  }

  @GetMapping("/payments")
  public ResponseEntity<List<CreditDto>> allPayments() {
    return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
  }
}
