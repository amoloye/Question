package com.example.quiz_application.mapper;

import com.example.quiz_application.dto.ResponseDto;
import com.example.quiz_application.entity.Response;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    Response responseDtoToResponse (ResponseDto responseDto);

    @InheritInverseConfiguration
    ResponseDto responseToResponseDto (Response response);
}
