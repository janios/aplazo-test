package com.cristian.aplazotest.mapper;

import com.cristian.aplazotest.models.dto.PaymentDto;
import com.cristian.aplazotest.models.entities.Payment;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {
  List<PaymentDto> getDtosFromEntities(List<Payment> payment);
}
