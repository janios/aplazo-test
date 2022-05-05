package com.cristian.aplazotest.service;

import com.cristian.aplazotest.constants.AplazoConstants;
import com.cristian.aplazotest.mapper.CreditMapper;
import com.cristian.aplazotest.mapper.RequestMapper;
import com.cristian.aplazotest.mapper.ResponseMapper;
import com.cristian.aplazotest.models.dto.CreditDto;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.entities.Payment;
import com.cristian.aplazotest.models.exception.AplazoException;
import com.cristian.aplazotest.repository.CreditRepository;
import com.cristian.aplazotest.repository.PaymentRepository;
import com.cristian.aplazotest.utils.validator.RequestValidation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired CreditRepository creditRepository;

  @Autowired PaymentRepository paymentRepository;

  @Autowired RequestMapper requestMapper;

  @Autowired ResponseMapper responseMapper;

  @Autowired CreditMapper creditMapper;

  @Transactional
  public List<ResponseDto> calulate(RequestDto request) throws AplazoException {

    var credit = requestMapper.getCreditFromRequest(request);
    RequestValidation.validateRequest(request);
    creditRepository.save(credit);
    List<ResponseDto> response = new ArrayList<>();
    Double amountPerTerm =
        ((request.getAmount() * request.getRate()) + request.getAmount()) / request.getTerm();

    for (var i = 0; i < request.getTerm(); i++) {
      var currentResponse =
          ResponseDto.builder()
              .amount(amountPerTerm)
              .paymentNumber(i + 1)
              .paymentDate(LocalDate.now().plusDays(AplazoConstants.PAYMENT_PERIOD * (i + 1)))
              .build();
      response.add(currentResponse);
    }

    List<Payment> payments =
        response.stream()
            .map(r -> responseMapper.getPaymentFromRespons(r))
            .peek(p -> p.setCredit(credit))
            .collect(Collectors.toList());

    paymentRepository.saveAll(payments);

    return response;
  }

  public List<CreditDto> getAllPayments() {
    return creditMapper.getDtosFromEntities(creditRepository.findAll());
  }
}
