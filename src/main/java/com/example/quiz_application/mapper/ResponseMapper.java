package com.example.quiz_application.mapper;


import com.example.quiz_application.dto.ResponseDto;
import com.example.quiz_application.entity.Response;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResponseMapper {

    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    List<Response> responseDtoToResponse (List<ResponseDto> responseDtoList);
    List<Response> responseDtoToResponse (List<ResponseDto> responseDtoList, @MappingTarget List<Response> responses);

}
