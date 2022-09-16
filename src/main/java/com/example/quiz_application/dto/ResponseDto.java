package com.example.quiz_application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private long responseId;

    private String text;

    private boolean correct;
}
