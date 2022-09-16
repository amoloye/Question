package com.example.quiz_application.service.impl;

import com.example.quiz_application.dto.ResponseDto;
import com.example.quiz_application.entity.Response;
import com.example.quiz_application.mapper.ResponseMapper;
import com.example.quiz_application.repository.ResponseRepository;
import com.example.quiz_application.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {
    private final ResponseRepository responseRepository;

    @Override
    public void createResponse (List<ResponseDto> responseDtoList) {
        List<Response> responses= ResponseMapper.INSTANCE.responseDtoToResponse(responseDtoList);
         responseRepository.saveAll(responses);
    }
}
