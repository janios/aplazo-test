package com.cristian.aplazotest.mapper;

import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.entities.Payment;
import org.mapstruct.Mapper;

@Mapper
public interface ResponseMapper {

  Payment getPaymentFromRespons(ResponseDto responsesDto);
}
