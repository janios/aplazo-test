package com.cristian.aplazotest.service;

import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.entities.Credit;
import com.cristian.aplazotest.models.entities.Payment;
import com.cristian.aplazotest.repository.CreditRepository;
import com.cristian.aplazotest.repository.PaymentRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

  @Autowired CreditRepository creditRepository;

  @Autowired PaymentRepository paymentRepository;

  @Transactional
  public List<ResponseDto> calulate(RequestDto request) {

    var credit = new Credit();
    BeanUtils.copyProperties(request, credit);

    creditRepository.save(credit);
    List<ResponseDto> payments = new ArrayList<>();
    Double amountPerTerm =
        ((request.getAmount() * request.getRate()) + request.getAmount()) / request.getTerm();

    for (int i = 0; i < request.getTerm(); i++) {
      ResponseDto currentResponse =
          ResponseDto.builder()
              .amount(amountPerTerm)
              .paymentNumber(i + 1)
              .paymentDate(LocalDate.now().plusDays(7 * (i + 1)))
              .build();

      var payment = new Payment();
      BeanUtils.copyProperties(currentResponse, payment);
      payment.setCredit(credit);
      paymentRepository.save(payment);

      payments.add(currentResponse);
    }

    return payments;
  }

  public List<Payment> getAll() {
  return paymentRepository.findAll();
  }

  public List<Credit> getAllCredits() {
    return creditRepository.findAll();
  }
}
