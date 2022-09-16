package com.example.quiz_application.controller;

import com.example.quiz_application.dto.ResponseDto;
import com.example.quiz_application.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ResponseController {
    private final ResponseService responseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/responses")
    public void createResponse(@RequestBody List<ResponseDto> responseDtoList){
       responseService.createResponse(responseDtoList);
    }
}
