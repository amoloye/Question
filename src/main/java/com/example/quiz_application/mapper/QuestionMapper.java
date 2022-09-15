package com.example.quiz_application.mapper;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.Question;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question questionDtoToQuestion (QuestionDto questionDto);

    @InheritInverseConfiguration
    QuestionDto questionToQuestionDto (Question question);

}
