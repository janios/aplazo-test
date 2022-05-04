package com.cristian.aplazotest.mapper;

import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.entities.Credit;
import org.mapstruct.Mapper;

@Mapper
public interface RequestMapper {
  Credit getCreditFromRequest(RequestDto requestDto);
}
