package com.cristian.aplazotest.mapper;

import com.cristian.aplazotest.models.dto.CreditDto;
import com.cristian.aplazotest.models.entities.Credit;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CreditMapper {
  List<CreditDto> getDtosFromEntities(List<Credit> credit);
}
