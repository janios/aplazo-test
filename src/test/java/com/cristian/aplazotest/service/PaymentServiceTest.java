package com.cristian.aplazotest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.cristian.aplazotest.mapper.CreditMapper;
import com.cristian.aplazotest.mapper.RequestMapper;
import com.cristian.aplazotest.mapper.ResponseMapper;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.exception.AplazoException;
import com.cristian.aplazotest.repository.CreditRepository;
import com.cristian.aplazotest.repository.PaymentRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

  @Mock CreditRepository creditRepository;

  @Mock PaymentRepository paymentRepository;

  @Spy RequestMapper requestMapper = Mappers.getMapper(RequestMapper.class);

  @Spy ResponseMapper responseMapper = Mappers.getMapper(ResponseMapper.class);

  @Spy CreditMapper creditMapper = Mappers.getMapper(CreditMapper.class);

  @InjectMocks PaymentService paymentService;

  @Test
  public void calculateTest() throws AplazoException {
    RequestDto request = RequestDto.builder().amount(10d).term(2).rate(.10).build();

    List<ResponseDto> responseList = paymentService.calulate(request);

    assertNotNull(responseList);
    assertEquals(request.getTerm(), responseList.size());

    for (int i = 0; i < responseList.size(); i++) {
      ResponseDto currentResponse = responseList.get(i);
      assertEquals(i + 1, currentResponse.getPaymentNumber());
      assertEquals(LocalDate.now().plusDays(7 * (i + 1)), currentResponse.getPaymentDate());
    }
  }
}
