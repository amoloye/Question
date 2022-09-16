package com.example.quiz_application.service;

import com.example.quiz_application.dto.ResponseDto;

import java.util.List;

public interface ResponseService{
    void createResponse (List<ResponseDto> responseDtoList);
}
